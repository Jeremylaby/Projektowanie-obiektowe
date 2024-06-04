package dokumenty;

import java.util.Iterator;

public class Druk {
    public static void wypiszFakture(Faktura faktura)
    {
        System.out.println("=====================================================");
        drukujNaglowek(faktura);
        System.out.println();
        drukujPozycje(faktura);
        System.out.println();
        drukujStopke(faktura);
        System.out.println("=====================================================");
    }
    public static void drukujNaglowek(Faktura faktura){
        System.out.println("FA z dnia: "+faktura.getDataSprzedazy().toString());
        System.out.println("Wystawiona dla: "+faktura.getKontrahent());

    }
    public static void drukujPozycje(Faktura faktura){
        Iterator<Pozycja> iteratorPozycji=faktura.getIteratorPozycji();
        while(iteratorPozycji.hasNext())
        {
            Pozycja pozycja=iteratorPozycji.next();
            System.out.println("Towar: "+pozycja.getNazwa()+" Ilosc: "+pozycja.getIlosc()+" Wartosc:" + pozycja.getWartosc());
        }
    }
    public static void drukujStopke(Faktura faktura){
        System.out.println("Na kwote: "+faktura.getSuma());
    }
}
