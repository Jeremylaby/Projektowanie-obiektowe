package pl.edu.agh.to.lab4.search;

import pl.edu.agh.to.lab4.models.Suspect;
import pl.edu.agh.to.lab4.search.SearchStrategy;

import java.util.Collection;

public class CompositeSearchStrategy implements SearchStrategy {
    private final Collection<SearchStrategy> strategies;

    public CompositeSearchStrategy(Collection<SearchStrategy> strategies) {
        this.strategies = strategies;
    }

    @Override
    public boolean filter(Suspect suspect) {
        for(SearchStrategy strategy : strategies){
            if(!strategy.filter(suspect)){
                return false;
            }
        }
        return true;
    }
}
