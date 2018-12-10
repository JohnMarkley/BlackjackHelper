package com.example.jay.blackjackhelper;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Button begin = (Button) findViewById(R.id.enterButton);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void begin(View view){
        Intent intent = new Intent(this, helperActivity.class);
        startActivity(intent);
    }

    public void howItWorks(View view){
        Intent intent = new Intent(this, HowItWorks.class);
        startActivity(intent);
    }


}
