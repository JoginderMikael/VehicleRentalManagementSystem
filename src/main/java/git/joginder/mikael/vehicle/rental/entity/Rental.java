package git.joginder.mikael.vehicle.rental.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "Rentals")
public class Rental {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Customer customer;

    @ManyToOne
    private Vehicle vehicle;

    private LocalDate startDate;
    private LocalDate endDate;
    private double totalCost;
    private boolean isReturned;

    public Rental() {
    }

    public Long getId() {
        return this.id;
    }

    public Rental setId(Long id) {
        this.id = id;
        return this;
    }

    public Customer getCustomer() {
        return this.customer;
    }

    public Rental setCustomer(Customer customer) {
        this.customer = customer;
        return this;
    }

    public Vehicle getVehicle() {
        return this.vehicle;
    }

    public Rental setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
        return this;
    }

    public LocalDate getStartDate() {
        return this.startDate;
    }

    public Rental setStartDate(LocalDate startDate) {
        this.startDate = startDate;
        return this;
    }

    public LocalDate getEndDate() {
        return this.endDate;
    }

    public Rental setEndDate(LocalDate endDate) {
        this.endDate = endDate;
        return this;
    }

    public double getTotalCost() {
        return this.totalCost;
    }

    public Rental setTotalCost(double totalCost) {
        this.totalCost = totalCost;
        return this;
    }

    public boolean isReturned() {
        return this.isReturned;
    }

    public Rental setReturned(boolean returned) {
        isReturned = returned;
        return this;
    }

    @Override
    public String toString() {
        return "\nRENTAL DETAILS \n"
                + "ID: \t" + this.getId() + "\n"
                + "CUSTOMER: \t" + (this.getCustomer() != null ? this.getCustomer().getName() : "None" )+ "\n"
                + "VEHICLE: \t" + (this.getVehicle() != null ? this.getVehicle().getModel(): "None") + "\n"
                + "START DATE: \t" + this.getStartDate() + "\n"
                + "END DATE: \t" + this.getEndDate() + "\n"
                + "TOTAL COST: \t" + this.getTotalCost() + "\n"
                + "IS RETURNED: \t" + this.isReturned() + "\n";
    }
}
