/**
 * Copyright (c) 2016 CA.  All rights reserved.
 * <p>
 * This software and all information contained therein is confidential and proprietary and may not be duplicated, disclosed
 * or reproduced in whole or in part for any purpose except as authorized by the applicable license agreement, without the
 * express written authorization of CA. All authorized reproductions must be marked with this language.
 * <p>
 * TO THE EXTENT PERMITTED BY APPLICABLE LAW, CA PROVIDES THIS SOFTWARE "AS IS" WITHOUT WARRANTY OF ANY KIND,
 * INCLUDING WITHOUT LIMITATION, ANY IMPLIED WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE OR NONINFRINGEMENT.
 * IN NO EVENT WILL CA BE LIABLE TO THE END USER OR ANY THIRD PARTY FOR ANY LOSS OR DAMAGE, DIRECT OR INDIRECT, FROM THE USE OF THIS MATERIAL,
 * INCLUDING WITHOUT LIMITATION, LOST PROFITS, BUSINESS INTERRUPTION, GOODWILL, OR LOST DATA, EVEN IF CA IS EXPRESSLY ADVISED OF SUCH LOSS OR DAMAGE.
 */
package my.painboard.db.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

@Data
@EqualsAndHashCode
@Embeddable
@MappedSuperclass
@ToString
public abstract class PersistentObject implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    @Column(name = "uuid", unique = true)
    private String uuid;

}
