package com.platzi.javatests.fizzbuzz;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class FizzBuzzShould {
    @Test
    public void returnFizzWhenIsDivisibleBy3() {
        assertThat(FizzBuzz.fizzBuzz(3),is("Fizz"));
        assertThat(FizzBuzz.fizzBuzz(6),is("Fizz"));
    }

    @Test
    public void returnFizzWhenIsDivisibleBy5() {
        assertThat(FizzBuzz.fizzBuzz(5),is("Buzz"));
        assertThat(FizzBuzz.fizzBuzz(10),is("Buzz"));
    }

    @Test
    public void returnFizzBuzzWhenIsDivisibleBy3And5() {
        assertThat(FizzBuzz.fizzBuzz(15),is("FizzBuzz"));
        assertThat(FizzBuzz.fizzBuzz(30),is("FizzBuzz"));
    }

    @Test
    public void returnNumberWhenIsNotDivisibleBy3AndNotBy5() {
        assertThat(FizzBuzz.fizzBuzz(2),is("2"));
        assertThat(FizzBuzz.fizzBuzz(16),is("16"));
    }
}