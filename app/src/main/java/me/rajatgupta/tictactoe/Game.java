package me.rajatgupta.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;



public class Game extends AppCompatActivity {
    char [] status = new char[9];
    byte rFlag = 0, tc=0;
    char Turn;
    String msg;
    TextView chance, Result;
    public void clickAction(View v){
        ViewGroup parent = (ViewGroup)v;
        TextView t = (TextView) parent.getChildAt(0);
        if((t.getText().toString()).length()==0 && rFlag==0)
        {
            String T1 = Turn+"";
            t.setText(T1);
            status[((int) t.getId()%10)]=Turn;
            tc++;
            Log.d("idFetch", String.format("%s",tc));
            if(status[0]==status[1]&&status[1]==status[2]&& status[0]!='\0'){
                String winner = status[0]+" is the winner";
                Result.setText(winner);
                rFlag = 1;
            }
            else if(status[3]==status[4]&&status[4]==status[5]&& status[3]!='\0'){
                String winner = status[4]+" is the winner";
                Result.setText(winner);
                rFlag = 1;
            }
            else if(status[6]==status[7]&&status[7]==status[8]&& status[8]!='\0'){
                String winner = status[8]+" is the winner";
                Result.setText(winner);
                rFlag = 1;
            }
            else if(status[0]==status[4]&&status[4]==status[8]&& status[8]!='\0'){
                String winner = status[4]+" is the winner";
                Result.setText(winner);
                rFlag = 1;
            }
            else if(status[2]==status[4]&&status[4]==status[6]&& status[6]!='\0'){
                String winner = status[4]+" is the winner";
                Result.setText(winner);
                rFlag = 1;
            }
            else if(status[0]==status[3]&&status[6]==status[3]&& status[0]!='\0'){
                String winner = status[0]+" is the winner";
                Result.setText(winner);
                rFlag = 1;
            }
            else if(status[1]==status[4]&&status[4]==status[7]&& status[7]!='\0'){
                String winner = status[4]+" is the winner";
                Result.setText(winner);
                rFlag = 1;
            }
            else if(status[2]==status[5]&&status[5]==status[8]&& status[8]!='\0'){
                String winner = status[5]+" is the winner";
                Result.setText(winner);
                rFlag = 1;
            }

            if(rFlag==0){
                if (Turn == 'X') Turn = 'O';
                else Turn = 'X';
                msg = "Chance for " + Turn;
                chance.setText(msg);
                if (tc==9) {
                    String mess = "Draw";
                    chance.setText(mess);
                }
            }
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
        Result = findViewById(R.id.Resut);
        Turn = 'X';
    }
}