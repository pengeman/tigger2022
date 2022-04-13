package org.peng.noteBook;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import org.peng.tiger2022.R;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class NoteBookActivity extends AppCompatActivity {
    EditText mtext = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notebook);

        ImageButton returnButton = (ImageButton) findViewById(R.id.returnButton);
        mtext = findViewById(R.id.mtext);

        returnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //String stext = mtext.getText().toString();

            }
        });

        mtext.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                // editText失去焦点
                System.out.println(hasFocus);
            }
        });
    }

    private void saveText() {
        String sText = mtext.getText().toString();

        //filename = saveFD.getDirectory() + saveFD.getFile();
        String filename = System.getProperty("user.dir") + "/dblook.txt";
        System.out.println(filename);//user.dir指定了当前的路径
        File directory = new File("");//设定为当前文件夹
        try {
            System.out.println(directory.getCanonicalPath());//获取标准的路径
            System.out.println(directory.getAbsolutePath());//获取绝对路径
        } catch (IOException ed) {
        }

        if (filename != null) {
            try {
                File file = new File(filename);
                FileWriter writer = new FileWriter(file);
                BufferedWriter out = new BufferedWriter(writer);
                out.write(sText, 0, sText.length());

                out.close();
                writer.close();
            } catch (IOException e2) {
            }
        }
    }
}
