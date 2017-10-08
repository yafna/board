package my.painboard.db.service;

import java.util.Date;
import java.util.List;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;
import lombok.extern.slf4j.Slf4j;
import my.painboard.db.model.User;
import my.painboard.db.model.User_;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Repository
@Transactional
public class UserService {
    @PersistenceContext
    private Session em;
    @Autowired
    private TeamService teamService;

    public String create(String name, String teamUuid) {
        User user = new User();
        user.setName(name);
        user.setTeam(teamService.getByUuid(teamUuid));
        user.setBorn(new Date());
        em.saveOrUpdate(user);
        return user.getUuid();
    }

    public void update(String uuid, String name, String teamUuid){
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaUpdate<User> q = cb.createCriteriaUpdate(User.class);
        Root<User> c = q.from(User.class);
        q.set(c.get(User_.modified), new Date())
                .set(c.get(User_.name), name)
                .set(c.get(User_.team), teamService.getByUuid(teamUuid))
                .where(cb.equal(c.get(User_.uuid), uuid));
        em.createQuery(q).executeUpdate();
    }

    public void remove(String uuid) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaUpdate<User> q = cb.createCriteriaUpdate(User.class);
        Root<User> c = q.from(User.class);
        q.set(c.get(User_.dead), new Date()).where(cb.equal(c.get(User_.uuid), uuid));
        em.createQuery(q).executeUpdate();
    }

    public User getByUuid(String uuid) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<User> q = cb.createQuery(User.class);
        Root<User> c = q.from(User.class);
        q.where(cb.equal(c.get(User_.uuid), uuid));
        return em.createQuery(q.select(c)).getSingleResult();
    }

    public List<User> list() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<User> q = cb.createQuery(User.class);
        Root<User> c = q.from(User.class);
        q.where(cb.isNull(c.get(User_.dead)));
        return em.createQuery(q.select(c)).getResultList();
    }

    public List<User> removed() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<User> q = cb.createQuery(User.class);
        Root<User> c = q.from(User.class);
        q.where(cb.isNotNull(c.get(User_.dead)));
        return em.createQuery(q.select(c)).getResultList();
    }
}
