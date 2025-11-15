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
            IO.println("1. Rent a Vehicle");
            IO.println("2. Return a Vehicle.");
            IO.println("3. Exit");

            int choice = Integer.parseInt(ConsoleUtil.read("Enter Your choice: "));

            switch (choice){
                case 1 -> {
                    Long custId = Long.parseLong(ConsoleUtil.read("Customer ID: "));
                    Long vehId = Long.parseLong(ConsoleUtil.read("Vehicle ID: "));
                    int days = Integer.parseInt(ConsoleUtil.read("Days: "));
                    rentalService.rentVehicle(custId,vehId,days);
                }
                case 2 -> {
                    Long rentId = Long.parseLong(ConsoleUtil.read("Rental ID: "));
                    rentalService.returnVehicle(rentId);
                }
                case 3 ->  {
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
