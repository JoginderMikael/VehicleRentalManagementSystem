package git.joginder.mikael.dao;

import git.joginder.mikael.entity.Vehicle;
import git.joginder.mikael.util.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

//This is the reusable class with JPA CRUD LOGIC.
public class GenericDAO<T> {

    private static final Logger log = LoggerFactory.getLogger(GenericDAO.class);

    private final Class<T> type;
    protected EntityManager em = JPAUtil.getEntityManager();

    public GenericDAO(Class<T> type){
        this.type = type;
    }

    //saving entity to db
    public void save(T entity){
        em.getTransaction().begin();
        em.persist(entity);
        em.getTransaction().commit();
    }

    //updating entity to db
    public void update(T entity){
        em.getTransaction().begin();
        em.merge(entity);
        em.getTransaction().commit();
    }

    //deleting entity from db
    public void delete(T entity){
        em.getTransaction().begin();
        em.remove(em.merge(entity));
        em.getTransaction().commit();
    }

    //finding an entity from db by id
    public T findById(Long id){
        return em.find(type, id);
    }

    //listing all entities
    public List<T> findAll(){
        return em.createQuery("from " + type.getSimpleName(), type).getResultList();
    }

//    //creating the entities
//    public void create(T entity) {
//        EntityManager em = JPAUtil.getEntityManager();
//
//        EntityTransaction tx = null;
//        try (em) {
//            tx = em.getTransaction();
//            tx.begin();
//            em.persist(entity);
//            tx.commit();
//        } catch (Exception e) {
//            assert tx != null;
//            if (tx.isActive()) tx.rollback();
//            throw e;
//        }
//    }

}
