package com.tpillon.interactiveapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    public static final String MESSAGE_KEY = "TextKey";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();
        String text = intent.getStringExtra(MESSAGE_KEY);
        TextView textView = findViewById(R.id.textView);
        String formattedText = getResources().getString(R.string.entered_text, text);
        textView.setText(formattedText);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Toast.makeText(this, "back is pressed", Toast.LENGTH_LONG).show();
    }

    public void clickToBack(View view) {
        onBackPressed();
    }
}
