package pl.agh.edu.dp.main;

import pl.agh.edu.dp.labirynth.*;
import pl.agh.edu.dp.labirynth.builder.CountingMazeBuilder;
import pl.agh.edu.dp.labirynth.builder.MazeBuilder;
import pl.agh.edu.dp.labirynth.builder.StandardMazeBuilder;
import pl.agh.edu.dp.labirynth.factory.BombedMazeFactory;
import pl.agh.edu.dp.labirynth.factory.EnchantedMazeFactory;
import pl.agh.edu.dp.labirynth.factory.MazeFactory;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
//        check();
        newGame();
    }

    private static void newGame() {
        StandardMazeBuilder builder = new StandardMazeBuilder();
        Random rand = new Random();
        int numberOfRooms = 10 + rand.nextInt(6); // 10 to 15 rooms
        int numberOfBombedRooms = 1 + rand.nextInt(numberOfRooms / 3);

        Set<Integer> bombedRoomIndices = new HashSet<>();
        while (bombedRoomIndices.size() < numberOfBombedRooms) {
            bombedRoomIndices.add(rand.nextInt(numberOfRooms));
        }
        if (bombedRoomIndices.contains(0)) {
            builder.addBombedRoom(0);
        } else {
            builder.addRoom(0);
        }
        for (int i = 1; i < numberOfRooms; i++) {
            if (bombedRoomIndices.contains(i)) {
                builder.addDoorBetweenBombed(i - 1, i);
            } else {
                builder.addDoorBetween(i - 1, i);
            }
        }
        System.out.println("There is " + numberOfRooms + " rooms");
        System.out.println(numberOfBombedRooms + " of them are bombedRooms");
        MazeGame mazeGame = new MazeGame();
        mazeGame.createMaze(builder);
        mazeGame.playGame();
    }

    private static void check() {

        System.out.println("Test Builder:");
        StandardMazeBuilder standardMazeBuilder = new StandardMazeBuilder();
        CountingMazeBuilder countingMazeBuilder = new CountingMazeBuilder();
        standardMazeBuilder.addRoom(0);
        countingMazeBuilder.addRoom(0);

        for (int i = 1; i < 6; i++) {
            standardMazeBuilder.addDoorBetween(i - 1, i);
            countingMazeBuilder.addDoorBetween(i - 1, i);
        }
        System.out.println("Counts:");
        System.out.println(countingMazeBuilder.getCounts());
        System.out.println();
        System.out.println("Test Singleton");
        System.out.println("Maze Factory");
        MazeFactory mazeFactory1 = MazeFactory.getInstance();
        MazeFactory mazeFactory2 = MazeFactory.getInstance();
        System.out.println(mazeFactory1 == mazeFactory2);
        System.out.println();
        System.out.println("EnchantedMazeFactory");
        EnchantedMazeFactory enchantedMazeFactory1 = EnchantedMazeFactory.getInstance();
        EnchantedMazeFactory enchantedMazeFactory2 = EnchantedMazeFactory.getInstance();
        System.out.println(enchantedMazeFactory1 == enchantedMazeFactory2);
        System.out.println();
        System.out.println("BombedMazeFactory:");
        BombedMazeFactory bombedMazeFactory1 = BombedMazeFactory.getInstance();
        BombedMazeFactory bombedMazeFactory2 = BombedMazeFactory.getInstance();
        System.out.println(bombedMazeFactory1 == bombedMazeFactory2);
        System.out.println();
        System.out.println("Test factory created Maze game:");
        Maze maze;
        MazeGame game = new MazeGame();
        System.out.println("MazeFactory game:");
        maze = game.createMaze(MazeFactory.getInstance());
        System.out.println("There is " + maze.getRoomNumbers() + " rooms");
        game.playGame();
        System.out.println();

        System.out.println("EnchantedMazeFactory game:");
        maze = game.createMaze(EnchantedMazeFactory.getInstance());
        System.out.println("There is " + maze.getRoomNumbers() + " rooms");
        game.playGame();
        System.out.println();

        System.out.println("BombedMazeFactory game:");
        maze = game.createMaze(BombedMazeFactory.getInstance());
        System.out.println("There is " + maze.getRoomNumbers() + " rooms");
        game.playGame();
        System.out.println();
    }
}



