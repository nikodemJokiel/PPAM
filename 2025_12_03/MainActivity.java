package com.example.a2025_12_03;

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

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emailContent = email.getText().toString();
                String passwordContent = password.getText().toString();
                String repeatPasswordContent = repeatPassword.getText().toString();
                String newMessage = "";
                if(!emailContent.contains("@")) {
                    newMessage = "Nieprawidłowy adres e-mail\n";
                }
                if(!passwordContent.equals(repeatPasswordContent)){
                    newMessage += "Hasła się różnią";
                }
                if(emailContent.contains("@") && passwordContent.equals(repeatPasswordContent)){
                    newMessage = "Witaj " + emailContent;
                }
                message.setText(newMessage);

            }
        });

    }
}