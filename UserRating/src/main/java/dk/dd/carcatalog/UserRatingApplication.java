package dk.dd.carcatalog;

import lombok.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import java.util.ArrayList;
import java.util.List;

@EnableDiscoveryClient
@SpringBootApplication
public class UserRatingApplication implements CommandLineRunner {

    @Autowired
    private UserRepo repo;

    UserRatingApplication(UserRepo repo){
        this.repo = repo;
    };

    public static void main(String[] args){SpringApplication.run(UserRatingApplication.class, args); }

    @Override
    public void run(String ...args) throws Exception{
        List<Rating> l = new ArrayList<>();

        Rating r = new Rating(1L, 10);
        l.add(r);
        User u = new User("", "Andreas", l);
        u.setRatings(l);

        repo.save(u);
    }

}


