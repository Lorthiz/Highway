package wspa.groupproject.highway.repository;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import wspa.groupproject.highway.model.Vehicle;

import javax.persistence.EntityManager;
import java.util.List;

@Component
public class VehicleRepositoryImpl implements VehicleRepository {

    @Autowired
    private EntityManager entityManager;

    @Override
    public Vehicle findById(Long id) {
        return getSession().get(Vehicle.class, id);
    }

    @Override
    public void changeStatus(Long id) {
        Vehicle vehicle = findById(id);
        vehicle.setStatus(!vehicle.isStatus());
        getSession().update(vehicle);
    }

    @Override
    public List<Vehicle> findAll() {
        return getSession().createQuery("from Vehicle", Vehicle.class).getResultList();
    }

    @Override
    public void save(Vehicle vehicle) {
        getSession().save(vehicle);
    }

    private Session getSession() {
        return entityManager.unwrap(Session.class);
    }
}
