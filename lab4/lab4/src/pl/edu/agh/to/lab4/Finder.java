package pl.edu.agh.to.lab4;

import java.util.*;

public class Finder {
    private final CompositeAggregate aggregate;

    public Finder(Collection<SuspectAgregator> aggregate) {
        this.aggregate = new CompositeAggregate(aggregate);
    }

    public Finder(PersonDataProvider personDataProvider, PrisonersDatabase prisonersDatabase) {
        this(Arrays.asList(personDataProvider, prisonersDatabase));
    }
    public void display(SearchStrategy strategy){
        Collection<Suspect> suspects = new ArrayList<>();
        for(Suspect suspect : aggregate.getAggregate()){
            if(strategy.filter(suspect)&&suspect.canBeAccused()){
                suspects.add(suspect);
            }
            if(suspects.size()==20){
                break;
            }
        }
        System.out.println("Znalazlem " + suspects.size() + " pasujacych podejrzanych!");
        for(Suspect suspect : suspects){
            suspect.display();
        }
    }


}
