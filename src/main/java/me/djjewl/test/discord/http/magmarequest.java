package me.djjewl.test.discord.http;

import com.google.gson.JsonParser;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class magmarequest {
    public static String mvrequest(String args)
    {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.magmafoundation.org/api/v2/"+args+"/latest"))
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();

        HttpResponse<String> response = null;
        try {
            response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return(response.body());

    }
}


