package com.example.egzamin_24_06_2024;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText numerPrania;
    Button zatwierdz;
    Button wlacz;

    TextView numerPraniaTekst;
    TextView statusOdkurzacza;
    TextView odkurzaczStan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numerPrania = findViewById(R.id.numerPrania);
        zatwierdz = findViewById(R.id.zatwierdz);
        wlacz = findViewById(R.id.wlacz);

        numerPraniaTekst = findViewById(R.id.numerPraniaTekst);
        statusOdkurzacza = findViewById(R.id.statusOdkurzacza);
        odkurzaczStan = findViewById(R.id.odkurzaczStan);

        zatwierdz.setOnClickListener(v -> {
            String tekst = numerPrania.getText().toString();

            if (!tekst.isEmpty()) {
                int numer = Integer.parseInt(tekst);

                if (numer >= 1 && numer <= 12) {
                    numerPraniaTekst.setText("Numer prania: " + numer);
                }
            }
        });

        wlacz.setOnClickListener(v -> {
            if (wlacz.getText().toString().equals("Włącz")) {
                wlacz.setText("Wyłącz");
                odkurzaczStan.setText("Odkurzacz włączony");
            } else {
                wlacz.setText("Włącz");
                odkurzaczStan.setText("Odkurzacz wyłączony");
            }
        });
    }
}