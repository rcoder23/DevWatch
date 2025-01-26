package org.example;

public class Main {
    public static void main(String[] args) {
        // Initialize the SDK client
        ErrorTrackerClient tracker = new ErrorTrackerClient("http://localhost:8080/api/errors");
        try {
            // Simulate an exception
            int result = 10 / 0;
        } catch (Exception e) {
            tracker.captureException(e); // Send the exception to the error tracker
        }
    }
}