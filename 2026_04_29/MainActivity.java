package edu.zsk.a2026_04_29;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int[] ids = {
                R.id.img1, R.id.img2, R.id.img3, R.id.img4, R.id.img5,
                R.id.img6, R.id.img7, R.id.img8, R.id.img9, R.id.img10,
                R.id.img11, R.id.img12, R.id.img13, R.id.img14, R.id.img15
        };

        for (int id : ids) {
            findViewById(id).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ImageDialogFragment dialog = ImageDialogFragment.newInstance(android.R.drawable.ic_menu_gallery);
                    dialog.show(getSupportFragmentManager(), "image_dialog");
                }
            });
        }
    }
}