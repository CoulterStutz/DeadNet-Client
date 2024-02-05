package com.deadnet.deadnet_client;

import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class SocketConnection {
    private String VIN;
    private int RacerPin;
    public String RacerName;

    public SocketConnection(String VIN, int RacerPin, String RacerName) {
        this.VIN = VIN;
        this.RacerPin = RacerPin;
        this.RacerName = RacerName;
    }

    public void connectToServer(String serverAddress, int serverPort) {
        try {
            // Create a socket connection to the server
            Socket socket = new Socket(serverAddress, serverPort);

            // Get the output stream to send data to the server
            ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());

            // Send VIN and RacerPin to the server in the format "VIN::RACER_PIN"
            String authMessage = VIN + "::" + RacerPin;
            outputStream.writeObject(authMessage);

            // Get the input stream to receive data from the server
            ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());

            // Wait for the "authenticated" message from the server
            String authenticationResponse = (String) inputStream.readObject();

            if ("authenticated".equals(authenticationResponse)) {
                // If authenticated, start listening for new messages
                startListeningForMessages(inputStream);
            } else {
                // If not authenticated, show a toast for authentication error
                showToast("Authentication Error");

                // Close the input stream
                inputStream.close();
            }

            // Close the output stream and the socket
            outputStream.close();
            socket.close();

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void startListeningForMessages(ObjectInputStream inputStream) {
        // Use a separate thread to continuously listen for messages
        new Thread(() -> {
            try {
                while (true) {
                    // Wait for a new message from the server
                    String message = (String) inputStream.readObject();

                    // Process the received message (you can customize this part)
                    processReceivedMessage(message);
                }
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }).start();
    }

    private void processReceivedMessage(String message) {
        // Implement your logic to process the received message
        // For example, display a toast with the received message
        showToast("Received message: " + message);
    }

    private void showToast(final String message) {
        // Use Handler to show toast on the UI thread
        new Handler(Looper.getMainLooper()).post(() ->
                Toast.makeText(App.getContext(), message, Toast.LENGTH_SHORT).show());
    }
}
