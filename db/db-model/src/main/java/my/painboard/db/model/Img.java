package my.painboard.db.model;

import java.util.Date;
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
@Table(name = "img")
public class Img extends PersistentObject {
    @Column(name = "level", nullable = false)
    private Integer level;
    @Column(name = "path", nullable = false)
    private String path;
    @Column(name = "desc")
    private String desc;
}
