package com.example.kamil.wojnakarty;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

import static com.example.kamil.wojnakarty.TaliaKart.tasuj;
import static com.example.kamil.wojnakarty.TaliaKart.usun_wojne;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView gracz1_textview = (TextView) findViewById(R.id.g1tv);
        final TextView gracz2_textview = (TextView) findViewById(R.id.g2tv);
        final TextView wygrany_textview = (TextView) findViewById(R.id.winnertv);
        final Button tura_button = (Button) findViewById(R.id.button);

        TaliaKart taliaKart = new TaliaKart();
        ArrayList<TaliaKart> rozdanie = taliaKart.rozdaj();
        TaliaKart talia_gracz1 = rozdanie.get(0);
        TaliaKart talia_gracz2 = rozdanie.get(1);

        usun_wojne(talia_gracz1, talia_gracz2);

        assert tura_button != null;
        tura_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                assert wygrany_textview != null;
                wygrany_textview.setText(talia_gracz1.getTalia_kart().get(0).toString());
            }
        });

    }
}
