package com.example.kamil.wojnakarty;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by kamil on 28.04.17.
 */

public class TaliaKart {
    private ArrayList<Karta> talia_kart;

    public TaliaKart() {
        final ArrayList<String> figury = new ArrayList<>(Arrays.asList("Trefl", "Pik", "Karo", "Kier"));
        final ArrayList<String> numery = new ArrayList<>(Arrays.asList("2", "3", "4", "5", "6",
                "7", "8", "9", "10", "J", "Q", "K", "A"));

        talia_kart = new ArrayList<Karta>();
        for (int i = 0; i < figury.size(); i++) {
            for (int j = 0; j < numery.size(); j++) {
                this.talia_kart.add(new Karta(figury.get(i), numery.get(j)));
            }
        }
        tasuj();
    }

    public void tasuj() {
        Collections.shuffle(this.talia_kart);
    }

    public Rozdanie rozdaj() {
        Queue<Karta> karty_gracz1 = new PriorityQueue<Karta>();

        for (int i = 0; i < this.talia_kart.size() / 2; i++) {
            karty_gracz1.add(this.talia_kart.get(i));
        }

        Queue<Karta> karty_gracz2 = new PriorityQueue<Karta>();

        for (int i = this.talia_kart.size() / 2; i < this.talia_kart.size(); i++) {
            karty_gracz2.add(this.talia_kart.get(i));
        }
        return new Rozdanie(karty_gracz1, karty_gracz2);
    }

    public ArrayList<Karta> getTalia_kart() {
        return talia_kart;
    }

}
