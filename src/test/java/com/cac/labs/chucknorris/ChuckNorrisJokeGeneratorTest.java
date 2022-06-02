package com.cac.labs.chucknorris;

import com.cac.labs.chucknorris.domain.ChuckNorrisJokeGenerator;
import com.cac.labs.chucknorris.services.ChuckNorrisJokeService;
import com.cac.labs.chucknorris.services.JokeService;
import guru.springframework.norris.chuck.ChuckNorrisQuotes;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class ChuckNorrisJokeGeneratorTest {

    private static ChuckNorrisJokeGenerator jokeGenerator;

    @BeforeAll
    public static void init() {
        jokeGenerator = new ChuckNorrisJokeGenerator(new ChuckNorrisQuotes());
    }

    @Test
    public void jokeIsNotNull() {
        JokeService jokeService = new ChuckNorrisJokeService(jokeGenerator);
        String joke = jokeService.getJoke();
        Assertions.assertNotNull(joke);
    }

    @Test
    public void jokeIsNotBlank() {
        JokeService jokeService = new ChuckNorrisJokeService(jokeGenerator);
        String joke = jokeService.getJoke();
        Assertions.assertFalse(joke.isBlank());
    }

    @Test
    public void jokesAreNotEqualMoreThanThreeTimes() {
        JokeService jokeService = new ChuckNorrisJokeService(jokeGenerator);
        String joke1 = jokeService.getJoke();
        String joke2 = jokeService.getJoke();
        String joke3 = jokeService.getJoke();

        Assertions.assertFalse(joke1.equals(joke2) && joke2.equals(joke3));
    }
}
