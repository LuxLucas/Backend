package lista002_obj.exercicio02;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        SoccerPlayer[] soccerPlayers = new SoccerPlayer[4];
        Arrays.setAll(soccerPlayers, i -> new SoccerPlayer());

        for (SoccerPlayer player : soccerPlayers) {
            System.out.println(player);
        }

        System.out.println(new SoccerPlayer("Lucas", "Flôres", "Zagueiro", "Criciúma", (short) 18));
    }
}

