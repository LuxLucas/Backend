package lista002_obj.exercicio03;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URI;
import java.io.IOException;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class PokemonApi {

    private String urlBase;
    private static final String DEFAULT_BASE_URL = "https://pokeapi.co/api/v2/";

    public PokemonApi (String url){
        setUrlBase(url);
    }

    public PokemonApi (){
        this.urlBase = this.DEFAULT_BASE_URL;
    }

    public void setUrlBase (String url){
        this.urlBase = url;
    }

    public JsonNode get(String path) {
        HttpClient client = HttpClient.newHttpClient();
        ObjectMapper objectMapper = new ObjectMapper();

        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create(this.urlBase + path))
                .header("Accept", "application/json")
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() != 200) {
                throw new RuntimeException("Erro HTTP " + response.statusCode() + ": " + response.body());
            }

            return objectMapper.readTree(response.body());

        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("Falha ao chamar API: " + e.getMessage(), e);
        }
    }

}
