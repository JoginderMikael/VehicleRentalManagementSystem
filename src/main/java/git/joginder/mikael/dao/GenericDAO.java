package git.joginder.mikael.dao;

import git.joginder.mikael.util.JPAUtil;
import jakarta.persistence.EntityManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

//This is the reusable class with JPA CRUD LOGIC.
public class GenericDAO<T> {

    private static final Logger logger = LoggerFactory.getLogger(GenericDAO.class);

    private final Class<T> type;
    protected EntityManager em = JPAUtil.getEntityManager();

    public GenericDAO(Class<T> type){
        this.type = type;
    }

    //saving entity to db
    public void save(T entity){
        logger.info("Saving details.....");
        em.getTransaction().begin();
        em.persist(entity);
        em.getTransaction().commit();
    }

    //updating entity to db
    public void update(T entity){
        logger.info("Updating the details....");
        em.getTransaction().begin();
        em.merge(entity);
        em.getTransaction().commit();
    }

    //deleting entity from db
    public void delete(T entity){
        logger.info("Deleting details....");
        em.getTransaction().begin();
        em.remove(em.merge(entity));
        em.getTransaction().commit();
    }

    //finding an entity from db by id
    public T findById(Long id){
        logger.info("Fetching....");
        return em.find(type, id);
    }

    //listing all entities
    public List<T> findAll(){
        logger.info("Fetching all....");
        return em.createQuery("FROM " + type.getSimpleName(), type).getResultList();
    }

}
