package me.djjewl.main.discord.http;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import org.bukkit.Bukkit;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.logging.Level;

public class magmarequest {

    public static JsonElement mvrequest(String args)
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
        JsonElement Output = JsonParser.parseString(response.body());
        if (!Output.isJsonObject()) {
            Bukkit.getLogger().log(Level.SEVERE, "API call Not A JSON");
        }
        return (Output);
    }
}


