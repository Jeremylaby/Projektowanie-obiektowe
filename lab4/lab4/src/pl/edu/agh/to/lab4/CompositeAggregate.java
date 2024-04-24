package pl.edu.agh.to.lab4;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class CompositeAggregate implements SuspectAgregator {
    private final Collection<Suspect> aggregate;

    public CompositeAggregate(Collection<SuspectAgregator> aggregates) {
        this.aggregate = generateAggregate(aggregates);
    }
    private Collection<Suspect> generateAggregate(Collection<SuspectAgregator> aggregates){
        Collection<Suspect> result = new ArrayList<>();
        for(SuspectAgregator aggregate : aggregates){
            Iterator<Suspect> iterator = aggregate.iterator();
            while(iterator.hasNext()){
                result.add(iterator.next());
            }
        }
        return result;
    }

    public Collection<Suspect> getAggregate() {
        return aggregate;
    }

    @Override
    public Iterator<Suspect> iterator() {
        return aggregate.iterator();
    }
}
