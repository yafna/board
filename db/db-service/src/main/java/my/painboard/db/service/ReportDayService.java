package my.painboard.db.service;

import java.util.List;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import lombok.extern.slf4j.Slf4j;
import my.painboard.db.model.ReportDay;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Repository
@Transactional
public class ReportDayService {
    @PersistenceContext
    private Session em;

    public String create(int day, int year) {
        ReportDay reportDay = new ReportDay();
        reportDay.setDay(day);
        reportDay.setYear(year);
        em.saveOrUpdate(reportDay);
        return reportDay.getUuid();
    }

    public List<ReportDay> getDays() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<ReportDay> q = cb.createQuery(ReportDay.class);
        Root<ReportDay> c = q.from(ReportDay.class);
        return em.createQuery(q.select(c)).getResultList();
    }
}
