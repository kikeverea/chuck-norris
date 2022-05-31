package com.cac.labs.chucknorris;

import com.cac.labs.chucknorris.services.ChuckNorrisJokeService;
import com.cac.labs.chucknorris.services.JokeService;
import guru.springframework.norris.chuck.ChuckNorrisQuotes;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class ChuckNorrisJokeServiceTest {

    private static ChuckNorrisQuotes jokeGenerator;

    @BeforeAll
    public static void init() {
        jokeGenerator = new ChuckNorrisQuotes();
    }

    @Test
    public void jokeIsNotNull() {
        JokeService jokeService = new ChuckNorrisJokeService(jokeGenerator);
        String joke = jokeService.generateJoke();

        Assertions.assertNotNull(joke);
    }

    @Test
    public void jokeIsNotBlank() {
        JokeService jokeService = new ChuckNorrisJokeService(jokeGenerator);
        String joke = jokeService.generateJoke();

        Assertions.assertFalse(joke.isBlank());
    }

    @Test
    public void jokesAreNotEqualMoreThanThreeTimes() {
        JokeService jokeService = new ChuckNorrisJokeService(jokeGenerator);
        String joke1 = jokeService.generateJoke();
        String joke2 = jokeService.generateJoke();
        String joke3 = jokeService.generateJoke();

        Assertions.assertFalse(joke1.equals(joke2) && joke2.equals(joke3));
    }
}
