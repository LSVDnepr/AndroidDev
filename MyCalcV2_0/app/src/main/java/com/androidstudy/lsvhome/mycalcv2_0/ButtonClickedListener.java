package com.androidstudy.lsvhome.mycalcv2_0;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class ButtonClickedListener implements View.OnClickListener {
    private TextView textView;
    private String memory = "";
    private AppCompatActivity activity;


    public ButtonClickedListener(TextView textView, AppCompatActivity activity) {
        this.textView = textView;
        this.activity = activity;
    }


    @Override
    public void onClick(View v) {
        Button btn = (Button) v;
        switch (v.getId()) {
            case R.id.buttonMC:
                memory = "";
                break;
            case R.id.buttonMS:
                memory = textView.getText().toString();
                break;
            case R.id.buttonMR:
                textView.setText(memory);
                break;
            case R.id.buttonC:
                textView.setText("0");
                break;
            case R.id.buttonDel:
                CharSequence cs = textView.getText();
                if (cs.length() == 1) {
                    textView.setText("0");
                    return;
                }
                textView.setText(cs.subSequence(0, cs.length() - 1));
                break;
            case R.id.buttonPlus:
            case R.id.buttonMinus:
            case R.id.buttonMultiply:
            case R.id.buttonDivide:
            case R.id.buttonDot:
                operatorClicked(btn.getText().toString());
                break;
            case R.id.buttonPth1://прописать логику
                break;
            case R.id.buttonPth2://прописать логику
                break;
            case R.id.buttonEquals:
                textView.setText(calcResult(textView.getText().toString()));

                //new
                Intent intent = new Intent(activity, SecondActivity.class);
                intent.putExtra("calcResults", textView.getText().toString());
                activity.startActivityForResult(intent, 0);
                break;
            default:
                if (textView.getText().toString().equals("0")) {
                    textView.setText(((Button) v).getText());
                    return;
                }
                textView.append(((Button) v).getText());
        }

    }


    public void operatorClicked(String btnText) {
        Character[] replace = new Character[]{'.', '+', '-', '*', '/'};
        CharSequence calcAreaText = textView.getText();
        int lastInd = calcAreaText.length() - 1;

        for (Character ch : replace) {
            if (ch.equals(calcAreaText.charAt(lastInd))) {
                return;
            }
        }

        textView.append(btnText);
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


}
