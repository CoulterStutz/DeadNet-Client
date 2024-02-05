package com.deadnet.deadnet_client;

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

            // Send the formatted string VIN::RacerPin to the server
            String formattedData = VIN + "::" + RacerPin;
            outputStream.writeObject(formattedData);

            // Close the output stream
            outputStream.close();

            // Close the socket
            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
