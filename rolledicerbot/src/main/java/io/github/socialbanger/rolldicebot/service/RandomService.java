package io.github.socialbanger.rolldicebot.service;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class RandomService {

    public int getRoll(int diceType) {
        return new Random().nextInt(diceType) + 1;
    }
}
