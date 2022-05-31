package com.cac.labs.chucknorris.services;

import guru.springframework.norris.chuck.ChuckNorrisQuotes;
import org.springframework.stereotype.Service;

@Service
public class ChuckNorrisJokeService implements JokeService {

    private final ChuckNorrisQuotes jokeGenerator;

    public ChuckNorrisJokeService(ChuckNorrisQuotes jokeGenerator) {
        this.jokeGenerator = jokeGenerator;
    }

    @Override
    public String generateJoke() {
        return jokeGenerator.getRandomQuote();
    }
}
