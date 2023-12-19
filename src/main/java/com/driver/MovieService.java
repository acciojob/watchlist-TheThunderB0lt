package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    @Autowired
    MovieRepository movieRepository;
    public String addMovie(Movie movie) {
        String res = movieRepository.addMovie(movie);
        return res;
    }

    public String addDirector(Director director) {
        String res = movieRepository.addDirector(director);
        return res;
    }

    public String addDirectorPair(String movieName, String directorName) {
        String res = movieRepository.addDirectorPair(movieName, directorName);
        return res;
    }

    public Movie getMovieByName(String name) {
        Movie movie = movieRepository.getMovieByName(name);
        return movie;
    }

    public Director getDirectorByName(String name) {
        Director director = movieRepository.getDirectorByName(name);
        return director;
    }

    public List<String> getMoviesByDirectorName(String director) {
        List<String> list = movieRepository.getMoviesByDirectorName(director);
        return list;
    }

    public List<String> findAllMovies() {
        List<String> list = movieRepository.findAllMovies();
        return list;
    }

    public String deleteDirectorByName(String name) {
        String res = movieRepository.deleteDirectorByName(name);
        return res;
    }

    public String deleteAllDirectors() {
        String res = movieRepository.deleteAllDirectors();
        return res;
    }
}
