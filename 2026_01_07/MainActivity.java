package com.example.a2025_12_03;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText Email, Pass, Pass2;
    TextView Message;
    Button btnConfirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Email = findViewById(R.id.Email);
        Pass = findViewById(R.id.Pass);
        Pass2 = findViewById(R.id.Pass2);
        Message = findViewById(R.id.Message);
        btnConfirm = findViewById(R.id.btnConfirm);

        btnConfirm.setOnClickListener(v -> {

            String email = Email.getText().toString();
            String pass = Pass.getText().toString();
            String pass2 = Pass2.getText().toString();

            Message.setTextColor(getColor(android.R.color.holo_red_dark));

            if (!email.contains("@") || !email.contains(".")) {
                Message.setText("Niepoprawny e-mail");
                return;
            }

            if (!pass.equals(pass2)) {
                Message.setText("Hasła nie są takie same");
                return;
            }

            if (pass.length() < 8) {
                Message.setText("Hasło za krótkie");
                return;
            }

            boolean duza = false, mala = false, cyfra = false;

            for (char c : pass.toCharArray()) {
                if (Character.isUpperCase(c)) duza = true;
                if (Character.isLowerCase(c)) mala = true;
                if (Character.isDigit(c)) cyfra = true;
            }

            if (!duza || !mala || !cyfra) {
                Message.setText("Hasło musi mieć dużą, małą literę i cyfrę");
                return;
            }

            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            intent.putExtra("email", email);
            startActivity(intent);
        });
    }
}
