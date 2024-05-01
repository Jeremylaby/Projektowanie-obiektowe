package pl.edu.agh.to.lab4.provider;

import pl.edu.agh.to.lab4.iterators.SuspectAgregator;
import pl.edu.agh.to.lab4.models.Student;
import pl.edu.agh.to.lab4.models.Suspect;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class StudentDataProvider implements SuspectAgregator {
    private final Collection<Student> students = new ArrayList<>();

    public StudentDataProvider() {
        students.add(new Student("Janusz","Zakała",21,"213456"));
        students.add(new Student("Edmund","Kociołek",23,"215456"));
        students.add(new Student("Janusz","Dobry",17,"123506"));
    }

    public Collection<Student> getStudents() {
        return students;
    }

    @Override
    public Iterator<Suspect> iterator() {

        return ((Collection<Suspect>)(Collection<?>) students).iterator();
    }
}
