package com.myinsane.restapimovies;

import com.myinsane.restapimovies.dto.MovieDto;
import com.myinsane.restapimovies.dto.MovieListDto;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@RestController
class MoviesController {

    private final MoviesRepository repository;

    MoviesController(MoviesRepository repository) {
        this.repository = repository;
    }

    //Aggregate root

    @GetMapping("/api/movies")
//    CollectionModel<EntityModel<Movies>> all() {
//        List<EntityModel<Movies>> movies = repository.findAll().stream()
//                .map(movie -> EntityModel.of(movie,
//                        linkTo(methodOn(MoviesController.class).one(movie.getId())).withSelfRel(),
//                        linkTo(methodOn(MoviesController.class).all()).withRel("employees")))
//                .collect(Collectors.toList());
//        return CollectionModel.of(movies,
//                linkTo(methodOn(MoviesController.class).all()).withSelfRel());
//    }
    MovieListDto all() {
        return new MovieListDto(repository.findAll());
    }

    @PostMapping("/api/movies")
    Movies newMovies(@RequestBody MovieDto newMovies) {
        return repository.save(newMovies.getMovie());
    }

    //Single item
    @GetMapping("/api/movies/{id}")
//    EntityModel<Movies> one(@PathVariable Long id) {
//        Movies movies = repository.findById(id)
//                .orElseThrow(() -> new MoviesNotFoundException(id));
//
//        return EntityModel.of(movies, //
//                linkTo(methodOn(MoviesController.class).one(id)).withSelfRel(),
//                linkTo(methodOn(MoviesController.class).all()).withRel("movies"));
//    }
    MovieDto one(@PathVariable long id) {
        return repository.findById(id)
                .map(MovieDto::new)
                .orElseThrow(() -> new MoviesNotFoundException(id));
    }

//    @PutMapping("/api/movies/{id}")
//    Movies replaceMovies(@RequestBody Movies newMovies, @PathVariable Long id) {
//        return repository.findById(id)
//                .map(movies -> {
//                    movies.setDirector(newMovies.getDirector());
//                    movies.setLength(newMovies.getLength());
//                    movies.setRating(newMovies.getRating());
//                    movies.setTitle(newMovies.getTitle());
//                    movies.setYear(newMovies.getYear());
//                    return repository.save(movies);
//                })
//                .orElseGet(() -> {
//                    newMovies.setId(id);
//                    return repository.save(newMovies);
//                });
//    }

    @DeleteMapping("/api/movies/{id}")
    void deleteMovies(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
