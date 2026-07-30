package org.desviante;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Game {
    private final int gameNumber;
    private final LocalDate date;
    private final Team homeTeam;
    private final Team awayTeam;
    private final int attendance;
    private final List<PlayerGameStats> playerGameStats;

    public Game(int gameNumber, LocalDate date, Team homeTeam, Team awayTeam, int attendance) {
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

    public LocalDate getDate() {
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

    @Override
    public String toString() {
        return String.format(
                "Game #%d [%s]%nAttendance: %d%nHome Team: %s%nAway Team: %s",
                gameNumber, date, attendance, homeTeam, awayTeam
        );
    }
}