package com.androidstudy.lsvhome.mycalcv2_0;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class OperatorPressedListener implements View.OnClickListener {//обрабатывает нажатие + - * / . ( )

    private TextView textView;

    public OperatorPressedListener(TextView textView){
        this.textView=textView;
    }


    @Override
    public void onClick(View v) {

      Character[] replace=new Character[]{'.','+','-','*','/'};
      CharSequence calcAreaText=textView.getText().toString();
      int lastInd=calcAreaText.length()-1;
      /*if (calcAreaText.equals("0")){

          return;
      }*/

      for (Character ch:replace){
          if (ch.equals(calcAreaText.charAt(lastInd))){
              return;
          }
      }

      textView.append(((Button)v).getText());

    }

}
