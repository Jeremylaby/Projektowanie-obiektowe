package pl.edu.agh.to.lab4.models;

import pl.edu.agh.to.lab4.models.Suspect;

public class CracowCitizen extends Suspect {


    private final int age;

    public CracowCitizen(String firstname, String lastname, int age) {
        super(firstname,lastname);
        this.age = age;
    }

    public int getAge() {
        return age;
    }

}
