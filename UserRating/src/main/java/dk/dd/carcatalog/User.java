package dk.dd.carcatalog;

import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


import lombok.Data;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.util.List;


@Data
@Document(collection = "users")
public class User  {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    private String name;
    private List<Rating> ratings;

    public User(String id, String name, List<Rating> ratings) {
        this.id = id;
        this.name = name;
        this.ratings = ratings;
    }

    public User() {
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