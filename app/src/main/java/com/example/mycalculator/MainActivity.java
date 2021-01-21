package com.example.mycalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private TextView txtCalculations, txtEnter;

    private enum OPERATOR {
        PLUS, SUBSTRACT, MULTIPLY, DIVIDE, EQUAL
    }

    String currentNumber, stringNumberAtLeft, getStringNumberAtRight;
    private OPERATOR currentOperator;
    private int calculationsResult;

    private String calculationsString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        currentNumber = "";
        calculationsResult = 0;
        calculationsString = "";

        findViewById(R.id.btnC).setOnClickListener(MainActivity.this);
        findViewById(R.id.ibtnSeven).setOnClickListener(MainActivity.this);
        findViewById(R.id.ibtnEight).setOnClickListener(MainActivity.this);
        findViewById(R.id.ibtnNine).setOnClickListener(MainActivity.this);
        findViewById(R.id.ibtnDivide).setOnClickListener(MainActivity.this);
        findViewById(R.id.ibtnFour).setOnClickListener(MainActivity.this);
        findViewById(R.id.ibtnFive).setOnClickListener(MainActivity.this);
        findViewById(R.id.ibtnSix).setOnClickListener(MainActivity.this);
        findViewById(R.id.ibtnMultiply).setOnClickListener(MainActivity.this);
        findViewById(R.id.ibtnOne).setOnClickListener(MainActivity.this);
        findViewById(R.id.ibtnTwo).setOnClickListener(MainActivity.this);
        findViewById(R.id.ibtnThree).setOnClickListener(MainActivity.this);
        findViewById(R.id.ibtnMinus).setOnClickListener(MainActivity.this);
        findViewById(R.id.ibtnZero).setOnClickListener(MainActivity.this);
        findViewById(R.id.ibtnPlus).setOnClickListener(MainActivity.this);
        findViewById(R.id.imgEqual).setOnClickListener(MainActivity.this);


        txtCalculations = findViewById(R.id.txtCalculations);
        txtEnter = findViewById(R.id.txtEnter);

    }

    private void numberIsTapped(int tappedNumber) {
        currentNumber += String.valueOf(tappedNumber);
        txtEnter.setText(currentNumber);
        calculationsString = currentNumber;
        txtCalculations.setText(calculationsString);
    }

    private void operatorIsTapped(OPERATOR operator) {
        if (currentOperator != null) {
            if (currentNumber != "") {
                getStringNumberAtRight = currentNumber;
                currentNumber = "";
                switch (currentOperator) {
                    case PLUS:
                        calculationsResult = Integer.parseInt(stringNumberAtLeft) + Integer.parseInt(getStringNumberAtRight);
                        break;
                    case MULTIPLY:
                        calculationsResult = Integer.parseInt(stringNumberAtLeft) * Integer.parseInt(getStringNumberAtRight);
                        break;
                    case SUBSTRACT:
                        calculationsResult = Integer.parseInt(stringNumberAtLeft) - Integer.parseInt(getStringNumberAtRight);
                        break;
                    case DIVIDE:
                        if (Integer.parseInt(stringNumberAtLeft) != 0) {
                            calculationsResult = Integer.parseInt(stringNumberAtLeft) / Integer.parseInt(getStringNumberAtRight);
                        }
                        break;
                }

                stringNumberAtLeft = String.valueOf(calculationsResult);
                txtCalculations.setText(stringNumberAtLeft);
                calculationsString = stringNumberAtLeft;
            }
        } else {
            stringNumberAtLeft = currentNumber;
            currentNumber = "";
        }
        currentOperator = operator;
    }

    private void clearTapped() {
        currentNumber = "";
        calculationsResult = 0;
        calculationsString = "";
        stringNumberAtLeft = "";
        getStringNumberAtRight = "";
        currentOperator = null;
        txtCalculations.setText("0");
        txtEnter.setText("0");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnC:
                clearTapped();
                break;
            case R.id.ibtnSeven:
                numberIsTapped(7);
                break;
            case R.id.ibtnEight:
                numberIsTapped(8);
                break;
            case R.id.ibtnNine:
                numberIsTapped(9);
                break;
            case R.id.ibtnDivide:
                operatorIsTapped(OPERATOR.DIVIDE);
                calculationsString += " / ";
                break;
            case R.id.ibtnFour:
                numberIsTapped(4);
                break;
            case R.id.ibtnFive:
                numberIsTapped(5);
                break;
            case R.id.ibtnSix:
                numberIsTapped(6);
                break;
            case R.id.ibtnMultiply:
                operatorIsTapped(OPERATOR.MULTIPLY);
                calculationsString += " * ";
                break;
            case R.id.ibtnOne:
                numberIsTapped(1);
                break;
            case R.id.ibtnTwo:
                numberIsTapped(2);
                break;
            case R.id.ibtnThree:
                numberIsTapped(3);
                break;
            case R.id.ibtnMinus:
                operatorIsTapped(OPERATOR.SUBSTRACT);
                calculationsString += " - ";
                break;
            case R.id.ibtnZero:
                numberIsTapped(0);
                break;
            case R.id.ibtnPlus:
                operatorIsTapped(OPERATOR.PLUS);
                calculationsString += " + ";
                break;
            case R.id.imgEqual:
                operatorIsTapped(OPERATOR.EQUAL);
                break;
        }
        txtCalculations.setText(calculationsString);
    }
}