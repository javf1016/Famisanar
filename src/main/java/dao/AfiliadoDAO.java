package dao;

import entidad.Afiliado;
import exception.DAOException;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;

@Named
@Transactional
public class AfiliadoDAO {

    @PersistenceContext(unitName = "AfiliadoPU")
    private EntityManager em;

    String url = "jdbc:postgresql://localhost:5432/famisanar";
    String user = "postgres";
    String password = "root";

    public List<Afiliado> findByIdentificacion(String tid, String numero) {
        try {
            return em.createQuery("SELECT a FROM Afiliado a WHERE a.tipoIdentific = :tid AND a.numero = :numero", Afiliado.class)
                    .setParameter("tid", tid)
                    .setParameter("numero", numero)
                    .getResultList();
        } catch (Exception e) {
            throw new DAOException("Error al buscar por identificación", e);
        }
    }

    public List<Afiliado> findByApellidos(String apellidos) {
        try {
            return em.createQuery("SELECT a FROM Afiliado a WHERE a.apellidos LIKE :apellidos", Afiliado.class)
                    .setParameter("apellidos", "%" + apellidos + "%")
                    .getResultList();
        } catch (Exception e) {
            throw new DAOException("Error al buscar por apellidos", e);
        }
    }
}
