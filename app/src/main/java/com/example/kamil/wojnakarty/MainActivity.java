package com.example.kamil.wojnakarty;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

import static com.example.kamil.wojnakarty.Karta.wygrany_k1;
import static com.example.kamil.wojnakarty.Runda.runda;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView gracz1_textview = (TextView) findViewById(R.id.g1tv);
        final TextView gracz2_textview = (TextView) findViewById(R.id.g2tv);
        final TextView wygrany_textview = (TextView) findViewById(R.id.winnertv);
        final TextView pozost1_tv = (TextView) findViewById(R.id.pozost1);
        final TextView pozost2_tv = (TextView) findViewById(R.id.pozost2);
        final Button tura_button = (Button) findViewById(R.id.button);

        TaliaKart taliaKart = new TaliaKart(true);
        ArrayList<TaliaKart> rozdanie = taliaKart.rozdaj();
        final TaliaKart talia_gracz1 = rozdanie.get(0);
        final TaliaKart talia_gracz2 = rozdanie.get(1);

        final TaliaKart bufor1 = new TaliaKart(false);
        final TaliaKart bufor2 = new TaliaKart(false);

        assert tura_button != null;
        tura_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Karta[] rozdanie = new Karta[2];
                try {
                    rozdanie = runda(talia_gracz1, talia_gracz2, bufor1, bufor2);
                    assert pozost1_tv != null;
                    pozost1_tv.setText("Karty: " + (talia_gracz1.talia_length() + bufor1.talia_length()));
                    assert pozost2_tv != null;
                    pozost2_tv.setText("Karty: " + (talia_gracz2.talia_length() + bufor2.talia_length()));
                    if (wygrany_k1(rozdanie[0], rozdanie[1])) {
                        assert wygrany_textview != null;
                        wygrany_textview.setText(R.string.wygrany1);
                    } else {
                        assert wygrany_textview != null;
                        wygrany_textview.setText(R.string.wygrany2);
                    }
                } catch (Runda.GameOverException e) {
                    assert wygrany_textview != null;
                    wygrany_textview.setText("Grę wygrywa " + e.getMessage());
                    tura_button.setEnabled(false);
                }
                assert gracz1_textview != null;
                gracz1_textview.setText(rozdanie[0].toString());
                assert gracz2_textview != null;
                gracz2_textview.setText(rozdanie[1].toString());
            }
        });

    }
}
