package git.joginder.mikael.dao;

import git.joginder.mikael.util.JPAUtil;
import jakarta.persistence.EntityManager;
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

    public void save(T entity){
        em.getTransaction().begin();
        em.persist(entity);
        em.getTransaction().commit();
    }

    public void update(T entity){
        em.getTransaction().begin();
        em.merge(entity);
        em.getTransaction().commit();
    }

    public void delete(T entity){
        em.getTransaction().begin();
        em.remove(em.merge(entity));
        em.getTransaction().commit();
    }

    public T findById(Long id){
        return em.find(type, id);
    }

    public List<T> findAll(){
        return em.createQuery("from " + type.getSimpleName(), type).getResultList();
    }
}
