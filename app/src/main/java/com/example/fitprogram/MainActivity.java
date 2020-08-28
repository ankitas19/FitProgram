package com.example.fitprogram;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView titlepage, subtitlepage, btnexercise;
    ImageView imgpage;
    Animation animimgpage, bttone, bttwo, btthree, itr;
    View bgprogress, bgprogressstop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        animimgpage= AnimationUtils.loadAnimation(this,R.anim.animimgpage);
        bttone= AnimationUtils.loadAnimation(this,R.anim.bttone);
        bttwo= AnimationUtils.loadAnimation(this,R.anim.bttwo);
        btthree= AnimationUtils.loadAnimation(this,R.anim.btthree);
        itr= AnimationUtils.loadAnimation(this,R.anim.itr);

        Typeface MLight=Typeface.createFromAsset(getAssets(), "fonts/MLight.ttf");
        Typeface MMedium=Typeface.createFromAsset(getAssets(), "fonts/MMedium.ttf");
        Typeface Vidaloka=Typeface.createFromAsset(getAssets(), "fonts/Vidaloka.ttf");

        titlepage=(TextView) findViewById(R.id.titlepage);
        subtitlepage=(TextView) findViewById(R.id.subtitlepage);
        btnexercise=(TextView) findViewById(R.id.btnexercise);
        imgpage=(ImageView) findViewById(R.id.imgpage);
        bgprogress=(View) findViewById(R.id.bgprogress);
        bgprogressstop=(View) findViewById(R.id.bgprogresstop);

        titlepage.setTypeface(Vidaloka);
        subtitlepage.setTypeface(MLight);
        btnexercise.setTypeface(MMedium);

        imgpage.startAnimation(animimgpage);
        titlepage.startAnimation(bttone);
        subtitlepage.startAnimation(bttone);

        btnexercise.startAnimation(btthree);
        bgprogress.startAnimation(bttwo);
        bgprogressstop.startAnimation(itr);

        btnexercise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a=new Intent(MainActivity.this,WorkoutAct.class);
                a.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(a);
            }
        });
    }
}