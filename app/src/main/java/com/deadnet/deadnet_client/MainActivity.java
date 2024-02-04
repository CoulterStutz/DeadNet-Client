package com.deadnet.deadnet_client;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.os.Handler;

public class MainActivity extends AppCompatActivity {
    private CardView copView;

    void CopAlert(){
        copView = findViewById(R.id.CopView);
        ObjectAnimator animator = ObjectAnimator.ofFloat(copView, "translationY", 0f);
        animator.setDuration(500); // Adjust the duration as needed
        animator.start();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}