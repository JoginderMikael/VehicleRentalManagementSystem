package git.joginder.mikael.ui;

import git.joginder.mikael.service.CustomerService;
import git.joginder.mikael.service.RentalService;
import git.joginder.mikael.service.VehicleService;
import git.joginder.mikael.util.ConsoleUtil;
import git.joginder.mikael.util.JPAUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MainMenu {

    private static final Logger logger = LoggerFactory.getLogger(MainMenu.class);

    public static void mainMenu(){

        var rentalService = new RentalService();
        var customerService = new CustomerService();
        var vehicleService = new VehicleService();

        while(true){
            IO.println("----------------------");
            IO.println("VEHICLE RENTAL SYSTEM");
            IO.println("----------------------");
            IO.println("1. Add Vehicle.");
            IO.println("2. View All Vehicles.");
            IO.println("3. Add Customer.");
            IO.println("4. View All Customers.");
            IO.println("5. Rent a Vehicle.");
            IO.println("6. Return a Vehicle.");
            IO.println("7. View All Rentals.");
            IO.println("8. Search Customer by ID.");
            IO.println("9. Search Vehicle by ID.");
            IO.println("0. Exit");

            int choice = ConsoleUtil.readInt("Enter Your choice: ");

            switch (choice){
                case 1 ->{
                    String model = ConsoleUtil.readString("Model: ");
                    String type = ConsoleUtil.readString("Type: ");
                    double dailyRate = ConsoleUtil.readDouble("Daily Rate: ");
                    vehicleService.addVehicle(model, type, dailyRate);
                }
                case 2 -> vehicleService.viewAllVehicles();
                case 3 -> {
                    String name = ConsoleUtil.readString("Customer Name: ");
                    String phone = ConsoleUtil.readString("Phone: ");
                    String email = ConsoleUtil.readString("Email: ");
                    customerService.addCustomer(name, phone, email);

                }
                case 4 -> customerService.viewAllCustomers();
                case 5 -> {
                    Long custId = ConsoleUtil.readLong("Customer ID: ");
                    Long vehId = ConsoleUtil.readLong("Vehicle ID: ");
                    int days = ConsoleUtil.readInt("Days: ");
                    rentalService.rentVehicle(custId,vehId,days);
                }
                case 6 -> {
                    Long rentId = ConsoleUtil.readLong("Rental ID: ");
                    rentalService.returnVehicle(rentId);
                }
                case 7 -> rentalService.viewAllRentals();
                case 8 -> {
                    Long customerId = ConsoleUtil.readLong("Customer ID: ");
                    customerService.searchCustomerById(customerId);
                }
                case 9 -> {
                    Long vehicleId = ConsoleUtil.readLong("Vehicle ID: ");
                    vehicleService.searchVehicleById(vehicleId);
                }
                case 0 ->  {
                    logger.info("System exiting...");
                    JPAUtil.shutDown();
                    IO.println("GoodBye!");
                    return;
                }
                default ->  IO.println("Invalid Choice!");

            }
        }
    }
}
