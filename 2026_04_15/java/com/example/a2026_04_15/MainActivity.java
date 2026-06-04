package com.example.a2026_04_15;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;

public class MainActivity extends AppCompatActivity {

    Button button;
    TextView txt1;
    TextView txt2;
    EditText name;
    EditText email;

    private int clickCount = 0;
    private String welcomeText = "";
    private static final String KEY_CLICK_COUNT = "click_count";
    private static final String KEY_WELCOME_TEXT = "welcome_text";

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

        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        button = findViewById(R.id.button);
        txt1 = findViewById(R.id.txt1);
        txt2 = findViewById(R.id.txt2);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nameStr = name.getText() != null ? name.getText().toString().trim() : "";
                String emailStr = email.getText() != null ? email.getText().toString().trim() : "";

                if (nameStr.isEmpty() || emailStr.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Najpierw uzupełnij swoje dane", Toast.LENGTH_SHORT).show();
                } else {
                    clickCount++;
                    txt2.setText("Kliknąłeś przycisk " + clickCount + " razy");

                    welcomeText = "Witaj, " + nameStr + "! Twój adres e-mail to: " + emailStr;
                    txt1.setText(welcomeText);
                }
            }
        });

    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(KEY_CLICK_COUNT, clickCount);
        outState.putString(KEY_WELCOME_TEXT, welcomeText);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        clickCount = savedInstanceState.getInt(KEY_CLICK_COUNT, 0);
        welcomeText = savedInstanceState.getString(KEY_WELCOME_TEXT, "");

        txt2.setText("Kliknąłeś przycisk " + clickCount + " razy");
        txt1.setText(welcomeText);
    }
}