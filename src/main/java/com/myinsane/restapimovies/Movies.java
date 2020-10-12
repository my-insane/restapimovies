package com.myinsane.restapimovies;

import java.sql.Time;
import java.lang.String;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Movies {

    private @Id
    @GeneratedValue
    Long id;
    private String title;
    private int year;
    private String director;
    private String length;
    private int rating;

    public Movies() { }

    public Movies(Long id, String title, int year, String director, String length, int rating) {
        this.id = id;
        if (title == null) {
            int status = 400;
            String reason = "Field 'title' is required";
            return;
        } else this.title = title;
        if (year < 1900) {
            int status = 400;
            String reason = "Field 'year' should be fewer then 1900";
            return;
        }
        if (year > 2100) {
            int status = 400;
            String reason = "Field 'year' should be less then 2100";
            return;
        } else this.year = year;
        this.director = director;
        this.length = length;
        this.rating = rating;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}

