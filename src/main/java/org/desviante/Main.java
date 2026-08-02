package org.desviante;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.List;
import java.util.ArrayList;

public class Main {
    public static List<Team> teams = new ArrayList<>();
    public static List<Game> games = new ArrayList<>();

    public static void main(String[] args) {
        List<Team> teams = createTeams();

        // Print teams data
        printTeamsData(teams);

        games = createGame(teams);

        printGames(games);

    }

    public static List<Team> createTeams() {

        // Define team data
        String[][] teamData = {
                {"Philadelphia 76ers", "Conference 1"},
                {"Los Angeles Lakers", "Conference 2"}
        };

        // Populate teams
        teams = Team.populateTeams(teamData);

        // Create players for each team
        List<Player> player = createPlayers();

        return teams;  // Return the list of teams
    }

    public static List<Player> createPlayers() {

        List<Player> players = new ArrayList<>();

        // Data for creating players
        String[][] playerData = {
                {"0", "Allen Iverson", "1"},
                {"0", "Aaron McKie", "2"},
                {"0", "Dikembe Mutombo", "3"},
                {"0", "Tyrone Hill", "4"},
                {"0", "Jumaine Jones", "5"},
                {"1", "Kobe Bryant", "6"},
                {"1", "Shaquille O'Neal", "7"},
                {"1", "Rick Fox", "8"},
                {"1", "Horace Grant", "9"},
                {"1", "Derek Fisher", "10"}
        };

        // Populate players into the teams
        int teamCounter = 0;
        for (Team team : teams) {
            List<Player> teamPlayers = Player.populatePlayer(playerData, teamCounter);  // Get players for the team
            for (Player player : teamPlayers) {
                team.addPlayer(player);  // Add players to the team
            }
            teamCounter++;
        }
        return players;
    }

    public static List<Game> createGame(List<Team> teams){
        // Define game data
        String[][] gameData = {
                {String.valueOf(1), "2001-06-06", "0", "1", String.valueOf(18997)}
        };
        games = Game.populateGames(teams, gameData);
        return games;
    }


    // Method to print teams data
    public static void printTeamsData(List<Team> teams) {
        for (Team team : teams) {
            System.out.println("-".repeat(56));
            System.out.println(team.toString());
            System.out.println("-".repeat(56));
            team.players.forEach(Player::printPlayer);
        }
    }

    public static void printGames (List<Game> games){
        for (Game game : games) {
            game.printGameDetails();
        }
    }
}

