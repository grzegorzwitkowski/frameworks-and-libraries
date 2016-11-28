package hystrixdemo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
public class UsersController {

    private Map<String, User> users = new HashMap<String, User>() {{
        put("1", new User("1", "Jan", "Kowalski", 24));
        put("2", new User("2", "Anna", "Nowak", 25));
    }};

    @RequestMapping(path = "/users", method = GET)
    public List<User> findAll() {
        return new LinkedList<>(users.values());
    }
}
