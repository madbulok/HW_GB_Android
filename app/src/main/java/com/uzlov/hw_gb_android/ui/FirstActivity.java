package com.uzlov.hw_gb_android.ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceManager;

import com.uzlov.hw_gb_android.R;

import java.util.prefs.PreferenceChangeEvent;

public class FirstActivity extends AppCompatActivity implements View.OnClickListener, SharedPreferences.OnSharedPreferenceChangeListener {

    private TextView previewCalculation;
    private final StringBuilder historyCalc = new StringBuilder();
    private SharedPreferences settings;


    @Override
    protected void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initSettings();

        loadTheme();

        setContentView(R.layout.activity_main);

        initUI();

    }

    private void initSettings() {
        settings = PreferenceManager.getDefaultSharedPreferences(this);
        settings.registerOnSharedPreferenceChangeListener(this);
    }


    private void initUI(){
        // клавиатура
        int[] id_buttons = new int[]{R.id.button1, R.id.button2, R.id.button3,
                R.id.button4, R.id.button5, R.id.button6, R.id.button7, R.id.button8,
                R.id.button9, R.id.button0, R.id.button_backspace, R.id.button_minus, R.id.button_divider,
                R.id.button_multiply, R.id.button_point, R.id.button_plus, R.id.button_percent,
                R.id.button_clear, R.id.btnSettings
        };

        for (int id : id_buttons) {
            findViewById(id).setOnClickListener(this);
        }

        // поле результатов
        previewCalculation = findViewById(R.id.tvPreviewcalculation);
    }

    private void loadTheme() {
        String s = settings.getString(getString(R.string.ID_THEME),"0");
        switch (s){
            case("0"):
                setTheme(R.style.Theme_DevelopersLife);
                break;
            case("1"):
                setTheme(R.style.Theme_DevelopersLifeBlue);
                break;
            case("2"):
                setTheme(R.style.Theme_DevelopersLifeRed);
                break;
            case("3"):
                setTheme(R.style.Theme_DevelopersLifeGreen);
                break;
        }
    }

    @Override
    public void onClick(View v) {
        initCalculatorNumListener(v);
        initCalculatorOperandListener(v);
    }

    private void initCalculatorNumListener(View v) {
        switch (v.getId()){
            case(R.id.button1):
                historyCalc.append(getString(R.string._1));
                previewCalculation.setText(historyCalc.toString());
                break;
            case(R.id.button2):
                historyCalc.append(getString(R.string._2));
                previewCalculation.setText(historyCalc.toString());
                break;
            case(R.id.button3):
                historyCalc.append(getString(R.string._3));
                previewCalculation.setText(historyCalc.toString());
                break;
            case(R.id.button4):
                historyCalc.append(getString(R.string._4));
                previewCalculation.setText(historyCalc.toString());
                break;
            case(R.id.button5):
                historyCalc.append(getString(R.string._5));
                previewCalculation.setText(historyCalc.toString());
                break;
            case(R.id.button6):
                historyCalc.append(getString(R.string._6));
                previewCalculation.setText(historyCalc.toString());
                break;
            case(R.id.button7):
                historyCalc.append(getString(R.string._7));
                previewCalculation.setText(historyCalc.toString());
                break;
            case(R.id.button8):
                historyCalc.append(getString(R.string._8));
                previewCalculation.setText(historyCalc.toString());
                break;
            case(R.id.button9):
                historyCalc.append(getString(R.string._9));
                previewCalculation.setText(historyCalc.toString());
                break;
            case(R.id.button0):
                historyCalc.append(getString(R.string._0));
                previewCalculation.setText(historyCalc.toString());
                break;
        }
    }

    private void initCalculatorOperandListener(View v) {
        switch (v.getId()){
            case(R.id.button_backspace):
                if (isFirstInput()) break;
                historyCalc.deleteCharAt(historyCalc.length()-1);
                previewCalculation.setText(historyCalc.toString());

                break;
            case(R.id.button_minus):
                if (isFirstInput()) break;
                if (replaceLastIfOperator()){
                    historyCalc.append(getString(R.string.minus)).append("\n");
                } else {
                    historyCalc.append("\n").append(getString(R.string.minus)).append("\n");
                }
                previewCalculation.setText(historyCalc.toString());
                break;
            case(R.id.button_multiply):
                if (isFirstInput()) break;
                if (replaceLastIfOperator()){
                    historyCalc.append(getString(R.string.multiply_extended)).append("\n");
                } else {
                    historyCalc.append("\n").append(getString(R.string.multiply_extended)).append("\n");
                }
                previewCalculation.setText(historyCalc.toString());
                break;
            case(R.id.button_point):
                if (isFirstInput()) break;
                historyCalc.append(getString(R.string.point)).append("\n");
                previewCalculation.setText(historyCalc.toString());
                break;
            case(R.id.button_plus):
                if (isFirstInput()) break;
                if (replaceLastIfOperator()){
                    historyCalc.append(getString(R.string.plus)).append("\n");
                } else {
                    historyCalc.append("\n").append(getString(R.string.plus)).append("\n");
                }
                previewCalculation.setText(historyCalc.toString());
                break;
            case(R.id.button_divider):
                if (isFirstInput()) break;
                if (replaceLastIfOperator()){
                    historyCalc.append(getString(R.string._div)).append("\n");
                } else {
                    historyCalc.append("\n").append(getString(R.string._div)).append("\n");
                }
                previewCalculation.setText(historyCalc.toString());
                break;
            case(R.id.button_percent):
                if (isFirstInput()) break;
                if (replaceLastIfOperator()){
                    historyCalc.append(getString(R.string.percent)).append("\n");
                } else {
                    historyCalc.append("\n").append(getString(R.string.percent)).append("\n");
                }
                previewCalculation.setText(historyCalc.toString());
                break;
            case(R.id.button_clear):
                if (isFirstInput()) break;
                historyCalc.delete(0, historyCalc.length());
                previewCalculation.setText(historyCalc.toString());
                break;
            case (R.id.btnSettings):
                openSettingsActivity();
        }
    }

    private void openSettingsActivity() {
        Intent intent = new Intent(this, SettingsActivity.class);
        startActivity(intent);
    }

    private boolean isFirstInput(){
        return previewCalculation.length() < 1 || historyCalc.length() < 1;
    }

    private boolean replaceLastIfOperator() {
        boolean isNeedReplace = isLastOperand();
        if (isNeedReplace){
            historyCalc.delete(historyCalc.length()-3, historyCalc.length()-1);
            previewCalculation.setText(historyCalc);
        }
         return isNeedReplace;
    }

    private boolean isLastOperand(){
        int lastSymbol = historyCalc.length()-2;
        if (lastSymbol < 0) return false;
        return String.valueOf(historyCalc.charAt(lastSymbol)).equals(getString(R.string._div)) ||
                String.valueOf(historyCalc.charAt(lastSymbol)).equals(getString(R.string.minus)) ||
                String.valueOf(historyCalc.charAt(lastSymbol)).equals(getString(R.string.plus)) ||
                String.valueOf(historyCalc.charAt(lastSymbol)).equals(getString(R.string.percent)) ||
                String.valueOf(historyCalc.charAt(lastSymbol)).equals(getString(R.string.multiply_extended));
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
    }
}
