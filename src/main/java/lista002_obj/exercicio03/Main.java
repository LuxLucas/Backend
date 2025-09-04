package lista002_obj.exercicio03;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URI;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;

public class Main {

    public static void main(String[] args) {
    String uri = "https://pokeapi.co/api/v2/"; 
    HttpClient client = HttpClient.newBuilder().build();

    HttpRequest request = HttpRequest.newBuilder()
        .GET()
        .uri(URI.create(uri + "pokemon/"))
        .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(response.body());
            
            ArrayNode jsonArray = (ArrayNode) objectMapper.readTree("results").get("results");
            for(JsonNode json: jsonArray){
                System.out.println(json.get("name").asText());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
