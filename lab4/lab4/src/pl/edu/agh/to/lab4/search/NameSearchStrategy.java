package pl.edu.agh.to.lab4.search;

import pl.edu.agh.to.lab4.models.Suspect;
import pl.edu.agh.to.lab4.search.SearchStrategy;

public class NameSearchStrategy implements SearchStrategy {
    private final String name;

    public NameSearchStrategy(String name) {
        this.name = name;
    }

    @Override
    public boolean filter(Suspect suspect) {
        return suspect.getFirstname().equals(name);
    }
}
