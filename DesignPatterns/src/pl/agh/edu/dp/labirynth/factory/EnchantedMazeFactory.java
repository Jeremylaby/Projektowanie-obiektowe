package pl.agh.edu.dp.labirynth.factory;

import pl.agh.edu.dp.labirynth.*;
import pl.agh.edu.dp.labirynth.enchanted.AncientGate;
import pl.agh.edu.dp.labirynth.enchanted.HighMagicMountains;
import pl.agh.edu.dp.labirynth.enchanted.MagicRealm;

public class EnchantedMazeFactory extends MazeFactory{
    @Override
    public Room makeRoom(int roomNo){
        MagicRealm magicRealm = new MagicRealm(roomNo);
        for(Direction direction: Direction.values()){
            magicRealm.setSide(direction,makeWall());
        }
        return magicRealm;
    }
    @Override
    public Wall makeWall(){
        return new HighMagicMountains();
    }
    @Override
    public Door makeDoor(Room r1, Direction direction, Room r2){
        if (r1.getSide(direction) instanceof Door)
            throw new IllegalArgumentException("R1 Already has doors in direction: " + direction + ".");
        if (r2.getSide(direction.opposite()) instanceof Door)
            throw new IllegalArgumentException("R2 Already has doors in direction: " + direction.opposite() + ".");
        AncientGate ancientGate = new AncientGate(r1, r2);
        r1.setSide(direction, ancientGate);
        r2.setSide(direction.opposite(), ancientGate);
        return ancientGate;
    }
}
