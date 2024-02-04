package com.deadnet.deadnet_client;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.os.Handler;

public class MainActivity extends AppCompatActivity {
    private CardView copView;
    private CardView constructionView;
    private CardView hazardView;
    private CardView routeChangeView;
    private CardView disconnectedView;

    void CopAlert(){
        copView = findViewById(R.id.CopView);
        ObjectAnimator animator = ObjectAnimator.ofFloat(copView, "translationY", 100f);
        animator.setDuration(500); // Adjust the duration as needed
        animator.start();

        new Handler().postDelayed(() -> {
            ObjectAnimator reverseAnimator = ObjectAnimator.ofFloat(copView, "translationY", -300f);
            reverseAnimator.setDuration(500); // Adjust the duration as needed
            reverseAnimator.start();
        }, 2000); // Delay for 2 seconds
    }

    void ConstructionAlert(){
        constructionView = findViewById(R.id.ConstructionView);
        ObjectAnimator animator = ObjectAnimator.ofFloat(constructionView, "translationY", 100f);
        animator.setDuration(500); // Adjust the duration as needed
        animator.start();

        new Handler().postDelayed(() -> {
            ObjectAnimator reverseAnimator = ObjectAnimator.ofFloat(constructionView, "translationY", -300f);
            reverseAnimator.setDuration(500); // Adjust the duration as needed
            reverseAnimator.start();
        }, 2000); // Delay for 2 seconds
    }

    void HazardAlert(){
        hazardView = findViewById(R.id.RoadHazardView);
        ObjectAnimator animator = ObjectAnimator.ofFloat(hazardView, "translationY", 100f);
        animator.setDuration(500); // Adjust the duration as needed
        animator.start();

        new Handler().postDelayed(() -> {
            ObjectAnimator reverseAnimator = ObjectAnimator.ofFloat(hazardView, "translationY", -300f);
            reverseAnimator.setDuration(500); // Adjust the duration as needed
            reverseAnimator.start();
        }, 2000); // Delay for 2 seconds
    }

    void RouteChangeAlert(){
        routeChangeView = findViewById(R.id.RouteChangeView);
        ObjectAnimator animator = ObjectAnimator.ofFloat(routeChangeView, "translationY", 100f);
        animator.setDuration(500); // Adjust the duration as needed
        animator.start();

        new Handler().postDelayed(() -> {
            ObjectAnimator reverseAnimator = ObjectAnimator.ofFloat(routeChangeView, "translationY", -300f);
            reverseAnimator.setDuration(500); // Adjust the duration as needed
            reverseAnimator.start();
        }, 2000); // Delay for 2 seconds
    }

    void DisconnectedAlert(){
        disconnectedView = findViewById(R.id.DisconnectedView);
        ObjectAnimator animator = ObjectAnimator.ofFloat(disconnectedView, "translationY", 100f);
        animator.setDuration(500); // Adjust the duration as needed
        animator.start();

        new Handler().postDelayed(() -> {
            ObjectAnimator reverseAnimator = ObjectAnimator.ofFloat(disconnectedView, "translationY", -300f);
            reverseAnimator.setDuration(500); // Adjust the duration as needed
            reverseAnimator.start();
        }, 2000); // Delay for 2 seconds
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new Handler().postDelayed(() -> {
            CopAlert();
        }, 1000);
        new Handler().postDelayed(() -> {
            ConstructionAlert();
        }, 4000);
        new Handler().postDelayed(() -> {
            HazardAlert();
        }, 7000);
        new Handler().postDelayed(() -> {
            RouteChangeAlert();
        }, 10000);
        new Handler().postDelayed(() -> {
            DisconnectedAlert();
        }, 13000);
    }
}