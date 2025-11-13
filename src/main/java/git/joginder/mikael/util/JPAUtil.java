package git.joginder.mikael.util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;


public class JPAUtil {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("vehicle_rental");
    public static EntityManager getEntityManager(){
        return emf.createEntityManager();
    }
}
