package com.example.inf04_02_2306_sg;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    TextView size, cite;
    SeekBar seekBarSize;
    Button nextCite;
    String[] cites = {"Dzień dobry", "Good morning", "Buenos dias"};
    int citeIndex = 0;

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

        size = findViewById(R.id.size);
        cite = findViewById(R.id.cite);
        seekBarSize = findViewById(R.id.seekBarSize);
        nextCite = findViewById(R.id.nextCite);

        seekBarSize.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int fontSize = seekBarSize.getProgress();
                cite.setTextSize(fontSize);
                size.setText("Rozmiar: " + fontSize);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        nextCite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                citeIndex += 1;
                if(citeIndex > 2){
                    citeIndex = 0;
                }
                cite.setText(cites[citeIndex]);
            }
        });
    }
}