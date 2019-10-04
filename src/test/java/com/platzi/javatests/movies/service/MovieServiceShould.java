package com.platzi.javatests.movies.service;

import com.platzi.javatests.movies.data.MovieRepository;
import com.platzi.javatests.movies.model.Genre;
import com.platzi.javatests.movies.model.Movie;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static com.platzi.javatests.movies.model.Genre.*;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class MovieServiceShould {

    MovieService movieService;

    @Before
    public void setUp() throws Exception {

        MovieRepository movieRepository = Mockito.mock(MovieRepository.class);

        Mockito.when(movieRepository.findAll()).thenReturn(
                Arrays.asList(
                        new Movie(1, "Dark Knight", 152, ACTION, "director1"),
                        new Movie(2, "Memento", 113, THRILLER, "director2"),
                        new Movie(3, "There's Something About Mary", 119, COMEDY, "director3"),
                        new Movie(4, "Super 8", 112, THRILLER, "ana"),
                        new Movie(5, "Scream", 111, HORROR, "luisa"),
                        new Movie(6, "Home Alone", 103, COMEDY, "maria"),
                        new Movie(7, "Matrix", 136, ACTION, "spielberg"),
                        new Movie(8, "Superwoman", 200, ACTION, "nobody"),
                        new Movie(9, "Kid super kid", 300, ACTION, "nobo")
                )
        );
        movieService = new MovieService(movieRepository);
    }

    @Test
    public void returnMoviesByGenre() {
        Collection<Movie> movies = movieService.findMoviesByGenre(COMEDY);
        assertThat(getMoviesIds(movies), is(Arrays.asList(3, 6)));
    }


    @Test
    public void returnMoviesByLength() {
        Collection<Movie> movies = movieService.findMoviesByLength(119);
        assertThat(getMoviesIds(movies), is(Arrays.asList(2, 3, 4, 5, 6)));
    }

    @Test
    public void returnMoviesWhichContainName() {
        Collection<Movie> movies = movieService.findMoviesByName("super");
        assertThat(getMoviesIds(movies), is(Arrays.asList(4, 8, 9)));
    }

    @Test
    public void returnMoviesWhichContainDirector() {
        Collection<Movie> movies = movieService.findMoviesByDirector("director");
        assertThat(getMoviesIds(movies),is(Arrays.asList(1,2,3)));
    }

    private List<Integer> getMoviesIds(Collection<Movie> movies) {
        return movies.stream().map(Movie::getId).collect(Collectors.toList());
    }
}
