package com.cac.labs.chucknorris.services;

import com.cac.labs.chucknorris.domain.ChuckNorrisJokeGenerator;
import org.springframework.stereotype.Service;

@Service
public class ChuckNorrisJokeService implements JokeService {

    private final ChuckNorrisJokeGenerator jokeGenerator;

    public ChuckNorrisJokeService(ChuckNorrisJokeGenerator jokeGenerator) {
        this.jokeGenerator = jokeGenerator;
    }

    @Override
    public String getJoke() {
        return jokeGenerator.generateJoke();
    }
}
