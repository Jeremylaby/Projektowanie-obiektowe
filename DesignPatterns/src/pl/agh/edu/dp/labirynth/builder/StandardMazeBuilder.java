package pl.agh.edu.dp.labirynth.builder;

import pl.agh.edu.dp.labirynth.*;
import pl.agh.edu.dp.labirynth.bombed.BombedRoom;
import pl.agh.edu.dp.labirynth.bombed.BombedWall;

import java.util.*;

public class StandardMazeBuilder implements MazeBuilder{
    private Maze currentMaze=new Maze();
    private HashMap<Integer,Room> rooms =new HashMap<>();
    @Override
    public void addRoom(int roomNumber) {
        if(!rooms.containsKey(roomNumber)){
            rooms.put(roomNumber,makeRoom(roomNumber));
        }else{
            System.out.println("Room with that number already exists");
        }
    }
    private Room makeRoom(int roomNumber){
        Room room = new Room(roomNumber);
        for(Direction direction : Direction.values()){
            room.setSide(direction,new Wall());
        }
        return room;
    }
    private Room makeBombedRoom(int roomNumber){
        BombedRoom bombedRoom = new BombedRoom(roomNumber);
        for(Direction direction : Direction.values()){
            bombedRoom.setSide(direction,new BombedWall());
        }
        return bombedRoom;
    }
    public void addBombedRoom(int roomNumber){
        if(!rooms.containsKey(roomNumber)){
            rooms.put(roomNumber,makeBombedRoom(roomNumber));
        }else{
            System.out.println("Room with that number already exists");
        }
    }

    public void addDoorBetweenBombed(int roomNumber1, int roomNumber2) {
        if (!rooms.containsKey(roomNumber1)) {
            throw new IllegalArgumentException("There is no room with number: " + roomNumber1);
        }
        Room room1 = rooms.get(roomNumber1);
        if (rooms.containsKey(roomNumber2)) {
            throw new IllegalArgumentException("There is room with number: " + roomNumber2);
        }
        addBombedRoom(roomNumber2);
        Room room2 = rooms.get(roomNumber2);
        findCommonWall(room1, room2);
    }

    @Override
    public void addDoorBetween(int roomNumber1, int roomNumber2) {
        if (!rooms.containsKey(roomNumber1)) {
            throw new IllegalArgumentException("There is no room with number: " + roomNumber1);
        }
        Room room1 = rooms.get(roomNumber1);
        if (rooms.containsKey(roomNumber2)) {
            throw new IllegalArgumentException("There is room with number: " + roomNumber2);
        }
        addRoom(roomNumber2);
        Room room2 = rooms.get(roomNumber2);
        findCommonWall(room1, room2);
    }

    private void findCommonWall(Room room1, Room room2) {
        if (hasCommonDoor(room1, room2)) {
            throw new IllegalStateException("Rooms already connected");
        }
        ArrayList<Direction> finalDirections = new ArrayList<>();
        for (Direction direction : Direction.values()) {
            if (room1.getSide(direction) instanceof Wall && room2.getSide(direction.opposite()) instanceof Wall) {
                finalDirections.add(direction);
            }
        }
        if (finalDirections.isEmpty()) {
            throw new IllegalStateException("There is no common wall");
        }
        Random rand = new Random();
        Direction selectedDirection = finalDirections.get(rand.nextInt(finalDirections.size()));
        Door newDoor = new Door(room1, room2);
        room1.setSide(selectedDirection, newDoor);
        room2.setSide(selectedDirection.opposite(), newDoor);
    }
    public  boolean hasCommonDoor(Room room1, Room room2) {
        for (Map.Entry<Direction, MapSite> entry : room1.getSides().entrySet()) {
            MapSite side = entry.getValue();
            if (side instanceof Door door) {
                if ((door.getRoom1() == room1 && door.getRoom2() == room2) ||
                        (door.getRoom1() == room2 && door.getRoom2() == room1)) {
                    return true;
                }
            }
        }
        return false;
    }

    public Maze build() {
        currentMaze.setRooms(new Vector<>(rooms.values()));
        return currentMaze;
    }

    @Override
    public void clearMaze() {
        currentMaze=new Maze();
        rooms = new HashMap<>();
    }
}
