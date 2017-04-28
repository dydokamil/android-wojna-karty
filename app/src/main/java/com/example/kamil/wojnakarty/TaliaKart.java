package com.example.kamil.wojnakarty;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

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

    public TaliaKart[] rozdaj() {
        int rozmiar = this.talia_kart.size();
        TaliaKart gracz1 = new TaliaKart()
    }

    public ArrayList<Karta> getTalia_kart() {
        return talia_kart;
    }

}
