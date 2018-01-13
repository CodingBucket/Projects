package com.example.hasanpc.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    EditText first_input, second_input;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        first_input = (EditText)findViewById(R.id.firstInput);
        second_input = (EditText)findViewById(R.id.secondInput);
        result = (TextView)findViewById(R.id.result);
    }

    public void functionCalculator(View view){
        int number1, number2, total;

        number1 = Integer.parseInt(first_input.getText().toString());
        number2 = Integer.parseInt(second_input.getText().toString());

        if(view.getId() == R.id.plusButton){
            total = number1 + number2;
        } else if (view.getId() == R.id.minusButton){
            total = number1 - number2;
        } else if (view.getId() == R.id.multiplicationButton){
            total = number1 * number2;
        } else if (view.getId() == R.id.divideButton){
            total = number1 / number2;
        } else {
            total = 0;
        }

        result.setText(Integer.toString(total));
    }
}
