package pl.edu.agh.to.lab4.models;

import pl.edu.agh.to.lab4.models.Suspect;

import java.util.Calendar;

public class Prisoner extends Suspect {
    private final int judgementYear;

    private final int senteceDuration;

    private final String pesel;


    public Prisoner(String firstname, String lastname, String pesel, int judgementYear, int sentenceDuration) {
        super(firstname,lastname);
        this.pesel = pesel;
        this.judgementYear = judgementYear;
        this.senteceDuration = sentenceDuration;
    }

    public String getPesel() {
        return pesel;
    }

    public boolean isJailedNow() {
        return judgementYear + senteceDuration >= getCurrentYear();
    }

    public int getCurrentYear() {
        return Calendar.getInstance().get(Calendar.YEAR);
    }

    @Override
    public boolean canBeAccused() {
        return !isJailedNow()&&super.canBeAccused();
    }

    @Override
    public int getAge() {
        int a = Integer.parseInt(pesel.substring(0,2));
        int b = Integer.parseInt(pesel.substring(2,4));
        a+=(b>=20 ? 2000:1900);
        return getCurrentYear()-a;
    }
}
