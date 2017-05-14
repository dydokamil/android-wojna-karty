package com.example.kamil.wojnakarty;

import static com.example.kamil.wojnakarty.Karta.wygrany_k1;

/**
 * Created by kamil on 5/14/17.
 */

public class Runda {
    static class GameOverException extends Exception {
        GameOverException(String wygrany) {
            super(wygrany);
        }
    }

    public static Karta[] runda(TaliaKart t1, TaliaKart t2, TaliaKart bufor1, TaliaKart bufor2) throws GameOverException {
        if (t1.talia_length() == 0 || t2.talia_length() == 0) {
            t1.getTalia_kart().addAll(bufor1.getTalia_kart());
            t2.getTalia_kart().addAll(bufor2.getTalia_kart());

            bufor1.getTalia_kart().clear();
            bufor2.getTalia_kart().clear();

            if (t1.talia_length() == 0) {
                throw new GameOverException("Gracz1");
            } else if (t2.talia_length() == 0) {
                throw new GameOverException("Gracz2");
            }

            t1.tasuj();
            t2.tasuj();
        }
        Karta k1 = t1.zabierz_karte();
        Karta k2 = t2.zabierz_karte();

        boolean wygral_k1 = wygrany_k1(k1, k2);
        if (wygral_k1) {
            bufor1.add_card(k1);
            bufor1.add_card(k2);
        } else {
            bufor2.add_card(k1);
            bufor2.add_card(k2);
        }

        return new Karta[]{k1, k2};

    }
}
