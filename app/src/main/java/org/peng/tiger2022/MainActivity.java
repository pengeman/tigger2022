package org.peng.tiger2022;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.peng.calculator.Activity_cal;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button b_cal = (Button) findViewById(R.id.b_cal);
        b_cal.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                System.out.println("sout main activity");
                Intent intent = new Intent(MainActivity.this, Activity_cal.class);
                startActivity(intent);
            }
        });

        Button b_F3 = findViewById(R.id.f3);
        b_F3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, F3Activity.class);
                startActivity(intent);
            }
        });

    }
}