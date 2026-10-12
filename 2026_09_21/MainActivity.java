package com.example.aplikacja;

import android.os.Bundle;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    TextView txtRozmiar, txtCytat;
    SeekBar suwakRozmiaru;
    Button btnZmienTekst;

    String[] cytaty = {
            "Dzień dobry",
            "Good morning",
            "Buenos dias"
    };

    int numerCytatu = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtRozmiar = findViewById(R.id.txtRozmiar);
        txtCytat = findViewById(R.id.txtCytat);
        suwakRozmiaru = findViewById(R.id.suwakRozmiaru);
        btnZmienTekst = findViewById(R.id.btnZmienTekst);

        suwakRozmiaru.setMax(40);
        suwakRozmiaru.setProgress(20);

        txtRozmiar.setText("Rozmiar: " + suwakRozmiaru.getProgress());
        txtCytat.setTextSize(suwakRozmiaru.getProgress());

        suwakRozmiaru.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(
                            SeekBar seekBar, int progress, boolean fromUser) {

                        txtRozmiar.setText("Rozmiar: " + progress);
                        txtCytat.setTextSize(progress);
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {
                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {
                    }
                });

        btnZmienTekst.setOnClickListener(v -> {
            numerCytatu = (numerCytatu + 1) % cytaty.length;
            txtCytat.setText(cytaty[numerCytatu]);
        });
    }
}
