package ru.netology.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class GameTest {
    Player player1 = new Player(101, "Valera", 50);
    Player player2 = new Player(102, "Kolya", 100);
    Player player3 = new Player(103, "Sergey", 50);
    Player player4 = new Player(104, "Vanya", 150);

    @Test
    public void shouldRegister() {
        Game game = new Game();
        game.register(player1);
        game.register(player2);
        game.register(player3);
        ArrayList<Player> actual = game.findAll();
        List<Player> expected = Arrays.asList(player1, player2, player3);
        Assertions.assertArrayEquals(expected.toArray(), actual.toArray());
    }

    @Test
    public void shouldWinsPlayer2() {
        Game game = new Game();
        game.register(player1);
        game.register(player2);
        int actual = game.round("Valera", "Kolya");
        int expected = 2;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldPlayDraw() {
        Game game = new Game();
        game.register(player1);
        game.register(player3);
        int actual = game.round("Valera", "Sergey");
        int expected = 0;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldWinsPlayer1() {
        Game game = new Game();
        game.register(player2);
        game.register(player3);
        int actual = game.round("Kolya", "Sergey");
        int expected = 1;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldPlayIfNoRegisteredPlayer1() {
        Game game = new Game();
        game.register(player2);
        game.register(player3);
        Assertions.assertThrows(NotRegisteredException.class, () ->
                game.round("Olya", "Sergey"));
    }

    @Test
    public void shouldPlayIfNoRegisteredPlayer2() {
        Game game = new Game();
        game.register(player2);
        game.register(player3);
        Assertions.assertThrows(NotRegisteredException.class, () ->
                game.round("Kolya", "Masha"));
    }

    @Test
    public void shouldPlayIfNoRegisteredBothPlayers() {
        Game game = new Game();
        game.register(player2);
        game.register(player3);
        Assertions.assertThrows(NotRegisteredException.class, () ->
                game.round("Olya", "Masha"));
    }

    @Test
    public void shouldPlayIfNotRegistered() {
        Game game = new Game();
        Assertions.assertThrows(NotRegisteredException.class, () ->
                game.round("Olya", "Masha"));
    }

    @Test
    public void shouldSearchPlayerByNameAndOutputStrength() {
        Game game = new Game();
        game.map.put(player1.getName(), player1.getStrength());
        game.map.put(player2.getName(), player2.getStrength());
        game.map.put(player3.getName(), player3.getStrength());
        Integer expected = 50;
        Integer actual = game.search("Sergey");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldSearchIfNoPlayerWithSearchName() {
        Game game = new Game();
        game.map.put(player1.getName(), player1.getStrength());
        game.map.put(player2.getName(), player2.getStrength());
        game.map.put(player3.getName(), player3.getStrength());
        Assertions.assertThrows(NotRegisteredException.class, () ->
                game.search("Olya"));

    }
}
