package rabaty.adapter;

import rabatlosowy.LosowyRabat;
import rabaty.ObliczCenePoRabacieProcentowym;

public class AdapterObiektowy extends ObliczCenePoRabacieProcentowym {
    public LosowyRabat losowyRabat;

    public AdapterObiektowy() {
        this.losowyRabat = new LosowyRabat();
    }
    public double LosujRabat(){
        return losowyRabat.losujRabat();
    }


}
