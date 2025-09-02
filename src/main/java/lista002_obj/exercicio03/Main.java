package lista002_obj.exercicio03;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URI;
import java.util.Random;

public class Main {

    public static void main(String[] args){

        short limitOfPokemons = 5;
        short maxOffset = (short) (1025 - limitOfPokemons);
        Random random = new Random();
        short randomOffset = (short) random.nextInt(maxOffset);

        String uriApi = "https://pokeapi.co/api/v2/pokemon/";
        String parameters = String.format("?limit=%d&offset=%d", limitOfPokemons, randomOffset);
        String uriRequest = uriApi + parameters;

        HttpRequest request = HttpRequest.newBuilder()
        .GET()
        .uri(URI.create(uriRequest))
        .build();
    }
}
