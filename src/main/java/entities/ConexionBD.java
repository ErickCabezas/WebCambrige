
package entities;
import jakarta.persistence.*;

public class ConexionBD {

    public static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
    public static EntityManager entityManager = entityManagerFactory.createEntityManager();

    //TypedQuery<Usuario> consultaUsuariosQuery = entityManager.createNamedQuery("Usuario.usuarios", Usuario.class);
    public static EntityTransaction transaction = entityManager.getTransaction();
    public static void endConnection() {

        entityManager.close();
        entityManagerFactory.close();

    }

}
