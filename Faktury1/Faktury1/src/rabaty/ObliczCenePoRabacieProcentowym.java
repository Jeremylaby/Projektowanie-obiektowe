package rabaty;

public class ObliczCenePoRabacieProcentowym implements ObliczCenePoRabacie{



    @Override
    public double obliczCenePoRabacie(double cena) {
        return (1- Konfiguracja.getInstance().getProcentRabatu())*cena;
    }
}
