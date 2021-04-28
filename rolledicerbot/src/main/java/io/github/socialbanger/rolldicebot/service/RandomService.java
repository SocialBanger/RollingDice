package io.github.socialbanger.rolldicebot.service;

import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class RandomService {

    public int getRoll(int diceType) {
        return ThreadLocalRandom.current().nextInt(diceType) + 1;
    }
}
