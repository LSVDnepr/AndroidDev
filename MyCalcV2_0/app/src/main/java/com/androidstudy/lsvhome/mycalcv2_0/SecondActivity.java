package com.androidstudy.lsvhome.mycalcv2_0;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SecondActivity extends AppCompatActivity {

    public EditText eT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();
        eT = (EditText) findViewById(R.id.editResult);

        eT.setText(intent.getStringExtra("calcResults"));


        Button btnBack = (Button) findViewById(R.id.buttonBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent resIntent = new Intent();
                resIntent.putExtra("calcResults", eT.getText().toString());
                setResult(RESULT_OK, resIntent);
                finish();
            }
        });


    }

    @Override
    public void onBackPressed() {
        Intent resIntent = new Intent();
       // resIntent.putExtra("calcResults", "backInPhonePressed");
        resIntent.putExtra("calcResults", eT.getText().toString());
        setResult(RESULT_CANCELED, resIntent);
        finish();
    }

}

