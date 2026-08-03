package org.desviante;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * Classe que define um jogo de basquete
 */
public class Game {
    /**
     * Número do jogo
     */
    private final int gameNumber;
    /**
     * Data do jogo em formato
     */
    private final String date;
    /**
     * Time de casa
     */
    private final Team homeTeam;
    /**
     * Time visitante
     */
    private final Team awayTeam;
    /**
     * Público presente
     */
    private final int attendance;
    /**
     * Lista de estatísticas dos jogadores
     */
    private final List<PlayerGameStats> playerGameStats;

    /**
     * Construtor que cria um jogo a partir dos dados
     *
     * @param gameNumber número do jogo
     * @param date       data do jogo
     * @param homeTeam   time de casa
     * @param awayTeam   time visitante
     * @param attendance público presente
     */
    public Game(int gameNumber, String date, Team homeTeam, Team awayTeam, int attendance) {
        this.gameNumber = gameNumber;
        this.date = Objects.requireNonNull(date, "Date cannot be null");
        this.homeTeam = Objects.requireNonNull(homeTeam, "Home team cannot be null");
        this.awayTeam = Objects.requireNonNull(awayTeam, "Away team cannot be null");
        this.attendance = attendance;
        this.playerGameStats = new ArrayList<>();
    }

    // Getters

    /**
     * Retorna o número do jogo
     *
     * @return gameNumber
     */
    public int getGameNumber() {
        return gameNumber;
    }

    /**
     * Retorna a data do jogo
     *
     * @return date
     */
    public String getDate() {
        return date;
    }

    /**
     * Retorna o time de casa
     *
     * @return homeTeam
     */
    public Team getHomeTeam() {
        return homeTeam;
    }

    /**
     * Retorna o time visitante
     *
     * @return awayTeam
     */
    public Team getAwayTeam() {
        return awayTeam;
    }

    /**
     * Retorna o público presente
     *
     * @return attendance
     */
    public int getAttendance() {
        return attendance;
    }

    /**
     * Retorna a lista com as estatísticas dos jogadores durante o jogo
     *
     * @return
     */
    public List<PlayerGameStats> getPlayerGameStats() {
        return Collections.unmodifiableList(playerGameStats);
    }

    // Helper method to add player stats safely

    // TODO
    public void calculateTeamScore(Team team){
    }

    /**
     * Calculates the scores for both teams in a game
     * It uses calculateTeamScore(Team team) method to compute the score based on PlayerGameStats. This method also determines and prints the scores of both teams.
     */
    public void teamsScore(){

    }

    /**
     * Adicionar as estatísticas de um jogador
     * @param stats
     */
    public void addPlayerGameStats(PlayerGameStats stats) {
        if (stats != null) {
            this.playerGameStats.add(stats);
        }
    }

    /**
     * Popular uma lista de jogos a partir de
     * @param teams uma lista de times
     * @param gameData os dados dos jogos
     * @return uma lista de jogos
     */
    public static List<Game> populateGames(List<Team> teams, String[][] gameData) {
        List<Game> games = new ArrayList<>();
        for (String[] data : gameData) {
            int gameNumber = Integer.parseInt(data[0]); // Game number
            String date = data[1]; // Game date
            Team homeTeam = teams.get(Integer.parseInt(data[2])); // Get home team
            Team awayTeam = teams.get(Integer.parseInt(data[3])); // Get away team
            int attendance = Integer.parseInt(data[4]); // Attendance
            // Create and add game to list
            Game game = new Game(gameNumber, date, homeTeam, awayTeam, attendance);
            games.add(game);
        }
        return games;
    }

    /**
     * Imprime os detalhes do Jogo
     */
    public void printGameDetails() {
        System.out.println("Game #" + gameNumber);
        System.out.println("Date: " + date);
        System.out.println("Attendance: " + attendance);

        //System.out.print("Home Team:");
        Team.printTeamData(homeTeam);

        //System.out.print("Away Team:");
        Team.printTeamData(awayTeam);
    }

    /**
     * Generates a summary of the game, including which team won and the final score.
     * It determines the winner based on the team scores
     * and returns the summary as a string.
     */
    public void gameSummary(){
        System.out.println("Game #" + gameNumber);
        //Game # 1:
        //Team Los Angeles Lakers score: 86
        System.out.println("Team" + homeTeam.getName() + " score: "+);
        System.out.println("Team" + awayTeam.getName() + " score: "+);

    }

    /**
     * Returns a map with the highest scorers from both teams in the game.
     * It uses highestTeamScorer(Team team) to find the highest scorer for each team
     * and adds them to the map, which is then returned.
     */
    public map<Player player, int score> highestScorer(){

    }

    /**
     * Finds the player with the highest score on a given team based on PlayerGameStats.
     * It iterates through the stats
     * and returns the player with the highest score.
     * @param team
     * @return player
     */
    public Player highestTeamScorer(Team team){

    }

    /**
     * Converte o objeto Jogo para o formato string
     * @return Uma string com os dados do jogo, número, data, público, time de casa e time visitante
     */
    @Override
    public String toString() {
        return String.format(
                "Game #%d [%s]%nAttendance: %d%nHome Team: %s%nAway Team: %s",
                gameNumber, date, attendance, homeTeam, awayTeam
        );
    }
}