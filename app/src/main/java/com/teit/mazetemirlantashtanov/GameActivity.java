package com.teit.mazetemirlantashtanov;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class GameActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game);


        Intent intent = getIntent();
        int dimension = intent.getIntExtra("Dimension",4);


        Button btn_up = (Button) findViewById(R.id.upButton);
        Button btn_left = (Button) findViewById(R.id.leftButton);
        Button btn_right = (Button) findViewById(R.id.rightButton);
        Button btn_down = (Button) findViewById(R.id.downButton);

        Button btn_return =(Button)findViewById(R.id.returnButton);

        GameView gm = (GameView)findViewById(R.id.gameview);

        // we need to set properly data =>
        gm.SetDimension(dimension);


        btn_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(gm.canMoveUP()){
                    gm.Move("Up");
                    boolean isGameFinished = gm.userCameToExit();
                    if(isGameFinished){
                        //todo : we should say that user is won and give possibility to start new game
                        final Intent intent = new Intent(com.teit.mazetemirlantashtanov.GameActivity.this,FinishGame.class);
                        intent.putExtra("Dimension",dimension);
                        startActivity(intent);
                        finish();
                    }
                }
                else{
                    Toast toast = Toast.makeText(getApplicationContext(),
                            "Can't move to up!", Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });

        btn_left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(gm.canMoveLEFT()){
                    gm.Move("Left");
                    boolean isGameFinished = gm.userCameToExit();
                    if(isGameFinished){
                        //todo : we should say that user is won and give possibility to start new game
                        final Intent intent = new Intent(com.teit.mazetemirlantashtanov.GameActivity.this,FinishGame.class);
                        intent.putExtra("Dimension",dimension);
                        startActivity(intent);
                        finish();
                    }
                }
                else{
                    Toast toast = Toast.makeText(getApplicationContext(),
                            "Can't move to left!", Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });

        btn_right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(gm.canMoveRIGHT()){
                    gm.Move("Right");
                    boolean isGameFinished = gm.userCameToExit();
                    if(isGameFinished){
                        //todo : we should say that user is won and give possibility to start new game
                        final Intent intent = new Intent(com.teit.mazetemirlantashtanov.GameActivity.this,FinishGame.class);
                        intent.putExtra("Dimension",dimension);
                        startActivity(intent);
                        finish();
                    }
                }
                else{
                    Toast toast = Toast.makeText(getApplicationContext(),
                            "Can't move to right!", Toast.LENGTH_SHORT);
                    toast.show();
                }

            }
        });

        btn_down.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(gm.canMoveDOWN()){
                    gm.Move("Down");
                    boolean isGameFinished = gm.userCameToExit();
                    if(isGameFinished){
                        //todo : we should say that user is won and give possibility to start new game
                        final Intent intent = new Intent(com.teit.mazetemirlantashtanov.GameActivity.this,FinishGame.class);
                        intent.putExtra("Dimension",dimension);
                        startActivity(intent);
                        finish();
                    }
                }
                else{
                    Toast toast = Toast.makeText(getApplicationContext(),
                            "Can't move to down!", Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });

        btn_return.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Intent intent = new Intent(com.teit.mazetemirlantashtanov.GameActivity.this,CreateButtons.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
