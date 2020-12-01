package dk.dd.carsearch;

import org.springframework.data.annotation.Id;

public class Rating {
    @Id
    private String id;
    private Long carID;
    private int rating;
}
