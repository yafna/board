package my.painboard.db.service;

import javax.persistence.PersistenceContext;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Repository
@Transactional
public class VacationService {

    @PersistenceContext
    private Session em;

}
