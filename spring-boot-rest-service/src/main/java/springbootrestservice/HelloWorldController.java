package springbootrestservice;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @RequestMapping(path = "hello", method = RequestMethod.GET)
    public String sayHelloWorld(@RequestParam(name = "name", required = false) String name) {
        return String.format("Hello %s!", name != null ? name : "World");
    }
}
