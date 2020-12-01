package dk.dd.carcatalog;

import org.springframework.data.annotation.Id;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.io.Serializable;

public class Rating implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    private String brand;
    private String note;
    private Stars rating;

    public Rating() {
    }

    public Rating(String brand, String note, Stars rating) {
        this.brand = brand;
        this.note = note;
        this.rating = rating;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Stars getRating() {
        return rating;
    }

    public void setRating(Stars rating) {
        this.rating = rating;
    }
}