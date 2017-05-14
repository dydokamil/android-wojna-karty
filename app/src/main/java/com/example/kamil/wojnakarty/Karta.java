package com.example.kamil.wojnakarty;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * Created by kamil on 28.04.17.
 */

public class Karta {
    private String figura;
    private String numer;

    public Karta(String figura, String numer) {
        this.figura = figura;
        this.numer = numer;
    }

    @Override
    public String toString() {
        return "" + figura + " " + numer;
    }

    public String getFigura() {
        return figura;
    }

    public String getNumer() {
        return numer;
    }

    public static boolean wygrany_k1(Karta k1, Karta k2) {
        final ArrayList<String> numery = new ArrayList<>(Arrays.asList("2", "3", "4", "5", "6",
                "7", "8", "9", "10", "J", "Q", "K", "A"));
        if (numery.indexOf(k1.getNumer()) > numery.indexOf(k2.getNumer())) {
            return true;
        } else if (numery.indexOf(k1.getNumer()) < numery.indexOf(k2.getNumer())) {
            return false;
        } else {
            Random random = new Random();
            if (random.nextFloat() > .5) {
                return true;
            } else {
                return false;
            }
        }
    }
}
