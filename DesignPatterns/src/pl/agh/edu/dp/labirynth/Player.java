package pl.agh.edu.dp.labirynth;


public class Player {
    private Room occupiedRoom;
    private int hp = 5;

    public Player() {
        this(null);
    }
    public Player(Room startingRoom) {
        this.occupiedRoom = startingRoom;
    }

    public void setRoom(Room newRoom) {
        this.occupiedRoom = newRoom;
    }

    public void takeDmg(int amount) {
        hp -= amount;
    }

    public boolean isAlive() {
        return hp > 0;
    }

    public int getHp() {
        return hp;
    }
    public void heal(){
        hp=5;
    }
    public Room getOccupiedRoom() {
        return occupiedRoom;
    }
}