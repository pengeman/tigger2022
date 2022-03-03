package org.peng.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import org.peng.tiger2022.R;

public class Activity_cal extends AppCompatActivity {
    private Button[] btnCommand = new Button[5];// 符号按钮
    private Button[] btnNum = new Button[11]; // 数字按钮
    private EditText editText = null;// 显示区域
    private Button btnClear = null; // clear按钮

    private static String lastCommand; // 用于保存运算符
    private boolean clearFlag; // 用于判断是否清空显示区域的值,true需要,false不需要
    private boolean firstFlag; // 用于判断是否是首次输入,true首次,false不是首次
    private double result; // 计算结果

    public Activity_cal() {
        // 初始化各项值
        result = 0; // x的值
        firstFlag = true; // 是首次运算
        clearFlag = false; // 不需要清空
        lastCommand = "="; // 运算符
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cal);

        // 获取运算符
        btnCommand[0] = (Button) findViewById(R.id.add);
        btnCommand[1] = (Button) findViewById(R.id.subtract);
        btnCommand[2] = (Button) findViewById(R.id.multiply);
        btnCommand[3] = (Button) findViewById(R.id.divide);
        btnCommand[4] = (Button) findViewById(R.id.equal);
        // 获取数字
        btnNum[0] = (Button) findViewById(R.id.num0);
        btnNum[1] = (Button) findViewById(R.id.num1);
        btnNum[2] = (Button) findViewById(R.id.num2);
        btnNum[3] = (Button) findViewById(R.id.num3);
        btnNum[4] = (Button) findViewById(R.id.num4);
        btnNum[5] = (Button) findViewById(R.id.num5);
        btnNum[6] = (Button) findViewById(R.id.num6);
        btnNum[7] = (Button) findViewById(R.id.num7);
        btnNum[8] = (Button) findViewById(R.id.num8);
        btnNum[9] = (Button) findViewById(R.id.num9);
        btnNum[10] = (Button) findViewById(R.id.point);

        // 初始化显示结果区域
        editText = (EditText) findViewById(R.id.Result);
        editText.setText("0.0");

        // 实例化监听器对象
        NumberAction na = new NumberAction();
        CommandAction ca = new CommandAction();
        for (Button bc : btnCommand) {
            bc.setOnClickListener((View.OnClickListener) ca);
        }
        for (Button bc : btnNum) {
            bc.setOnClickListener((View.OnClickListener) na);
        }
        // clear按钮的动作
        btnClear = (Button) findViewById(R.id.clear);
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setText("0.0");
                // 初始化各项值
                result = 0; // x的值
                firstFlag = true; // 是首次运算
                clearFlag = false; // 不需要清空
                lastCommand = "="; // 运算符

            }
        });
    }

    //数字按钮监听器
    private class NumberAction implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            Button btn = (Button) view;
            String input = btn.getText().toString();


            if (firstFlag) { // 首次输入
                // 一上就".",就什么也不做
                if (input.equals(".")) {
                    return;
                }
                // 如果是"0.0"的话,就清空
                if (editText.getText().toString().equals("0.0")) {
                    editText.setText("");
                }
                firstFlag = false;// 改变是否首次输入的标记值
            } else {
                String editTextStr = editText.getText().toString();
                // 判断显示区域的值里面是否已经有".",如果有,输入的又是".",就什么都不做
                if (editTextStr.indexOf(".") != -1 && input.equals(".")) {
                    return;
                }
                // 判断显示区域的值里面只有"-",输入的又是".",就什么都不做
                if (editTextStr.equals("-") && input.equals(".")) {
                    return;
                }
                // 判断显示区域的值如果是"0",输入的不是".",就什么也不做
                if (editTextStr.equals("0") && !input.equals(".")) {
                    return;
                }
            }

            // 如果我点击了运算符以后,再输入数字的话,就要清空显示区域的值
            if (clearFlag) {
                editText.setText("");
                clearFlag = false;// 还原初始值,不需要清空
            }
            editText.setText(editText.getText().toString() + input);// 设置显示区域的值
        }
    }


    //符号按钮监听器
    private class CommandAction implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            Button btn = (Button) view;
            String inputCommand = (String) btn.getText();

            if (firstFlag) {// 首次输入"-"的情况
                if (inputCommand.equals("-")) {
                    editText.setText("-");// 显示区域的内容设置为"-"
                    firstFlag = false;// 改变首次输入的标记
                }
            } else {

                if (!clearFlag) {// 如果flag=false不需要清空显示区的值,就调用方法计算

                    calculate(Double.parseDouble(editText.getText().toString()));// 保存显示区域的值,并计算
                }
                // 保存你点击的运算符
                lastCommand = inputCommand;
                clearFlag = true;// 因为我这里已经输入过运算符,
            }
        }
    }

    // 计算用的方法
    public void calculate(double x) {

        // Object lastCommand = null;

        if (lastCommand.equals("+")) {
            result += x;
        } else if (lastCommand.equals("-")) {
            result -= x;
        } else if (lastCommand.equals("*")) {
            result *= x;
        } else if (lastCommand.equals("/")) {
            result /= x;
        } else if (lastCommand.equals("=")) {
            result = x;
        }
        editText.setText("" + result);

    }
}
