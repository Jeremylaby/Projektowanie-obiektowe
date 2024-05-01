package pl.edu.agh.to.lab4;

import pl.edu.agh.to.lab4.provider.PersonDataProvider;
import pl.edu.agh.to.lab4.provider.PrisonersDataProvider;
import pl.edu.agh.to.lab4.provider.StudentDataProvider;
import pl.edu.agh.to.lab4.search.AgeSearchStrategy;
import pl.edu.agh.to.lab4.search.Finder;
import pl.edu.agh.to.lab4.search.NameSearchStrategy;
import pl.edu.agh.to.lab4.search.SearchStrategy;

import java.util.ArrayList;
import java.util.Arrays;

public class Application {

    public static void main(String[] args) {
        Finder suspects = new Finder(new PersonDataProvider(), new PrisonersDataProvider());
        SearchStrategy nameStrat= new NameSearchStrategy("Janusz");
        suspects.display(nameStrat);
        SearchStrategy ageStrat = new AgeSearchStrategy(20,25);
        suspects.display(ageStrat);
        Finder suspects2= new Finder(new ArrayList<>(Arrays.asList(new StudentDataProvider(),new PersonDataProvider(),new PrisonersDataProvider())));
        suspects2.display(nameStrat);
        suspects2.display(ageStrat);
    }
}
