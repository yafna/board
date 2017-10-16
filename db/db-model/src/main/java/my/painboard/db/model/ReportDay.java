package my.painboard.db.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "REPORT_DAY")
public class ReportDay extends PersistentObject {
    @Column(name = "day", nullable = false)
    private int day;
    @Column(name = "year", nullable = false)
    private int year;
}
