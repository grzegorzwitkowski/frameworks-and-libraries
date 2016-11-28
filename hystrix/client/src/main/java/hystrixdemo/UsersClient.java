package hystrixdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Component
public class UsersClient {

    private RestTemplate restTemplate;
    private final String usersResource;

    @Autowired
    public UsersClient(RestTemplate restTemplate, @Value("${services.users-repository.url}") String usersRepositoryUrl) {
        this.restTemplate = restTemplate;
        this.usersResource = usersRepositoryUrl + "/users";
    }

    public List<User> findAll() {
        User[] users = restTemplate.getForObject(usersResource, User[].class);
        return Arrays.asList(users);
    }
}
