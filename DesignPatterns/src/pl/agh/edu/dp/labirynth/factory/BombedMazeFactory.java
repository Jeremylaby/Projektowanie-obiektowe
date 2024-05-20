package pl.agh.edu.dp.labirynth.factory;

import pl.agh.edu.dp.labirynth.Direction;
import pl.agh.edu.dp.labirynth.Room;
import pl.agh.edu.dp.labirynth.Wall;
import pl.agh.edu.dp.labirynth.bombed.BombedRoom;
import pl.agh.edu.dp.labirynth.bombed.BombedWall;


public class BombedMazeFactory extends MazeFactory{
    @Override
    public Room makeRoom(int roomNo){
        BombedRoom bombedRoom= new BombedRoom(roomNo);
        for(Direction direction: Direction.values()){
            bombedRoom.setSide(direction,makeWall());
        }
        return bombedRoom;
    }
    @Override
    public Wall makeWall(){
        return new BombedWall();
    }
}
