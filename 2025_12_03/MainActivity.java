package com.example.a2025_12_03;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText Email, Pass, Pass2;
    private TextView Message;
    private Button btnConfirm;
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
        Email = findViewById(R.id.Email);
        Pass = findViewById(R.id.Pass);
        Pass2 = findViewById(R.id.Pass2);
        Message = findViewById(R.id.Message);
        btnConfirm = findViewById(R.id.btnConfirm);

        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String email = Email.getText().toString().trim();
                String pwd = Pass.getText().toString();
                String pwd2 = Pass2.getText().toString();

                if (email.isEmpty() || !email.contains("@")) {
                    Message.setText("Nieprawidłowy adres e-mail.");
                    return;
                }

                if (pwd.isEmpty() || pwd2.isEmpty()) {
                    Message.setText("Hasło nie może być puste.");
                    return;
                }

                if (!pwd.equals(pwd2)) {
                    Message.setText("Hasła się różnią.");
                    return;
                }

                Message.setText("Witaj " + email);
            }
        });
    }
}