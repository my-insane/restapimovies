package com.myinsane.restapimovies;

public class MoviesNotFoundException extends RuntimeException{
    MoviesNotFoundException(Long id) {
        super("Could not find movies " + id);
    }
}
