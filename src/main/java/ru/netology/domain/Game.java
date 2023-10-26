package ru.netology.domain;

import java.util.ArrayList;


public class Game {

    private ArrayList<Player> players = new ArrayList<>();


    public void register(Player player) {
        players.add(player);
    }

    public ArrayList<Player> findAll() {
        return players;
    }

    public Player findByName(String playerName) {
        for (Player player : players) {
            if (player.getName().equals(playerName)) {
                return player;
            }
        }
        return null;
    }

    public int round(String playerName1, String playerName2) {
        if (findByName(playerName1) == null) {
            throw new NotRegisteredException("Player " + playerName1 + " not found");
        }
        if (findByName(playerName2) == null) {
            throw new NotRegisteredException("Player " + playerName2 + " not found");
        }
        Player player2 = findByName(playerName2);
        Player player1 = findByName(playerName1);
        int result;
        if (player1.getStrength() > player2.getStrength()) {
            result = 1;
        } else if (player1.getStrength() < player2.getStrength()) {
            result = 2;
        } else {
            result = 0;
        }
        return result;
    }
}









