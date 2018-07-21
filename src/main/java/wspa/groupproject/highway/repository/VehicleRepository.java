package wspa.groupproject.highway.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import wspa.groupproject.highway.model.User;
import wspa.groupproject.highway.model.Vehicle;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface VehicleRepository {

    Vehicle findById(Long id);

    List<Vehicle> findAll();

}
