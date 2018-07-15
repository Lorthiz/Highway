package wspa.groupproject.highway.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import wspa.groupproject.highway.model.Ride;

import java.util.List;

@Repository
@Transactional
public interface RideRepository {

    Ride findById(Long id);

    List<Ride> findByStudentId(Long id);

    List<Ride> findByInstructorId(Long id);

    List<Ride> findForInterval(Long start, Long end);

    List<Ride> findAll();

    void save(Ride ride);

    void saveOrUpdate(Ride ride);

}
