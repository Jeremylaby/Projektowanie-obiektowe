package pl.edu.agh.to.lab4;

public class AgeSearchStrategy implements SearchStrategy{
    private final int fromAge;
    private final int toAge;


    public AgeSearchStrategy(int fromAge, int toAge) {
        this.fromAge = fromAge;
        this.toAge = toAge;
    }

    @Override
    public boolean filter(Suspect suspect) {
        return suspect.getAge()>=fromAge&&suspect.getAge()<=toAge;
    }
}
