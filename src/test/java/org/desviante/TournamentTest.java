package org.desviante;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Testes para os cálculos agregados do torneio: vencedor e maior pontuador.
 */
public class TournamentTest {

    /**
     * Verifica que o time com mais vitórias entre os jogos do torneio
     * é retornado como vencedor.
     */
    @Test
    void getTournamentWinnerReturnsTeamWithMostWins() {
        Team teamA = new Team("Team A", "Conference 1");
        Team teamB = new Team("Team B", "Conference 2");
        Player playerA = new Player("Player A", 1);
        Player playerB = new Player("Player B", 2);
        teamA.addPlayer(playerA);
        teamB.addPlayer(playerB);

        Tournament tournament = new Tournament("Test Tournament", "2024");

        Game game1 = new Game(1, "2024-01-01", teamA, teamB, 1000);
        game1.addPlayerGameStats(new PlayerGameStats(game1, playerA, 10, 0, 0, 0, 0, 0)); // 20 pts
        game1.addPlayerGameStats(new PlayerGameStats(game1, playerB, 5, 0, 0, 0, 0, 0));  // 10 pts
        tournament.addGame(game1);

        Game game2 = new Game(2, "2024-01-03", teamA, teamB, 1000);
        game2.addPlayerGameStats(new PlayerGameStats(game2, playerA, 8, 0, 0, 0, 0, 0));  // 16 pts
        game2.addPlayerGameStats(new PlayerGameStats(game2, playerB, 3, 0, 0, 0, 0, 0));  // 6 pts
        tournament.addGame(game2);

        assertEquals(teamA, tournament.getTournamentWinner());
    }

    /**
     * Verifica que o jogador com a maior soma de pontos, somando as
     * estatísticas de todos os jogos do torneio, é retornado como maior pontuador.
     */
    @Test
    void highestScorerReturnsPlayerWithMostTotalPoints() {
        Team teamA = new Team("Team A", "Conference 1");
        Team teamB = new Team("Team B", "Conference 2");
        Player playerA = new Player("Player A", 1);
        Player playerB = new Player("Player B", 2);
        teamA.addPlayer(playerA);
        teamB.addPlayer(playerB);

        Tournament tournament = new Tournament("Test Tournament", "2024");

        Game game1 = new Game(1, "2024-01-01", teamA, teamB, 1000);
        game1.addPlayerGameStats(new PlayerGameStats(game1, playerA, 10, 0, 0, 0, 0, 0)); // 20 pts
        game1.addPlayerGameStats(new PlayerGameStats(game1, playerB, 5, 0, 0, 0, 0, 0));  // 10 pts
        tournament.addGame(game1);

        assertEquals(playerA, tournament.highestScorer());
    }
}