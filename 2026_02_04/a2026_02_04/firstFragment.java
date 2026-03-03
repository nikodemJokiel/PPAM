package com.example.a2026_02_04;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.Button;
import android.widget.EditText;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import java.util.regex.Pattern;


public class firstFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.first_fragment, container, false);
        Button button = view.findViewById(R.id.button);
        button.setOnClickListener(v -> {
            FragmentActivity mainActivity = getActivity();
            assert mainActivity != null;
            EditText emailEntry = view.findViewById(R.id.editTextEmail);
            String email = emailEntry.getText().toString().trim();

            if(Pattern.matches("^[a-zA-Z0-9._-]+@[a-zA-Z0-9._-]+$", email))
            {
                EditText nameEntry = view.findViewById(R.id.editTextText2);
                String name = nameEntry.getText().toString();

                EditText surnameEntry = view.findViewById(R.id.editTextText3);
                String surname = surnameEntry.getText().toString();

                if (!name.isEmpty() && !surname.isEmpty())
                {
                    FragmentManager fragmentManager = getParentFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                    var fragment = new secondFragment();
                    Bundle args = new Bundle();
                    args.putString("email", email);
                    args.putString("name", name);
                    args.putString("surname", surname);
                    fragment.setArguments(args);
                    fragmentTransaction.replace(R.id.main, fragment);

                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();
                }
            }
        });
        return view;
    }
}