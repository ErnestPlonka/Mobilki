package com.example.domekwgorach;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private int liczbaPolubien = 0;
    private TextView tvPolubienia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnPolub = findViewById(R.id.btnPolub);
        Button btnUsun = findViewById(R.id.btnUsun);
        Button btnZapisz = findViewById(R.id.btnZapisz);
        tvPolubienia = findViewById(R.id.tvPolubienia);

        btnPolub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                liczbaPolubien++;
                aktualizujLicznik();
            }
        });

        btnUsun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (liczbaPolubien > 0) {
                    liczbaPolubien--;
                }
                aktualizujLicznik();
            }
        });

        btnZapisz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Oferta została zapisana", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void aktualizujLicznik() {
        tvPolubienia.setText(liczbaPolubien + " polubień");
    }
}
