package org.desviante;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe que define um jogador
 */
public class Player {
    /**
     * Define o nome do Jogador
     */
    private String name;
    /**
     * Define o número do Jogador
     */
    private int number;

    /**
     * Construtor que cria um jogador a partir do Nome e Número
     * @param name Nome do jogador
     * @param number Número do jogador
     */
    public Player(String name, int number) {
        this.name = name;
        this.number = number;
    }

    /**
     * Obtém o nome do jogador
     * @return Nome do Jogador
     */
    public String getName() {
        return name;
    }

    /**
     * Obtém o número do jogador
     * @return Número do Jogador
     */
    public int getNumber() {
        return number;
    }

    /**
     * Popular uma lista de Jogadores a partir dos dados dos jogadores e número do time
     * @param playerData Array de strings contendo os dados dos jogadores
     * Contendo:
     *      data[0] o índice do time do qual serão selecionados os jogadores
     *      data[1] o nome de cada jogador do time selecionado
     *      data[2] o número de cada jogador do time selecionado
     * @param teamCounter Número do time
     * @return Lista de jogadores
     */
    public static List<Player> populatePlayer(String[][] playerData, int teamCounter) {
        List<Player> players = new ArrayList<>();
        for (String[] data : playerData) {
            // Only process players that belong to the current team
            if (Integer.parseInt(data[0]) == teamCounter) {
                String name = data[1];                    // Name is at index 1
                int number = Integer.parseInt(data[2]);   // Number is at index 2

                Player player = new Player(name, number);
                players.add(player);
            }
        }
        return players;
    }

    /**
     * Imprime um jogador com nome e número
     */
    public void printPlayer() {
        System.out.printf("--- Player Name: %s, Player Number: %d%n", this.getName(), this.getNumber());
    }
}
