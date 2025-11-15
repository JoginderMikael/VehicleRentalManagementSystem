package git.joginder.mikael.vehicle.rental.service;

import git.joginder.mikael.vehicle.rental.dao.VehicleDAO;
import git.joginder.mikael.vehicle.rental.entity.Vehicle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class VehicleService {

    private static final Logger logger = LoggerFactory.getLogger(VehicleService.class);
    private final VehicleDAO vehicleDAO = new VehicleDAO();

    public void viewAllVehicles() {
        VehicleDAO vehicleDAO = new VehicleDAO();
        List<Vehicle> vehicles = vehicleDAO.getAllVehicles();
        vehicles.forEach(IO::println); //utilizing the toString method. v.toString()
    }

    public void searchVehicleById(Long Id){
        logger.info("Searching vehicle by Id: {}", Id);

        VehicleDAO vehicleDAO = new VehicleDAO();
        Vehicle vehicle = vehicleDAO.findById(Id);

        if(vehicle == null){
            IO.println("No vehicle found with ID: " + Id);
            logger.warn("Vehicle search filed. No customer found for ID {}", Id);
            return;
        }

        IO.println("Vehicle found: \n" + vehicle);
        logger.info("Vehicle found: {}", vehicle.getId());
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
        IO.println("Vehicle Added successfully.");
    }

}
