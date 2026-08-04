package org.desviante;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

import static org.desviante.PlayerGameStats.populatePlayerGameStats;

public class Main {
    static List<Team> teams;

    public static void main(String[] args) {

        // The Main class initializes a static list named games to store Game objects.
        // This list will contain all the games created in the program.
        // It calls createGame() to create and return a list of games.
        List<Game> games = createGame();

        printGameResults(games);
        // Print teams data
        //printTeamsData(teams);

        //printGames(games);



    }

    public static List<Game> createGame() {
        List<Team> teams = createTeams();
        List<Game> games = new ArrayList<>();

        String[] gameDates = {
                "2001-06-06",
                "2001-06-08",
                "2001-06-10",
                "2001-06-13"
        };

        int[]  gameAttendance = {
                18997,
                18997,
                20900,
                20896
        };

        int[][][] playerStatsOfAllGames = {
                {
                        {18, 3, 9, 2, 3, 6},
                        {3, 1, 2, 2, 5, 9},
                        {4, 0, 5, 5, 11, 0},
                        {1, 0, 2, 1, 5, 0},
                        {2, 0, 0, 0, 0, 0},
                        {7, 0, 1, 0, 3, 5},
                        {17, 0, 10, 6, 14, 5},
                        {7, 3, 2, 1, 6, 5},
                        {3, 0, 2, 4, 1, 0},
                        {0, 0, 0, 0, 0, 1}
                },
                {
                        {10, 3, 0, 0, 4, 3},
                        {6, 2, 0, 4, 2, 6},
                        {5, 0, 6, 4, 9, 1},
                        {1, 0, 0, 1, 4, 0},
                        {1, 1, 0, 0, 3, 0},
                        {11, 1, 8, 1, 7, 6},
                        {12, 0, 4, 8, 12, 9},
                        {5, 2, 2, 0, 0, 3},
                        {0, 0, 0, 1, 5, 2},
                        {2, 0, 2, 2, 3, 2}
                },
                {
                        {12, 3, 10, 2, 10, 4},
                        {9, 0, 5, 5, 7, 0},
                        {2, 0, 1, 1, 5, 8},
                        {1, 0, 0, 0, 2, 0},
                        {1, 1, 0, 0, 1, 0},
                        {13, 0, 6, 0, 6, 3},
                        {11, 0, 8, 3, 9, 3},
                        {2, 0, 3, 1, 1, 2},
                        {2, 0, 0, 3, 4, 1},
                        {1, 0, 1, 0, 0, 2}
                },
                {
                        {12, 1, 10, 1, 3, 4},
                        {9, 0, 1, 3, 6, 0},
                        {1, 0, 3, 0, 3, 2},
                        {3, 0, 1, 2, 5, 1},
                        {0, 0, 0, 1, 2, 1},
                        {6, 0, 7, 2, 8, 9},
                        {1, 0, 8, 8, 6, 5},
                        {4, 2, 0, 0, 1, 1},
                        {2, 1, 2, 0, 1, 4},
                        {1, 0, 0, 0, 5, 0}
                }
        };

        for (int i = 0; i < gameDates.length; i++) {
            int gameNumber = i+1;
            String date = gameDates[i];
            Team homeTeam = teams.getFirst();
            Team awayTeam = teams.getLast();
            int attendance = gameAttendance[i];
            Game game = new Game(gameNumber, date, homeTeam, awayTeam, attendance);
            int[][] homeStats = Arrays.copyOfRange(playerStatsOfAllGames[i], 0, 5);
            int[][] awayStats = Arrays.copyOfRange(playerStatsOfAllGames[i], 5, 10);
            List<PlayerGameStats> homePlayerStats = PlayerGameStats.populatePlayerGameStats(game, homeTeam.getPlayers(), homeStats);
            for (PlayerGameStats playerGameStats : homePlayerStats) {
                game.addPlayerGameStats(playerGameStats);
            }
            List<PlayerGameStats> awayPlayerStats = PlayerGameStats.populatePlayerGameStats(game, awayTeam.getPlayers(), awayStats);
            for (PlayerGameStats playerGameStats : awayPlayerStats) {
                game.addPlayerGameStats(playerGameStats);
            }
            games.add(game);
        }

        return games;
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
        createPlayers();

        return teams;  // Return the list of teams
    }

    public static void createPlayers() {

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

        for (int i = 0; i < teams.size(); i++) {
            Team team = teams.get(i);
            List<Player> teamPlayers = Player.populatePlayer(playerData, i);
            for (Player player : teamPlayers) {
                team.addPlayer(player);
            }
        }
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

    public static void printGameResults(List<Game> games){
        for (Game game : games) {
            game.gameSummary();
            // TODO
            game.highestScorer();
        }
    }


}

