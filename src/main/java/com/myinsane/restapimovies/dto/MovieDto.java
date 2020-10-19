package com.myinsane.restapimovies.dto;

import com.myinsane.restapimovies.Movies;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class MovieDto {
    private Movies movie;
}