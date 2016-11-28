package hystrixdemo;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandProperties;

import java.util.List;

import static java.util.Collections.emptyList;

public class GetUsersCommand extends HystrixCommand<List<User>> {

    private final UsersClient usersClient;

    public GetUsersCommand(UsersClient usersClient) {
        super(Setter
                .withGroupKey(HystrixCommandGroupKey.Factory.asKey("users-command-group"))
                .andCommandPropertiesDefaults(
                        HystrixCommandProperties.Setter().withExecutionTimeoutInMilliseconds(1000)
                )
        );
        this.usersClient = usersClient;
    }

    @Override
    protected List<User> run() throws Exception {
        return usersClient.findAll();
    }

    @Override
    protected List<User> getFallback() {
        return emptyList();
    }
}
