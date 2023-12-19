package com.driver;

import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MovieRepository {
    Map<String, Movie> movieList = new HashMap<>();
    Map<String, Director> directorList = new HashMap<>();
    Map<Movie, Director> movieDirector = new HashMap<>();

    public String addMovie(Movie movie) {
        String name = movie.getName();
        movieList.put(name, movie);

        return "Movie added successfully";
    }

    public String addDirector(Director director) {
        String name = director.getName();
        directorList.put(name, director);

        return "Director added successfully";
    }

    public String addMovieDirectorPair(String movieName, String directorName) {
        Movie movie = movieList.get(movieName);
        Director director = directorList.get(directorName);
        movieDirector.put(movie, director);

        return "Movie and Director added successfully";
    }

    public Movie getMovieByName(String name) {
        Movie movie = movieList.get(name);
        return movie;
    }

    public Director getDirectorByName(String name) {
        Director director = directorList.get(name);
        return director;
    }

    public List<String> getMoviesByDirectorName(String director) {
        List<String> list = new ArrayList<>();

        //Return List of movies name(List()) wrapped in a ResponseEntity object
        for(Movie movie : movieDirector.keySet()) {
            if((movieDirector.get(movie).getName()).equals(director)) {
                list.add(movie.getName());
            }
        }
        return list;
    }

    public List<String> findAllMovies() {
        List<String> list = new ArrayList<>();

        for(String movies : movieList.keySet()) {
            list.add(movies);
        }
        return list;
    }

    public String deleteDirectorByName(String name) {
        directorList.remove(name);

        Iterator<Map.Entry<Movie, Director>> itr = movieDirector.entrySet().iterator();
        while(itr.hasNext()) {
            Map.Entry<Movie, Director> entry = itr.next();
            if(entry.getValue().getName().equals(name)) {
                movieList.remove(entry.getKey().getName());
                itr.remove();
            }
        }
        return "Director and Movie deleted Successfully";
    }

    public String deleteAllDirectors() {
        Iterator<Map.Entry<Movie, Director>> itr = movieDirector.entrySet().iterator();
        while(itr.hasNext()) {
            Map.Entry<Movie, Director> entry = itr.next();
            directorList.remove(entry.getValue().getName());
            movieList.remove(entry.getKey().getName());
            itr.remove();
        }
        return "All Record deleted";
    }
}
