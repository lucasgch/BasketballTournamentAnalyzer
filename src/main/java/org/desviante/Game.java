package org.desviante;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Game {
    private final int gameNumber;
    private final String date;
    private final Team homeTeam;
    private final Team awayTeam;
    private final int attendance;
    private final List<PlayerGameStats> playerGameStats;

    public Game(int gameNumber, String date, Team homeTeam, Team awayTeam, int attendance) {
        this.gameNumber = gameNumber;
        this.date = Objects.requireNonNull(date, "Date cannot be null");
        this.homeTeam = Objects.requireNonNull(homeTeam, "Home team cannot be null");
        this.awayTeam = Objects.requireNonNull(awayTeam, "Away team cannot be null");
        this.attendance = attendance;
        this.playerGameStats = new ArrayList<>();
    }

    // Getters
    public int getGameNumber() {
        return gameNumber;
    }

    public String getDate() {
        return date;
    }

    public Team getHomeTeam() {
        return homeTeam;
    }

    public Team getAwayTeam() {
        return awayTeam;
    }

    public int getAttendance() {
        return attendance;
    }

    public List<PlayerGameStats> getPlayerGameStats() {
        return Collections.unmodifiableList(playerGameStats);
    }

    // Helper method to add player stats safely
    public void addPlayerGameStats(PlayerGameStats stats) {
        if (stats != null) {
            this.playerGameStats.add(stats);
        }
    }


        public static List<Game> populateGames(List<Team> teams, String[][] gameData) {
            List<Game> games = new ArrayList<>();
            for (String[] data : gameData) {
                int gameNumber = Integer.parseInt(data[0]); // Game number
                String date = data[1]; // Game date
                Team homeTeam = teams.get(Integer.parseInt(data[2])); // Get home team
                Team awayTeam = teams.get(Integer.parseInt(data[3])); // Get away team
                int attendance = Integer.parseInt(data[4]); // Attendance
                // Create and add game to list
                Game game = new Game(gameNumber, date, homeTeam, awayTeam, attendance);
                games.add(game);
            }
            return games;
        }

    public void printGameDetails() {
        System.out.println("Game #" + gameNumber);
        System.out.println("Date: " + date);
        System.out.println("Attendance: " + attendance);

        //System.out.print("Home Team:");
        Team.printTeamData(homeTeam);

        //System.out.print("Away Team:");
        Team.printTeamData(awayTeam);
    }

    @Override
    public String toString() {
        return String.format(
                "Game #%d [%s]%nAttendance: %d%nHome Team: %s%nAway Team: %s",
                gameNumber, date, attendance, homeTeam, awayTeam
        );
    }
}