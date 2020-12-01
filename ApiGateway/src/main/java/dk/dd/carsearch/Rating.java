package dk.dd.carsearch;

import org.springframework.data.annotation.Id;

import java.io.Serializable;

public class Rating implements Serializable {
    @Id
    private String id;
    private Long carID;
    private int rating;

    public Rating() {
    }

    public Rating(String id, Long carID, int rating) {
        this.id = id;
        this.carID = carID;
        this.rating = rating;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getCarID() {
        return carID;
    }

    public void setCarID(Long carID) {
        this.carID = carID;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}