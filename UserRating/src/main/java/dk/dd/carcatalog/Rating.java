package dk.dd.carcatalog;

import org.springframework.data.annotation.Id;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.io.Serializable;

public class Rating implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    private Long carID;
    private int rating;

    public Rating(Long carID, int rating) {
        this.carID = carID;
        this.rating = rating;
    }

    public Rating()
    {

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