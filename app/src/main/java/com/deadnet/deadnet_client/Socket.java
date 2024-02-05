package com.deadnet.deadnet_client;

public class Socket {
    private String VIN;
    private int RacerPin;
    public String RacerName;

    public Socket(String VIN, int RacerPin, String RacerName) {
        this.VIN = VIN;
        this.RacerPin = RacerPin;
        this.RacerName = RacerName;
    }
}
