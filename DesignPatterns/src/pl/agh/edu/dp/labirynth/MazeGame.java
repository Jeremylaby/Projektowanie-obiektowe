package pl.agh.edu.dp.labirynth;

import pl.agh.edu.dp.labirynth.bombed.BombedRoom;
import pl.agh.edu.dp.labirynth.bombed.BombedWall;
import pl.agh.edu.dp.labirynth.builder.StandardMazeBuilder;
import pl.agh.edu.dp.labirynth.factory.MazeFactory;

import java.util.Vector;
import java.util.Scanner;


public class MazeGame {
    private Maze maze;
    private Player player;

    public Maze createMaze(StandardMazeBuilder mazeBuilder) {
        maze = mazeBuilder.build();
        return maze;
    }
    public Maze createMaze(MazeFactory factory){
        Room room1 = factory.makeRoom(1);
        Room room2 = factory.makeRoom(2);
        Room room3 = factory.makeRoom(5);
        Room room4 = factory.makeRoom(7);
        factory.makeDoor(room1, Direction.North, room2);
        factory.makeDoor(room1, Direction.South, room3);
        factory.makeDoor(room2, Direction.North, room4);
        Vector<Room> rooms = new Vector<>();
        rooms.add(room1);
        rooms.add(room2);
        rooms.add(room3);
        rooms.add(room4);

        maze = new Maze();
        maze.setRooms(rooms);
        return maze;
    }

    public void playGame() {
        player = new Player(maze.getRooms().get(0));
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome in The Maze Game");
        while (true) {
            player.heal();
            while (player.isAlive()) {
                System.out.println("You have :"+player.getHp()+" hp");
                if (player.getOccupiedRoom() == maze.getRooms().get(maze.getRoomNumbers() - 1)) {
                    System.out.println("You have found the treasure!");
                    return;
                }
                Direction movedirection = null;
                while (movedirection == null) {
                    System.out.println("Enter a direction (N, W, S, E) or Q-quit:");
                    String input = scanner.nextLine().toUpperCase();
                    if (input.equalsIgnoreCase("Q")) {
                        System.out.println("You have surrendered");
                        return;
                    }
                    movedirection=Direction.parseString(input);
                }
                MapSite mapSite=player.getOccupiedRoom().getSide(movedirection);
                mapSite.Enter();
                if(mapSite instanceof BombedWall){
                    player.takeDmg(1);
                }
                if(mapSite instanceof Door){
                    Room nextRoom = ((Door) mapSite).goToNextRoom(player.getOccupiedRoom());
                    player.setRoom(nextRoom);
                    nextRoom.Enter();
                }
            }
            System.out.println("You have died try again....");
        }
    }
}
