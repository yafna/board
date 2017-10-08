package my.painboard.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UIImage {
    private String uuid;
    private String description;
    private Integer level;
    private String name;
}
