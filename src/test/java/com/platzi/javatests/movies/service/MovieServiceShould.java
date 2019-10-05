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
                        new Movie(9, "Kid super kid", 300, ACTION, "nobo"),
                        new Movie(10, "W2", 200, ACTION, "n")
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
        assertThat(getMoviesIds(movies), is(Arrays.asList(1, 2, 3)));
    }

    @Test
    public void returnMoviesByNameAndLength() {
        Movie movie = new Movie("super", 200, null, null);
        Collection<Movie> moviesByTemplate = movieService.findMoviesByTemplate(movie);
        assertThat(getMoviesIds(moviesByTemplate), is(Arrays.asList(4, 8)));
    }

    @Test
    public void returnMoviesByNameAndGenre() {
        Movie movie = new Movie("me", null, COMEDY, null);
        Collection<Movie> moviesByTemplate = movieService.findMoviesByTemplate(movie);
        assertThat(getMoviesIds(moviesByTemplate), is(Arrays.asList(3, 6)));
    }

    @Test
    public void returnMoviesByNameAndDirector() {
        Movie movie = new Movie("me", null, null, "director");
        Collection<Movie> moviesByTemplate = movieService.findMoviesByTemplate(movie);
        assertThat(getMoviesIds(moviesByTemplate), is(Arrays.asList(2, 3)));
    }

    @Test
    public void returnMoviesByLengthAndGenre() {
        Movie movie = new Movie(null, 200, ACTION, null);
        Collection<Movie> moviesByTemplate = movieService.findMoviesByTemplate(movie);
        assertThat(getMoviesIds(moviesByTemplate), is(Arrays.asList(1, 7, 8, 10)));
    }

    @Test
    public void returnMoviesByLengthAndDirector() {
        Movie movie = new Movie(null, 119, null, "director");
        Collection<Movie> moviesByTemplate = movieService.findMoviesByTemplate(movie);
        assertThat(getMoviesIds(moviesByTemplate), is(Arrays.asList(2, 3)));
    }

    @Test
    public void returnMoviesByGenreAndDirector() {
        Movie movie = new Movie(null, null, ACTION, "nobo");
        Collection<Movie> moviesByTemplate = movieService.findMoviesByTemplate(movie);
        assertThat(getMoviesIds(moviesByTemplate), is(Arrays.asList(8, 9)));
    }

    @Test
    public void returnMoviesByNameLengthAndGenre() {
        Movie movie = new Movie("me", 119, COMEDY, null);
        Collection<Movie> moviesByTemplate = movieService.findMoviesByTemplate(movie);
        assertThat(getMoviesIds(moviesByTemplate), is(Arrays.asList(3, 6)));
    }

    @Test
    public void returnMoviesByLengthGenreAndDirector() {
        Movie movie = new Movie(null, 200, ACTION, "o");
        Collection<Movie> moviesByTemplate = movieService.findMoviesByTemplate(movie);
        assertThat(getMoviesIds(moviesByTemplate), is(Arrays.asList(1, 8)));
    }

    @Test
    public void returnMoviesByNameGenreAndDirector() {
        Movie movie = new Movie("", null, ACTION, "o");
        Collection<Movie> moviesByTemplate = movieService.findMoviesByTemplate(movie);
        assertThat(getMoviesIds(moviesByTemplate), is(Arrays.asList(1, 8, 9)));
    }

    @Test
    public void returnMoviesByNameLengthAndDirector() {
        Movie movie = new Movie("super", 200, null, "o");
        Collection<Movie> moviesByTemplate = movieService.findMoviesByTemplate(movie);
        assertThat(getMoviesIds(moviesByTemplate), is(Arrays.asList(8)));
    }

    @Test
    public void returnMoviesById() {
        Movie movie = new Movie(3, "super", 200, null, "o");
        Collection<Movie> moviesByTemplate = movieService.findMoviesByTemplate(movie);
        assertThat(getMoviesIds(moviesByTemplate), is(Arrays.asList(3)));
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwExceptionWhenLengthIsNegative() {
        Movie movie = new Movie( "super", -200, null, "o");
        Collection<Movie> moviesByTemplate = movieService.findMoviesByTemplate(movie);
    }

    private List<Integer> getMoviesIds(Collection<Movie> movies) {
        return movies.stream().map(Movie::getId).collect(Collectors.toList());
    }
}
