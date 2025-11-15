package git.joginder.mikael.dao;

import git.joginder.mikael.entity.Vehicle;
import git.joginder.mikael.util.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
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

public List<Vehicle> getAllVehicles(){
    try (EntityManager em = JPAUtil.getEntityManager()) {
        TypedQuery<Vehicle> query =
                em.createQuery("SELECT v FROM Vehicle v", Vehicle.class);
        return query.getResultList();
     }
    }
}
