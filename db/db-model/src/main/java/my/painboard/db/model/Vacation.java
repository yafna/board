package my.painboard.db.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "VACATION")
public class Vacation extends PersistentObject {
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
