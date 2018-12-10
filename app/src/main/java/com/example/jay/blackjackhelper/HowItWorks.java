package com.example.jay.blackjackhelper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class HowItWorks extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_how_it_works);

        setText();

        }

    private void setText(){
        TextView howItWorks = (TextView) findViewById(R.id.dealerHeader);
        howItWorks.setText("Welcome to the Blackjack Helper! The definitive guide on guiding you through the game of Blackjack. To start, select what card" +
                " the dealer is showing. From there you can input what cards you hold. Our app will automatically keep track of your overall value and advise you" +
                "on what your next action should be. Hit clear to reset the values and start a new hand. Good luck!");
    }


}


