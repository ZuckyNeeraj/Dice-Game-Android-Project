package com.example.dicegame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.Image;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnObj = findViewById(R.id.button);



        //Used Image views for two dices
        final ImageView diceDisplay1 = findViewById(R.id.imageView2);


        //Array of images
        final int [] diceImages = {R.drawable.dice1,R.drawable.dice2,
                             R.drawable.dice3,R.drawable.dice4,
                             R.drawable.dice5,R.drawable.dice6};

        //Sound
        final MediaPlayer mp = MediaPlayer.create(this, R.raw.dice_sound);
        btnObj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random rdnObj = new Random();
                //storing and generating numbers
                int myRandNum1 = rdnObj.nextInt(6);


                //Using array to get random roll
                diceDisplay1.setImageResource(diceImages[myRandNum1]);

                //animation
                YoYo.with(Techniques.Shake)
                        .duration(500)
                        .repeat(0)
                        .playOn(findViewById(R.id.imageView2));


                mp.start();
            }
        });

    }
}
