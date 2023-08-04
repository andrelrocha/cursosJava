package rocha.andre.streaming.main;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import rocha.andre.streaming.models.Address;
import rocha.andre.streaming.models.AddressConsultaCep;

public class MainChallenge {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner scanner = new Scanner(System.in);
        HttpClient client = HttpClient.newHttpClient();
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();

        List<Address> addresses = new ArrayList<>();

        System.out.println("Caso deseje sair, digite 1");

        while(true) {
            System.out.println("Digite o CEP: ");
            String cepInput = scanner.nextLine();

            if(cepInput.equals("1")) {
                break;
            }

            String addressFormatted = cepInput.replaceAll("[^0-9]", "");

            String apiUri = "https://viacep.com.br/ws/" + addressFormatted + "/json/";
            
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(apiUri))
                    .build();

            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            String json = response.body();

            AddressConsultaCep address = gson.fromJson(json, AddressConsultaCep.class);

            Address addressUser = new Address(address);

            try {
                addresses.add(addressUser);
            } catch (NumberFormatException err) {
                System.out.printf("\nSomething has happened: %s", err.getMessage());
            } catch (Exception e) {
                System.out.printf("\nSomething has happened: %s", e.getMessage());
            }

            try (FileWriter file = new FileWriter("addresses.json")) {
                gson.toJson(addresses, file);
            } catch (Exception e) {
                System.out.printf("\nSomething has happened: %s", e.getMessage());
            }
            
        }
    }
}
