package com.myinsane.restapimovies;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
class MoviesController {

    private final MoviesRepository repository;

    MoviesController(MoviesRepository repository) {
        this.repository = repository;
    }

    //Aggregate root

    @GetMapping("/movies")
    List<Movies> all() {
        return repository.findAll();
    }

    @PostMapping("/movies")
    Movies newMovies(@RequestBody Movies newMovies) {
        return repository.save(newMovies);
    }

    //Single item
    @GetMapping("/movies/{id}")
    Movies one(@PathVariable long id) {
        return repository.findById(id)
                .orElseThrow(() -> new MoviesNotFoundException(id));
    }

    @PutMapping("/movies/{id}")
    Movies replaceMovies(@RequestBody Movies newMovies, @PathVariable Long id) {
        return repository.findById(id)
                .map(movies -> {
                    movies.setDirector(newMovies.getDirector());
                    movies.setLength(newMovies.getLength());
                    movies.setRating(newMovies.getRating());
                    movies.setTitle(newMovies.getTitle());
                    movies.setYear(newMovies.getYear());
                    return repository.save(movies);
                })
                .orElseGet(() -> {
                    newMovies.setId(id);
                    return repository.save(newMovies);
                });
    }

    @DeleteMapping("/movies/{id}")
    void deleteMovies(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
