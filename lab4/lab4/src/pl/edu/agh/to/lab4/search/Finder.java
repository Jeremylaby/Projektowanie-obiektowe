package pl.edu.agh.to.lab4.search;

import pl.edu.agh.to.lab4.models.Suspect;
import pl.edu.agh.to.lab4.iterators.CompositeAggregate;
import pl.edu.agh.to.lab4.provider.PersonDataProvider;
import pl.edu.agh.to.lab4.provider.PrisonersDataProvider;
import pl.edu.agh.to.lab4.iterators.SuspectAgregator;

import java.util.*;

public class Finder {
    private final CompositeAggregate aggregate;

    public Finder(Collection<SuspectAgregator> aggregate) {
        this.aggregate = new CompositeAggregate(aggregate);
    }

    public Finder(PersonDataProvider personDataProvider, PrisonersDataProvider prisonersDatabase) {
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
            System.out.println(suspect.display());
        }
    }


}
