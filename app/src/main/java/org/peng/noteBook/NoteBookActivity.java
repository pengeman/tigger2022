package org.peng.noteBook;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import org.peng.tiger2022.R;

public class NoteBookActivity extends AppCompatActivity {
    EditText mtext = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notebook);

        ImageButton returnButton  = (ImageButton)findViewById(R.id.returnButton);
        mtext = findViewById(R.id.mtext);

        returnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String stext = mtext.getText().toString();

            }
        });

    }

    private void saveText(){
        String sText = mtext.getText().toString();

    }
}