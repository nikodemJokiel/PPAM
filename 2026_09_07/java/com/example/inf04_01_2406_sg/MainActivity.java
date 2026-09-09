package com.example.inf04_01_2406_sg;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.nio.InvalidMarkException;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button roll, rollReset;
    TextView gameResult, rollResult;
    ImageView dial1, dial2, dial3, dial4, dial5;


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

        roll = findViewById(R.id.roll);
        rollReset = findViewById(R.id.rollReset);
        gameResult = findViewById(R.id.gameResult);
        rollResult = findViewById(R.id.rollResult);
        dial1 = findViewById(R.id.dial1);
        dial2 = findViewById(R.id.dial2);
        dial3 = findViewById(R.id.dial3);
        dial4 = findViewById(R.id.dial4);
        dial5 = findViewById(R.id.dial5);
        ImageView[] imageViews = {dial1, dial2, dial3, dial4, dial5};

        final int[] totalScore = {0};

        roll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random random = new Random();
                int rollSum = 0;
                int[] rolls = new int[5];
                for (int i=0; i<5; i++){
                    int randomRoll = random.nextInt(6)+1;
                    String imageName = "k" + randomRoll;
                    int imageId = getResources().getIdentifier(imageName, "drawable", getPackageName());
                    imageViews[i].setImageResource(imageId);
                    rollSum += randomRoll;
                    totalScore[0] += randomRoll;
                }
                rollResult.setText("Wynik tego losowania: "+ rollSum);
                gameResult.setText("Wynik gry: "+ totalScore[0]);
            }
        });

        rollReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i=0; i<5; i++){
                    imageViews[i].setImageResource(R.drawable.question);
                }
                totalScore[0] = 0;
                rollResult.setText("Wynik tego losowania: 0");
                gameResult.setText("Wynik gry: "+ totalScore[0]);
            }
        });
    }
}