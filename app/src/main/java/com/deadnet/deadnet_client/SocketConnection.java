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

            // Send an instance of Socket (this class) to the server
            outputStream.writeObject(this);

            // Close the output stream
            outputStream.close();

            // Close the socket
            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // Example usage:
        SocketConnection socketConnection = new SocketConnection("123456", 5678, "John Doe");
        socketConnection.connectToServer("127.0.0.1", 8080);
    }
}
