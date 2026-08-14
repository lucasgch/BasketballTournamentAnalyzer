package org.desviante;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayerGameTest {

    @Test
    void getPlayerGameScoreCalculatesFromFieldGoalsThreesAndFreeThrows(){
        Game game = new Game(1, "2001-06-06", new Team("Home", "Conference 1"), new Team("Away", "Conference 2"), 1000);
        Player player = new Player("Allen Iverson", 3);

        PlayerGameStats stats = new PlayerGameStats(game, player,18, 3, 9, 2, 3, 6);

        assertEquals(48, stats.getPlayerGameScore());
    }

    @Test
    void getPlayerGameScoreIsZeroWhenNoShotsMade() {

        Game game = new Game(1, "2001-06-06", new Team("Home", "Conference 1"), new Team("Away", "Conference 2"), 1000);
        Player player = new Player("Allen Iverson", 3);

        PlayerGameStats stats = new PlayerGameStats(game, player, 0, 0, 0, 0, 0, 0);

        assertEquals(0, stats.getPlayerGameScore());
    }

}