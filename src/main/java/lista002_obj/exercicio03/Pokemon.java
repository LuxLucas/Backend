package lista002_obj.exercicio03;

import java.util.Random;
import java.util.List;
import java.util.ArrayList;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.JsonNode;

public class Pokemon {

    private short level;
    private int experience;
    private String name;
    private String growRate;
    private List<String> types = new ArrayList<>();
    private List<String> habilities = new ArrayList<>();

    private static final PokemonApi API = new PokemonApi();
    private static final short NUMBER_OF_POKEMONS = 1025;
    private static final Random RANDOM = new Random();

    public Pokemon( String name, 
                    List<String> types, 
                    int experience, 
                    short level, 
                    String growRate, 
                    List<String> habilities ) {

        setName(name);
        setTypes(types);
        setExperience(experience);
        setLevel(level);
        setGrowRate(growRate);
        setHabilities(habilities);
    }

    private Pokemon(String name, 
                    String types, 
                    int experience, 
                    String growRate,
                    String[] habilities ) {
        
    }

    private static JsonNode searchPokemonById(short id){
        return API.get("pokemon/%d".formatted(id));
    }

    public static Pokemon random() {
        short randomId = (short) RANDOM.nextInt(NUMBER_OF_POKEMONS);

        JsonNode informationsOfPokemon = searchPokemonById(randomId);
        String name = informationsOfPokemon.get("name").asText();

        ArrayNode nodeTypes = (ArrayNode) informationsOfPokemon.get("types");
        for(JsonNode node: nod;eTypes){
            
        }
    }

    public void setLevel(short level) {
        this.level = level;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTypes(List<String> types) {
        this.types = types;
    }

    public void setGrowRate(String growRate) {
        this.growRate = growRate;
    }

    public void setHabilities(List<String> habilities) {
        this.habilities = habilities;
    }

    public short getLevel() {
        return level;
    }

    public int getExperience() {
        return experience;
    }

    public String getName() {
        return name;
    }

    public List<String> getTypes() {
        return types;
    }

    public String getGrowRate() {
        return growRate;
    }

    public List<String> getHabilities() {
        return habilities;
    }
}
