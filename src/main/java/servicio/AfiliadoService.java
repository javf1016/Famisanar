package servicio;

import dao.AfiliadoDAO;
import entidad.Afiliado;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
@Stateless
public class AfiliadoService {
    @Inject
    private AfiliadoDAO afiliadoDAO;

    public List<Afiliado> consultarPorIdentificacion(String tid, String numero) {
        this.afiliadoDAO = new AfiliadoDAO();
        return afiliadoDAO.findByIdentificacion(tid, numero);
    }

    public List<Afiliado> consultarPorApellidos(String apellidos) {
        return afiliadoDAO.findByApellidos(apellidos);
    }
}
