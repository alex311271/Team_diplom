package ru.netology;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class PlayerTest {

    @Test
    public void shouldSumGenreIfOneGame() {
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        Player player = new Player("Petya");
        player.installGame(game);
        player.play(game, 3);

        int expected = 3;
        int actual = player.sumGenre(game.getGenre());
        assertEquals(expected, actual);
    }
    @Test
    public void TestSum2Genre() {
        GameStore store = new GameStore();
        Game game = store.publishGame("Мир танков", "Аркады");
        Game game1 = store.publishGame("Клеопатра", "Стратегия");
        Game game2 = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        Player player = new Player("Petya");
        player.installGame(game);
        player.installGame(game1);
        player.installGame(game2);
        player.play(game, 2);
        player.play(game1, 4);
        player.play(game2, 6);

        int expected = 8;
        int actual = player.sumGenre("Аркады");
        assertEquals(expected, actual);
    }


    @Test
    public void MostPlayerGenre() {
        GameStore store = new GameStore();
        Game game = store.publishGame("Мир танков", "Аркады");
        Game game1 = store.publishGame("Клеопатра", "Стратегия");
        Game game2 = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        Player player = new Player("Petya");
        player.installGame(game);
        player.installGame(game1);
        player.installGame(game2);
        player.play(game, 2);
        player.play(game1, 4);
        player.play(game2, 6);

        Game expected = game2;
        Game actual = player.mostPlayerByGenre("Аркады");
        assertEquals(expected, actual);
    }
    @Test
    public void shouldNoInstallGame() {
        GameStore store = new GameStore();
        Game game = store.publishGame("Мир танков", "Аркады");
        Game game1 = store.publishGame("Клеопатра", "Стратегия");
        Game game2 = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        Player player = new Player("Petya");
        player.installGame(game);
        player.installGame(game2);
        player.play(game, 3);
        player.play(game2, 2);


        String expected = null;
        Game actual = player.mostPlayerByGenre("Стратегия");
        assertEquals(expected, actual);
    }

    // другие ваши тесты
}
