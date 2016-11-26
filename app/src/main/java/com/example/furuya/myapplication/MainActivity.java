package com.example.furuya.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import static java.lang.Integer.parseInt;

public class MainActivity extends AppCompatActivity {
  public EditText calcAeditText;
  public EditText calcBeditText;
  public TextView calcResultView;
  public Spinner operatorsSpinner;
  public Button calcButton;

  @Override
  protected  void onStart() {
    super.onStart();
  }
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    initElements();
  }

  private void initElements() {
    calcAeditText = (EditText) findViewById(R.id.calc_a_edittext);
    calcBeditText = (EditText) findViewById(R.id.calc_b_edittext);
    operatorsSpinner = (Spinner) findViewById(R.id.operators_spinner);
    calcResultView = (TextView) findViewById(R.id.calc_result_view);
    calcButton = (Button) findViewById(R.id.calc_button);
  }

  private Integer calcInputNumbers() {
    Integer result = 0;
    Integer a = parseInt(calcAeditText.getText().toString());
    Integer b = parseInt(calcBeditText.getText().toString());
    String operator = operatorsSpinner.getSelectedItem().toString();

    switch(operator) {
      case "+":
        result = a + b;
        break;
      case "-":
        result = a - b;
        break;
      case "*":
        result = a * b;
        break;
      case "/":
        result = a / b;
        break;
    }
    return result;
  }

  public void updateCalcResult(View v) {
    Integer a = parseInt(calcAeditText.getText().toString());
    Integer b = parseInt(calcBeditText.getText().toString());
    String operator = operatorsSpinner.getSelectedItem().toString();
    Integer calcResult = calcInputNumbers();
    String resultText = a + " " + operator + " " + b + " = " + calcResult;

    calcResultView.setText(resultText);
  }
}
