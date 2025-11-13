package git.joginder.mikael.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "customers")
public class Customer {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String phone;
    private String email;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Rental> rentals = new ArrayList<>();

    public Customer() {
    }

    public Long getId() {
        return id;
    }

    public Customer setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Customer setName(String name) {
        this.name = name;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public Customer setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Customer setEmail(String email) {
        this.email = email;
        return this;
    }

    public List<Rental> getRentals() {
        return rentals;
    }

    public Customer setRentals(List<Rental> rentals) {
        this.rentals = rentals;
        return this;
    }

    @Override
    public String toString() {
        return "\nCUSTOMER DETAILS \n"
                + "ID: \t" + this.getId() + "\n"
                + "NAME: \t" + this.getName() + "\n"
                + "PHONE: \t" + this.getPhone() + "\n"
                + "EMAIL: \t" + this.getEmail() + "\n"
                + "RENTALS: \t" + this.getRentals()+ "\n";
    }

}
