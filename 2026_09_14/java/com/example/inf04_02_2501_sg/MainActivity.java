package com.example.inf04_02_2501_sg;

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

    Button wlacz,zatwierdz;
    EditText nrPrania;
    TextView nrPraniaLabel, wlaczonyLabel;
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

        wlacz = findViewById(R.id.wlacz);
        zatwierdz = findViewById(R.id.zatwierdz);
        nrPrania = findViewById(R.id.nrPrania);
        nrPraniaLabel = findViewById(R.id.nrPraniaLabel);
        wlaczonyLabel = findViewById(R.id.wlaczonyLabel);

        zatwierdz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!nrPrania.getText().toString().isEmpty()){
                    int inputNrPrania = Integer.parseInt(nrPrania.getText().toString());
                    if(inputNrPrania >=1 && inputNrPrania<=12){
                        nrPraniaLabel.setText("Numer prania: "+ inputNrPrania);
                    }
                }

            }
        });

        wlacz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(wlacz.getText().toString().equals("Włącz")){
                    wlacz.setText("Wyłącz");
                    wlaczonyLabel.setText("Odkurzacz włączony");
                    return;
                }
                if(wlacz.getText().toString().equals("Wyłącz")){
                    wlacz.setText("Włącz");
                    wlaczonyLabel.setText("Odkurzacz wyłączony");
                }
            }
        });
    }
}