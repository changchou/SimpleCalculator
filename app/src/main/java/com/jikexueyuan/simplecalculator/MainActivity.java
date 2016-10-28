package com.jikexueyuan.simplecalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView textView;
    private Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btnAdd, btnSub, btnMul, btnDiv, btnEql, btnClear;

    int option = 0;
    int a = 0, b = 0, sum = 0;
    boolean run = true;
    boolean editable = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.textView);
        btn0 = (Button) findViewById(R.id.btn0);
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        btn4 = (Button) findViewById(R.id.btn4);
        btn5 = (Button) findViewById(R.id.btn5);
        btn6 = (Button) findViewById(R.id.btn6);
        btn7 = (Button) findViewById(R.id.btn7);
        btn8 = (Button) findViewById(R.id.btn8);
        btn9 = (Button) findViewById(R.id.btn9);
        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnSub = (Button) findViewById(R.id.btnSub);
        btnMul = (Button) findViewById(R.id.btnMul);
        btnDiv = (Button) findViewById(R.id.btnDiv);
        btnEql = (Button) findViewById(R.id.btnEql);
        btnClear = (Button) findViewById(R.id.btnClear);

        btn0.setOnClickListener(this);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);
        btnAdd.setOnClickListener(this);
        btnSub.setOnClickListener(this);
        btnMul.setOnClickListener(this);
        btnDiv.setOnClickListener(this);
        btnEql.setOnClickListener(this);
        btnClear.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Button btn = (Button) v;
        String str = textView.getText().toString();

        if (btn.getId() == R.id.btn0 || btn.getId() == R.id.btn1 || btn.getId() == R.id.btn2 || btn.getId() == R.id.btn3 || btn.getId() == R.id.btn4 || btn.getId() == R.id.btn5 || btn.getId() == R.id.btn6 || btn.getId() == R.id.btn7 || btn.getId() == R.id.btn8 || btn.getId() == R.id.btn9) {
            if (str.equals("0")) {
                str = (String) btn.getText();
                editable = true;
            } else {
                if (editable){
                    str += (String) btn.getText();
                }else {
                    str = (String) btn.getText();
                    editable = true;
                }
            }
            textView.setText(str);

        }

        if (btn.getId() == R.id.btnAdd || btn.getId() == R.id.btnSub || btn.getId() == R.id.btnMul || btn.getId() == R.id.btnDiv) {
            if (option == 0) {
                a = Integer.parseInt(str);
            } else {
                b = Integer.parseInt(str);
                switch (option) {
                    case 1:
                        sum = a + b;
                        break;
                    case 2:
                        sum = a - b;
                        break;
                    case 3:
                        sum = a * b;
                        break;
                    case 4:
                        if (b == 0) {
                            Toast.makeText(MainActivity.this, "0不能作除数,重新开始", Toast.LENGTH_SHORT).show();
                            textView.setText("0");
                            break;
                        }
                        sum = a / b;
                        break;
                    default:
                        break;
                }
                a = sum;
            }
            switch (btn.getId()) {
                case R.id.btnAdd:
                    option = 1;
                    break;
                case R.id.btnSub:
                    option = 2;
                    break;
                case R.id.btnMul:
                    option = 3;
                    break;
                case R.id.btnDiv:
                    option = 4;
                    break;
                default:
                    break;
            }
            textView.setText("0");
        }

        if (btn.getId() == R.id.btnEql) {
            b = Integer.parseInt(str);
            switch (option) {
                case 1:
                    sum = a + b;
                    break;
                case 2:
                    sum = a - b;
                    break;
                case 3:
                    sum = a * b;
                    break;
                case 4:
                    if (b == 0) {
                        Toast.makeText(MainActivity.this, "0不能作除数,重新开始", Toast.LENGTH_SHORT).show();
                        textView.setText("0");
                        run = false;
                        break;
                    }
                    sum = a / b;
                    break;
                default:
                    break;
            }
            if (run) {
                textView.setText("" + sum);
                a = Integer.parseInt(str);
                option = 0;
                editable = false;
            }else {
                textView.setText("0");
                a = 0;
                b = 0;
                sum = 0;
                option = 0;
                run = true;
                editable = true;
            }
        }

        if (btn.getId() == R.id.btnClear) {
            textView.setText("0");
            a = 0;
            b = 0;
            sum = 0;
            option = 0;
            run = true;
            editable = true;
        }
    }
}
