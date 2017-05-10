package com.example.kamil.wojnakarty;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

/**
 * Created by kamil on 28.04.17.
 */

public class Rozdanie {
    public Rozdanie(Deque<Karta> karty_gracz1, Deque<Karta> karty_gracz2) {
        this.karty_gracz1 = karty_gracz1;
        this.karty_gracz2 = karty_gracz2;
    }

    public Deque karty_gracz1;
    public Deque karty_gracz2;
}
