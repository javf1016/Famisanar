package controlador;

import dao.AfiliadoDAO;
import entidad.Afiliado;
import entidad.TipoIdentific;
import exception.DAOException;

import javax.enterprise.context.RequestScoped;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named("consultaBean")
@ViewScoped
public class ConsultaBean {

    private String consultaPor;
    private Long tid;
    private Long numero;
    private String apellidos;
    private List<Afiliado> afiliados;
    private String errorMessage;
    private List<TipoIdentific> tipoIdentificList;

    @Inject
    private AfiliadoDAO afiliadoDAO;

    // Getters y setters

    public String getConsultaPor() {
        return consultaPor;
    }

    public void setConsultaPor(String consultaPor) {
        this.consultaPor = consultaPor;
    }

    public Long getTid() {
        return tid;
    }

    public void setTid(Long tid) {
        this.tid = tid;
    }

    public Long getNumero() {
        return numero;
    }

    public void setNumero(Long numero) {
        this.numero = numero;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public List<Afiliado> getAfiliados() {
        return afiliados;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setAfiliados(List<Afiliado> afiliados) {
        this.afiliados = afiliados;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public void setTipoIdentificList(List<TipoIdentific> tipoIdentificList) {
        this.tipoIdentificList = tipoIdentificList;
    }

    public AfiliadoDAO getAfiliadoDAO() {
        return afiliadoDAO;
    }

    public void setAfiliadoDAO(AfiliadoDAO afiliadoDAO) {
        this.afiliadoDAO = afiliadoDAO;
    }

    public void consultar() {
        try {
            if ("identificacion".equals(consultaPor)) {
                this.afiliadoDAO = new AfiliadoDAO();
                afiliados = afiliadoDAO.findByIdentificacion(tid, numero);
                System.out.println("afiliado "+afiliados.get(0));
            } else if ("apellidos".equals(consultaPor)) {
                this.afiliadoDAO = new AfiliadoDAO();
                afiliados = afiliadoDAO.findByApellidos(apellidos);
                System.out.println("afiliado "+afiliados.get(0));
            }
            errorMessage = null;
        } catch (DAOException e) {
            errorMessage = e.getMessage();
        }
    }

    public List<TipoIdentific> getTipoIdentificList() {
        if (tipoIdentificList == null) {
            this.afiliadoDAO = new AfiliadoDAO();
            tipoIdentificList = afiliadoDAO.findAll();
        }
        return tipoIdentificList;
    }
}
