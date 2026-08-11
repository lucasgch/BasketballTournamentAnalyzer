package org.desviante;

import java.util.*;

//TODO
public class Tournament {
    /**
     * The name of the tournament
     */
    private String name;
    /**
     * Represents the tournament’s season, typically the year it takes place
     */
    private String season;
    /**
     * MVP: The most valuable player of the tournament
     */
    private Player mvp;
    /**
     * A list of teams participating in the tournament
     */
    private ArrayList<Team> teams;
    /**
     * A list of games played during the tournament
     */
    private ArrayList<Game> games;

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

    public List<Game> getGames() {
        return games;
    }

    public String getSeason() {
        return season;
    }

    public Player getMvp() {
        return mvp;
    }

    public void setMvp(Player player) {
        this.mvp = player;
    }

    public Player highestScorer() {
        if (mvp == null) {
            Map<Player, Integer> playerScores = new HashMap<>();
            for (Game game : games) {
                for (PlayerGameStats stats : game.getPlayerGameStats()) {
                    playerScores.merge(stats.getPlayer(), stats.getPlayerGameScore(), Integer::sum);
                }
            }
            Player hScorer = null;
            int highestScore = Integer.MIN_VALUE;
            for (Map.Entry<Player, Integer> entry : playerScores.entrySet()) {
                if (entry.getValue() > highestScore) {
                    highestScore = entry.getValue();
                    hScorer = entry.getKey();
                }
            }
            setMvp(hScorer);
        }
        return mvp;
    }


    // Method to get MVP stats
    public Map<String, String> mvpStats() {
        if (mvp == null) {
            highestScorer();
        }
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

        stats.put("MVP Player", playerName);
        stats.put("Total Rebounds", String.valueOf(totalRebounds));
        stats.put("Total Assists", String.valueOf(totalAssists));
        stats.put("Total Games Played", String.valueOf(totalGamesPlayed));
        stats.put("Total Points Scored", String.valueOf(totalPointsScored));

        return stats;
    }

    public Team getTournamentWinner() {
        // Create a map to count wins for each team
        Map<Team, Integer> teamWins = new HashMap<>();

        // Iterate over games to count wins
        for (Game game : games) {
            Team winningTeam = game.getWinningTeam();
            if (winningTeam != null) {
                teamWins.put(winningTeam, teamWins.getOrDefault(winningTeam, 0) + 1);
            }
        }

        // Find the team with the most wins
        Team potentialWinner = null;
        int maxWins = 0;
        boolean draw = false;

        for (Map.Entry<Team, Integer> entry : teamWins.entrySet()) {
            if (entry.getValue() > maxWins) {
                maxWins = entry.getValue();
                potentialWinner = entry.getKey();
                draw = false; // reset the draw flag
            } else if (entry.getValue() == maxWins) {
                draw = true; // if multiple teams have the same maxWins
            }
        }

        // If there's a draw, no clear winner, return null or some indication of a draw
        if (draw) {
            return null; // Represents a draw
        }

        return potentialWinner; // Returns the team with the most wins if no draw
    }

    public Map<String, String> calculateTournamentStats() {
        Map<String, String> summary = new LinkedHashMap<>();

        Team winner = getTournamentWinner();
        summary.put("Tournament Winner", winner != null ? winner.getName() : "Draw");

        Player scorer = highestScorer();
        summary.put("Highest Scorer", scorer != null ? scorer.getName() : "N/A");

        Map<String, String> mvpData = mvpStats();
        summary.putAll(mvpData); // incorpora MVP, rebotes, assistências etc.

        return summary;
    }

    @Override
    public String toString() {
        return "Tournament:" + name;
    }
}