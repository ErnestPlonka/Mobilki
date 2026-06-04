package edu.zsk.a2026_04_01;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class activity3 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);

        Button btn4 = findViewById(R.id.btn4);
        btn4.setOnClickListener(v -> {
            Intent intent = new Intent(activity3.this, MainActivity.class);
            startActivity(intent);
        });
    }
}