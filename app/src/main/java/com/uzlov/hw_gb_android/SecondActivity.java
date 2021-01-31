package com.uzlov.hw_gb_android;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_second);

        Button buttonBack = findViewById(R.id.btnToFirstActivity);
        buttonBack.setOnClickListener(v ->{
            Intent intent = new Intent(this, FirstActivity.class);
            startActivity(intent);
        });
    }
}
