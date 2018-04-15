package com.androidstudy.lsvhome.mycalcv2_0;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class ButtonClickedListener implements View.OnClickListener {
    private TextView textView;
    private String memory = "";
    private AppCompatActivity activity;


    public ButtonClickedListener(TextView textView, AppCompatActivity activity){
        this.textView=textView;
        this.activity=activity;
    }


    @Override
    public void onClick(View v) {



    }
}
