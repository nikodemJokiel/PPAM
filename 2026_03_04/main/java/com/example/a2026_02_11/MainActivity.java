package com.example.a2026_02_11;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button button;
    EditText name, surname, classname;
    Intent reported;
    Bundle reportedBundle;

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

        button = findViewById(R.id.button);
        name = findViewById(R.id.name_input);
        surname = findViewById(R.id.surname_input);
        classname = findViewById(R.id.class_input);
        reported = new Intent(this, ReportedActivity.class);
        reportedBundle = new Bundle();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nameContent = name.getText().toString();
                String surnameContent = surname.getText().toString();
                String classnameContent = classname.getText().toString();

                if(nameContent.isEmpty() || surnameContent.isEmpty() || classnameContent.isEmpty()){
                    Toast.makeText(MainActivity.this, "Wypełnij wszystkie pola!", Toast.LENGTH_SHORT).show();
                }
                else{
                    reportedBundle.putString("name", nameContent);
                    reportedBundle.putString("surname", surnameContent);
                    reportedBundle.putString("classname", classnameContent);
                    reported.putExtras(reportedBundle);

                    name.setText("");
                    surname.setText("");
                    classname.setText("");

                    ProgressDialog progressDialog = new ProgressDialog(MainActivity.this);
                    progressDialog.setTitle("Dodaję uwagę");
                    progressDialog.setMessage("Proszę czekać...");
                    progressDialog.setCancelable(false);
                    progressDialog.show();

                    new android.os.Handler(android.os.Looper.getMainLooper()).postDelayed(() -> {
                        progressDialog.dismiss();
                        startActivity(reported);
                    },2000);


                }
            }
        });
    }
}