package com.example.a2025_12_03;

import android.content.Intent;
import android.graphics.Color;
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

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    Button btn;
    TextView message;
    EditText email, password, repeatPassword;
    Intent loggedIn;
    Bundle logParams;


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

        btn = findViewById(R.id.button);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        repeatPassword = findViewById(R.id.repeatPassword);
        message = findViewById(R.id.message);

        loggedIn = new Intent(this, MainActivity2.class);
        logParams = new Bundle();

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emailContent = email.getText().toString();
                String passwordContent = password.getText().toString();
                String repeatPasswordContent = repeatPassword.getText().toString();
                String newMessage = "";

                message.setTextColor(Color.parseColor("#FF0000"));

                if(!Pattern.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", emailContent)) {
                    newMessage += "niepoprawny email";
                }
                else if(!passwordContent.equals(repeatPasswordContent)){
                    newMessage += "Hasła się różnią";
                }
                else if(passwordContent.length()<8){
                    newMessage += "hasło powinno mieć przynajmniej 8 zaków";
                }
                else if(!passwordContent.matches(".*\\d.*")){
                    newMessage += "hasło powinno mieć przynajmniej jedną cyfrę";
                }
                else if(!passwordContent.matches(".*[A-Z]+.*")){
                    newMessage += "hasło powinno mieć przynajmniej jedną wielką literę";
                }
                else if(!passwordContent.matches(".*[a-z]+.*")){
                    newMessage += "hasło powinno mieć przynajmniej jedną małą literę";
                }
                else{
                    message.setTextColor(Color.parseColor("#FFFFFF"));
                    newMessage = "Witaj " + emailContent;
                    logParams.putString("email", emailContent);
                    loggedIn.putExtras(logParams);
                    startActivity(loggedIn);
                }
                message.setText(newMessage);

            }
        });

    }
}
