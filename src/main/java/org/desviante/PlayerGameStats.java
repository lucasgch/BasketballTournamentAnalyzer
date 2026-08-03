package org.desviante;

import java.util.ArrayList;
import java.util.List;

public class PlayerGameStats {
    /**
     * The game to which these statistics belong
     */
    Game game;
    /**
     * The player with whom these statistics are associated
     */
    Player player;
    /**
     * The total number of field goals a player scored in a game
     */
    int fieldGoals;
    /**
     * The total number of three-point shots a player made in a game
     */
    int threePoints;
    /**
     * The number of free throws a player scores in a game
     */
    int freeThrows;
    /**
     * The total count of offensive rebounds by a player in a game
     */
    int offensiveRebounds;
    /**
     * The total count of defensive rebounds by a player in a game
     */
    int defensiveRebounds;
    /**
     * The number of assists a player provides in a game
     */
    int assists;

    /**
     * Construtor que cria as estatísticas de um jogador em um jogo
     * @param game Jogo
     * @param player Jogador
     * @param fieldGoals Pontos
     * @param threePoints Pontos de 3
     * @param freeThrows Lances livres
     * @param offensiveRebounds Rebotes ofensivos
     * @param defensiveRebounds Rebotes defensivos
     * @param assists Assistências
     */
    public PlayerGameStats(Game game, Player player, int fieldGoals, int threePoints, int freeThrows, int offensiveRebounds, int defensiveRebounds, int assists) {
        this.game = game;
        this.player = player;
        this.fieldGoals = fieldGoals;
        this.threePoints = threePoints;
        this.freeThrows = freeThrows;
        this.offensiveRebounds = offensiveRebounds;
        this.defensiveRebounds = defensiveRebounds;
        this.assists = assists;
    }

    /**
     * Retorna o Jogador
     * @return Player
     */
    public Player getPlayer() {
        return player;
    }

    public int getOffensiveRebounds() {
        return offensiveRebounds;
    }

    public int getDefensiveRebounds() {
        return defensiveRebounds;
    }

    public int getAssists() {
        return assists;
    }

    /**
     * Obtém a estatística individual de determinado Jogador
     */
    public int getPlayerGameScore(){
        return fieldGoals * 2 + threePoints + freeThrows;
    }

    /**
     * Populate the stats of each game in the PlayerGameStats class
     */
    public static List<PlayerGameStats> populatePlayerGameStats(Game game, List<Player> players, int[][] playerStats) {
        List<PlayerGameStats> playerGameStatsList = new ArrayList<>();

        for (int i = 0; i < players.size(); i++) {
            Player player = players.get(i);
            int[] stats = playerStats[i];
            PlayerGameStats playerStatsData = new PlayerGameStats(
                    game,
                    player,
                    stats[0], // Points
                    stats[1], // Assists
                    stats[2], // Rebounds
                    stats[3], // Steals
                    stats[4], // Blocks
                    stats[5] // Turnovers
            );
            playerGameStatsList.add(playerStatsData);
        }

        return playerGameStatsList;
    }

}
