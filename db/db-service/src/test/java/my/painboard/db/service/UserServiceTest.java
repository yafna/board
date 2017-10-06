package my.painboard.db.service;

import java.util.UUID;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceTest extends BaseTest {

    @Autowired
    private UserService userService;

    @Test
    public void getByUuid() throws Exception {
        String name = UUID.randomUUID().toString();
        String uuid = userService.create(name, "bdd");
        Assert.assertNotNull(uuid);
        Assert.assertEquals(name, userService.getByUuid(uuid).getName());
    }

    @Test
    public void testListAll() {
        int size = userService.list().size();
        String uuid = userService.create("a", "b");
        Assert.assertNotNull(uuid);
        userService.create("c", "d");
        Assert.assertEquals(size + 2, userService.list().size());
    }

    @Test
    public void testDelete() {
        int size = userService.list().size();
        int removedsize = userService.removed().size();
        String uuid = userService.create("ad", "bd");
        userService.create("cd", "dd");
        Assert.assertEquals(size + 2, userService.list().size());
        userService.remove(uuid);
        Assert.assertEquals(size + 1, userService.list().size());
        Assert.assertEquals(removedsize + 1, userService.removed().size());
    }
}
