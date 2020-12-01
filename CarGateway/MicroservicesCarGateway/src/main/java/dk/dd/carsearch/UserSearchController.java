package dk.dd.carsearch;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;


@RestController
public class UserSearchController {
    UserRatingSearchClient client;

    public UserSearchController(dk.dd.carsearch.UserRatingSearchClient client) {
        this.client = client;
    }

    @GetMapping("/ratings/{name}")
    @ResponseBody
    @CrossOrigin(origins = "*") // allow request from any client

    public Collection<User> myUser(@PathVariable String name)
    {
        List<User> collect = client.readUsers()
                .getContent()
                .stream()
                .filter(User -> User.getName().equals(name))
                .collect(Collectors.toList());
        return collect;
    }

    @GetMapping("/ratings")
    @ResponseBody
    @CrossOrigin(origins = "*") // allow request from any client

    public Collection<User> myUser()
    {
        List<User> collect = client.readUsers()
                .getContent()
                .stream()
                .collect(Collectors.toList());
        return collect;
    }
}
