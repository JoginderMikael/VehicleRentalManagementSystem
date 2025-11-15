package git.joginder.mikael.dao;

import git.joginder.mikael.entity.Customer;
import git.joginder.mikael.util.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class CustomerDAO extends GenericDAO<Customer> {

    private static final Logger log = LoggerFactory.getLogger(CustomerDAO.class);

    public CustomerDAO() {
        super(Customer.class);
    }

    public List<Customer> getAllCustomers(){
        try (EntityManager em = JPAUtil.getEntityManager()) {
            TypedQuery<Customer> query =
                    em.createQuery("SELECT DISTINCT c FROM Customer c LEFT JOIN FETCH c.rentals", Customer.class);
            return query.getResultList();
        }
    }
}
