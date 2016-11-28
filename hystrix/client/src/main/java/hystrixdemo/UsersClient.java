package hystrixdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Component
public class UsersClient {

    private RestTemplate restTemplate;

    @Autowired
    public UsersClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<User> findAll() {
        User[] users = restTemplate.getForObject("http://localhost:8081/users", User[].class);
        return Arrays.asList(users);
    }
}
