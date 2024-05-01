package pl.edu.agh.to.lab4.provider;

import pl.edu.agh.to.lab4.iterators.SuspectAgregator;
import pl.edu.agh.to.lab4.models.CracowCitizen;
import pl.edu.agh.to.lab4.models.Suspect;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class PersonDataProvider implements SuspectAgregator {

    private final Collection<CracowCitizen> cracovCitizens = new ArrayList<CracowCitizen>();
    public PersonDataProvider(Collection<CracowCitizen> cracowCitizens){
        cracovCitizens.addAll(cracowCitizens);
    }

    public PersonDataProvider() {
        cracovCitizens.add(new CracowCitizen("Jan", "Kowalski", 30));
        cracovCitizens.add(new CracowCitizen("Janusz", "Krakowski", 30));
        cracovCitizens.add(new CracowCitizen("Janusz", "Mlodociany", 10));
        cracovCitizens.add(new CracowCitizen("Kasia", "Kosinska", 19));
        cracovCitizens.add(new CracowCitizen("Piotr", "Zgredek", 29));
        cracovCitizens.add(new CracowCitizen("Tomek", "Gimbus", 14));
        cracovCitizens.add(new CracowCitizen("Janusz", "Gimbus", 15));
        cracovCitizens.add(new CracowCitizen("Alicja", "Zaczarowana", 22));
        cracovCitizens.add(new CracowCitizen("Janusz", "Programista", 77));
        cracovCitizens.add(new CracowCitizen("Pawel", "Pawlowicz", 32));
        cracovCitizens.add(new CracowCitizen("Krzysztof", "Mendel", 30));
    }


    public Collection<CracowCitizen> getAllCracovCitizens() {
        return cracovCitizens;
    }
    public Iterator<Suspect> iterator(){
        return ((Collection<Suspect>)(Collection<?>) cracovCitizens).iterator();
    }
}
