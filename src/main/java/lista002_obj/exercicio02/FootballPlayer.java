package lista002_obj.exercicio02;

public class FootballPlayer {
    private short age;
    private String firstName, lastName, position, team;
    private static final String[] positions = {
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

    public FootballPlayer(String firstName,
                          String lastName,
                          String position,
                          String team,
                          short age){

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

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setAge(short age) {
        this.age = age;
    }
}
