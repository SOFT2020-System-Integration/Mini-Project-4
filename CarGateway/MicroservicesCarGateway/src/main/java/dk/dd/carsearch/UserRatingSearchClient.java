package dk.dd.carsearch;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.Resources;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

@CrossOrigin
@FeignClient("user-rating")
@RibbonClient(name="user-rating", configuration = RibbonConfig.class)
public interface UserRatingSearchClient
{
    @GetMapping("/users")
    Resources<User> readUsers();


}
