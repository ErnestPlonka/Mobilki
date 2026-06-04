package edu.zsk.a2026_04_01;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class activity2 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        Button btn3 = findViewById(R.id.btn3);
        btn3.setOnClickListener(v -> {
            Intent intent = new Intent(activity2.this, MainActivity.class);
            startActivity(intent);
        });
    }
}