package com.example.foodapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.example.foodapp.Customer.CustomerDashboard;

public class IntroductoryScreen extends AppCompatActivity {

    ImageView logo,app_name;
    Animation topanim,leftanim;
    private static int SPLASH_SCREEN = 5000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introductory_screen);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        logo = findViewById(R.id.logo);
        app_name = findViewById(R.id.app_name);

        topanim = AnimationUtils.loadAnimation(this,R.anim.top_animation);
        leftanim = AnimationUtils.loadAnimation(this,R.anim.left_animation);

        logo.setAnimation(topanim);
        app_name.setAnimation(leftanim);

        new Handler().postDelayed(() -> {
            Intent intent = new Intent(IntroductoryScreen.this, CustomerDashboard.class);
            startActivity(intent);
            finish();

        }, SPLASH_SCREEN);

    }

    @Override
    public void onBackPressed(){
        super.onBackPressed();
    }


}