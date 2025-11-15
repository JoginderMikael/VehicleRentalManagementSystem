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
        logger.info("Fetching all customers....");
        CustomerDAO customerDAO = new CustomerDAO();
        List<Customer> customers = customerDAO.getAllCustomers();
        customers.forEach(IO::println);
    }

    public void searchCustomerById(Long Id){

        logger.info("Searching for customer with ID: {}", Id);
        CustomerDAO customerDAO = new CustomerDAO();
        Customer customer = customerDAO.findById(Id);

        if(customer == null){
            IO.println("No customer found with ID: " + Id);
            logger.warn("Customer search failed. No customer found with ID {}", Id);
            return;
        }

        IO.println("\n Customer Found: \n" + customer);
        logger.info("Customer found: {}", customer.getId());
    }

}
