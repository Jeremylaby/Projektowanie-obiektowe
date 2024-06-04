package rabaty.adapter;

import rabatlosowy.LosowyRabat;
import rabaty.Konfiguracja;
import rabaty.ObliczCenePoRabacie;

public class AdapterKlasowy extends LosowyRabat implements ObliczCenePoRabacie {
    @Override
    public double obliczCenePoRabacie(double cena) {
        return (1- Konfiguracja.getInstance().getProcentRabatu())*cena;
    }
}
