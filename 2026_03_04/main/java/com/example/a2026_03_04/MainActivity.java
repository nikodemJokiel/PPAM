package com.example.a2026_03_04;

import android.content.Intent;
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
import android.app.ProgressDialog;

public class MainActivity extends AppCompatActivity {
    Button button;
    TextView name, surname, classname;
    EditText inpName, inpSurname, inpClassname;
    Intent reported;
    Bundle reportedParams;



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
        name = findViewById(R.id.name_label);
        surname = findViewById(R.id.surname_label);
        classname = findViewById(R.id.class_label);
        inpName = findViewById(R.id.name_input);
        inpSurname = findViewById(R.id.surname_input);
        inpClassname = findViewById(R.id.class_input);

        reported = new Intent(this, ReportedActivity.class );
        reportedParams = new Bundle();


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameContent = inpName.getText().toString();
                String surnameContent = inpSurname.getText().toString();
                String classnameContent = inpClassname.getText().toString();

                if(!nameContent.isEmpty() && !surnameContent.isEmpty() && !classnameContent.isEmpty()){
                     ProgressDialog progressDialog = new ProgressDialog();
                     progressDialog.setTitle("");
                     progressDialog.setMessage("");
                     progressDialog.show();


                    reportedParams.putString("name", nameContent);
                    reportedParams.putString("surname", surnameContent);
                    reportedParams.putString("class", classnameContent);
                    reported.putExtras(reportedParams);

                    startActivity(reported);
                }
            }
        });
    }
}