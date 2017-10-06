package my.painboard.db.model;

import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class Vacation {
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "from_id", nullable = false)
    private ReportDay from;
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "to_id", nullable = false)
    private ReportDay to;
}
