package org.desviante;

import java.util.*;

//TODO
public class Tournament {
    /**
     * The name of the tournament
     */
    String name;
    /**
     * Represents the tournament’s season, typically the year it takes place
     */
    String season;
    /**
     * MVP: The most valuable player of the tournament
     */
    Player mvp;
    /**
     * A list of teams participating in the tournament
     */
    ArrayList<Team> teams;
    /**
     * A list of games played during the tournament
     */
    static ArrayList<Game> games;

    public Tournament(String name, String season) {
        this.name = name;
        this.season = season;
        this.teams = new ArrayList<>();
        this.games = new ArrayList<>();
    }

    // Getters and setters
    public void addTeam(Team team) {
        teams.add(team);
    }

    public List<Team> getTeams() {
        return teams;
    }

    public String getName() {
        return name;
    }

    public void addGame(Game game) {
        games.add(game);
    }

    public static List<Game> getGames() {
        return games;
    }

    public void setMvp(Player player) {
        this.mvp = player;
    }

    public Player highestScorer(List<Game> games2) {
        Map<Player, Integer> playerScores = new HashMap<>();

        // Aggregate scores for all players
        for (Game game1 : games2) {
            for (PlayerGameStats stats : game1.getPlayerGameStats()) {
                Player player = stats.getPlayer();
                int playerScore = stats.getPlayerGameScore();

                if (playerScores.containsKey(player)) {
                    playerScore += playerScores.get(player);
                }
                playerScores.put(player, playerScore);
            }
        }

        // Find the player with the highest score
        Player hScorer = null;
        int highestScore = Integer.MIN_VALUE;
        for (Map.Entry<Player, Integer> entry : playerScores.entrySet()) {
            int value = entry.getValue();
            if (value > highestScore) {
                highestScore = value;
                hScorer = entry.getKey();
            }
        }
        setMvp(hScorer);
        return hScorer;
    }

    // Method to get MVP stats
    public Map<String, String> mvpStats(ArrayList<Game> games) {
        Map<String, String> stats = new LinkedHashMap<>();
        int totalGamesPlayed = 0;
        int totalPointsScored = 0;
        int totalRebounds = 0;
        int totalAssists = 0;
        String playerName = "";

        for (Game game : games) {
            for (PlayerGameStats gameStats : game.getPlayerGameStats()) {
                Player player = gameStats.getPlayer();
                if (player.equals(mvp)) {
                    totalGamesPlayed++;
                    int points = gameStats.getPlayerGameScore();
                    totalPointsScored += points;
                    int oRebounds = gameStats.getOffensiveRebounds();
                    int dRebounds = gameStats.getDefensiveRebounds();
                    totalRebounds += oRebounds + dRebounds;
                    totalAssists += gameStats.getAssists();
                    playerName = player.getName();
                }
            }
        }

        System.out.println("-------------------------------------------------------");
        stats.put("MVP Player", playerName);
        stats.put("Total Rebounds", String.valueOf(totalRebounds));
        stats.put("Total Assists", String.valueOf(totalAssists));
        stats.put("Total Games Played", String.valueOf(totalGamesPlayed));
        stats.put("Total Points Scored", String.valueOf(totalPointsScored));

        return stats;
    }
}