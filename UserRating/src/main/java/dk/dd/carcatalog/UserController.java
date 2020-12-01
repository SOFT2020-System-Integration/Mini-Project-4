package dk.dd.carcatalog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Queue;
import static org.springframework.data.mongodb.core.query.Criteria.where;

//@RepositoryRestController
@RepositoryRestResource
@ResponseBody
//@RestController
@RequestMapping("/users")
public class UserController
{
    @Autowired
    private UserRepo repo;
    private Object user;



    @GetMapping("/")
    public List<dk.dd.carcatalog.User> retrieveAllUsers()
    {
        return (List<dk.dd.carcatalog.User>) repo.findAll();
    }

    @GetMapping("/{name}")
    public dk.dd.carcatalog.User findByName(@PathVariable String name)
    {
        return repo.findByName(name);
    }


    /*
    @GetMapping("/")
    public List<User> retrieveAllCars()
    {
        return repo.findAll();
    }
    @GetMapping("/{id}")
    public Optional<User> getUser(@PathVariable String id)
    {
        return repo.findById(id);
    }

    @PostMapping("/")
    public String saveCar(@RequestBody User car)
    {
        repo.save(car);
        return " record saved..";
    }

    @DeleteMapping("/{id}")
    public String deleteCar(@PathVariable String id)
    {
        repo.deleteById(id);
        return " record deleted...";
    }

     */

/*
    @GetMapping("/hardcode")
    public String saveCar()
    {
        User user = new User("Jonatan");
        Rating rating = new Rating(1L, 1);
        List<Rating> list = new ArrayList<>();
        list.add(rating);
        user.setRatings(list);
        repo.save(user);
        return " record saved..";
    }

 */


/*
        @PutMapping("/{id}")
        public ResponseEntity<Object> updateCar(@RequestBody dk.dd.carcatalog.Car car, @PathVariable int id)
        {
            Optional<dk.dd.carcatalog.Car> found = repo.findById((long) id);

            if (!found.isPresent())
                return ResponseEntity.badRequest()
                        .header("Custom-Header", "foo")
                        .body("Try again")
                        .notFound().build();
            car.setId((long) id);
            repo.save(car);
            return   ResponseEntity.ok()
                    .header("Custom-Header", "foo")
                    .body("Notice the custom header")
                    .noContent().build();
        }

 */
}
