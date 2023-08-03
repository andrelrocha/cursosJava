package rocha.andre.streaming.main;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import rocha.andre.streaming.exceptions.ErrorConversionException;
import rocha.andre.streaming.models.Title;
import rocha.andre.streaming.models.TitleOmdb;

import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class MainWithSearch {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner scanner = new Scanner(System.in);
        HttpClient client = HttpClient.newHttpClient();

        System.out.println("Qual o nome do filme que você deseja ver as infos?");
        String movie = scanner.nextLine();
        //String movieFormatted = movie.toLowerCase().replace(" ", "-");
        String movieFormatted = URLEncoder.encode(movie, StandardCharsets.UTF_8);
        String apiUri = "http://www.omdbapi.com/?t=" + movieFormatted + "&apikey=6a2c4c22";

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(apiUri))
                .build();

        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        String json = response.body();

        System.out.println(json);

        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .create();
        //Title myTitle = gson.fromJson(json, Title.class);
        TitleOmdb myTitleOmdb = gson.fromJson(json, TitleOmdb.class);
        System.out.printf("My title before: %s", myTitleOmdb);

        try {
            Title myTitle = new Title(myTitleOmdb);
            System.out.printf("My title after: %s", myTitle);
        } catch (NumberFormatException err) {
            System.out.printf("\nSomething has happened: %s", err.getMessage());
        } catch (ErrorConversionException err) {
            System.out.printf("\nSomething has happened, customised:\n%s", err.getMessage());
        }
    }
}
