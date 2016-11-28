package hystrixdemo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import java.util.concurrent.TimeUnit;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
public class UsersRepositoryController {

    private final Random random = new Random();

    private Map<String, User> users = new HashMap<String, User>() {{
        put("1", new User("1", "Jan", "Kowalski", 24));
        put("2", new User("2", "Anna", "Nowak", 25));
    }};

    @RequestMapping(path = "/users", method = GET)
    public List<User> findAll() throws InterruptedException {
        List<User> users = new LinkedList<>(this.users.values());
        long delay = 100 + random.nextInt(200); // delay from 100 to 300 ms
        TimeUnit.MILLISECONDS.sleep(delay);
        return users;
    }
}
