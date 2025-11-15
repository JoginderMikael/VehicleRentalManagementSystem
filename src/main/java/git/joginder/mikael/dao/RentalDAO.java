package git.joginder.mikael.dao;

import git.joginder.mikael.entity.Rental;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RentalDAO extends GenericDAO<Rental>{
    private static final Logger log = LoggerFactory.getLogger(RentalDAO.class);

    public RentalDAO() {
        super(Rental.class);
    }
}
