package com.androidstudy.lsvhome.mycalcv2_0;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    private TextView calcStr;

    public void setButtonListeners(View v, View.OnClickListener listener){
        if (v instanceof Button){
            v.setOnClickListener(listener);
            return;
        }
        if (!(v instanceof ViewGroup)){
            return;
        }
        for (int i=0;i<((ViewGroup) v).getChildCount();i++){
            setButtonListeners(((ViewGroup) v).getChildAt(i),listener);
        }

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calcStr = (TextView) findViewById(R.id.calcArea);

        ButtonClickedListener btnListener=new ButtonClickedListener(calcStr,this);
        setButtonListeners(findViewById(R.id.buttonLayout),btnListener);

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





