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

        l1.add(new Rating("Mini", "Fantastic car, i really love it!", Stars.Five));
        l1.add(new Rating("Ferrari", "Fastest car i've ever driven!", Stars.Five));

        l2.add(new Rating("Bugatti", "It was okay", Stars.Three));
        l2.add(new Rating("Renault", "Great daily driver", Stars.Four));
        l2.add(new Rating("Ferrari", "I love it!!", Stars.Five));

        l3.add(new Rating("Renault", "I hate it, terrible", Stars.One));
        l3.add(new Rating("Mini", "Better than renault", Stars.Three));

        l4.add(new Rating("Mini", "My favorite car ever", Stars.Five));

        User u1 = new User(null, "Andreas", l1);
        User u2 = new User(null, "Jonas", l2);
        User u3 = new User(null, "Jonatan", l3);
        User u4 = new User(null, "Thomas", l4);

        repo.save(u1);
        repo.save(u2);
        repo.save(u3);
        repo.save(u4);
    }

}


