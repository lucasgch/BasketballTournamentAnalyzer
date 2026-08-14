package org.desviante;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Testes para o cálculo de pontuação individual da classe PlayerGameStats.
 */
public class PlayerGameTest {

    /**
     * Verifica que a pontuação é calculada corretamente a partir de cestas
     * de quadra, cestas de três pontos e lances livres convertidos.
     */
    @Test
    void getPlayerGameScoreCalculatesFromFieldGoalsThreesAndFreeThrows(){
        Game game = new Game(1, "2001-06-06", new Team("Home", "Conference 1"), new Team("Away", "Conference 2"), 1000);
        Player player = new Player("Allen Iverson", 3);

        PlayerGameStats stats = new PlayerGameStats(game, player,18, 3, 9, 2, 3, 6);

        assertEquals(48, stats.getPlayerGameScore());
    }

    /**
     * Verifica que a pontuação é zero quando nenhum arremesso foi convertido,
     * garantindo que a soma não produz valores inesperados no caso limite.
     */
    @Test
    void getPlayerGameScoreIsZeroWhenNoShotsMade() {

        Game game = new Game(1, "2001-06-06", new Team("Home", "Conference 1"), new Team("Away", "Conference 2"), 1000);
        Player player = new Player("Allen Iverson", 3);

        PlayerGameStats stats = new PlayerGameStats(game, player, 0, 0, 0, 0, 0, 0);

        assertEquals(0, stats.getPlayerGameScore());
    }

}