package org.peng.tiger2022;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText eText_cal = (EditText) findViewById(R.id.eText_cal);
        eText_cal.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                System.out.println("sout main activity");
                Intent intent = new Intent(MainActivity.this, Activity_cal.class);
                startActivity(intent);
            }
        });

    }
}