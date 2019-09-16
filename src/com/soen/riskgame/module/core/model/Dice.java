package com.soen.riskgame.module.core.model;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;

public class Dice {

    public static Integer roll() throws NoSuchAlgorithmException {
        Random random = SecureRandom.getInstanceStrong();
        return random.nextInt(5) + 1;
    }
}
