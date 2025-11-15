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

public class RentalService {

    private static final Logger logger = LoggerFactory.getLogger(RentalService.class);

    private final VehicleDAO vehicleDAO = new VehicleDAO();
    private final CustomerDAO customerDAO = new CustomerDAO();
    private final RentalDAO rentalDAO = new RentalDAO();


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
            logger.warn("Vehicle ID = {} is not available", vehicleId);
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

        logger.info("Vehicle ID = {} returned successfully.", vehicle.getId());
        IO.println("Vehicle returned successfully!");
    }


}

