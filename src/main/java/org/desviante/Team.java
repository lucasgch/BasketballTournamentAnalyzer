package org.desviante;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Classe que define um time
 */
public class Team {
    /**
     * Nome do jogador
     */
    private String name;
    /**
     * Nome da conferência do time
     */
    private String conference;
    /**
     * Lista de jogadores do time
     */
    private List<Player> players;

    /**
     * Construtor que cria um time com um Nome, Conferência e lista vazia de jogadores
     * @param name do time
     * @param conference do time
     */
    public Team(String name, String conference) {
        this.name = name;
        this.conference = conference;
        players = new ArrayList<>();
    }

    /**
     * Retorna o nome do time
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Retorna o nome da conferência do time
     * @return conference
     */
    public String getConference() {
        return conference;
    }

    /**
     * Popular uma lista de times a partir dos dados dos times
     * @param teamData Array de Strings contendo:
     *      data[0]: Nome do time
     *      data[1]: Nome da conferência do time
     * @return Lista de times criados
     */
    public static List<Team> populateTeams(String[][] teamData) {
        List<Team> teams = new ArrayList<>();
        for (String[] data : teamData) {
            String name = data[0];
            String conference = data[1];
            Team team = new Team(name, conference);
            teams.add(team);
        }
        return teams;
    }



    /**
     * Retorna uma lista de jogadores do time
     * @return Lista de Jogadores
     */
    public List<Player> getPlayers() {
        return players;
    }

    /**
     * Adiciona um jogador ao time
     * @param player
     */
    public void addPlayer(Player player){
        this.players.add(player);
    }

    /**
     * Imprime os dados do time com nome, conferência e lista de jogadores
     * @param homeTeam
     */
    public static void printTeamData(Team homeTeam) {
        System.out.println(("-").repeat(55));
        System.out.printf("Team name: %s, Conference: %s%n", homeTeam.name, homeTeam.conference);
        System.out.println(("-").repeat(55));
        for (Player player : homeTeam.players) {
            player.printPlayer();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Team team = (Team) o;
        return Objects.equals(name, team.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    /**
     * Converte o objeto time para string no formato Team name: Conference:
     * @return String contendo o nome do time e a conferência
     */
    @Override
    public String toString() {
        return "Team name: " + name;
    }
}
