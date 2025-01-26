package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class ErrorTrackerClient {
    private final String apiEndpoint;
    private final ObjectMapper objectMapper = new ObjectMapper(); // Jackson for JSON serialization

    public ErrorTrackerClient(String apiEndpoint) {
        this.apiEndpoint = apiEndpoint;
    }

    public void captureException(Exception exception) {
        try {
            // Prepare the payload object
            ErrorPayload payload = new ErrorPayload(
                    exception.getMessage(),
                    getStackTraceAsString(exception)
            );

            // Serialize the payload to JSON using Jackson
            String jsonPayload = objectMapper.writeValueAsString(payload);

            // Open a connection to the API
            URL url = new URL(apiEndpoint);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setDoOutput(true);

            // Write the JSON payload to the output stream
            try (OutputStream os = connection.getOutputStream()) {
                os.write(jsonPayload.getBytes());
                os.flush();
            }

            // Check the response code (for debugging/logging purposes)
            int responseCode = connection.getResponseCode();
            System.out.println("Response Code: " + responseCode);
        } catch (Exception e) {
            System.err.println("Failed to send error to tracker: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private String getStackTraceAsString(Exception exception) {
        StringBuilder sb = new StringBuilder();
        for (StackTraceElement element : exception.getStackTrace()) {
            sb.append(element.toString()).append("\n");
        }
        return sb.toString();
    }

    // A simple class to represent the error payload
    static class ErrorPayload {
        private final String message;
        private final String stackTrace;

        public ErrorPayload(String message, String stackTrace) {
            this.message = message;
            this.stackTrace = stackTrace;
        }

        public String getMessage() {
            return message;
        }

        public String getStackTrace() {
            return stackTrace;
        }
    }

}
