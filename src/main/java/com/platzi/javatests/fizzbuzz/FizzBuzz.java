package com.platzi.javatests.fizzbuzz;

public class FizzBuzz {

    public static String fizzBuzz(int n) {
        return n % 3 == 0 && n % 5 == 0 ? "FizzBuzz" : n % 3 == 0 ? "Fizz" : n % 5 == 0 ? "Buzz" : String.valueOf(n);
    }
}
