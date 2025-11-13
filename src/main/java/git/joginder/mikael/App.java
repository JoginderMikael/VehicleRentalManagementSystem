package git.joginder.mikael;

import git.joginder.mikael.entity.Customer;
import git.joginder.mikael.entity.Rental;
import git.joginder.mikael.entity.Vehicle;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


import java.time.LocalDate;
import java.time.LocalTime;

public class App {
    static void main() {
        IO.println("----------------------");
        IO.println("VEHICLE RENTAL SYSTEM");
        IO.println("----------------------");

        Customer customer = new Customer()
                .setName("Alex Mathenge")
                .setPhone("0797753726")
                .setEmail("Alex@gmail.com");


        Vehicle vehicle = new Vehicle()
                .setAvailable(true)
                .setType("Tesla")
                .setModel("ModelX")
                .setDailyRate(100);

        Rental rental = new Rental()
                .setCustomer(customer)
                .setVehicle(vehicle)
                .setStartDate(LocalDate.now())
                .setEndDate(LocalDate.from(LocalDate.now().atTime(LocalTime.MAX)))
                .setTotalCost(vehicle.getDailyRate() * 2)
                .setReturned(true);


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

        Transaction transaction = session.beginTransaction();

        session.persist(rental);
        session.persist(customer);
        session.persist(vehicle);

        transaction.commit();

        factory.close();
        session.close();
    }


}
