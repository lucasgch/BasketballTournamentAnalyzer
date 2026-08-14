package org.desviante;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameTest {

    @Test
    void getWinningTeamReturnsTeamWithHigherScore() {
        // Arrange: monta o cenário
        Team home = new Team("Home", "Conference 1");
        Team away = new Team("Away", "Conference 2");
        Player homePlayer = new Player("Home Player", 1);
        Player awayPlayer = new Player("Away Player", 2);
        home.addPlayer(homePlayer);
        away.addPlayer(awayPlayer);

        Game game = new Game(1, "2024-01-01", home, away, 1000);
        game.addPlayerGameStats(new PlayerGameStats(game, homePlayer, 10, 0, 0, 0, 0, 0)); // 20 pontos
        game.addPlayerGameStats(new PlayerGameStats(game, awayPlayer, 5, 0, 0, 0, 0, 0));  // 10 pontos

        // Act: executa o que está sendo testado
        Team winner = game.getWinningTeam();

        // Assert: verifica se o resultado é o esperado
        assertEquals(home, winner);
    }

}
