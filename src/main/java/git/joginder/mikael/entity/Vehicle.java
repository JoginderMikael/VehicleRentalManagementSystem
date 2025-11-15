package git.joginder.mikael.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "vehicles")
public class Vehicle {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String model;
    private String type;
    private double dailyRate;
    private boolean isAvailable;

    @OneToMany(mappedBy = "vehicle", cascade = CascadeType.ALL)
    private List<Rental> rental = new ArrayList<>();

    public Vehicle() {
    }

    public Long getId() {
        return id;
    }

    public Vehicle setId(Long id) {
        this.id = id;
        return this;
    }

    public String getModel() {
        return model;
    }

    public Vehicle setModel(String model) {
        this.model = model;
        return this;
    }

    public String getType() {
        return type;
    }

    public Vehicle setType(String type) {
        this.type = type;
        return this;
    }

    public double getDailyRate() {
        return dailyRate;
    }

    public Vehicle setDailyRate(double dailyRate) {
        this.dailyRate = dailyRate;
        return this;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public Vehicle setAvailable(boolean available) {
        isAvailable = available;
        return this;
    }

    public List<Rental> getRental() {
        return rental;
    }

    public Vehicle setRental(List<Rental> rental) {
        this.rental = rental;
        return this;
    }

    @Override
    public String toString() {
        return "\nVEHICLE DETAILS \n"
                + "ID: \t" + this.getId() + "\n"
                + "MODEL: \t" + this.getModel() + "\n"
                + "TYPE: \t" + this.getType() + "\n"
                + "DAILY RATE: \t" + this.getDailyRate() + "\n"
                + "AVAILABLE: \t" + this.isAvailable() + "\n"
                + "RENTAL: \t" + (this.getRental() != null ? this.getRental().size() : "None" ) + "\n"
                ;
    }
}
