package rocha.andre.streaming.models;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import rocha.andre.streaming.models.TitleOmdb;

import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

public class OMDbApiClient {
    private static final String API_KEY = "YOUR_API_KEY";

    public TitleOmdb fetchMovieData(String movieName) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        String movieFormatted = URLEncoder.encode(movieName, StandardCharsets.UTF_8);
        String apiUri = "http://www.omdbapi.com/?t=" + movieFormatted + "&apikey=" + API_KEY;

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(apiUri))
                .build();

        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        String json = response.body();
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .create();

        return gson.fromJson(json, TitleOmdb.class);
    }
}