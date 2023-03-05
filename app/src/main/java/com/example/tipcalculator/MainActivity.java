package com.example.tipcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText costEditText;
    private RadioGroup radioGroup;
    private Switch roundUpTipSwitch;
    private Button calcTipButton;
    private TextView tipAmountText;
    private double tipPercent ;
    private boolean isRoundTip;

    private double tipAmount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        costEditText = findViewById(R.id.editText);
        radioGroup = findViewById(R.id.radioGroup);
        roundUpTipSwitch = findViewById(R.id.roundUpTip);
        calcTipButton = findViewById(R.id.calcButton);
        tipAmountText = findViewById(R.id.tipAmount);


        calcTipButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String costString = costEditText.getText().toString();
                int cost = Integer.parseInt(costString);
                int checkRadioId = radioGroup.getCheckedRadioButtonId();
                if (checkRadioId == R.id.amazing) {
                    tipPercent = 0.2;
                } else if (checkRadioId == R.id.good) {
                    tipPercent = 0.18;
                } else if (checkRadioId == R.id.okay) {
                    tipPercent = 0.15;
                }

                isRoundTip = roundUpTipSwitch.isChecked();
                tipAmount = cost * tipPercent;
                if(isRoundTip){
                    tipAmount = Math.round(tipAmount);
                }

                tipAmountText.setText(""+tipAmount);

            }
        });
    }
}