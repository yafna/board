package my.painboard.service.controller;

import java.util.ArrayList;
import java.util.List;
import my.painboard.db.model.User;
import my.painboard.db.service.UserService;
import my.painboard.service.dto.ActionResult;
import my.painboard.service.dto.UIUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/hello")
    public String hellohere() {
        return "Helloworld";
    }

    @RequestMapping("/users")
    public
    @ResponseBody
    List<UIUser> listUsers() {
        List<UIUser> res = new ArrayList<>();
        for (User item : userService.list()) {
            res.add(new UIUser(item.getUuid(), item.getName(), item.getTeam()));
        }
        return res;
    }

    @RequestMapping("/addUser")
    public
    @ResponseBody
    ActionResult addUser(@RequestBody UIUser user) {
        userService.create(user.getName(), user.getTeam());
        return new ActionResult(true, "Seems that ok");
    }


    @RequestMapping("/removeUser")
    public
    @ResponseBody
    ActionResult removeUser(String uuid) {
        userService.remove(uuid);
        return new ActionResult(true, "Seems that ok");
    }
}
