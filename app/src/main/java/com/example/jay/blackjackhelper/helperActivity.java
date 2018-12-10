package com.example.jay.blackjackhelper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class helperActivity extends AppCompatActivity implements View.OnClickListener {
    private int dealerValue = 0;
    private int playerValue = 0;
    private int aceCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_helper);

        //Button declaration for Dealer
        Button aceCardD = (Button) findViewById(R.id.cardA9);
        aceCardD.setOnClickListener(this);
        Button twoCardD = (Button) findViewById(R.id.card2);
        twoCardD.setOnClickListener(this);
        Button threeCardD = (Button) findViewById(R.id.card3);
        threeCardD.setOnClickListener(this);
        Button fourCardD = (Button) findViewById(R.id.card4);
        fourCardD.setOnClickListener(this);
        Button fiveCardD = (Button) findViewById(R.id.card5);
        fiveCardD.setOnClickListener(this);
        Button sixCardD = (Button) findViewById(R.id.card6);
        sixCardD.setOnClickListener(this);
        Button sevenCardD = (Button) findViewById(R.id.card7);
        sevenCardD.setOnClickListener(this);
        Button eightCardD = (Button) findViewById(R.id.card8);
        eightCardD.setOnClickListener(this);
        Button nineCardD = (Button) findViewById(R.id.card9);
        nineCardD.setOnClickListener(this);
        Button tenCardD = (Button) findViewById(R.id.card10);
        tenCardD.setOnClickListener(this);


        //Button declaration for Players
        Button aceCardP = (Button) findViewById(R.id.cardAPlayer);
        aceCardP.setOnClickListener(this);
        Button twoCardP = (Button) findViewById(R.id.card2Player);
        twoCardP.setOnClickListener(this);
        Button threeCardP = (Button) findViewById(R.id.card3Player);
        threeCardP.setOnClickListener(this);
        Button fourCardP = (Button) findViewById(R.id.card4Player);
        fourCardP.setOnClickListener(this);
        Button fiveCardP = (Button) findViewById(R.id.card5Player);
        fiveCardP.setOnClickListener(this);
        Button sixCardP = (Button) findViewById(R.id.card6Player);
        sixCardP.setOnClickListener(this);
        Button sevenCardP = (Button) findViewById(R.id.card7Player);
        sevenCardP.setOnClickListener(this);
        Button eightCardP = (Button) findViewById(R.id.card8Player);
        eightCardP.setOnClickListener(this);
        Button nineCardP = (Button) findViewById(R.id.card9Player);
        nineCardP.setOnClickListener(this);
        Button tenCardP = (Button) findViewById(R.id.card10Player);
        tenCardP.setOnClickListener(this);

        //Clear
        Button clearButton = (Button) findViewById(R.id.clearButton);
        clearButton.setOnClickListener(this);


        //Text Declaration

    }


    public void onClick(View v){
        TextView playerValueText = (TextView)findViewById(R.id.playerValInt);
        TextView dealerValueText = (TextView) findViewById(R.id.dealerValInt);
        TextView result = (TextView) findViewById(R.id.resultTextView);

        int calculateResult;


        switch(v.getId()){

            case R.id.cardA9:
                dealerValue = 11;
                break;
            case R.id.card2:
                dealerValue = 2;
                break;
            case R.id.card3:
                dealerValue = 3;
                break;
            case R.id.card4:
                dealerValue =  4;
                break;
            case R.id.card5:
                dealerValue =  5;
                break;
            case R.id.card6:
                dealerValue =  6;
                break;
            case R.id.card7:
                dealerValue =  7;
                break;
            case R.id.card8:
                dealerValue =  8;
                break;
            case R.id.card9:
                dealerValue =  9;
                break;
            case R.id.card10:
                dealerValue = 10;
                break;
            case R.id.cardAPlayer:
                playerValue = playerValue + 11;
                aceCount++;
                break;
            case R.id.card2Player:
                playerValue = playerValue + 2;
                break;
            case R.id.card3Player:
                playerValue = playerValue + 3;
                break;
            case R.id.card4Player:
                playerValue = playerValue + 4;
                break;
            case R.id.card5Player:
                playerValue = playerValue + 5;
                break;
            case R.id.card6Player:
                playerValue = playerValue + 6;
                break;
            case R.id.card7Player:
                playerValue = playerValue + 7;
                break;
            case R.id.card8Player:
                playerValue = playerValue + 8;
                break;
            case R.id.card9Player:
                playerValue = playerValue + 9;
                break;
            case R.id.card10Player:
                playerValue = playerValue + 10;
                break;
            case R.id.clearButton:
                playerValue = 0;
                dealerValue = 0;
                break;
                default:
                    break;
        }
        if(aceCount > 0){
            if(playerValue > 21){
                playerValue = playerValue - 10;
                aceCount--;
            }
        }
        if(playerValue == 0){
            playerValueText.setText("-");
        }else{
            playerValueText.setText("" + playerValue);
        }

        if(dealerValue == 0){
            dealerValueText.setText("-");
        }else{
            dealerValueText.setText("" + dealerValue);
        }


        calculateResult = calculate(dealerValue, playerValue);

        if(calculateResult == -4){
            result.setText("BUST");
        }else if(calculateResult == -3){
            result.setText("HIT");
        }else if(calculateResult == -2){
            result.setText("STAND");
        }else if(calculateResult == -1){
            result.setText("DOUBlE");
        }else if(calculateResult == 0){
            result.setText("");
        }else{
            result.setText("Something Went Wrong");
        }

    }


   private int calculate(int dealerVal, int playerVal) {
        //-4 = BUST
        //-3 = HIT
        //-2 = STAND
        //-1 = DOUBLE
       // 0 = " "
        int playerValue = playerVal;
        int dealerValue = dealerVal;
        if(dealerValue == 0 || playerValue == 0){
            return 0;
        }else{
            if(playerValue > 21){
                return -4;
         }else if(playerValue >= 17){
                return -2;
         }else if(playerValue >= 12 && playerValue <= 16){
             if(dealerValue >= 7){
                 return -3;
             }else{
                 return -2;
             }
         }else if(playerValue == 12){
             if(dealerValue <= 7 || dealerValue > 4){
                 return -3;
             }else{
                 return -2;
             }
         }else{
             return -3;
         }
        }

    }
}
