package com.example.a2026_03_18;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    TextView wiek, komunikat;
    EditText imieNazwisko, cel, godzina;
    SeekBar wiekSlider;
    Button buttonOk;
    ListView listaGatunkow;

    String[] gatunki = {"Pies", "Kot", "Świnka morska"};
    String wybranyGatunek = "";
    int wybranyWiek = 0;


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

        listaGatunkow = findViewById(R.id.listaGatunkow);
        buttonOk = findViewById(R.id.buttonOk);
        wiekSlider = findViewById(R.id.wiekSlider);
        imieNazwisko = findViewById(R.id.imieNazwisko);
        cel = findViewById(R.id.cel);
        godzina = findViewById(R.id.godzina);
        wiek =findViewById(R.id.wiek);
        komunikat = findViewById(R.id.komunikat);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,gatunki);
        listaGatunkow.setAdapter(adapter);

        listaGatunkow.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                wybranyGatunek = gatunki[position];

                if (position == 0) {
                    wiekSlider.setMax(18);
                } else if (position == 1) {
                    wiekSlider.setMax(20);
                } else if (position == 2) {
                    wiekSlider.setMax(9);
                }

                wiekSlider.setProgress(0);
                wybranyWiek = 0;
                wiek.setText("Ile ma lat? 0");
            }
        });

        wiekSlider.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                wybranyWiek = progress;
                wiek.setText("Ile ma lat? "+progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        buttonOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String imieNazwiskoString = imieNazwisko.getText().toString();
                String celString = cel.getText().toString();
                String godzinaString = godzina.getText().toString();

                NotificationManager notificationManager = getSystemService(NotificationManager.class);

                NotificationChannel channel = new NotificationChannel("c1","channel 1", NotificationManager.IMPORTANCE_HIGH);
                notificationManager.createNotificationChannel(channel);
                Notification notification = new NotificationCompat.Builder(MainActivity.this, "c1")
                        .setSmallIcon(android.R.drawable.ic_dialog_info)
                        .setContentTitle("Nowa wizyta")
                        .setContentText(imieNazwiskoString +", "+wybranyGatunek+", "+wybranyWiek+", "+celString+", "+godzinaString)
                        .setAutoCancel(true)
                        .build();

                int id = 1;
                notificationManager.notify(id, notification);


                komunikat.setText(imieNazwiskoString +", "+wybranyGatunek+", "+wybranyWiek+", "+celString+", "+godzinaString);
            }
        });
    }
}