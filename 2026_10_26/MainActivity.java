
package com.example.cezarek;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button button;
    TextView result;
    EditText text, key;

    private static final int ALPHABET_LENGTH = 26;

    public static String encrypt(String text, int key) {

        int shift = key % ALPHABET_LENGTH;

        if (shift < 0) {
            shift = shift + ALPHABET_LENGTH;
        }

        StringBuilder result = new StringBuilder();

        for (char c : text.toCharArray()) {

            if (c >= 'a' && c <= 'z') {

                int position = c - 'a';
                int newPosition = (position + shift) % ALPHABET_LENGTH;
                char newLetter = (char) ('a' + newPosition);

                result.append(newLetter);

            } else {
                result.append(c);
            }
        }

        return result.toString();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        result = findViewById(R.id.result);
        text = findViewById(R.id.text);
        key = findViewById(R.id.key);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String textValue = text.getText().toString();
                String keyValue = key.getText().toString();

                int keyNumber = 0;

                if (!keyValue.isEmpty()) {
                    keyNumber = Integer.parseInt(keyValue);
                }

                String encrypted = encrypt(textValue, keyNumber);

                result.setText(encrypted);
            }
        });
    }
}
