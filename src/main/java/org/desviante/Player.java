package org.desviante;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private int number;
    private ArrayList<Player> roster;

    public Player(String name, int number) {
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }

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

    public void printPlayer() {
        System.out.printf("--- Player Name: %s, Player Number: %d%n", this.getName(), this.getNumber());
    }
}
