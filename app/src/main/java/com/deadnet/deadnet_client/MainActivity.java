package com.deadnet.deadnet_client;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private CardView welcomeAlert;
    private CardView copView;
    private CardView undercoverCopView;
    private CardView constructionView;
    private CardView hazardView;
    private CardView routeChangeView;
    private CardView disconnectedView;
    private int LoadingValue = 0;

    private void UpdateLoadingBar(ProgressBar progressBar) {
        // Create a handler to update the progress every second
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                // Update the progress value
                if (LoadingValue <= 100) {
                    // Set the new progress value
                    progressBar.setProgress(LoadingValue);
                    // Call the method again after 1 second
                    handler.postDelayed(this, 1000);
                }
            }
        }, 1000); // Start updating after 1 second
    }

    void WelcomeAlert(){
        welcomeAlert = findViewById(R.id.WelcomeView);
        ObjectAnimator animator = ObjectAnimator.ofFloat(welcomeAlert, "translationY", 100f);
        animator.setDuration(500); // Adjust the duration as needed
        animator.start();

        new Handler().postDelayed(() -> {
            ObjectAnimator reverseAnimator = ObjectAnimator.ofFloat(welcomeAlert, "translationY", -300f);
            reverseAnimator.setDuration(500); // Adjust the duration as needed
            reverseAnimator.start();
        }, 2000); // Delay for 2 seconds
    }

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

    void UndercoverAlert(){
        undercoverCopView = findViewById(R.id.UndercoverAlert);
        ObjectAnimator animator = ObjectAnimator.ofFloat(undercoverCopView, "translationY", 100f);
        animator.setDuration(500); // Adjust the duration as needed
        animator.start();

        new Handler().postDelayed(() -> {
            ObjectAnimator reverseAnimator = ObjectAnimator.ofFloat(undercoverCopView, "translationY", -300f);
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
    }

    void ReconnectedAlert(){
        ObjectAnimator reverseAnimator = ObjectAnimator.ofFloat(disconnectedView, "translationY", -300f);
        reverseAnimator.setDuration(500); // Adjust the duration as needed
        reverseAnimator.start();
    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);
        new Handler().postDelayed(() -> {
            setContentView(R.layout.activity_main);
        }, 5000);
        new Handler().postDelayed(() -> {
            LoadingValue += 25;
            UpdateLoadingBar(findViewById(R.id.LoadingBar));
        }, 1000);
        new Handler().postDelayed(() -> {
            LoadingValue += 25;
            UpdateLoadingBar(findViewById(R.id.LoadingBar));
        }, 2000);
        new Handler().postDelayed(() -> {
            LoadingValue += 25;
            UpdateLoadingBar(findViewById(R.id.LoadingBar));
        }, 3000);
        new Handler().postDelayed(() -> {
            LoadingValue += 25;
            UpdateLoadingBar(findViewById(R.id.LoadingBar));
        }, 4000);
        new Handler().postDelayed(() -> {
            WelcomeAlert();
        }, 6000);
        new Handler().postDelayed(() -> {
            CopAlert();
        }, 9000);
        new Handler().postDelayed(() -> {
            ConstructionAlert();
        }, 12000);
        new Handler().postDelayed(() -> {
            HazardAlert();
        }, 15000);
        new Handler().postDelayed(() -> {
            RouteChangeAlert();
        }, 18000);
        new Handler().postDelayed(() -> {
            DisconnectedAlert();
        }, 21000);
        new Handler().postDelayed(() -> {
            ReconnectedAlert();
        }, 31000);

        /*@SuppressLint({"MissingInflatedId", "LocalSuppress"}) CardView voiceButton = findViewById(R.id.VoiceButton);
        voiceButton.setOnTouchListener(new View.OnTouchListener() {
            @SuppressLint("ClickableViewAccessibility")
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        // Start a handler to print "HOLDING" every 100ms
                        Toast.makeText(MainActivity.this, "HOLDING", Toast.LENGTH_SHORT).show();
                        break;

                    case MotionEvent.ACTION_UP:
                        // Stop printing when the touch is released
                        Toast.makeText(MainActivity.this, "STOPPED HOLDING", Toast.LENGTH_SHORT).show();
                        break;
                }
                return true;
            }
        });*/

    }
}