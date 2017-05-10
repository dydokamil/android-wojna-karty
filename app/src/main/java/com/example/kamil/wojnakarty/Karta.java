package com.example.kamil.wojnakarty;

/**
 * Created by kamil on 28.04.17.
 */

public class Karta {
    private String figura;
    private String kolor;

    public Karta(String figura, String kolor) {
        this.figura = figura;
        this.kolor = kolor;
    }

    @Override
    public String toString() {
        return "" + figura + " " + kolor;
    }
}
