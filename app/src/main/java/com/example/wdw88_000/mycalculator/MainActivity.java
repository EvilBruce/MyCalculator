package com.example.wdw88_000.mycalculator;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity implements View.OnClickListener{
    Button one, two, three, four, five, six, seven, eight, nine, zero, add, sub, mul, div, cancel, equal, cancel_all, dot;
    TextView disp;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        one = (Button) findViewById(R.id.one);
        two = (Button) findViewById(R.id.two);
        three = (Button) findViewById(R.id.three);
        four = (Button) findViewById(R.id.four);
        five = (Button) findViewById(R.id.five);
        six = (Button) findViewById(R.id.six);
        seven = (Button) findViewById(R.id.seven);
        eight = (Button) findViewById(R.id.eight);
        nine = (Button) findViewById(R.id.nine);
        zero = (Button) findViewById(R.id.zero);
        add = (Button) findViewById(R.id.add);
        sub = (Button) findViewById(R.id.sub);
        mul = (Button) findViewById(R.id.mul);
        div = (Button) findViewById(R.id.div);
        cancel = (Button) findViewById(R.id.cancel);
        cancel_all = (Button) findViewById(R.id.cancel_all);
        equal = (Button) findViewById(R.id.equal);
        dot = (Button) findViewById(R.id.dot);
        disp = (TextView) findViewById(R.id.display);

        one.setOnClickListener(this);
        two.setOnClickListener(this);
        three.setOnClickListener(this);
        four.setOnClickListener(this);
        five.setOnClickListener(this);
        six.setOnClickListener(this);
        seven.setOnClickListener(this);
        eight.setOnClickListener(this);
        nine.setOnClickListener(this);
        zero.setOnClickListener(this);
        cancel.setOnClickListener(this);
        add.setOnClickListener(this);
        sub.setOnClickListener(this);
        mul.setOnClickListener(this);
        div.setOnClickListener(this);
        equal.setOnClickListener(this);
        dot.setOnClickListener(this);
        cancel_all.setOnClickListener(this);
    }
    int clear_flag = 0;
    String sign_flag ="";
    Double total =0.0;
    int last_button =0;

    public void shownum(String num){
        if(clear_flag == 1){
            disp.setText("");
            clear_flag=0;
        }
        else if(disp.getText()=="0"){
            disp.setText("");
        }
        disp.setText(disp.getText()+num);
    }
    public void showsign(String sign){
        if(last_button == R.id.add || last_button == R.id.sub || last_button == R.id.mul ||last_button == R.id.div){}
        else {
            clear_flag = 1;
            Double newNumber = Double.parseDouble(disp.getText().toString());
            if(sign_flag == ""||sign_flag == "="){
                total = newNumber;
                disp.setText(total.toString());
            }
            else if(sign_flag == "+"){
                total = total + newNumber;
                disp.setText(total.toString());
            }
            else if(sign_flag == "-"){
                total = total - newNumber;
                disp.setText(total.toString());
            }
            else if(sign_flag == "*"){
                total = total* newNumber;
                disp.setText(total.toString());
            }
            else if(sign_flag == "/"){
                total = total/ newNumber;
                disp.setText(total.toString());
            }
        }
        sign_flag = sign;
    }
    public void onClick(View v){
        if(v.getId()== R.id.zero){
            shownum("0");
        }
        else if(v.getId()== R.id.one){
            shownum("1");
        }
        else if(v.getId()== R.id.two){
            shownum("2");
        }
        else if(v.getId()== R.id.three){
            shownum("3");
        }
        else if(v.getId()== R.id.four){
            shownum("4");
        }
        else if(v.getId()== R.id.five){
            shownum("5");
        }
        else if(v.getId()== R.id.six){
            shownum("6");
        }
        else if(v.getId()== R.id.seven){
            shownum("7");
        }
        else if(v.getId()== R.id.eight){
            shownum("8");
        }
        else if(v.getId()== R.id.nine){
            shownum("9");
        }
        else if(v.getId()== R.id.dot){
            if(clear_flag == 1){
                disp.setText("");
                clear_flag = 0;
            }
            if(disp.getText().toString().indexOf(".")<0){
                disp.setText(disp.getText()+".");
            }
        }
        else if(v.getId()== R.id.cancel_all){
           disp.setText("0");
            total =0.0;
            sign_flag = "";
        }
        else if(v.getId()== R.id.cancel){
            if(disp.getText().toString().length()>0){
                int start =0;
                int end = disp.getText().toString().length()-1;
                String newText = disp.getText().toString().substring(start, end);
                disp.setText(newText);
            }
        }
        else if(v.getId()== R.id.add){
            showsign("+");
        }
        else if(v.getId()== R.id.sub){
            showsign("-");
        }
        else if(v.getId()== R.id.mul){
            showsign("*");
        }
        else if(v.getId()== R.id.div){
            showsign("/");
        }
        else if(v.getId()== R.id.equal){
            Double newNumber = Double.parseDouble(disp.getText().toString());
           if(sign_flag == "+"){
                total = total + newNumber;
                disp.setText(total.toString());
            }
            else if(sign_flag == "-"){
                total = total - newNumber;
                disp.setText(total.toString());
            }
            else if(sign_flag == "*"){
                total = total* newNumber;
                disp.setText(total.toString());
            }
            else if(sign_flag == "/"){
                total = total/ newNumber;
                disp.setText(total.toString());
            }
            sign_flag = "=";
        }
        last_button = v.getId();
    }
}
