package git.joginder.mikael.dao;

import git.joginder.mikael.entity.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CustomerDAO extends GenericDAO<Customer> {

    private static final Logger log = LoggerFactory.getLogger(CustomerDAO.class);

    public CustomerDAO() {
        super(Customer.class);
    }

}
