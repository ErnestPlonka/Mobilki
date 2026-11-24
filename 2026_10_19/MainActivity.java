package com.example.wizyta;

import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private EditText etWlasciciel;
    private EditText etCelWizyty;
    private ListView listGatunek;
    private TextView tvWiek;
    private TextView tvGodzina;
    private TextView tvWynik;
    private SeekBar seekWiek;

    private String wybranyGatunek = "";
    private int wiek = 0;
    private int godzina = 16;
    private int minuta = 0;

    private final String[] gatunki = {"Pies", "Kot", "Świnka morska"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etWlasciciel = findViewById(R.id.etWlasciciel);
        etCelWizyty = findViewById(R.id.etCelWizyty);
        listGatunek = findViewById(R.id.listGatunek);
        tvWiek = findViewById(R.id.tvWiek);
        tvGodzina = findViewById(R.id.tvGodzina);
        tvWynik = findViewById(R.id.tvWynik);
        seekWiek = findViewById(R.id.seekWiek);
        Button btnOk = findViewById(R.id.btnOk);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                R.layout.list_item,
                R.id.tvElementListy,
                gatunki
        );
        listGatunek.setAdapter(adapter);

        // Początkowo suwak ma zakres od 0 do 20.
        seekWiek.setMax(20);
        tvWiek.setText("Ile ma lat?  " + wiek);

        listGatunek.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                wybranyGatunek = gatunki[position];

                int maksymalnyWiek;
                if (wybranyGatunek.equals("Pies")) {
                    maksymalnyWiek = 18;
                } else if (wybranyGatunek.equals("Kot")) {
                    maksymalnyWiek = 20;
                } else {
                    maksymalnyWiek = 9;
                }

                seekWiek.setMax(maksymalnyWiek);
                if (wiek > maksymalnyWiek) {
                    seekWiek.setProgress(maksymalnyWiek);
                    wiek = maksymalnyWiek;
                    aktualizujWiek();
                }
            }
        });

        seekWiek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                wiek = progress;
                aktualizujWiek();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        tvGodzina.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TimePickerDialog dialog = new TimePickerDialog(
                        MainActivity.this,
                        (timePicker, selectedHour, selectedMinute) -> {
                            godzina = selectedHour;
                            minuta = selectedMinute;
                            aktualizujGodzine();
                        },
                        godzina,
                        minuta,
                        true
                );
                dialog.show();
            }
        });

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String wlasciciel = etWlasciciel.getText().toString().trim();
                String cel = etCelWizyty.getText().toString().trim();

                String wynik = wlasciciel + ", " + wybranyGatunek + ", "
                        + wiek + ", " + cel + ", " + String.format(Locale.getDefault(),
                        "%02d:%02d", godzina, minuta);

                tvWynik.setText(wynik);
            }
        });

        aktualizujGodzine();
    }

    private void aktualizujWiek() {
        tvWiek.setText("Ile ma lat?  " + wiek);
    }

    private void aktualizujGodzine() {
        tvGodzina.setText(String.format(Locale.getDefault(), "%02d:%02d", godzina, minuta));
    }
}
