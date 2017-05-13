package com.example.kamil.wojnakarty;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
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

    public TaliaKart(ArrayList<Karta> karty) {
        talia_kart = karty;
    }

    public void tasuj() {
        Collections.shuffle(this.talia_kart);
    }

    public static void usun_wojne(TaliaKart t1, TaliaKart t2) {
        boolean wojna = false;

        if (t1.talia_length() >= t2.talia_length()) {
            for (int i = 0; i < t2.talia_length(); i++) {
                if (t1.getTalia_kart().get(i) == t2.getTalia_kart().get(i)) {
                    wojna = true;
                    break;
                }
            }
        } else {
            for (int i = 0; i < t1.talia_length(); i++) {
                if (t1.getTalia_kart().get(i) == t2.getTalia_kart().get(i)) {
                    wojna = true;
                    break;
                }
            }
        }

        if (wojna) {
            t1.tasuj();
            t2.tasuj();
            usun_wojne(t1, t2);
        }
    }

    public ArrayList<TaliaKart> rozdaj() {
        ArrayList<Karta> gracz1 = new ArrayList<>();
        ArrayList<Karta> gracz2 = new ArrayList<>();
        for (int i = 0; i < this.talia_kart.size() / 2; i++) {
            gracz1.add(this.getTalia_kart().get(i));
        }
        for (int i = this.talia_kart.size() / 2; i < this.talia_kart.size(); i++) {
            gracz2.add(this.getTalia_kart().get(i));
        }
        TaliaKart talia_gracz1 = new TaliaKart(gracz1);
        TaliaKart talia_gracz2 = new TaliaKart(gracz2);

        ArrayList<TaliaKart> rozdanie = new ArrayList<>();
        rozdanie.add(talia_gracz1);
        rozdanie.add(talia_gracz2);

        return rozdanie;
    }

    public ArrayList<Karta> getTalia_kart() {
        return talia_kart;
    }

    public int talia_length() {
        return this.talia_kart.size();
    }

}
