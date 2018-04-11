package com.androidstudy.lsvhome.mycalcv2_0;

import android.graphics.drawable.ClipDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        TextView calcStr=(TextView)findViewById(R.id.calcArea);

        Button b1=(Button)findViewById(R.id.button1);
        b1.setOnClickListener(new MyListener(calcStr,"1"));

        Button b2=(Button)findViewById(R.id.button2);
        b2.setOnClickListener(new MyListener(calcStr,"2"));

        Button b3=(Button)findViewById(R.id.button3);
        b3.setOnClickListener(new MyListener(calcStr,"3"));

        Button b4=(Button)findViewById(R.id.button4);
        b4.setOnClickListener(new MyListener(calcStr,"4"));

        Button b5=(Button)findViewById(R.id.button5);
        b5.setOnClickListener(new MyListener(calcStr,"5"));

        Button b6=(Button)findViewById(R.id.button6);
        b6.setOnClickListener(new MyListener(calcStr,"6"));

        Button b7=(Button)findViewById(R.id.button7);
        b7.setOnClickListener(new MyListener(calcStr,"7"));

        Button b8=(Button)findViewById(R.id.button8);
        b8.setOnClickListener(new MyListener(calcStr,"8"));

        Button b9=(Button)findViewById(R.id.button9);
        b9.setOnClickListener(new MyListener(calcStr,"9"));

        Button b0=(Button)findViewById(R.id.button0);
        b0.setOnClickListener(new MyListener(calcStr,"0"));

        Button bdel=(Button)findViewById(R.id.buttonDel);
        bdel.setOnClickListener(new MyListener(calcStr,"\b"));

        Button bClear=(Button)findViewById(R.id.buttonC);
        ClipDrawable drawable=(ClipDrawable)bClear.getBackground();
        drawable.setLevel(5000);

        bClear.setOnClickListener(new MyListener(calcStr,"c"));


        Button bPlus=(Button)findViewById(R.id.buttonPlus);
        bPlus.setOnClickListener(new MyListener(calcStr,"+"));

        Button bMinus=(Button)findViewById(R.id.buttonMinus);
        bMinus.setOnClickListener(new MyListener(calcStr,"-"));
        Button bMultiply=(Button)findViewById(R.id.buttonMultiply);
        bMultiply.setOnClickListener(new MyListener(calcStr,"*"));

        Button bDivide=(Button)findViewById(R.id.buttonDivide);
        bDivide.setOnClickListener(new MyListener(calcStr,"/"));

        Button bPth1=(Button)findViewById(R.id.buttonPth1);
        bPth1.setOnClickListener(new MyListener(calcStr,"("));
        Button bPth2=(Button)findViewById(R.id.buttonPth2);
        bPth2.setOnClickListener(new MyListener(calcStr,")"));
        Button bComma=(Button)findViewById(R.id.buttonComma);
        bComma.setOnClickListener(new MyListener(calcStr,","));





    }
}
