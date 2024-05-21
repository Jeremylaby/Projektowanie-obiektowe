package pl.agh.edu.dp.labirynth.enchanted;

import pl.agh.edu.dp.labirynth.Door;
import pl.agh.edu.dp.labirynth.Room;

public class AncientGate extends Door {
    public AncientGate(Room r1, Room r2) {
        super(r1, r2);
    }
    @Override
    public void Enter() {
        System.out.println("Going through ancient gate");
    }
}
