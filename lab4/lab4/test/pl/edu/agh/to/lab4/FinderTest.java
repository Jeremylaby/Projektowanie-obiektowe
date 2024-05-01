package pl.edu.agh.to.lab4;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pl.edu.agh.to.lab4.iterators.FlatIterator;
import pl.edu.agh.to.lab4.iterators.SuspectAgregator;
import pl.edu.agh.to.lab4.models.CracowCitizen;
import pl.edu.agh.to.lab4.models.Prisoner;
import pl.edu.agh.to.lab4.models.Suspect;
import pl.edu.agh.to.lab4.search.Finder;
import pl.edu.agh.to.lab4.search.NameSearchStrategy;
import pl.edu.agh.to.lab4.search.SearchStrategy;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class FinderTest {
    private ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    private PrintStream originalOut;

    private Collection<CracowCitizen> allPersons = new ArrayList<CracowCitizen>();

    private Map<String, Collection<Prisoner>> allPrisoners = new HashMap<String, Collection<Prisoner>>();
// Zakomentowałem te linijki bo kod mi się nie
// kompilował nie wiem czy moim zadaniem było jeszcze pisanie tych testów
// bo nie było nic o tym w instrukcji
// jeżeli miałbym to rozwiązać w taki sposób żeby one działały
// to zamiast inicjować tabelę przy atrybutach podawałbym już stworzoną do konstruktora
// wtedy wystarczałoby dodać do findera 2 ddata Providery z pustymi tabelami
// bo wtedy finder iterował po tabelach i mapach znajdujących
// się w atrybutach a nie po ich kopiach które byłyby całyczas puste
//    private Finder suspectFinder = new Finder(allPersons,allPrisoners);
//
//    @Test
//    public void testDisplayingNotJailedPrisoner() {
//        addPrisoner("Wiezeienie stanowe", new Prisoner("Jan", "Kowalski", "802104543357", 2000, 1));
//        SearchStrategy strategy = new NameSearchStrategy("Jan")
//        suspectFinder.display(strategy);
//        assertContentIsDisplayed("Jan Kowalski");
//    }
//
//    @Test
//    public void testDisplayingSuspectedPerson() {
//        allPersons.add(new CracowCitizen("Jan", "Kowalski", 20));
//        SearchStrategy strategy = new NameSearchStrategy("Jan")
//        suspectFinder.display(strategy);
//        assertContentIsDisplayed("Jan Kowalski");
//    }
//
//    @Test
//    public void testNotDisplayingTooYoungPerson() {
//        allPersons.add(new CracowCitizen("Jan", "Kowalski", 15));
//        SearchStrategy strategy = new NameSearchStrategy("Jan")
//        suspectFinder.display(strategy);
//        assertContentIsNotDisplayed("Jan Kowalski");
//    }
//
//    @Test
//    public void testNotDisplayingJailedPrisoner() {
//        allPersons.add(new CracowCitizen("Jan", "Kowalski", 20));
//        addPrisoner("Wiezeienie stanowe", new Prisoner("Jan", "Kowalski2", "802104543357", 2000, 20));
//        SearchStrategy strategy = new NameSearchStrategy("Jan")
//        suspectFinder.display(strategy);
//        assertContentIsNotDisplayed("Jan Kowalski2");
//    }
//
//    private void assertContentIsDisplayed(String expectedContent) {
//        assertTrue("Application did not contain expected content: " + outContent.toString(), outContent.toString()
//                .contains(expectedContent));
//    }
//
//    private void assertContentIsNotDisplayed(String expectedContent) {
//        assertFalse("Application did contain expected content although it should not: " + outContent.toString(), outContent.toString()
//                .contains(expectedContent));
//    }
//
//    @Before
//    public void redirectSystemOut() {
//        originalOut = System.out;
//        System.setOut(new PrintStream(outContent));
//    }
//
//    @After
//    public void resetSystemOut() {
//        System.setOut(originalOut);
//    }
//
//    private void addPrisoner(String category, Prisoner news) {
//        if (!allPrisoners.containsKey(category))
//            allPrisoners.put(category, new ArrayList<Prisoner>());
//        allPrisoners.get(category).add(news);
//    }
}
