package com.androidstudy.lsvhome.mycalcv2_0;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class NumPressedListener implements View.OnClickListener {
    private TextView textView;


    public NumPressedListener(TextView textView){//обрабатывает нажатие [1-0]
        this.textView=textView;
    }

    @Override
    public void onClick(View v) {
        /*String[] replace=new String[]{"0",".","+","-","*","/",")"};//если единственное (первое) значение в калькуляторе на данный момент это эти символы
        //добавить обработку скобок (например, нельзя записывать число, если последний знак в строке это ")" - должен быть операторр или другая закрывающая скобка)
*/

        if (textView.getText().toString().equals("0")){
            textView.setText(((Button)v).getText());
            return;
        }

        textView.append(((Button)v).getText());

    }
}
