package pl.agh.edu.dp.labirynth.factory;

import pl.agh.edu.dp.labirynth.*;

public class MazeFactory {
    public Maze makeMaze(){
        return new Maze();
    }
    public Room makeRoom(int roomNo){
        Room room = new Room(roomNo);
        for(Direction direction: Direction.values()){
            room.setSide(direction,makeWall());
        }
        return room;
    }
    public Wall makeWall(){
        return new Wall();
    }
    public Door makeDoor(Room r1, Direction direction, Room r2){
        if (r1.getSide(direction) instanceof Door)
            throw new IllegalArgumentException("R1 Already has doors in direction: " + direction + ".");
        if (r2.getSide(direction.opposite()) instanceof Door)
            throw new IllegalArgumentException("R2 Already has doors in direction: " + direction.opposite() + ".");
        Door newDoor = new Door(r1, r2);
        r1.setSide(direction, newDoor);
        r2.setSide(direction.opposite(), newDoor);
        return newDoor;
    }
}
