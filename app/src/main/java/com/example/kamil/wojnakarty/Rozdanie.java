package com.example.kamil.wojnakarty;

import java.util.Queue;

/**
 * Created by kamil on 28.04.17.
 */

public class Rozdanie {
    public Rozdanie(Queue<Karta> karty_gracz1, Queue<Karta> karty_gracz2) {
        this.karty_gracz1 = karty_gracz1;
        this.karty_gracz2 = karty_gracz2;
    }

    public Queue<Karta> karty_gracz1;
    public Queue<Karta> karty_gracz2;
}
