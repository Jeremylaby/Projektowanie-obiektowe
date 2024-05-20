package pl.agh.edu.dp.labirynth.builder;

import pl.agh.edu.dp.labirynth.*;

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
        room.setSide(Direction.South,new Wall());
        room.setSide(Direction.North,new Wall());
        room.setSide(Direction.East,new Wall());
        room.setSide(Direction.West,new Wall());
        return room;
    }

    @Override
    public void addDoorBetween(int roomNumber1, int roomNumber2) {
        if(!rooms.containsKey(roomNumber1)){
            System.out.println("there is not such room");
            return;
        }
        Room room1 = rooms.get(roomNumber1);
        if(!rooms.containsKey(roomNumber2)) {
            addRoom(roomNumber2);
        }
        Room room2 = rooms.get(roomNumber2);
    }
    private void findCommonWall(Room room1,Room room2){
        if(hasCommonDoor(room1,room2)){
            System.out.println("Already connected");
            return;
        }
        ArrayList<Direction> finalDirections = new ArrayList<>();
        for(Direction direction : Direction.values()){
            if(room1.getSide(direction) instanceof Wall && room2.getSide(direction.opposite()) instanceof Wall){
                finalDirections.add(direction);
            }
        }
        if(finalDirections.isEmpty()){
            System.out.println("There is nor common wall");
            return;
        }
        Random rand = new Random();
        Direction selectedDirection = finalDirections.get(rand.nextInt(finalDirections.size()));
        Door newDoor = new Door(room1, room2);
        room1.setSide(selectedDirection, newDoor);
        room2.setSide(selectedDirection.opposite(), newDoor);
        System.out.println("Door added between Room " + room1.getRoomNumber() + " and Room " + room2.getRoomNumber() + " on " + selectedDirection);

    }
    public  boolean hasCommonDoor(Room room1, Room room2) {
        for (Map.Entry<Direction, MapSite> entry : room1.getSides().entrySet()) {
            MapSite side = entry.getValue();
            if (side instanceof Door) {
                Door door = (Door) side;
                if ((door.getRoom1() == room1 && door.getRoom2() == room2) ||
                        (door.getRoom1() == room2 && door.getRoom2() == room1)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void build() {
        currentMaze.setRooms(new Vector<>(rooms.values()));
    }

    @Override
    public void clearMaze() {
        currentMaze=new Maze();
        rooms = new HashMap<>();
    }
}
