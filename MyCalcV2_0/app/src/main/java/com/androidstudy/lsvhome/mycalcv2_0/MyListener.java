package com.androidstudy.lsvhome.mycalcv2_0;

import android.view.View;
import android.widget.TextView;

public class MyListener implements View.OnClickListener {
    private TextView textView;
    private String value;


    public MyListener(TextView textView, String value) {
        this.textView = textView;
        this.value = value;


    }


    @Override
    public void onClick(View v) {

        if (value.equals("C")) {
            textView.setText("");
            return;
        }
        if (value.equals("\b")) {
            textView.setText(textView.getText().subSequence(0, textView.getText().length() - 1));
            return;
        }
        if (value.equals("=")){
            calcResult();
            return;
        }
        textView.append(value);

    }

    public void calcResult(){
        String result=textView.getText().toString();

        if (result.indexOf(',')==-1){// расчеты для интов
            int iRes=0;


            result=String.valueOf(iRes);

        }else{
            //расчеты для double
            double dRes=0.0;
            result=String.valueOf(dRes);
        }


        textView.setText(result);


    }

}