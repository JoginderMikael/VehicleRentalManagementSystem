package git.joginder.mikael;

import git.joginder.mikael.service.RentalService;

import git.joginder.mikael.util.ConsoleUtil;
import git.joginder.mikael.util.JPAUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class App {

    private static final Logger logger = LoggerFactory.getLogger(App.class);


    static void main() {
        IO.println("----------------------");
        IO.println("VEHICLE RENTAL SYSTEM");
        IO.println("----------------------");

        var rentalService = new RentalService();

        while(true){
            IO.println("\n=== VEHICLE RENTAL SYSTEM ===");
            IO.println("1. Add Vehicle");
            IO.println("2. View All Vehicles");
            IO.println("3. Add Customer");
            IO.println("4. View All Customers");
            IO.println("5. Rent a Vehicle");
            IO.println("6. Return a Vehicle.");
            IO.println("7. View All Rentals");
            IO.println("0. Exit");

            int choice = ConsoleUtil.readInt("Enter Your choice: ");

            switch (choice){
                case 1 ->{
                    String model = ConsoleUtil.readString("Model: ");
                    String type = ConsoleUtil.readString("Type: ");
                    double dailyRate = ConsoleUtil.readDouble("Daily Rate: ");
                    rentalService.addVehicle(model, type, dailyRate);
                    break;
                }
                case 2 -> {
                    rentalService.viewAllVehicles();
                    break;
                }
                case 3 -> {
                    String name = ConsoleUtil.readString("Customer Name: ");
                    String phone = ConsoleUtil.readString("Phone: ");
                    String email = ConsoleUtil.readString("Email: ");
                    rentalService.addCustomer(name, phone, email);
                    break;

                }
                case 4 -> {
                    rentalService.viewAllCustomers();
                    break;
                }
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
                case 7 -> {
                    rentalService.viewAllRentals();
                    break;
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
