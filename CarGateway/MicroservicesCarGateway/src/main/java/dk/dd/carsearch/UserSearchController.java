package dk.dd.carsearch;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;


@RestController
public class UserSearchController {
    UserRatingSearchClient client;

    public UserSearchController(dk.dd.carsearch.UserRatingSearchClient client) {
        this.client = client;
    }

    @GetMapping("/myusers")
    @ResponseBody
    @CrossOrigin(origins = "*") // allow request from any client
    @HystrixCommand(fallbackMethod = "fallback") // in case of failure
    public Collection<User> myUser()
    {
        return client.readUsers()
                .getContent()
                .stream()
                .filter(this :: isMine)
                .collect(Collectors.toList());
    }



    private boolean isMine(User user)
    {
        return  user.getName().equals("Bobby Jones");
    }

    private Collection<User> fallback()
    {
        return new ArrayList<>();
    }
}
