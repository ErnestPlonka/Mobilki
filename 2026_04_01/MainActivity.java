package edu.zsk.a2026_04_01;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

public class MainActivity extends AppCompatActivity {

    private static final String CHANNEL_HIGH = "high_channel";
    private static final String CHANNEL_LOW = "low_channel";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createNotificationChannels();

        Button btn1 = findViewById(R.id.btn1);
        Button btn2 = findViewById(R.id.btn2);

        btn1.setOnClickListener(v -> sendNotification(CHANNEL_HIGH, NotificationCompat.PRIORITY_HIGH, activity2.class, 1));
        btn2.setOnClickListener(v -> sendNotification(CHANNEL_LOW, NotificationCompat.PRIORITY_LOW, activity3.class, 2));
    }

    private void sendNotification(String channelId, int priority, Class<?> targetActivity, int id) {
        Intent intent = new Intent(this, targetActivity);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);

        PendingIntent pendingIntent = PendingIntent.getActivity(this, id, intent,
                PendingIntent.FLAG_UPDATE_CURRENT | PendingIntent.FLAG_IMMUTABLE);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, channelId)
                .setSmallIcon(android.R.drawable.ic_dialog_info)
                .setContentTitle("Powiadomienie " + (id == 1 ? "Wysokie" : "Niskie"))
                .setContentText("Kliknij, aby otworzyć aktywność")
                .setPriority(priority)
                .setContentIntent(pendingIntent)
                .setAutoCancel(true);

        NotificationManager manager = getSystemService(NotificationManager.class);
        if (manager != null) {
            manager.notify(id, builder.build());
        }
    }

    private void createNotificationChannels() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel highChannel = new NotificationChannel(CHANNEL_HIGH,
                    "Wysoki Priorytet", NotificationManager.IMPORTANCE_HIGH);

            NotificationChannel lowChannel = new NotificationChannel(CHANNEL_LOW,
                    "Niski Priorytet", NotificationManager.IMPORTANCE_LOW);

            NotificationManager manager = getSystemService(NotificationManager.class);
            if (manager != null) {
                manager.createNotificationChannel(highChannel);
                manager.createNotificationChannel(lowChannel);
            }
        }
    }
}