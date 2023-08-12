package com.teit.mazetemirlantashtanov;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CreateButtons extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.buttonscreate);

        //initialize our buttons =>
        Button fouronfour = (Button) findViewById(R.id.fouronfour);
        Button fiveonfive = (Button) findViewById(R.id.fiveonfive);
        Button sixonsix = (Button) findViewById(R.id.sixonsix);
        Button sevenonseven = (Button) findViewById(R.id.sevenonseven);
        Button eightoneight = (Button) findViewById(R.id.eightoneight);
        Button nineonnine = (Button) findViewById(R.id.nineonnine);
        Button tenonten = (Button) findViewById(R.id.tenonten);

        fouronfour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Intent intent = new Intent(com.teit.mazetemirlantashtanov.CreateButtons.this,GameActivity.class);
                intent.putExtra("Dimension",4);
                startActivity(intent);
                finish();
            }
        });
        fiveonfive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Intent intent = new Intent(com.teit.mazetemirlantashtanov.CreateButtons.this,GameActivity.class);
                intent.putExtra("Dimension",5);
                startActivity(intent);
                finish();
            }
        });
        sixonsix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Intent intent = new Intent(com.teit.mazetemirlantashtanov.CreateButtons.this,GameActivity.class);
                intent.putExtra("Dimension",6);
                startActivity(intent);
                finish();
            }
        });
        sevenonseven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Intent intent = new Intent(com.teit.mazetemirlantashtanov.CreateButtons.this,GameActivity.class);
                intent.putExtra("Dimension",7);
                startActivity(intent);
                finish();
            }
        });
        eightoneight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Intent intent = new Intent(com.teit.mazetemirlantashtanov.CreateButtons.this,GameActivity.class);
                intent.putExtra("Dimension",8);
                startActivity(intent);
                finish();
            }
        });
        nineonnine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Intent intent = new Intent(com.teit.mazetemirlantashtanov.CreateButtons.this,GameActivity.class);
                intent.putExtra("Dimension",9);
                startActivity(intent);
                finish();
            }
        });
        tenonten.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Intent intent = new Intent(com.teit.mazetemirlantashtanov.CreateButtons.this,GameActivity.class);
                intent.putExtra("Dimension",10);
                startActivity(intent);
                finish();
            }
        });
    }
}
