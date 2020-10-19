package com.myinsane.restapimovies;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.lang.String;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
@NoArgsConstructor
public class Movies {

    private @Id @GeneratedValue Long id;
    private String title;
    private int year;
    private String director;
    private String length;
    private int rating;
//
//    public Long getId() {
//        return this.id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getTitle() {
//        return this.title;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    public int getYear() {
//        return this.year;
//    }
//
//    public void setYear(int year) {
//        this.year = year;
//    }
//
//    public String getDirector() {
//        return this.director;
//    }
//
//    public void setDirector(String director) {
//        this.director = director;
//    }
//
//    public String getLength() {
//        return this.length;
//    }
//
//    public void setLength(String length) {
//        this.length = length;
//    }
//
//    public int getRating() {
//        return this.rating;
//    }
//
//    public void setRating(int rating) {
//        this.rating = rating;
//    }
//
//    public Movies() { }
//
    public Movies(String title, int year, String director, String length, int rating) {
        this.title = title;
        this.year = year;
        this.director = director;
        this.length = length;
        this.rating = rating;
    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(this.id, this.title, this.year);
//    }
//
//    @Override
//    public String toString() {
//        return "Movie{" + "id=" + this.id +
//                ", title='" + this.title + '\'' +
//                ", year='" + this.year + '\'' +
//                ", director='" + this.director + '\'' +
//                ", length='" + this.length + '\'' +
//                ", rating='" + this.rating + '\'' + '}';
//    }
}

