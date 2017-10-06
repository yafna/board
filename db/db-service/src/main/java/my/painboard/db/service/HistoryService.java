package my.painboard.db.service;

import java.util.Date;
import java.util.List;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import lombok.extern.slf4j.Slf4j;
import my.painboard.db.model.History;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Repository
@Transactional
public class HistoryService {
    @PersistenceContext
    private Session em;

    public String create(String event) {
        History history = new History();
        history.setBorn(new Date());
        history.setEvent(event);
        em.saveOrUpdate(history);
        return history.getUuid();
    }

    public List<History> list() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<History> q = cb.createQuery(History.class);
        Root<History> c = q.from(History.class);
        return em.createQuery(q.select(c)).getResultList();
    }
}
