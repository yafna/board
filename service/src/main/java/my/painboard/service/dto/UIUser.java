package my.painboard.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import my.painboard.db.model.User;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UIUser {
    private String uuid;
    private String name;
    private String team;
    private String teamUuid;
    public UIUser(User user) {
        this.uuid = user.getUuid();
        this.name = user.getName();
        this.team = user.getTeam().getName();
        this.teamUuid = user.getTeam().getUuid();
    }
}
