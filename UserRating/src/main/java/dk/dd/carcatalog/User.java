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
@NoArgsConstructor
@RequiredArgsConstructor
@Document(collection = "users")
public class User  {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NonNull private String id;
    @NonNull private String name;
    private List<Rating> ratings;

}