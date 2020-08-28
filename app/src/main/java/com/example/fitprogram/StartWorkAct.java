package com.example.fitprogram;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class StartWorkAct extends AppCompatActivity {
    TextView subintropage, intropage, btnexercise, fitonetitle, fitonedesc, timervalue;
    View divpage, bgprogress;
    ImageView imgtimer;
    LinearLayout fitone;
    Animation ttbone, ttbtwo, btthree, bttfour, alpha;

    private static final long START_TIME_IN_MILLIS = 800000;
    private CountDownTimer countDownTimer;
    private boolean mTimerRunning;
    private long mTimeLeftInMillis = START_TIME_IN_MILLIS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_work);

        ttbone = AnimationUtils.loadAnimation(this, R.anim.ttbone);
        ttbtwo = AnimationUtils.loadAnimation(this, R.anim.ttbtwo);
        btthree = AnimationUtils.loadAnimation(this, R.anim.btthree);
        bttfour = AnimationUtils.loadAnimation(this, R.anim.bttfour);
        alpha = AnimationUtils.loadAnimation(this, R.anim.alpha);


        Typeface MLight = Typeface.createFromAsset(getAssets(), "fonts/MLight.ttf");
        Typeface MMedium = Typeface.createFromAsset(getAssets(), "fonts/MMedium.ttf");
        Typeface Vidaloka = Typeface.createFromAsset(getAssets(), "fonts/Vidaloka.ttf");

        btnexercise = (TextView) findViewById(R.id.btnexercise);
        intropage = (TextView) findViewById(R.id.intropage);
        subintropage = (TextView) findViewById(R.id.subintropage);
        fitonedesc = (TextView) findViewById(R.id.fitonedesc);
        fitonetitle = (TextView) findViewById(R.id.fitonetitle);
        timervalue = (TextView) findViewById(R.id.timervalue);

        fitone = (LinearLayout) findViewById(R.id.fitone);
        divpage = (View) findViewById(R.id.divpage);
        bgprogress = (View) findViewById(R.id.bgprogress);
        imgtimer = (ImageView) findViewById(R.id.imgtimer);

        intropage.setTypeface(Vidaloka);
        subintropage.setTypeface(MLight);
        btnexercise.setTypeface(MMedium);
        fitonedesc.setTypeface(MLight);
        fitonetitle.setTypeface(MMedium);
        timervalue.setTypeface(MMedium);

        intropage.startAnimation(ttbtwo);
        subintropage.startAnimation(ttbtwo);
        divpage.startAnimation(ttbtwo);
        fitone.startAnimation(ttbone);
        btnexercise.startAnimation(bttfour);
        bgprogress.startAnimation(btthree);
        imgtimer.startAnimation(alpha);
        timervalue.startAnimation(alpha);


        startTimer();


    btnexercise.setOnClickListener(new View.OnClickListener()

    {
        @Override
        public void onClick (View v){
        Intent a = new Intent(StartWorkAct.this, EditWorkAct.class);
        a.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        startActivity(a);
    }
    });
}

    private void startTimer(){
        countDownTimer=new CountDownTimer(mTimeLeftInMillis,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                mTimeLeftInMillis=millisUntilFinished;
                updateCountDownText();
            }

            @Override
            public void onFinish() {
                Toast.makeText(getApplicationContext(),"Congratulations!",Toast.LENGTH_SHORT).show();

            }
        }.start();
        mTimerRunning=true;
    }
    private void updateCountDownText(){
        int minutes=(int) (mTimeLeftInMillis/1000)/60;
        int seconds=(int) (mTimeLeftInMillis/1000)%60;

        String timeLeft=String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds);
        timervalue.setText(timeLeft);
    }
}