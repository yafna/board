package my.painboard.db.service;

import java.util.UUID;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceTest extends BaseTest {

    @Autowired
    private UserService userService;
    @Autowired
    private TeamService teamService;

    @Test
    public void testGetByUuid() throws Exception {
        String teamuuid = teamService.create("dfs");
        String name = UUID.randomUUID().toString();
        String uuid = userService.create(name, teamuuid);
        Assert.assertNotNull(uuid);
        Assert.assertEquals(name, userService.getByUuid(uuid).getName());
    }
    @Test
    public void testUpdate() throws Exception {
        String teamuuid = teamService.create("dfs");
        String name = UUID.randomUUID().toString();
        String uuid = userService.create(name, teamuuid);
        Assert.assertNotNull(uuid);
        Assert.assertEquals(name, userService.getByUuid(uuid).getName());

        String newTeamuuid = teamService.create("aaa");
        String newName = UUID.randomUUID().toString();
        userService.update(uuid, newName, newTeamuuid);
        Assert.assertEquals(newName, userService.getByUuid(uuid).getName());
        Assert.assertEquals(newTeamuuid, userService.getByUuid(uuid).getTeam().getUuid());
    }
    @Test
    public void testListAll() {
        String teamuuid = teamService.create("dfs");
        int size = userService.list().size();
        String uuid = userService.create("a", teamuuid);
        Assert.assertNotNull(uuid);
        userService.create("c", teamuuid);
        Assert.assertEquals(size + 2, userService.list().size());
    }

    @Test
    public void testDelete() {
        String teamuuid = teamService.create("dfs");
        int size = userService.list().size();
        int removedsize = userService.removed().size();
        String uuid = userService.create("ad", teamuuid);
        userService.create("cd", teamuuid);
        Assert.assertEquals(size + 2, userService.list().size());
        userService.remove(uuid);
        Assert.assertEquals(size + 1, userService.list().size());
        Assert.assertEquals(removedsize + 1, userService.removed().size());
    }
}
