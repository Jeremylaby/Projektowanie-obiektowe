package pl.agh.edu.dp.labirynth;

public enum Direction {
    North, South, East, West;
    public Direction opposite() {
        return (switch (this){
            case North -> South;
            case East -> West;
            case South -> North;
            case West -> East;
        });
    }
    public static Direction parseString(String input){
        Direction direction = null;
        switch (input) {
            case "N":
                direction = Direction.North;
                break;
            case "W":
                direction = Direction.West;
                break;
            case "S":
                direction = Direction.South;
                break;
            case "E":
                direction = Direction.East;
                break;
            default:
                System.out.println("Invalid input. Please enter N, W, S, or E.");
                break;
        }
        return direction;
    }
}