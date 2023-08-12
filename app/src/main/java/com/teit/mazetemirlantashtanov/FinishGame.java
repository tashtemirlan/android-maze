package com.teit.mazetemirlantashtanov;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FinishGame extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.won);

        Intent intent = getIntent();
        int dimension = intent.getIntExtra("Dimension",4);

        Button btn_again = (Button) findViewById(R.id.again);
        Button btn_choose = (Button) findViewById(R.id.choose);


        btn_again.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Intent intent = new Intent(com.teit.mazetemirlantashtanov.FinishGame.this,GameActivity.class);
                intent.putExtra("Dimension",dimension);
                startActivity(intent);
                finish();
            }
        });

        btn_choose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Intent intent = new Intent(com.teit.mazetemirlantashtanov.FinishGame.this,CreateButtons.class);
                startActivity(intent);
                finish();
            }
        });
    }
}