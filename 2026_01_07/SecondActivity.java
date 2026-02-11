package com.example.a2025_12_03;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        TextView txtEmail = findViewById(R.id.txtEmail);
        Button btnLogout = findViewById(R.id.btnLogout);

        String email = getIntent().getStringExtra("email");
        txtEmail.setText("Zalogowano jako " + email);

        btnLogout.setOnClickListener(v -> {
            startActivity(new Intent(this, MainActivity.class));
            finish();
        });
    }
}
