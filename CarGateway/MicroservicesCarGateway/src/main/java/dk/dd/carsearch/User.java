package dk.dd.carsearch;
import lombok.Data;
import lombok.NonNull;
import org.springframework.data.annotation.Id;

import java.util.List;

@Data
public class User  {
    @Id
    private String id;
    @NonNull private String name;
    @NonNull List<Rating> ratings;

}