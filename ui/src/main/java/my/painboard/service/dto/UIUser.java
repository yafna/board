package my.painboard.service.dto;

import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import my.painboard.db.model.Team;
import my.painboard.db.model.User;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UIUser {
    private String uuid;
    private String name;
    private String team;
    private List<String> teamUuids = new ArrayList<>();

    public UIUser(User user, List<Team>  teams) {
        this.uuid = user.getUuid();
        this.name = user.getName();
        String ttt = "";
        for(Team t: teams) {
            this.teamUuids.add(t.getUuid());
            ttt += t.getName() + " ";
        }
        this.team = ttt;
    }
}
