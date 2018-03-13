package com.example.jaco.bibleapp;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final MediaPlayer holySound = (MediaPlayer.create(this, R.raw.holy_sound2));

        ImageView bible = (ImageView) findViewById(R.id.bible);

        ObjectAnimator scaleDownX = ObjectAnimator.ofFloat(bible, "scaleX", 0.9f);
        ObjectAnimator scaleDownY = ObjectAnimator.ofFloat(bible, "scaleY", 0.9f);
        scaleDownX.setDuration(1000);
        scaleDownY.setDuration(1000);

        final AnimatorSet scaleDown = new AnimatorSet();
        scaleDown.play(scaleDownX).with(scaleDownY);

        scaleDown.start();


        bible.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (holySound.isPlaying()){
                    holySound.pause();
                    holySound.seekTo(0);
                }
                Toast.makeText(MainActivity.this, "FK OFF", Toast.LENGTH_LONG).show();
                scaleDown.start();
                holySound.start();
            }
        });

    }
}
