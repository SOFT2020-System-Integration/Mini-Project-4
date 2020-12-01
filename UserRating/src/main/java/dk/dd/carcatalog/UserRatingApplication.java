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

        //Delete All
        repo.deleteAll();

        List<Rating> l1 = new ArrayList<>();
        List<Rating> l2 = new ArrayList<>();
        List<Rating> l3 = new ArrayList<>();
        List<Rating> l4 = new ArrayList<>();

        Rating r1 = new Rating("1", 1L, 10);
        Rating r2 = new Rating("2", 2L, 6);
        Rating r3 = new Rating("3", 3L, 7);
        Rating r4 = new Rating("4", 4L, 4);
        Rating r5 = new Rating("5", 5L, 1);
        Rating r6 = new Rating("6", 6L, 4);
        Rating r7 = new Rating("7", 7L, 8);
        Rating r8 = new Rating("8", 8L, 10);

        l1.add(r1);
        l1.add(r2);
        l1.add(r3);
        l1.add(r4);
        l1.add(r5);
        l1.add(r6);
        l1.add(r7);
        l1.add(r8);
        l1.add(r7);
        l1.add(r8);

        l2.add(r1);
        l2.add(r3);
        l2.add(r8);

        l3.add(r8);
        l3.add(r7);

        l4.add(r3);
        l4.add(r5);
        l4.add(r7);
        l4.add(r2);



        User u1 = new User(null, "Andreas", l1);
        User u2 = new User(null, "Jonas", l2);
        User u3 = new User(null, "Jonatan", l3);
        User u4 = new User(null, "Thomas", l4);
        User u5 = new User(null, "Oliver", l4);

        repo.save(u1);
        repo.save(u2);
        repo.save(u3);
        repo.save(u4);
    }

}


