package com.linkedin.javacodechallenges;

import java.net.URI;
import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;
//import java.net.http.HttpRequest.BodyPublishers;
//import java.nio.file.Paths;
import java.io.IOException;
import java.net.http.HttpClient;
//import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Optional;

/**
 * Hello world!
 */
public class App {

    private static final boolean SHOW_HEADERS = false;
    private static final boolean SHOW_STATUS_CODE = false;
    private static final boolean SHOW_JSON = true;
    private static final HttpClient httpClient = HttpClient.newBuilder()
            .version(HttpClient.Version.HTTP_1_1)
            .build();

    public static HttpResponse<String> getRequest() throws IOException, InterruptedException {
        // This is only meaningful for icanhazdadjoke.com API.
        String returnFormat = App.SHOW_JSON ? "application/json" : "text/plain";
        HttpRequest request = HttpRequest.newBuilder()
                // .uri(URI.create("https://postman-echo.com/get"))
                .uri(URI.create("https://icanhazdadjoke.com/"))
                .GET()
                .setHeader("Accept", returnFormat)
                .build();
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        return response;
    }

    public static Optional<String> parseJoke(String responseBody) {
        /*
         * try {
         * JokeResponse jokeResponse = new Gson().fromJson(responseBody,
         * JokeResponse.class);
         * String joke = jokeResponse.getJoke();
         * if (joke != null) {
         * return Optional.of(jokeResponse.getJoke());
         * }
         * return Optional.empty();
         * } catch (Exception e) {
         * System.out.println("Must be out of jokes for now.");
         * return Optional.empty();
         * }
         */
        return Optional.empty();
    }

    public static void main(String[] args) {
        try {
            HttpResponse<String> response = App.getRequest();
            if (App.SHOW_HEADERS) {
                // Print response headers
                HttpHeaders headers = response.headers();
                System.out.println("Headers:");
                headers.map().forEach((k, v) -> System.out.println(k + ":" + v));
            }

            if (App.SHOW_STATUS_CODE) {
                // Print status code
                System.out.println("Status Code:");
                System.out.println(response.statusCode());
            }

            // This is what we want to see.
            if (!App.SHOW_JSON) {
                System.out.println(response.body());
            } else {
                result = parseJoke(responseBody);
            }
        } catch (Exception e) {
            System.out.println("Exception occurred: " + e.toString());
        }
    }

}
