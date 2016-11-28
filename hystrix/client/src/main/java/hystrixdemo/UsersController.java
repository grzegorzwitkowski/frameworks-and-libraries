package hystrixdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.toMap;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
public class UsersController {

    private final UsersClient usersClient;
    private final int timeoutMillis;

    @Autowired
    public UsersController(UsersClient usersClient, @Value("${services.users-repository.timeout}") int timeoutMillis) {
        this.usersClient = usersClient;
        this.timeoutMillis = timeoutMillis;
    }

    @RequestMapping(path = "/users", method = GET)
    public Map<String, User> findAll() {
        return new GetUsersCommand(usersClient, timeoutMillis).execute()
                .stream()
                .collect(toMap(User::getId, identity()));
    }
}
