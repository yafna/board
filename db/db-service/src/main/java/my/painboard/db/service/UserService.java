package my.painboard.db.service;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import lombok.extern.slf4j.Slf4j;
import my.painboard.db.model.User;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Slf4j
@Repository
public class UserService {
    @PersistenceContext
    private EntityManager em;

    public void add(String name, String team) {
        User user = new User();
        user.setName(name);
        user.setTeam(team);
        em.persist(user);
    }

    public void remove(String uuid) {

    }

    public List<User> list() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<User> q = cb.createQuery(User.class);
        Root<User> c = q.from(User.class);
        return em.createQuery(q.select(c)).getResultList();
    }
}
