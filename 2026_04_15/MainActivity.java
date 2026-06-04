package edu.zsk.a2026_04_15;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText etName, etEmail;
    private TextView txt1, txt2;
    private int clickCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        etName = findViewById(R.id.etName);
        etEmail = findViewById(R.id.etEmail);
        txt1 = findViewById(R.id.txt1);
        txt2 = findViewById(R.id.txt2);
        Button btnIncrease = findViewById(R.id.btnIncrease);

        btnIncrease.setOnClickListener(v -> {
            String name = etName.getText().toString().trim();
            String email = etEmail.getText().toString().trim();

            if (name.isEmpty() || email.isEmpty()) {
                Toast.makeText(MainActivity.this, "Najpierw uzupełnij swoje dane", Toast.LENGTH_SHORT).show();
            } else {
                clickCount++;


                txt1.setText("Witaj, " + name + "! Twój adres e-mail to: " + email);
                txt2.setText("Kliknąłeś przycisk " + clickCount + " razy");
            }
        });
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("COUNT_KEY", clickCount);
        outState.putString("TXT1_KEY", txt1.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        clickCount = savedInstanceState.getInt("COUNT_KEY");
        String savedTxt1 = savedInstanceState.getString("TXT1_KEY");

        txt1.setText(savedTxt1);
        txt2.setText("Kliknąłeś przycisk " + clickCount + " razy");
    }
}