package com.myinsane.restapimovies;

import java.sql.Time;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


public class Movies {

    private @Id
    @GeneratedValue
    Long id;
    private String title;
    private int year;
    private String director;
    private Time length;
    private int rating;

    Movies() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public void setTitle(String title) {
        if (title == null) {
            int status = 400;
            String reason = "Field 'title' is required";
        } else this.title = title;

    }

    public void setYear(int year) {
        this.year = year;
    }

    public Time getLength() {
        return length;
    }

    public void setLength(Time length) {
        this.length = length;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}

