package git.joginder.mikael;

import git.joginder.mikael.service.CustomerService;
import git.joginder.mikael.service.RentalService;

import git.joginder.mikael.service.VehicleService;
import git.joginder.mikael.ui.MainMenu;
import git.joginder.mikael.util.ConsoleUtil;
import git.joginder.mikael.util.JPAUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class App {

    private static final Logger logger = LoggerFactory.getLogger(App.class);
    static void main() {
        logger.info("Initializing the Rental service....");
        MainMenu.mainMenu();
    }
}
