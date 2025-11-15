package git.joginder.mikael.service;

import git.joginder.mikael.dao.CustomerDAO;
import git.joginder.mikael.dao.RentalDAO;
import git.joginder.mikael.entity.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class CustomerService {

    private static final Logger logger = LoggerFactory.getLogger(CustomerService.class);

    public void viewAllCustomers() {
        CustomerDAO customerDAO = new CustomerDAO();
        List<Customer> customers = customerDAO.getAllCustomers();
        customers.forEach(IO::println);
    }

}
