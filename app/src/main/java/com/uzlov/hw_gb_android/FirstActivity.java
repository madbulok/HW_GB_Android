package com.uzlov.hw_gb_android;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class FirstActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonBack = findViewById(R.id.btnToSecondActivity);
        EditText editTextName = findViewById(R.id.etName);
        TextView nameTV = findViewById(R.id.tvMyName);

        buttonBack.setOnClickListener(v ->{
            Intent intent = new Intent(this, SecondActivity.class);
            startActivity(intent);
        });

        editTextName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                nameTV.setText("Hello, "+s);
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }
}
