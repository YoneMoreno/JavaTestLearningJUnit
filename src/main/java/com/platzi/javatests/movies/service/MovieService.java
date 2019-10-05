package com.platzi.javatests.movies.service;

import com.platzi.javatests.movies.data.MovieRepository;
import com.platzi.javatests.movies.model.Genre;
import com.platzi.javatests.movies.model.Movie;

import java.util.*;
import java.util.stream.Collectors;

public class MovieService {

    private MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public Collection<Movie> findMoviesByGenre(Genre genre) {
        return movieRepository.findAll().stream()
                .filter(movie -> movie.getGenre().equals(genre)).collect(Collectors.toList());
    }


    public Collection<Movie> findMoviesByLength(int length) {
        return movieRepository.findAll().stream()
                .filter(movie -> movie.getMinutes() <= length).collect(Collectors.toList());
    }

    public Collection<Movie> findMoviesByName(String name) {
        return movieRepository.findAll().stream()
                .filter(movie -> movie.getName().toLowerCase().contains(name)).collect(Collectors.toList());
    }

    public Collection<Movie> findMoviesByDirector(String director) {
        return movieRepository.findAll().stream()
                .filter(movie -> movie.getDirector().toLowerCase().contains(director)).collect(Collectors.toList());
    }

    public Collection<Movie> findMoviesByTemplate(Movie template) {


        if (template.getId() != null) {
            Collection<Movie> movies = movieRepository.findAll();
            return movies.stream().filter(movie -> movie.getId().equals(template.getId())).collect(Collectors.toList());
        }

        Collection<Movie> foundByName = null, foundByLength = null, foundByGenre = null, foundByDirector = null;
        if (template.getName() != null) {
            foundByName = findMoviesByName(template.getName());
        }
        if (template.getMinutes() != null) {
            if (template.getMinutes() < 0) {
                throw new IllegalArgumentException("Length must be positive");
            }
            foundByLength = findMoviesByLength(template.getMinutes());
            if (foundByName != null && template.getGenre() == null && template.getDirector() == null) {
                return foundByName.stream().filter(foundByLength::contains).collect(Collectors.toList());
            }
        }
        if (template.getGenre() != null) {
            foundByGenre = findMoviesByGenre(template.getGenre());
            if (foundByName != null && foundByLength != null) {
                return foundByName.stream().filter((foundByLength::contains))
                        .filter(foundByGenre::contains).collect(Collectors.toList());
            }
            if (foundByName != null && template.getDirector() == null) {
                return foundByName.stream().filter((foundByGenre::contains)).collect(Collectors.toList());
            }
            if (foundByLength != null && template.getDirector() == null) {
                return foundByLength.stream().filter(foundByGenre::contains).collect(Collectors.toList());
            }
        }
        if (template.getDirector() != null) {
            foundByDirector = findMoviesByDirector(template.getDirector());
            if (foundByName != null && foundByGenre != null) {
                return foundByName.stream().filter(foundByGenre::contains)
                        .filter(foundByDirector::contains).collect(Collectors.toList());
            }
            if (foundByLength != null && foundByGenre != null) {
                return foundByLength.stream().filter(foundByGenre::contains)
                        .filter(foundByDirector::contains).collect(Collectors.toList());
            }
            if (foundByName != null && foundByLength != null) {
                return foundByName.stream().filter(foundByLength::contains)
                        .filter(foundByDirector::contains).collect(Collectors.toList());
            }

            if (foundByName != null) {
                return foundByName.stream().filter(foundByDirector::contains).collect(Collectors.toList());
            }
            if (foundByLength != null) {
                return foundByLength.stream().filter(foundByDirector::contains).collect(Collectors.toList());
            }
            if (foundByGenre != null) {
                return foundByGenre.stream().filter(foundByDirector::contains).collect(Collectors.toList());
            }
        }
        return null;
    }
}
