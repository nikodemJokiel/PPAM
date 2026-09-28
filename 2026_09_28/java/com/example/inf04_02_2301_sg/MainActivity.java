package com.example.inf04_02_2301_sg;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    Button buttonAddNote;
    EditText inputNote;
    ListView noteList;

    ArrayList<String> notes;
    ArrayAdapter<String> notesAdapter;

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

        buttonAddNote = findViewById(R.id.buttonAddNote);
        inputNote = findViewById(R.id.inputNote);
        noteList = findViewById(R.id.noteList);

        notes = new ArrayList<>(Arrays.asList("Zakupy: chleb, masło, ser", "Do zrobienia: obiad, umyć podłogi", "weekend: kino, spacer z psem"));

        notesAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, notes);
        noteList.setAdapter(notesAdapter);

        buttonAddNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                notes.add(inputNote.getText().toString());
                notesAdapter.notifyDataSetChanged();

            }
        });
    }
}