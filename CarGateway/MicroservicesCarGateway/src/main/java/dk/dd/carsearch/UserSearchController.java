package dk.dd.carsearch;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

public class UserSearchController {

    private UserRatingSearchClient userClient = null;

    public UserSearchController(UserRatingSearchClient userClient)
    {
        this.userClient = userClient;
    }

    @GetMapping("/myusers")
    @ResponseBody
    @CrossOrigin(origins = "*") // allow request from any client
    @HystrixCommand(fallbackMethod = "fallback") // in case of failure
    public Collection<User> myUser()
    {
        return userClient.readUsers()
                .getContent()
                .stream()
                .filter(this :: isMine)
                .collect(Collectors.toList());
    }

    private boolean isMine(User user)
    {
        return  user.getName().equals("Andreas");
    }

    private Collection<User> fallback()
    {
        return new ArrayList<>();
    }
}
