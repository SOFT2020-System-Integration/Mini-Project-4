package dk.dd.carsearch;
import lombok.Data;
import lombok.NonNull;
import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.util.List;

@Data
public class User {
    private String id;
    private String name;
    private List<Rating> ratings;

    public User() {
    }

    public User(String id, String name, List<Rating> ratings) {
        this.id = id;
        this.name = name;
        this.ratings = ratings;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(List<Rating> ratings) {
        this.ratings = ratings;
    }
}