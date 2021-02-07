package com.uzlov.hw_gb_android;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class FirstActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView previewCalculation;
    private final StringBuilder operationsCalculator = new StringBuilder();

    @Override
    protected void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initUI();

    }

    private void initUI(){
        // клавиатура
        int[] id_buttons = new int[]{R.id.button1, R.id.button2, R.id.button3,
                R.id.button4, R.id.button5, R.id.button6, R.id.button7, R.id.button8,
                R.id.button9, R.id.button0, R.id.button_backspace, R.id.button_minus, R.id.button_divider,
                R.id.button_multiply, R.id.button_point, R.id.button_plus, R.id.button_percent,
                R.id.button_clear
        };

        for (int id : id_buttons) {
            findViewById(id).setOnClickListener(this);
        }

        // поле результатов
        previewCalculation = findViewById(R.id.tvPreviewcalculation);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case(R.id.button1):
                operationsCalculator.append(getString(R.string._1));
                previewCalculation.setText(operationsCalculator.toString());
                break;
            case(R.id.button2):
                operationsCalculator.append(getString(R.string._2));
                previewCalculation.setText(operationsCalculator.toString());
                break;
            case(R.id.button3):
                operationsCalculator.append(getString(R.string._3));
                previewCalculation.setText(operationsCalculator.toString());
                break;
            case(R.id.button4):
                operationsCalculator.append(getString(R.string._4));
                previewCalculation.setText(operationsCalculator.toString());
                break;
            case(R.id.button5):
                operationsCalculator.append(getString(R.string._5));
                previewCalculation.setText(operationsCalculator.toString());
                break;
            case(R.id.button6):
                operationsCalculator.append(getString(R.string._6));
                previewCalculation.setText(operationsCalculator.toString());
                break;
            case(R.id.button7):
                operationsCalculator.append(getString(R.string._7));
                previewCalculation.setText(operationsCalculator.toString());
                break;
            case(R.id.button8):
                operationsCalculator.append(getString(R.string._8));
                previewCalculation.setText(operationsCalculator.toString());
                break;
            case(R.id.button9):
                operationsCalculator.append(getString(R.string._9));
                previewCalculation.setText(operationsCalculator.toString());
                break;
            case(R.id.button0):
                operationsCalculator.append(getString(R.string._0));
                previewCalculation.setText(operationsCalculator.toString());
                break;
            case(R.id.button_backspace):
                if (operationsCalculator.length() > 0){
                    operationsCalculator.deleteCharAt(operationsCalculator.length()-1);
                    previewCalculation.setText(operationsCalculator.toString());
                }
                break;
            case(R.id.button_minus):
                operationsCalculator.append("\n").append(getString(R.string.minus)).append("\n");
                previewCalculation.setText(operationsCalculator.toString());
                break;
            case(R.id.button_multiply):
                operationsCalculator.append("\n").append(getString(R.string.multiply_extended)).append("\n");
                previewCalculation.setText(operationsCalculator.toString());
                break;
            case(R.id.button_point):
                operationsCalculator.append(getString(R.string.point)).append("\n");
                previewCalculation.setText(operationsCalculator.toString());
                break;
            case(R.id.button_plus):
                operationsCalculator.append("\n").append(getString(R.string.plus)).append("\n");
                previewCalculation.setText(operationsCalculator.toString());
                break;
            case(R.id.button_divider):
                operationsCalculator.append("\n").append(getString(R.string._div)).append("\n");
                previewCalculation.setText(operationsCalculator.toString());
                break;
            case(R.id.button_percent):
                operationsCalculator.append("\n").append(getString(R.string.percent)).append("\n");
                previewCalculation.setText(operationsCalculator.toString());
                break;
            case(R.id.button_clear):
                operationsCalculator.delete(0, operationsCalculator.length());
                previewCalculation.setText(operationsCalculator.toString());
                break;
        }
    }
}
