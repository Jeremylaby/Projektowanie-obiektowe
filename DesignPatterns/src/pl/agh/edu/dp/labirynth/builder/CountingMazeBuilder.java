package pl.agh.edu.dp.labirynth.builder;

import java.util.HashMap;
import java.util.Map;

public class CountingMazeBuilder implements MazeBuilder {
    private int roomsCount;
    private int doorsCount;
    private int wallsCount;

    public CountingMazeBuilder() {
        this.roomsCount = 0;
        this.doorsCount = 0;
        this.wallsCount = 0;
    }

    @Override
    public void addRoom(int roomNumber) {
        roomsCount++;
        wallsCount += 4;
    }

    @Override
    public void addDoorBetween(int roomNumber, int newRoomNumber) {
        doorsCount++;
        roomsCount++;
        wallsCount += 3;
        wallsCount--;
    }

    @Override
    public void clearMaze() {
        roomsCount = 0;
        doorsCount = 0;
        wallsCount = 0;
    }
    public Map<String, Integer> getCounts() {
        Map<String, Integer> result = new HashMap<>();
        result.put("numberOfRooms", roomsCount);
        result.put("numberOfDoors", doorsCount);
        result.put("numberOfWalls", wallsCount);

        return result;
    }
}
