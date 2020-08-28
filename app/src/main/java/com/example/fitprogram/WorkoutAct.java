package com.example.fitprogram;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;

public class WorkoutAct extends AppCompatActivity {
    TextView titlepage, subtitlepage, subintropage, intropage, btnexercise, fitonetitle, fitonedesc, fittwotitle, fitthreetitle, fitfourtitle, fittwodesc, fitthreedesc, fitfourdesc;
    Animation bttone, bttwo, bttfour, btfive, btsix, btseven, bteight, btthree;
    View divpage, bgprogress;
    LinearLayout fitone, fittwo, fitthree, fitfour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout);

        bttone= AnimationUtils.loadAnimation(this,R.anim.bttone);
        bttwo= AnimationUtils.loadAnimation(this,R.anim.bttwo);
        btthree= AnimationUtils.loadAnimation(this,R.anim.btthree);
        bttfour= AnimationUtils.loadAnimation(this,R.anim.bttfour);
        btfive= AnimationUtils.loadAnimation(this,R.anim.btfive);
        btsix= AnimationUtils.loadAnimation(this,R.anim.btsix);
        btseven= AnimationUtils.loadAnimation(this,R.anim.btseven);
        bteight= AnimationUtils.loadAnimation(this,R.anim.bteight);

        Typeface MLight=Typeface.createFromAsset(getAssets(), "fonts/MLight.ttf");
        Typeface MMedium=Typeface.createFromAsset(getAssets(), "fonts/MMedium.ttf");
        Typeface Vidaloka=Typeface.createFromAsset(getAssets(), "fonts/Vidaloka.ttf");

        titlepage=(TextView) findViewById(R.id.titlepage);
        subtitlepage=(TextView) findViewById(R.id.subtitlepage);
        btnexercise=(TextView) findViewById(R.id.btnexercise);
        intropage=(TextView) findViewById(R.id.intropage);
        subintropage=(TextView) findViewById(R.id.subintropage);
        divpage=(View) findViewById(R.id.divpage);
        bgprogress=(View) findViewById(R.id.bgprogress);

        btnexercise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a=new Intent(WorkoutAct.this,StartWorkAct.class);
                a.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(a);
            }
        });

        fitone=(LinearLayout) findViewById(R.id.fitone);
        fittwo=(LinearLayout) findViewById(R.id.fittwo);
        fitthree=(LinearLayout) findViewById(R.id.fitthree);
        fitfour=(LinearLayout) findViewById(R.id.fitfour);

        fitonedesc=(TextView) findViewById(R.id.fitonedesc);
        fitonetitle=(TextView) findViewById(R.id.fitonetitle);

        fittwodesc=(TextView) findViewById(R.id.fittwodesc);
        fittwotitle=(TextView) findViewById(R.id.fittwotitle);

        fitthreedesc=(TextView) findViewById(R.id.fitthreedesc);
        fitthreetitle=(TextView) findViewById(R.id.fitthreetitle);

        fitfourdesc=(TextView) findViewById(R.id.fitfourdesc);
        fitfourtitle=(TextView) findViewById(R.id.fitfourtitle);

        titlepage.setTypeface(Vidaloka);
        subtitlepage.setTypeface(MLight);
        intropage.setTypeface(Vidaloka);
        subintropage.setTypeface(MLight);
        btnexercise.setTypeface(MMedium);
        fitonedesc.setTypeface(MLight);
        fitonetitle.setTypeface(MMedium);
        fittwodesc.setTypeface(MLight);
        fittwotitle.setTypeface(MMedium);
        fitthreedesc.setTypeface(MLight);
        fitthreetitle.setTypeface(MMedium);
        fitfourdesc.setTypeface(MLight);
        fitfourtitle.setTypeface(MMedium);

        titlepage.startAnimation(bttone);
        subtitlepage.startAnimation(bttone);
        divpage.startAnimation(bttone);

        intropage.startAnimation(bttwo);
        subintropage.startAnimation(bttwo);

        fitone.startAnimation(btthree);
        fittwo.startAnimation(bttfour);
        fitthree.startAnimation(btfive);
        fitfour.startAnimation(btsix);

        btnexercise.startAnimation(btseven);
        bgprogress.startAnimation(bteight);

    }
}