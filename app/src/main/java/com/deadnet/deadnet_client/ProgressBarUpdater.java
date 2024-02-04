package com.deadnet.deadnet_client;

import android.os.Handler;
import android.widget.ProgressBar;

public class ProgressBarUpdater {
    int progressValue;
    private void updateProgressBar(ProgressBar progressBar) {
        // Create a handler to update the progress every second
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                // Update the progress value
                progressValue += 10;
                if (progressValue <= 100) {
                    // Set the new progress value
                    progressBar.setProgress(progressValue);
                    // Call the method again after 1 second
                    handler.postDelayed(this, 1000);
                }
            }
        }, 1000); // Start updating after 1 second
    }
}
