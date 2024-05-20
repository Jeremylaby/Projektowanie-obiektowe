package pl.agh.edu.dp.labirynth.enchanted;

import pl.agh.edu.dp.labirynth.Room;

public class MagicRealm extends Room {
    public MagicRealm(int number) {
        super(number);
    }
    public void containsMagic(){
        System.out.println("Magic");
    }
}
