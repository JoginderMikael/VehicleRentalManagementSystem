package git.joginder.mikael.dao;

import git.joginder.mikael.entity.Vehicle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class VehicleDAO extends GenericDAO<Vehicle> {

    private static final Logger logger = LoggerFactory.getLogger(VehicleDAO.class);

    public VehicleDAO(){
        super(Vehicle.class);
    }
public List<Vehicle> findAvailable(){
        logger.info("Querying all available vehicles");
        return em.createQuery("FROM Vehicle v WHERE v.isvailable = true", Vehicle.class).
                getResultList();
}
}
