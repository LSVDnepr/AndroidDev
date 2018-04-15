package com.androidstudy.lsvhome.mycalcv2_0;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MyListener implements View.OnClickListener {
    private TextView textView;
    //private String value;
    private String memory = "";


    public MyListener(TextView textView, String value) {
        this.textView = textView;
        //this.value = value;

    }

    public MyListener(TextView textView) {
        this.textView = textView;
        //this.value = value;

    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {
          /*  case R.id.buttonC:
                textView.setText("0");
                break;
            case R.id.buttonDel:
                CharSequence cs = textView.getText();
                textView.setText(cs.subSequence(0, cs.length() - 1));
                break;*/
            case R.id.buttonMC://не работает
                memory = "";
                break;
            case R.id.buttonMS: //не работает
                memory = textView.toString();
                break;
            case R.id.buttonMR: //не работает
                textView.setText(memory);
                break;
            case R.id.buttonEquals:
                calcResult();
                break;

        }

        /*if (v.getId() == R.id.buttonC) {
            textView.setText("0");
            return;
        }

        if (v.getId() == R.id.buttonDel) {
            CharSequence cs = textView.getText();
            textView.setText(cs.subSequence(0, cs.length() - 1));
            return;
        }

        if (v.getId() == R.id.buttonMC) {
            memory = "";
            return;
        }*/
       /* if (v.getId() == R.id.buttonMS) {
            memory = textView.toString();
            return;
        }
        if (v.getId() == R.id.buttonMR) {
            textView.setText(memory);
            return;
        }*/

       /* CharSequence cs=((Button)v).getText();//новое
        textView.append(cs);//новое*/


        /*if (v.getId() == R.id.buttonEquals) {
            calcResult();
            return;
        }*/

        textView.append(((Button) v).getText());

    }


    public void calcResult() {
        String result = textView.getText().toString();

        if (result.indexOf(',') == -1) {// расчеты для интов
            int iRes = 0;


            result = String.valueOf(iRes);

        } else {
            //расчеты для double
            double dRes = 0.0;
            result = String.valueOf(dRes);
        }


        textView.setText(result);

    }

}
