package dao;

import entidad.Afiliado;
import entidad.TipoIdentific;
import exception.DAOException;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Named
@Transactional
public class AfiliadoDAO {

    @PersistenceContext(unitName = "AfiliadoPU")
    private EntityManager em;

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("AfiliadoPU");
    EntityManager entityManager = entityManagerFactory.createEntityManager();

    @Transactional
    public List<Afiliado> findByIdentificacion(Long tid, Long numero) {
        try {
            entityManager.getTransaction().begin();
            Long tipoIdentificId = tid;
            TipoIdentific tipoIdentific = entityManager.find(TipoIdentific.class, tipoIdentificId);
            if (tipoIdentific == null) {
                throw new Exception("Tipo de identificación no encontrado con id: " + tid);
            }
            return entityManager.createQuery("SELECT a FROM Afiliado a WHERE a.idtipoiden = :tid AND a.numero = :numero", Afiliado.class)
                    .setParameter("tid", tipoIdentific)
                    .setParameter("numero", numero)
                    .getResultList();
        } catch (Exception e) {
            throw new DAOException("Error al buscar por identificación", e);
        }
    }

    @Transactional
    public List<Afiliado> findByApellidos(String apellidos) {
        try {
            entityManager.getTransaction().begin();
            String apellido = "%"+apellidos+"%";
            // Usar una consulta JPQL para buscar por apellidos
            return entityManager.createQuery("SELECT a FROM Afiliado a WHERE a.apellidos LIKE :apellido", Afiliado.class)
                    .setParameter("apellido", apellido)
                    .getResultList();
        } catch (Exception e) {
            throw new DAOException("Error al buscar por apellidos", e);
        }
    }

    @Transactional
    public List<TipoIdentific> findAll() {
        entityManager.getTransaction().begin();
        return entityManager.createQuery("SELECT t FROM TipoIdentific t", TipoIdentific.class).getResultList();
    }
}
