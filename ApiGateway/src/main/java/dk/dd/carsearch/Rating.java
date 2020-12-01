package dk.dd.carsearch;

import org.springframework.data.annotation.Id;

import java.io.Serializable;

public class Rating implements Serializable {
    @Id
    private String id;
    private String brand;
    private String note;
    private Stars rating;

    public Rating() {
    }

    public Rating(String id, String brand, String note, Stars rating) {
        this.id = id;
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