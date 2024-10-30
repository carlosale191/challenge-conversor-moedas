package br.alura.challenge.conversor.moedas.service;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class DataApi {

    public void searchApi(int option, double value) throws IOException, InterruptedException {

        String apiKey = "847c9828d887e71eb0cfa9bb";
        String currency1 = "";
        String currency2 = "";

        switch (option) {
            case 1:
                currency1 = "BRL";
                currency2 = "USD";
                break;
            case 2:
                currency1 = "USD";
                currency2 = "BRL";
                break;
            case 3:
                currency1 = "BRL";
                currency2 = "EUR";
                break;
            case 4:
                currency1 = "EUR";
                currency2 = "BRL";
                break;
            case 5:
                currency1 = "BRL";
                currency2 = "GBP";
                break;
            case 6:
                currency1 = "GBP";
                currency2 = "BRL";
                break;
            case 7:
                currency1 = "BRL";
                currency2 = "JPY";
                break;
            case 8:
                currency1 = "JPY";
                currency2 = "BRL";
                break;
        }


        String apiAddress = "https://v6.exchangerate-api.com/v6/" + apiKey + "/pair/" + currency1 + "/" + currency2;

        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder().uri(URI.create(apiAddress)).build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            String json = response.body();

            JsonObject jsonObject = JsonParser.parseString(json).getAsJsonObject();
            String baseCode = jsonObject.get("base_code").getAsString();
            String targetCode = jsonObject.get("target_code").getAsString();
            double conversionRate = jsonObject.get("conversion_rate").getAsDouble();

            double inputValue = value;
            double convertedValue = inputValue * conversionRate;
            double convertedValueRound = Math.round(convertedValue * 100.0) / 100.0;

            System.out.println("Convertido de " + baseCode);
            System.out.println("Para " + targetCode);
            System.out.println("Taxa de conversão: " + conversionRate);

            System.out.println("Resultado da conversão: " + convertedValueRound);


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }


}
