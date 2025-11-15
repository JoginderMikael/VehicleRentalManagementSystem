package git.joginder.mikael.service;

import git.joginder.mikael.dao.CustomerDAO;
import git.joginder.mikael.dao.RentalDAO;
import git.joginder.mikael.dao.VehicleDAO;
import git.joginder.mikael.entity.Customer;
import git.joginder.mikael.entity.Rental;
import git.joginder.mikael.entity.Vehicle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.util.List;

public class RentalService {

    private static final Logger logger = LoggerFactory.getLogger(RentalService.class);

    private final VehicleDAO vehicleDAO = new VehicleDAO();
    private final CustomerDAO customerDAO = new CustomerDAO();
    private final RentalDAO rentalDAO = new RentalDAO();


    //renting a vehicle
    public void rentVehicle(Long customerId, Long vehicleId, int days){
        logger.info("Attempting to rent vehicle ID = {} to customer ID = {} for {} days", vehicleId, customerId, days);
        Customer customer = customerDAO.findById(customerId);
        Vehicle vehicle = vehicleDAO.findById(vehicleId);

        if(customer == null || vehicle == null){
            logger.error("Customer or Vehicle not found");
            IO.println("Invalid customer or vehicle ID.");
            return;
        }

        if(!vehicle.isAvailable()){
            logger.warn("Vehicle ID = {} is not available", vehicle.getModel());
            IO.println("Vehicle not available.");
            return;
        }

        double cost = vehicle.getDailyRate() * days;
        Rental rental = new Rental()
                .setCustomer(customer)
                .setVehicle(vehicle)
                .setStartDate(LocalDate.now())
                .setEndDate(LocalDate.now().plusDays(days))
                .setTotalCost(cost)
                .setReturned(false);

        rentalDAO.save(rental);
        vehicle.setAvailable(false);
        vehicleDAO.update(vehicle);

        logger.info("Vehicle rented successfully. Total cost = ${}", cost);
        IO.println("Vehicle rented successfully for $" + cost);

    }

    //returning a vehicle
    public void returnVehicle(Long rentalId){
        logger.info("Processing return for rental ID = {}", rentalId);
        Rental rental = rentalDAO.findById(rentalId);

        if(rental == null){
            logger.error("Rental ID = {} not found", rentalId);
            IO.println("Rental not found.");
            return;
        }

        rental.setReturned(true);
        Vehicle vehicle = rental.getVehicle();
        vehicle.setAvailable(true);

        rentalDAO.update(rental);
        vehicleDAO.update(vehicle);

        logger.info("Vehicle ID = {} returned successfully.", vehicle.getModel());
        IO.println("Vehicle returned successfully!");
    }

    //add a vehicle to the system
    public void addVehicle(String model, String type, double dailyRate){
        Vehicle vehicle = new Vehicle()
                .setModel(model)
                .setType(type)
                .setDailyRate(dailyRate)
                .setAvailable(true);

        vehicleDAO.save(vehicle);
        logger.info("Vehicle added successfully: {} ", model);
    }
    // add customer to the system
public void addCustomer(String name, String phone, String email){
        Customer customer = new Customer()
                .setName(name)
                .setPhone(phone)
                .setEmail(email);

        customerDAO.save(customer);
        logger.info("Customer added: {}", name);
}

    public void viewAllRentals() {
        List<Rental> rentals = rentalDAO.getAllRentals();
        rentals.forEach(r -> IO.println(
                r.getId() + " | Customer: " + r.getCustomer().getName() +
                        " | Vehicle: " + r.getVehicle().getModel() +
                        " | Rented: " + r.getStartDate() +
                        " | Returned: " + r.isReturned()
        ));
    }

    public void viewAllVehicles() {
        VehicleService vehicleService = new VehicleService();
        vehicleService.viewAllVehicles();
    }

    public void viewAllCustomers() {
        CustomerService customerService = new CustomerService();
        customerService.viewAllCustomers();
    }
}

