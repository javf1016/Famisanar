package controlador;

import dao.AfiliadoDAO;
import entidad.Afiliado;
import exception.DAOException;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named("consultaBean")
@RequestScoped
public class ConsultaBean {

    private String consultaPor;
    private String tid;
    private String numero;
    private String apellidos;
    private List<Afiliado> afiliados;
    private String errorMessage;

    @Inject
    private AfiliadoDAO afiliadoDAO;

    // Getters y setters

    public String getConsultaPor() {
        return consultaPor;
    }

    public void setConsultaPor(String consultaPor) {
        this.consultaPor = consultaPor;
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
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

    public void consultar() {
        try {
            if ("identificacion".equals(consultaPor)) {
                this.afiliadoDAO = new AfiliadoDAO();
                afiliados = afiliadoDAO.findByIdentificacion(tid, numero);
            } else if ("apellidos".equals(consultaPor)) {
                afiliados = afiliadoDAO.findByApellidos(apellidos);
            }
            errorMessage = null;
        } catch (DAOException e) {
            errorMessage = e.getMessage();
        }
    }
}
