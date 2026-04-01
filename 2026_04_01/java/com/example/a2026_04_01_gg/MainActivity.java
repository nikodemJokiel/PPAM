package com.example.a2026_04_01_gg;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    final String CHANNEL_HIGH_ID = "high_priority_channel";
    final String CHANNEL_HIGH_NAME = "My high priority Channel";

    final String CHANNEL_LOW_ID = "low_priority_channel";
    final String CHANNEL_LOW_NAME = "low priority channel";
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

        Button button1 = findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent secondActivity = new Intent(MainActivity.this, MainActivity2.class);


                PendingIntent pendingIntent = PendingIntent.getActivity(
                        MainActivity.this,
                        0,
                        secondActivity,
                        PendingIntent.FLAG_UPDATE_CURRENT | PendingIntent.FLAG_IMMUTABLE
                );

                NotificationManager notificationManager = getSystemService(NotificationManager.class);


                NotificationChannel channel = new NotificationChannel(
                            MainActivity.this.CHANNEL_HIGH_ID,
                            MainActivity.this.CHANNEL_HIGH_NAME,
                            NotificationManager.IMPORTANCE_HIGH
                );
                notificationManager.createNotificationChannel(channel);


                Notification notification = new NotificationCompat.Builder(MainActivity.this, MainActivity.this.CHANNEL_HIGH_ID)
                        .setSmallIcon(android.R.drawable.ic_dialog_info)
                        .setContentTitle("Powiadomienie")
                        .setContentText("Najwyższy priorytet")
                        .setContentIntent(pendingIntent)
                        .setAutoCancel(true)
                        .build();

                int id = 1;
                notificationManager.notify(id, notification);
            }
        });

        Button button2 = findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent thirdActivity = new Intent(MainActivity.this, MainActivity3.class);


                PendingIntent pendingIntent = PendingIntent.getActivity(
                        MainActivity.this,
                        0,
                        thirdActivity,
                        PendingIntent.FLAG_UPDATE_CURRENT | PendingIntent.FLAG_IMMUTABLE
                );

                NotificationManager notificationManager = getSystemService(NotificationManager.class);


                NotificationChannel channel = new NotificationChannel(
                        MainActivity.this.CHANNEL_LOW_ID,
                        MainActivity.this.CHANNEL_LOW_NAME,
                        NotificationManager.IMPORTANCE_LOW
                );
                notificationManager.createNotificationChannel(channel);


                Notification notification = new NotificationCompat.Builder(MainActivity.this, MainActivity.this.CHANNEL_HIGH_ID)
                        .setSmallIcon(android.R.drawable.ic_dialog_info)
                        .setContentTitle("Powiadomienie")
                        .setContentText("Niski priorytet")
                        .setContentIntent(pendingIntent)
                        .setAutoCancel(true)
                        .build();

                int id = 2;
                notificationManager.notify(id, notification);
            }
        });
    }


}