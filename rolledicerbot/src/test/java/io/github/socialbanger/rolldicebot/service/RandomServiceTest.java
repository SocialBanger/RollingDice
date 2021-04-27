package io.github.socialbanger.rolldicebot.service;

import io.github.socialbanger.rolldicebot.RolledicerbotApplicationTests;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RandomServiceTest extends RolledicerbotApplicationTests {

    RandomService randomService = new RandomService();

    @Test
    public void getRollSetD4Test() {
        int[] diceSetD4 = getArrayDice(4);
        for (int i = 0; i < 40; i++) {
            int expectedDice = randomService.getRoll(diceSetD4.length);
            Assertions.assertTrue(expectedDice >= diceSetD4[0]);
            Assertions.assertTrue(expectedDice <= diceSetD4[diceSetD4.length - 1]);
        }
    }

    @Test
    public void getRollSetD20Test() {
        int[] diceSetD20 = getArrayDice(20);
        for (int i = 0; i < 40; i++) {
            int expectedDice = randomService.getRoll(diceSetD20.length);
            Assertions.assertTrue(expectedDice >= diceSetD20[0]);
            Assertions.assertTrue(expectedDice <= diceSetD20[diceSetD20.length - 1]);
        }
    }

    private int[] getArrayDice(int sizeDice) {
        int[] arrayDice = new int[sizeDice];
        for (int i = 0; i < sizeDice; i++){
            arrayDice[i] = i + 1;
        }
        return arrayDice;
    }
}