package pl.agh.edu.dp.labirynth.bombed;

import pl.agh.edu.dp.labirynth.Room;

public class BombedRoom extends Room {
    public BombedRoom(int number) {
        super(number);
    }

    @Override
    public void Enter() {
        System.out.println("You have entered BombedRoom every wall has bomb inside "+this.getRoomNumber());
    }
}
