package git.joginder.mikael.dao;

import git.joginder.mikael.entity.Rental;
import jakarta.persistence.TypedQuery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class RentalDAO extends GenericDAO<Rental>{
    private static final Logger log = LoggerFactory.getLogger(RentalDAO.class);

    public RentalDAO() {
        super(Rental.class);
    }

    //List all the rentals
    public List<Rental> getAllRentals(){
        try{
            TypedQuery<Rental> query =
                    em.createQuery("SELECT r FROM Rental r", Rental.class);
            return query.getResultList();
        }finally {
            em.close();
        }
    }
}
