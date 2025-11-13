package git.joginder.mikael.util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class JPAUtil {

    private static final Logger logger = LoggerFactory.getLogger(JPAUtil.class);
    private static final EntityManagerFactory emf;

    static {
        logger.info("Initializing JPA EntityManagerFactory...");
        emf = Persistence.createEntityManagerFactory("vehiclerental");
    }
    public static EntityManager getEntityManager(){
        logger.debug("Creating new EntifyManager instance ...");
        return emf.createEntityManager();
    }

    public static void shutDown(){
        logger.info("Shutting down EntityManagerFactory....");
        emf.close();
    }

}
