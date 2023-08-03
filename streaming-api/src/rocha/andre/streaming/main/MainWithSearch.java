package rocha.andre.streaming.main;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import rocha.andre.streaming.exceptions.ErrorConversionException;
import rocha.andre.streaming.models.Title;
import rocha.andre.streaming.models.TitleOmdb;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainWithSearch {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner scanner = new Scanner(System.in);
        HttpClient client = HttpClient.newHttpClient();

        List<Title> titles = new ArrayList<>();

        System.out.println("Caso deseje sair, digite 1");

        while (true) {
            System.out.println("Qual o nome do filme que você deseja ver as infos?");
            String movie = scanner.nextLine();

            if (movie.equals("1")) {
                break;
            }

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
                titles.add(myTitle);

                //FileWriter fileWriter = new FileWriter("movies.txt");
                //fileWriter.write(myTitle.toString());
                //fileWriter.close();
            } catch (NumberFormatException err) {
                System.out.printf("\nSomething has happened: %s", err.getMessage());
            } catch (ErrorConversionException err) {
                System.out.printf("\nSomething has happened, customised:\n%s", err.getMessage());
            }
        }


        for (Title title : titles) {
            try (FileWriter fileWriter = new FileWriter("movies.txt", true); // 'true' to enable append mode
                 BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {

                bufferedWriter.newLine();
                bufferedWriter.write(title.toString());
            } catch (IOException e) {
                System.out.println("Failed to write to the file: " + e.getMessage());
            }
        }

    }
}
