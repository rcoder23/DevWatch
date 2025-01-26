package org.example;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        ErrorTrackerClient tracker = new ErrorTrackerClient("http://localhost:8080/api/errors");

        try {
            // Simulate an exception
            int result = 10 / 0;
        } catch (Exception e) {
            tracker.captureException(e); // Send the exception to the error tracker
        }
    }
}