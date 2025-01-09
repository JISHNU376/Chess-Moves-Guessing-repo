package com.example.demo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SensorInputSimulator {
    private String filePath;

    public SensorInputSimulator(String filePath) {
        this.filePath = filePath;
    }

    public String getNextSensorInput() {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String sensorInput;
            while ((sensorInput = reader.readLine()) != null) {
                return sensorInput; // Return the first input from the file
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "No input available";
    }

    public static void main(String[] args) {
        // Simulated file with sensor inputs
        String filePath = "sensor_data.txt";
        SensorInputSimulator sensorInput = new SensorInputSimulator(filePath);

        String nextInput = sensorInput.getNextSensorInput();
        System.out.println("Sensor Input: " + nextInput);
    }
}
