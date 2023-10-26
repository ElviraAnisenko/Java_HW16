package ru.netology.domain;

import java.util.ArrayList;
import java.util.HashMap;


public class Game {

    private ArrayList<Player> players = new ArrayList<>();
    HashMap<String, Integer> map = new HashMap<>();


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

    public Integer search(String playerName) {
        if (searchByName(playerName) == null) {
            throw new NotRegisteredException("Player " + playerName + " not found");
        }
        return searchByName(playerName);
    }

    public Integer searchByName(String playerName) {
        for (String key : map.keySet()) {
            Integer value = map.get(key);
            if (key.equals(playerName)) {
                return value;
            }
        }
        return null;
    }
}









