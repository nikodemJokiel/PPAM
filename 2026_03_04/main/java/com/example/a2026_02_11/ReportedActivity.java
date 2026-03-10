package com.example.a2026_02_11;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ReportedActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_reported);

        Bundle bundle = getIntent().getExtras();
        if(bundle!=null) {
            String name = bundle.getString("name");
            String surname = bundle.getString("surname");
            String classname = bundle.getString("classname");


            TextView reported_name = findViewById(R.id.reported_name);
            TextView reported_surname = findViewById(R.id.reported_surname);
            TextView reported_class = findViewById(R.id.reported_class);

            reported_name.setText(name);
            reported_surname.setText(surname);
            reported_class.setText(classname);
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ReportedActivity.this, MainActivity.class);
                startActivity(intent);

            }
        });
    }
}