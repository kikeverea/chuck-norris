package com.cac.labs.chucknorris.domain;

import guru.springframework.norris.chuck.ChuckNorrisQuotes;
import org.springframework.stereotype.Component;

@Component
public class ChuckNorrisJokeGenerator implements JokeGenerator {

    private final ChuckNorrisQuotes jokeGenerator = new ChuckNorrisQuotes();

    @Override
    public String generateJoke() {
        return jokeGenerator.getRandomQuote();
    }
}
