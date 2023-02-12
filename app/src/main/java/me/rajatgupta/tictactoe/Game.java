// this is the game activity where the actual game is played

package me.rajatgupta.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;



public class Game extends AppCompatActivity {
    byte winFlag = 0, tc=0;
    char Turn;
    String msg;
    TextView chance, result;
    public void clickAction(View v){
        ViewGroup parent = (ViewGroup)v;
        TextView t = (TextView) parent.getChildAt(0); //fetching the TextView where the click has occurred
        if((t.getText().toString()).length()==0 && winFlag ==0)
        {
            String T1 = Turn+"";
            t.setText(T1);
            tc++; //counting how many turns occurred

            if(winCheck(R.id.C0,R.id.C1,R.id.C2)||
                    winCheck(R.id.C3,R.id.C4,R.id.C5)||
                    winCheck(R.id.C6,R.id.C7,R.id.C8)||
                    winCheck(R.id.C0,R.id.C3,R.id.C6)||
                    winCheck(R.id.C1,R.id.C4,R.id.C7)||
                    winCheck(R.id.C2,R.id.C5,R.id.C8)||
                    winCheck(R.id.C0,R.id.C4,R.id.C8)||
                    winCheck(R.id.C6,R.id.C4,R.id.C2)


            ){
                winFlag = 1; // setting the winning event
            }


            if(winFlag ==0)//checking if the game is over. If not control goes in
            {
                //Switching players' turn
                if (Turn == 'X') Turn = 'O';
                else Turn = 'X';
                msg = "Chance for " + Turn;
                chance.setText(msg);
                if (tc==9) {
                    String mess = "Draw";
                    chance.setText(mess);
                }
            }
            // if the game is over
            else {
                chance.setText("");
            }


        }

    }
    public void reset(View v){
        finish();
        startActivity(getIntent());
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        chance = findViewById(R.id.Chance);
        result = findViewById(R.id.Result);
        Turn = 'X';
    }


    // method to check is the winning event has occurred
    // this also displays who is the winner
    Boolean winCheck(int a, int b, int c){
        TextView V1 = findViewById(a);
        TextView V2 = findViewById(b);
        TextView V3 = findViewById(c);
        String A = V1.getText().toString();
        String B = V2.getText().toString();
        String C = V3.getText().toString();

        if(A.equals(B)&&B.equals(C)&&A.length()!=0) {
            String message = A+" is the winner";
            result.setText(message);
            return true;
        }
        else return false;
    }
}