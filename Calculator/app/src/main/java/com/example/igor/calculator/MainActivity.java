package com.example.igor.calculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    final String LOG_TAG = "myLogs";

    TextView screen;
    Double total;

    Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9,
            btnAdd, btnSub, btnMult, btnDiv, btnTotal, btnC, btnDot, btnPlusMinus, btnPowTo2, btnSqRoot;

    double numberOne, numberTwo;

    boolean addition, subtract, multiplication, division, powTo2, sqRoot, plusMinus = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn0 = (Button) findViewById(R.id.btn_0);
        btn1 = (Button) findViewById(R.id.btn_1);
        btn2 = (Button) findViewById(R.id.btn_2);
        btn3 = (Button) findViewById(R.id.btn_3);
        btn4 = (Button) findViewById(R.id.btn_4);
        btn5 = (Button) findViewById(R.id.btn_5);
        btn6 = (Button) findViewById(R.id.btn_6);
        btn7 = (Button) findViewById(R.id.btn_7);
        btn8 = (Button) findViewById(R.id.btn_8);
        btn9 = (Button) findViewById(R.id.btn_9);

        btnAdd = (Button) findViewById(R.id.btn_add);
        btnSub = (Button) findViewById(R.id.btn_sub);
        btnMult = (Button) findViewById(R.id.btn_mult);
        btnDiv = (Button) findViewById(R.id.btn_div);

        btnDot = (Button) findViewById(R.id.btn_dot);

        btnTotal = (Button) findViewById(R.id.btn_total);
        btnC = (Button) findViewById(R.id.btn_clear);

        btnPlusMinus = (Button) findViewById(R.id.btn_plus_minus);

        btnPowTo2 = (Button) findViewById(R.id.btn_pow_to_2);
        btnSqRoot = (Button) findViewById(R.id.square_root);

        screen = (TextView) findViewById(R.id.tv_screen);


//   Кнопки 0-9 на setOnClickListener
        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                screen.setText("");
                screen.setText(screen.getText() + "0");
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                screen.setText("");
                screen.setText(screen.getText() + "1");
            }

        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                screen.setText("");
                screen.setText(screen.getText() + "2");
            }

        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                screen.setText("");
                screen.setText(screen.getText() + "3");
            }

        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                screen.setText("");
                screen.setText(screen.getText() + "4");
            }

        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                screen.setText("");
                screen.setText(screen.getText() + "5");
            }

        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                screen.setText("");
                screen.setText(screen.getText() + "6");
            }

        });

        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                screen.setText("");
                screen.setText(screen.getText() + "7");
            }

        });

        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                screen.setText("");
                screen.setText(screen.getText() + "8");
            }

        });

        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                screen.setText("");
                screen.setText(screen.getText() + "9");
            }

        });

//      Кнопки дій(+-*/) на setOnClickListener
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberOne = Double.parseDouble(screen.getText() + "");
                addition = true;
                screen.setText("+");
            }
        });

        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberOne = Double.parseDouble(screen.getText() + "");
                subtract = true;
                screen.setText("-");
            }
        });

        btnMult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberOne = Double.parseDouble(screen.getText() + "");
                multiplication = true;
                screen.setText("*");
            }
        });

        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberOne = Double.parseDouble(screen.getText() + "");

////      при натисканні на +/- змінюєм 1-ге число на протилежне по знаку
//                if(plusMinus == true &&  numberOne > 0 ){
//                    numberOne = Double.parseDouble("-" +  numberOne);
//                }
//                else{
//                numberOne = Double.parseDouble(screen.getText() + "");
//                }
//                plusMinus = false;
                division = true;
                screen.setText("/");
            }
        });


        btnPlusMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                plusMinus = true;

            }
        });

        btnPowTo2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberOne = Double.parseDouble(screen.getText() + "");
                powTo2 = true;
                //screen.setText("^2"); - призводить до закривання проги
            }
        });

        btnSqRoot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberOne = Double.parseDouble(screen.getText() + "");
                sqRoot = true;
                //screen.setText("√"); - призводить до закривання проги
            }
        });
        //      Кнопка дорівнює на setOnClickListener
        btnTotal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberTwo = Double.parseDouble(screen.getText() + "");

////               при натисканні на +/- змінюєм 2-ге число на протилежне по знаку
//                if(plusMinus == true &&  numberOne > 0 ){
//                    numberTwo = Double.parseDouble("-" +  numberTwo);
//                }
//                else{
//                    numberTwo = Double.parseDouble(screen.getText() + "");
//                }
//                plusMinus = false;


///////////////
//                if(plusMinus == true && numberOne < 0 && numberTwo < 0){
//                    numberOne =  numberOne * - 1;
//                    numberTwo =  numberTwo * - 1;
//                }


                if (addition == true) {
                    screen.setText((total = numberOne + numberTwo) + "");
                    addition = false;
                }

                if (subtract == true) {
                    screen.setText((total = numberOne - numberTwo) + "");
                    subtract = false;
                }

                if (multiplication == true) {
                    screen.setText((total = numberOne * numberTwo) + "");
                    multiplication = false;
                }

                if (division == true) {
                    screen.setText((total = numberOne / numberTwo) + "");
                    division = false;
                }
                // до  квадрату
                if (powTo2 == true) { screen.setText("");
                    screen.setText((total = numberOne * numberOne) + "");
                    powTo2 = false;
                }
                // корінь квадр.
                if (sqRoot == true) {
                    screen.setText((total = Math.pow(numberOne, 0.5)) + "");
                    sqRoot = false;
                }
            }
        });

//        // незалежний від btnTotal варіант квадрату і коріня квадр.(чомусь не працює)
//        btnPowTo2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (powTo2 == true) {
//                    //screen.setText("");
//                    screen.setText((total = numberOne * numberOne) + "");
//                    powTo2 = false;
//                }
//            }
//        });
//
//        btnSqRoot.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (sqRoot == true) {
//                    screen.setText((total = Math.pow(numberOne, 0.5)) + "");
//                    sqRoot = false;
//                }
//            }
//        });

        btnC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                screen.setText("");
            }
        });

        btnDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                screen.setText(screen.getText() + ".");
            }
        });


    }

    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        total = savedInstanceState.getDouble("sreen_s");
        screen.setText(total + "");
        Log.d(LOG_TAG, "onRestoreInstanceState");
    }

    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putDouble("sreen_s", total);

        Log.d(LOG_TAG, "onSaveInstanceState");
    }

}

