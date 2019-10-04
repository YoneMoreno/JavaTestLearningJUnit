package com.platzi.javatests.movies.data;

import com.platzi.javatests.movies.model.Genre;
import com.platzi.javatests.movies.model.Movie;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.init.ScriptUtils;

import java.sql.DatabaseMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.Collection;

import static com.platzi.javatests.movies.model.Genre.THRILLER;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class MovieRepositoryIntegrationTest {

    private MovieRepository movieRepositoryJdbc;
    private DriverManagerDataSource dataSource;

    @Before
    public void setUp() throws Exception {

        dataSource = new DriverManagerDataSource("jdbc:h2:mem:test;MODE=MYSQL", "sa", "sa");

        ScriptUtils.executeSqlScript(dataSource.getConnection(), new ClassPathResource("sql-scripts/test-data.sql"));
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        movieRepositoryJdbc = new MovieRepositoryJdbc(jdbcTemplate);
    }

    @Test
    public void loadAllMovies() throws SQLException {

        Collection<Movie> movies = movieRepositoryJdbc.findAll();
        assertThat(movies, is(Arrays.asList(
                new Movie(1, "Dark Knight", 152, Genre.ACTION, "director1"),
                new Movie(2, "Memento", 113, Genre.THRILLER, "director2"),
                new Movie(3, "Matrix", 136, Genre.ACTION, "spielberg")
        )));
    }

    @Test
    public void loadMovieById() {
        Movie movie = movieRepositoryJdbc.findById(2);
        assertThat(movie, is(new Movie(2, "Memento", 113, Genre.THRILLER, "director2")));
    }

    @Test
    public void insertMovie() {
        Movie movieToSaveInDb = new Movie("Super 8", 112, THRILLER, "ana");
        movieRepositoryJdbc.saveOrUpdate(movieToSaveInDb);
        Movie movieFromDb = movieRepositoryJdbc.findById(4);
        assertThat(movieFromDb, is(new Movie(4, "Super 8", 112, THRILLER, "ana")));
    }

    @After
    public void tearDown() throws Exception {
        final Statement s = dataSource.getConnection().createStatement();
        s.execute("drop all objects delete files");
    }
}