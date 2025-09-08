package lista002_obj.exercicio03;

import com.fasterxml.jackson.databind.JsonNode;

public class Main {

    public static void main(String[] args) {
        String uri = "https://pokeapi.co/api/v2/"; 

        PokemonApi api = new PokemonApi(uri);
        JsonNode jsonNode = api.get("pokemon-species/1025");
        System.out.println(jsonNode.toString());
    }
}
