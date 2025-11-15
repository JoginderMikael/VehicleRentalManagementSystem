package git.joginder.mikael;

import git.joginder.mikael.ui.MainMenu;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class App {

    private static final Logger logger = LoggerFactory.getLogger(App.class);
    static void main() {
        logger.info("Initializing the Rental service....");
        MainMenu.mainMenu();
    }
}
