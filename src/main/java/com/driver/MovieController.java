package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")

public class MovieController {
    @Autowired
    MovieService movieService;

    //1. Add a movie: POST /movies/add-movie
    @PostMapping("/add-movie")
    //Controller Name - addMovie
    public ResponseEntity<String> addMovie(@RequestBody Movie movie){ //Pass the Movie object as request body
        String ans =  movieService.addMovie(movie);
        return new ResponseEntity<>(ans, HttpStatus.CREATED);
    }

    //2. Add a director: POST /movies/add-director
    @PostMapping("/add-director")
    //Controller Name - addDirector
    public ResponseEntity<String> addDirector(@RequestBody Director director) { //Pass the Director object as request body
        String ans = movieService.addDirector(director);
        return new ResponseEntity<>(ans, HttpStatus.CREATED);
    }

    //3. Pair an existing movie and director: PUT /movies/add-movie-director-pair
    @PostMapping("/add-movie-director-pair")
    //Controller Name - addMovieDirectorPair
    public ResponseEntity<String> addDirectorPair(@RequestParam("movieName") String movieName, @RequestParam("directorName") String directorName) {
        String ans = movieService.addDirectorPair(movieName, directorName);
        return new ResponseEntity<>(ans, HttpStatus.CREATED); //Return success message wrapped in a ResponseEntity object
    }

    // 4. Get Movie by movie name: GET /movies/get-movie-by-name/{name}
    @GetMapping("/get-movie-by-name/{name}")
    //Controller Name - getMovieByName
    public ResponseEntity<Movie> getMovieByName(@PathVariable("name") String name) { //Pass movie name as path parameter
        Movie movie = movieService.getMovieByName(name);
        return new ResponseEntity<>(movie, HttpStatus.CREATED); //Return Movie object wrapped in a ResponseEntity object
    }

    // 5. Get Director by director name: GET /movies/get-director-by-name/{name}
    @GetMapping("/get-director-by-name/{name}")
    //Controller Name - getDirectorByName
    public ResponseEntity<Director> getDirectorByName(@PathVariable("name") String name) {
        Director director = movieService.getDirectorByName(name); //Pass director name as path parameter
        return new ResponseEntity<>(director, HttpStatus.CREATED);
    }

    //6. Get List of movies name for a given director name: GET /movies/get-movies-by-director-name/{director}
    @GetMapping("/get-movies-by-director-name/{director}")
    //Controller Name - getMoviesByDirectorName
    public ResponseEntity<List<String>> getMoviesByDirectorName(@PathVariable("director") String director) {
        List<String> list = movieService.getMoviesByDirectorName(director); //Return List of movies name(List()) wrapped in a ResponseEntity object
        return new ResponseEntity<>(list, HttpStatus.CREATED);
    }

    //7. Get List of all movies added: GET /movies/get-all-movies
    @GetMapping("/get-all-movies")
    //No params or body required
    //Return List of movies name(List()) wrapped in a ResponseEntity object
    //Controller Name - findAllMovies
    public ResponseEntity<List<String>> findAllMovies() {
        List<String> list = movieService.findAllMovies();
        return  new ResponseEntity<>(list, HttpStatus.CREATED);
    }

    //8. Delete a director and its movies from the records: DELETE /movies/delete-director-by-name
    @DeleteMapping("/delete-director-by-name")
    //Controller Name - deleteDirectorByName
    public ResponseEntity<String> deleteDirectorByName(@RequestParam("name") String name) {
        String ans = movieService.deleteDirectorByName(name);
        return new ResponseEntity<>(ans, HttpStatus.CREATED);
    }

    //9. Delete all directors and all movies by them from the records: DELETE /movies/delete-all-directors
    @DeleteMapping("/delete-all-directors")
    // Controller Name - deleteAllDirectors
    public ResponseEntity<String> deleteAllDirectors() {
        String ans = movieService.deleteAllDirectors();
        return new ResponseEntity<>(ans, HttpStatus.CREATED);
    }
}
