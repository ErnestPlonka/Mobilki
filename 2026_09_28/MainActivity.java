package com.example.notatki;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    EditText edtNowyElement;
    Button btnDodaj;
    ListView listaNotatek;

    ArrayList<String> notatki;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtNowyElement = findViewById(R.id.edtNowyElement);
        btnDodaj = findViewById(R.id.btnDodaj);
        listaNotatek = findViewById(R.id.listaNotatek);

        String[] danePoczatkowe = {
                "Zakupy",
                "Spotkanie o 15:00",
                "Przypomnieć o zadaniu"
        };

        notatki = new ArrayList<>(Arrays.asList(danePoczatkowe));

        adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                notatki
        );

        listaNotatek.setAdapter(adapter);

        btnDodaj.setOnClickListener(v -> {
            String nowaNotatka = edtNowyElement.getText().toString();

            notatki.add(nowaNotatka);
            adapter.notifyDataSetChanged();

            edtNowyElement.setText("");
        });
    }
}
