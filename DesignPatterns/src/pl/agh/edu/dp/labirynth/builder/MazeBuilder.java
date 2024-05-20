package pl.agh.edu.dp.labirynth.builder;

import pl.agh.edu.dp.labirynth.Direction;

public interface MazeBuilder {

    public void addRoom(int roomNumber);
    public void addDoorBetween(int roomNumber,int newRoomNumber);
    public void clearMaze();
}
