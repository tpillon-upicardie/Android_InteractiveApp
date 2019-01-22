package com.tpillon.interactiveapplication;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private int count = 0;
    private Resources resource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        resource = getResources();
    }

    public void changeText(View view) {
        Button button1 = findViewById(R.id.button1);
        String message = "thanks";
        button1.setText(resource.getString(R.string.new_text, ++count, message));
    }

    public void changeColor(View view) {
        Button button2 = findViewById(R.id.button2);
        int color = resource.getColor(R.color.other_color);
        button2.setBackgroundColor(color);
    }

    public void changeActivity(View view) {
        EditText editText = findViewById(R.id.editText);
        String text = editText.getText().toString();

        if (text == null
                || "".equals(text)) {
            Toast.makeText(this, resource.getText(R.string.empty_text), Toast.LENGTH_LONG).show();
            return;
        }

        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra(SecondActivity.MESSAGE_KEY, text);
        startActivity(intent);

    }
}
