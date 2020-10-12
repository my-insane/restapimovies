package com.myinsane.restapimovies;
import org.springframework.data.jpa.repository.JpaRepository;

interface MoviesRepository extends JpaRepository<Movies, Long> {
}
