package org.desviante;

import java.util.ArrayList;
import java.util.List;

import static org.desviante.Main.teams;

public class Team {
    private String name;
    private String conference;
    List<Player> players;

    public Team(String name, String conference) {
        this.name = name;
        this.conference = conference;
        players = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getConference() {
        return conference;
    }

    public static List<Team> populateTeams(String[][] teamData) {
        List<Team> teams = new ArrayList<>();
        for (String[] data : teamData) {
            String name = data[0];
            String conference = data[1];
            Team team = new Team(name, conference);
            teams.add(team);
        }
        return teams;
    }

    public void addPlayer(Player player){
        players.add(player);
    }

    public void printTeamData() {
        System.out.println(("-").repeat(55));
        System.out.printf("Team name: %s, Conference: %s%n", this.name, this.conference);
        System.out.println(("-").repeat(55));
        for (Player player : this.players) {
            player.printPlayer();
        }
    }
}
