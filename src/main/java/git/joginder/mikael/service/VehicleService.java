package git.joginder.mikael.service;

import git.joginder.mikael.dao.RentalDAO;
import git.joginder.mikael.dao.VehicleDAO;
import git.joginder.mikael.entity.Vehicle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class VehicleService {

    private static final Logger logger = LoggerFactory.getLogger(VehicleService.class);

    public void viewAllVehicles() {
        VehicleDAO vehicleDAO = new VehicleDAO();
        List<Vehicle> vehicles = vehicleDAO.getAllVehicles();
        vehicles.forEach(IO::println); //utilizing the toString method. v.toString()
    }

}
