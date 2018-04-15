package com.androidstudy.lsvhome.mycalcv2_0;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class MainActivity extends AppCompatActivity {
    private TextView calcStr;//=(TextView)findViewById(R.id.calcArea);//есть ли риски такого присвоения в качестве переменной класса?
    public String memory = "";
    private MainActivity mainActivity=this;




    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       calcStr = (TextView) findViewById(R.id.calcArea);





        NumPressedListener numListener = new NumPressedListener(calcStr);
        OperatorPressedListener operatorPressed = new OperatorPressedListener(calcStr);

        Button b1 = (Button) findViewById(R.id.button1);
        b1.setOnClickListener(numListener);

        Button b2 = (Button) findViewById(R.id.button2);
        b2.setOnClickListener(numListener);

        Button b3 = (Button) findViewById(R.id.button3);
        b3.setOnClickListener(numListener);

        Button b4 = (Button) findViewById(R.id.button4);
        b4.setOnClickListener(numListener);

        Button b5 = (Button) findViewById(R.id.button5);
        b5.setOnClickListener(numListener);

        Button b6 = (Button) findViewById(R.id.button6);
        b6.setOnClickListener(numListener);

        Button b7 = (Button) findViewById(R.id.button7);
        b7.setOnClickListener(numListener);

        Button b8 = (Button) findViewById(R.id.button8);
        b8.setOnClickListener(numListener);

        Button b9 = (Button) findViewById(R.id.button9);
        b9.setOnClickListener(numListener);

        Button b0 = (Button) findViewById(R.id.button0);
        b0.setOnClickListener(numListener);

        Button bPlus = (Button) findViewById(R.id.buttonPlus);
        bPlus.setOnClickListener(operatorPressed);

        Button bMinus = (Button) findViewById(R.id.buttonMinus);
        bMinus.setOnClickListener(operatorPressed);

        Button bMultiply = (Button) findViewById(R.id.buttonMultiply);
        bMultiply.setOnClickListener(operatorPressed);

        Button bDivide = (Button) findViewById(R.id.buttonDivide);
        bDivide.setOnClickListener(operatorPressed);

       /* Button bPth1=(Button)findViewById(R.id.buttonPth1);
        bPth1.setOnClickListener(operatorPressed);

        Button bPth2=(Button)findViewById(R.id.buttonPth2);
        bPth2.setOnClickListener(operatorPressed);*/

        Button bDot = (Button) findViewById(R.id.buttonDot);
        bDot.setOnClickListener(operatorPressed);


        Button bDel = (Button) findViewById(R.id.buttonDel);
        bDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CharSequence cs = calcStr.getText();
                if (cs.length() == 1) {
                    calcStr.setText("0");
                    return;
                }
                calcStr.setText(cs.subSequence(0, cs.length() - 1));
            }
        });

        Button bClear = (Button) findViewById(R.id.buttonC);
        /*ClipDrawable drawable=(ClipDrawable)bClear.getBackground();
        drawable.setLevel(5000);*/
        bClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcStr.setText("0");
            }
        });

        Button bMC = (Button) findViewById(R.id.buttonMC);
        bMC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                memory = "";
            }
        });


        Button bMS = (Button) findViewById(R.id.buttonMS);
        bMS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                memory = calcStr.getText().toString();
            }
        });


        Button bMR = (Button) findViewById(R.id.buttonMR);
        bMR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcStr.setText(memory);
            }
        });

        Button bEquals = (Button) findViewById(R.id.buttonEquals);
        bEquals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcStr.setText(calcResult(calcStr.getText().toString()));

                //new
                Intent intent = new Intent(mainActivity,SecondActivity.class);
                intent.putExtra("calcResults", calcStr.getText().toString());
                startActivityForResult(intent, 0);

            }
        });

    }


    public String calcResult(String calcStr) {
        try {
            StringTokenizer sT = new StringTokenizer(calcStr, "+-*/", true);
            if (sT.countTokens() % 2 == 0) {
                return "error";
            }
            ArrayList<String> el = new ArrayList<>();
            while (sT.hasMoreTokens()) {
                el.add(sT.nextToken());
            }

            Double.parseDouble(el.get(0));
            Double.parseDouble(el.get(el.size() - 1));

            for (int i = 1; i < el.size() - 1; i++) {
                if (el.get(i).equals("*")) {
                    double res = Double.parseDouble(el.get(i - 1)) * Double.parseDouble(el.get(i + 1));
                    //el.set(i,String.valueOf(Double.parseDouble(el.get(i-1))*Double.parseDouble(el.get(i+1))));
                    el.set(i, String.valueOf(res));
                    el.remove(i - 1);
                    el.remove(i--);
                    continue;
                }

                if (el.get(i).equals("/")) {
                    double res = Double.parseDouble(el.get(i - 1)) / Double.parseDouble(el.get(i + 1));
                    //el.set(i,String.valueOf(Double.parseDouble(el.get(i-1))*Double.parseDouble(el.get(i+1))));
                    el.set(i, String.valueOf(res));
                    el.remove(i - 1);
                    el.remove(i--);
                }
            }

            for (int i = 1; i < el.size() - 1; i++) {
                if (el.get(i).equals("+")) {
                    double res = Double.parseDouble(el.get(i - 1)) + Double.parseDouble(el.get(i + 1));
                    //el.set(i,String.valueOf(Double.parseDouble(el.get(i-1))*Double.parseDouble(el.get(i+1))));
                    el.set(i, String.valueOf(res));
                    el.remove(i - 1);
                    el.remove(i--);
                    continue;
                }

                if (el.get(i).equals("-")) {
                    double res = Double.parseDouble(el.get(i - 1)) - Double.parseDouble(el.get(i + 1));
                    //el.set(i,String.valueOf(Double.parseDouble(el.get(i-1))*Double.parseDouble(el.get(i+1))));
                    el.set(i, String.valueOf(res));
                    el.remove(i - 1);
                    el.remove(i--);
                }

            }
            return el.get(0);
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (data == null) {
            return;
        }

        String calcResults = data.getStringExtra("calcResults");
        if (calcResults.length()==0){
            calcStr.setText("0");
            return;
        }
        calcStr.setText(calcResults);



    }

}





