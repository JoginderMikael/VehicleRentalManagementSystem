package git.joginder.mikael;

import git.joginder.mikael.dao.RentalDAO;
import git.joginder.mikael.entity.Customer;
import git.joginder.mikael.entity.Rental;
import git.joginder.mikael.entity.Vehicle;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.time.LocalDate;
import java.time.LocalTime;

public class App {

    private static final Logger log = LoggerFactory.getLogger(App.class);


    static void main() {
        IO.println("----------------------");
        IO.println("VEHICLE RENTAL SYSTEM");
        IO.println("----------------------");

//        Customer customer = new Customer()
//                .setName("Alex Mathenge")
//                .setPhone("0797753726")
//                .setEmail("Alex@gmail.com");
//
//
//        Vehicle vehicle = new Vehicle()
//                .setAvailable(true)
//                .setType("Tesla")
//                .setModel("ModelX")
//                .setDailyRate(100);
//
//        Rental rental = new Rental()
//                .setCustomer(customer)
//                .setVehicle(vehicle)
//                .setStartDate(LocalDate.now())
//                .setEndDate(LocalDate.from(LocalDate.now().atTime(LocalTime.MAX)))
//                .setTotalCost(vehicle.getDailyRate() * 2)
//                .setReturned(true);


       // IO.println(customer.toString());
       // IO.println(vehicle.toString());
        // IO.println(rental.toString());

        Configuration config = new Configuration()
            .addAnnotatedClass(git.joginder.mikael.entity.Rental.class)
            .addAnnotatedClass(git.joginder.mikael.entity.Customer.class)
            .addAnnotatedClass(git.joginder.mikael.entity.Vehicle.class)
            .configure("hibernate.cfg.xml");

        SessionFactory factory = config.buildSessionFactory();
        Session session = factory.openSession();

      //  Transaction transaction = session.beginTransaction();

        //inserting data
//        session.persist(rental);
//        session.persist(customer);
//        session.persist(vehicle);

        //fetching data
        Customer customer = session.find(Customer.class, 1);
        customer.setId(1L);


        IO.println(customer);
//        Rental rental = session.get(Rental.class, 1);
//        Vehicle vehicle = session.get(Vehicle.class, 1);
//        IO.println(rental.toString());
      //  transaction.commit();

        factory.close();
        session.close();
    }


}
