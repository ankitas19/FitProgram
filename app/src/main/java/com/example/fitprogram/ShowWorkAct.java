package com.example.fitprogram;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

public class ShowWorkAct extends AppCompatActivity {
    Button btnnewwork, btnpopwork;
    TextView titlepage, subtitlepage;
    Animation exit, exits;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_work);

        exit= AnimationUtils.loadAnimation(this,R.anim.exit);
        exits= AnimationUtils.loadAnimation(this,R.anim.exits);

        btnnewwork = findViewById(R.id.btnnewwork);
        btnpopwork = findViewById(R.id.btnpopwork);
        titlepage = findViewById(R.id.titlepage);
        subtitlepage = findViewById(R.id.subtitlepage);

        Typeface MLight = Typeface.createFromAsset(getAssets(), "fonts/MLight.ttf");
        Typeface MMedium = Typeface.createFromAsset(getAssets(), "fonts/MMedium.ttf");
        Typeface Vidaloka = Typeface.createFromAsset(getAssets(), "fonts/Vidaloka.ttf");

        // customize font
        titlepage.setTypeface(Vidaloka);
        subtitlepage.setTypeface(MLight);

        btnnewwork.setSelected(true);

        btnnewwork.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnnewwork.setSelected(true);
                btnnewwork.setTextColor(Color.parseColor("#356C64"));

                btnpopwork.setSelected(false);
                btnpopwork.setTextColor(Color.parseColor("#25293E"));


                Fragment fragment;
                fragment = new NewWorkFrag();
                FragmentManager manager = getSupportFragmentManager();
                FragmentTransaction txn = manager.beginTransaction();

                txn.setCustomAnimations(R.anim.exit, R.anim.exits, R.anim.exit, R.anim.exits);
                txn.addToBackStack(null);

                txn.replace(R.id.contentwrap, fragment);
                txn.commit();
            }
        });

        btnpopwork.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnnewwork.setSelected(false);
                btnnewwork.setTextColor(Color.parseColor("#356C64"));

                btnpopwork.setSelected(true);
                btnpopwork.setTextColor(Color.parseColor("#25293E"));


                Fragment fragment;
                fragment = new PopWorkFrag();
                FragmentManager manager = getSupportFragmentManager();
                FragmentTransaction txn = manager.beginTransaction();

                txn.setCustomAnimations(R.anim.exit, R.anim.exits, R.anim.exit, R.anim.exits);
                txn.addToBackStack(null);

                txn.replace(R.id.contentwrap, fragment);
                txn.commit();
            }
        });
    }
}
