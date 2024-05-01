package pl.edu.agh.to.lab4.iterators;

import pl.edu.agh.to.lab4.models.Prisoner;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;

public class FlatIterator<Suspect> implements Iterator<Suspect> {
    private final Iterator<Collection<Prisoner>> outeriterator;
    private Iterator<Prisoner> inneriterator;

    public FlatIterator(Map<String, Collection<Prisoner>> collection) {
        this.outeriterator = collection.values().iterator();
        this.inneriterator = outeriterator.hasNext() ? outeriterator.next().iterator() : null;;
    }

    @Override
    public boolean hasNext() {
        while ((inneriterator == null || !inneriterator.hasNext()) && outeriterator.hasNext()) {
            inneriterator = outeriterator.next().iterator();
        }
        return inneriterator != null && inneriterator.hasNext();
    }

    @Override
    public Suspect next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return (Suspect) inneriterator.next();
    }
}
