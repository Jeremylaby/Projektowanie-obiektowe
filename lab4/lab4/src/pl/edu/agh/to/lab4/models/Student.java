package pl.edu.agh.to.lab4.models;

public class Student extends Suspect{
    private final int age;
    private final String index;

    public Student(String firstname, String lastname, int age, String index) {
        super(firstname, lastname);
        this.age = age;
        this.index = index;
    }

    public String getIndex() {
        return index;
    }

    @Override
    public int getAge() {
        return age;
    }
}
