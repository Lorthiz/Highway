package wspa.groupproject.highway.repository;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import wspa.groupproject.highway.model.Ride;

import javax.persistence.EntityManager;
import java.util.List;

@Component
public class RideRepositoryImpl implements RideRepository {

    @Autowired
    private EntityManager entityManager;

    @Override
    public Ride findById(Long id) {
        return getSession().get(Ride.class, id);
    }

    @Override
    public List<Ride> findByStudentId(Long studentId) {
        String hql = "from Ride R where R.student.id = :studentId";
        return getSession().createQuery(hql, Ride.class)
                .setParameter("studentId", studentId)
                .getResultList();
    }

    @Override
    public List<Ride> findByInstructorId(Long instructorId) {
        String hql = "from Ride R where R.instructor.id = :instructorId";
        return getSession().createQuery(hql, Ride.class)
                .setParameter("instructorId", instructorId)
                .getResultList();
    }

    @Override
    public List<Ride> findByUserId(Long userId) {
        String hql = "from Ride R where R.instructor.id = :userId or R.student.id = :userId";
        return getSession().createQuery(hql, Ride.class)
                .setParameter("userId", userId)
                .getResultList();
    }

    @Override
    public List<Ride> findForInterval(Long start, Long end) {
        return null;
    }

    @Override
    public List<Ride> findAll() {
        return getSession().createQuery("from Ride", Ride.class).getResultList();
    }

    @Override
    public void save(Ride ride) {
        getSession().save(ride);
    }

    @Override
    public void saveOrUpdate(Ride ride) {
        getSession().saveOrUpdate(ride);
    }

    @Override
    public void deleteById(Long id) {
        Ride toRemove = findById(id);
        getSession().delete(toRemove);
    }

    private Session getSession() {
        return entityManager.unwrap(Session.class);
    }
}
