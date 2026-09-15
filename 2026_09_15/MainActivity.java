package com.example.egzamin_24_06_2024;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

Button przyciskRzut, przyciskReset;
ImageView kostka1, kostka2, kostka3, kostka4, kostka5;
TextView wynikGryText, wynikRzutuText;
int sumaGry = 0;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    EdgeToEdge.enable(this);
    setContentView(R.layout.activity_main);

    ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
        Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
        v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
        return insets;
    });

    przyciskRzut = findViewById(R.id.btnRzuc);
    przyciskReset = findViewById(R.id.btnReset);

    kostka1 = findViewById(R.id.img1);
    kostka2 = findViewById(R.id.img2);
    kostka3 = findViewById(R.id.img3);
    kostka4 = findViewById(R.id.img4);
    kostka5 = findViewById(R.id.img5);

    wynikRzutuText = findViewById(R.id.wynikLos);
    wynikGryText = findViewById(R.id.wynikGry);

    ImageView[] obrazyKostek = {
            kostka1,
            kostka2,
            kostka3,
            kostka4,
            kostka5
    };

    int[] grafikiKostek = {
            R.drawable.k1,
            R.drawable.k2,
            R.drawable.k3,
            R.drawable.k4,
            R.drawable.k5,
            R.drawable.k6
    };

    Random generator = new Random();

    przyciskRzut.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int sumaRzutu = 0;

            for (int i = 0; i < 5; i++) {
                int wylosowanaWartosc = generator.nextInt(6) + 1;

                obrazyKostek[i].setImageResource(grafikiKostek[wylosowanaWartosc - 1]);

                sumaRzutu += wylosowanaWartosc;
                wynikRzutuText.setText("Wynik tego losowania: " + sumaRzutu);

                sumaGry += wylosowanaWartosc;
                wynikGryText.setText("Wynik gry: " + sumaGry);
            }
        }
    });

    przyciskReset.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            for (int i = 0; i < 5; i++) {
                obrazyKostek[i].setImageResource(R.drawable.question);
                wynikRzutuText.setText("Wynik tego losowania: ");
                sumaGry = 0;
                wynikGryText.setText("Wynik gry: ");
            }
        }
    });
}

}