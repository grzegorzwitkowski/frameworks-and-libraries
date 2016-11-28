package hystrixdemo;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandProperties;

import java.util.List;

import static java.util.Collections.emptyList;

public class GetUsersCommand extends HystrixCommand<List<User>> {

    private final UsersClient usersClient;

    public GetUsersCommand(UsersClient usersClient, int timeoutMillis) {
        super(Setter
                .withGroupKey(HystrixCommandGroupKey.Factory.asKey("users-command-group"))
                .andCommandPropertiesDefaults(
                        HystrixCommandProperties.Setter().withExecutionTimeoutInMilliseconds(timeoutMillis)
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
