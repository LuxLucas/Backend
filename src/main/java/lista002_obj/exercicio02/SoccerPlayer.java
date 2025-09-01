package lista002_obj.exercicio02;

import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class SoccerPlayer {

    private static final short RETIREMENT_AGE   = 65;
    private static final short MINIMUM_AGE      = 16;

    private short age;
    private String firstName, lastName, position, team;
    private static Random random = new Random();

    private static final String[] FIRST_NAMES = {
        "Lionel",
        "Cristiano",
        "Vinicius",
        "Erling",
        "Kylian",
        "Luka",
        "Rodrigo",
        "Harry",
        "Lautaro",
        "Florian",
        "Lucas"
    };
    private static final String[] LAST_NAMES = {
        "Messi",
        "Ronaldo",
        "Júnior",
        "Haaland",
        "Mbappé",
        "Modrić",
        "Hernández",
        "Kane",
        "Martínez",
        "Wirtz",
        "Flôres"
    };
    private static final String[] POSITIONS = {
        "Goleiro",
        "Lateral",
        "Zagueiro",
        "Líbero",
        "Volante",
        "Meia-lateral",
        "Meia-central",
        "Meia-armador",
        "Ponta",
        "Segundo atacante",
        "Centroavante"
    };
    private static final String[] TEAMS = {
        "Flamengo",
        "Palmeiras",
        "Corinthians",
        "São Paulo",
        "Grêmio",
        "Internacional",
        "Botafogo",
        "Fluminense",
        "Cruzeiro",
        "Atlético Mineiro",
        "Santos",
        "Criciúma"
    };

    public SoccerPlayer(){
        firstName   = randomFirstName();
        lastName    = randomLastName();
        position    = randomPosition();
        team        = randomTeam();
        age         = randomAge();
    }
    
    public SoccerPlayer(String firstName,
                        String lastName,
                        String position,
                        String team,
                        short age){

        setFirstName(firstName);
        setLastName(lastName);
        setPosition(position);
        setTeam(team);
        setAge(age);
    }

    public String getTeam() {
        return team;
    }

    public String getPosition() {
        return position;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public short getAge() {
        return age;
    }

    private boolean isValidString(String word){
        return !word.isEmpty() && !word.isBlank();
    }

    private boolean isValidPosition(String position){
        if(isValidString(position)){  
            for(String p: POSITIONS){
                if(p.equalsIgnoreCase(position)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isValidAge(short age){
        return age > MINIMUM_AGE && age < RETIREMENT_AGE;
    }

    private <T> void setProperty(T value, Consumer<T> setter, Predicate<T> validate){
        if(!validate.test(value)){
            throw new IllegalArgumentException(String.format("Valor indevido: '%s'.", value));
        }
        setter.accept(value);
    }

    public void setFirstName(String firstName) {
        setProperty(firstName, v -> this.firstName = v, this::isValidString);
    }

    public void setLastName(String lastName) {
        setProperty(lastName, v -> this.lastName = v, this::isValidString);
    }

    public void setTeam(String team) {
        setProperty(team, v -> this.team = v, this::isValidString);
    }

    public void setPosition(String position) {
        setProperty(position, v -> this.position = v, this::isValidPosition);
    }

    public void setAge(short age) {
        setProperty(age, v -> this.age = v, this::isValidAge);
    }

    private static <T> T randomProperty(T[] array){
        int length = array.length;
        return array[random.nextInt(length)];
    }

    private static String randomFirstName(){
        return randomProperty(FIRST_NAMES);
    }

    private static String randomLastName(){
        return randomProperty(LAST_NAMES);
    }

    private static String randomPosition(){
        return randomProperty(POSITIONS);
    }

    private static String randomTeam(){
        return randomProperty(TEAMS);
    }

    private static short randomAge(){
        return (short) random.nextInt(MINIMUM_AGE, RETIREMENT_AGE +1);
    }

    public static SoccerPlayer createRandom(){
        return new SoccerPlayer(
            randomFirstName(),
            randomLastName(),
            randomPosition(),
            randomTeam(),
            randomAge()
        );
    }

    @Override
    public String toString(){
        return String.format("""
        {
            firstName: %s,
            lastName: %s,
            position: %s,
            team: %s,
            age: %d
        }
                """, firstName, lastName, position, team, age);
    }
}
