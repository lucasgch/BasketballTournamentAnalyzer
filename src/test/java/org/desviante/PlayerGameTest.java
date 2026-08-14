package org.desviante;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

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

    /**
     * Verifica o cálculo de pontuação contra várias linhas de estatísticas reais,
     * copiadas do box score do Jogo 1 das Finais da NBA de 2001 (Basketball Reference).
     */
    @ParameterizedTest(name = "{0} cestas + {1} de três + {2} lances livres = {3} pontos")
    @CsvFileSource(resources = "/player-game-scores.csv", numLinesToSkip = 1)
    void getPlayerGameScoreCalculatesFromVariousStatLines(int fieldGoals, int threePoints, int freeThrows, int expectedScore) {
        Game game = new Game(1, "2001-06-06", new Team("Home", "Conference 1"), new Team("Away", "Conference 2"), 1000);
        Player player = new Player("Test Player", 1);

        PlayerGameStats stats = new PlayerGameStats(game, player, fieldGoals, threePoints, freeThrows, 0, 0, 0);

        assertEquals(expectedScore, stats.getPlayerGameScore());
    }

}