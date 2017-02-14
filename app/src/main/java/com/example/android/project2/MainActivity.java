package com.example.android.project2;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import static com.example.android.project2.R.drawable.mklogo;

public class MainActivity extends AppCompatActivity {

//    initialized hp for both fighters

    int subzeroHP = 100;
    int raidenHP = 100;
    int damageReduction = 0;
    MediaPlayer mp1;
    MediaPlayer mp2;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mp1 = MediaPlayer.create(this, R.raw.mkpunch);
        mp2 = MediaPlayer.create(this, R.raw.mkkick);

        Drawable mk = getDrawable(mklogo);
        mk.setAlpha(180);
    }

    public void subzeroWinningScreen() {
        if (raidenHP == 0) {
            Intent i = new Intent("com.example.android.project2.Main2Activity");
            startActivity(i);
        }
    }

    public void raidenWinningScreen() {
        if (subzeroHP == 0) {
            Intent i = new Intent("com.example.android.project2.Main3Activity");
            startActivity(i);
        }
    }

//minus ten hp for raiden when punch is pressed

    public void minusTenHPRaiden(View v) {
        mp1.start();
        raidenHP = raidenHP - 10;
        if (raidenHP < 0) {
            raidenHP = 0;
        }
        if (raidenHP == 0) {
            subzeroWinningScreen();
        }
        displayHPRaiden(raidenHP);
    }

    public void minusFifteenHPRaiden(View v) {
        mp2.start();
        raidenHP = raidenHP - 15;
        if (raidenHP < 0) {
            raidenHP = 0;
        }
        if (raidenHP == 0)
            subzeroWinningScreen();
        displayHPRaiden(raidenHP);
    }

    //    I initialize damageReduction integer to be deducted from raiden's hits
    public void minusFiveDamageRaiden(View v) {
        damageReduction = 5;
        displayStatus("Frozen");
    }


    //minus ten hp for subzero when punch is pressed
    public void minusTenHPSubzero(View v) {
        mp1.start();
        if (damageReduction == 5) {
            subzeroHP = subzeroHP - (10 - damageReduction);
            damageReduction = 0;
            displayStatus("");
        } else if (damageReduction == 0) {
            subzeroHP = subzeroHP - 10;
        }

        if (subzeroHP < 0) {
            subzeroHP = 0;
        }
        if (subzeroHP == 0) {
            raidenWinningScreen();
        }
        displayHPSubzero(subzeroHP);
    }


    public void minusFifteenHPSubzero(View v) {
        mp2.start();
        if (damageReduction == 5) {
            subzeroHP = subzeroHP - (15 - damageReduction);
            damageReduction = 0;
            displayStatus("");
        } else if (damageReduction == 0) {
            subzeroHP = subzeroHP - 15;
        }
        if (subzeroHP < 0) {
            subzeroHP = 0;
        }
        if (subzeroHP == 0) {
            raidenWinningScreen();
        }
        displayHPSubzero(subzeroHP);

    }


    public void resetHP(View v) {
        subzeroHP = 100;
        raidenHP = 100;
        damageReduction = 0;
        displayHPSubzero(subzeroHP);
        displayHPRaiden(raidenHP);
        displayStatus("");


    }


//the method to display hp's for both fighters

    public void displayHPSubzero(int HP) {
        TextView hpView = (TextView) findViewById(R.id.subzero_hp);
        hpView.setText(String.valueOf(HP));

    }

    public void displayHPRaiden(int HP) {
        TextView hpView = (TextView) findViewById(R.id.raiden_HP);
        hpView.setText(String.valueOf(HP));

    }

    //method to display status "weakened" when super button is pressed
    public void displayStatus(String status) {
        TextView statusView = (TextView) findViewById(R.id.raiDenStatus);
        statusView.setText(String.valueOf(status));

    }

}




