package my.painboard.service.controller;

import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import my.painboard.db.model.Team;
import my.painboard.db.service.TeamService;
import my.painboard.db.service.UserService;
import my.painboard.service.dto.UITeam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/team")
public class TeamContoller {
    @Autowired
    private TeamService teamService;
    @Autowired
    private UserService userService;

    @RequestMapping("/list")
    public
    @ResponseBody
    List<UITeam> list() {
        List<UITeam> res = new ArrayList<>();
        for (Team item : teamService.list()) {
            res.add(new UITeam(item.getUuid(), item.getName()));
        }
        return res;
    }

    @RequestMapping(value = "/modify", method = RequestMethod.POST, produces = MediaType.TEXT_HTML_VALUE)
    public void addTeam(@RequestBody UITeam team) {
        System.out.println("team = " + team.getUuid());
        System.out.println("team = " + team.getName());
        if (team.getUuid() == null) {
            teamService.create(team.getName());
        } else {
            teamService.update(team.getUuid(), team.getName());
        }
        log.debug("seems ok");
    }


    @RequestMapping("/remove/{uuid}")
    public void removeTeam(@PathVariable String uuid) {
        teamService.remove(uuid);
    }
}
