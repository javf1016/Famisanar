
import entidad.Afiliado;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        Afiliado afiliado = new Afiliado();
        afiliado.setNombres("Jorge");
        afiliado.setApellidos("Vera");
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("AfiliadoPU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(afiliado);
        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();
    }
}
