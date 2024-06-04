package rabaty;

public class Konfiguracja {
    private static Konfiguracja konfiguracja=null;
    private double kwotaRabatu;
    private double procentRabatu;
    private ObliczCenePoRabacie strategiaRabatu;

    private Konfiguracja() {
    }
    public static Konfiguracja getInstance(){
        if(konfiguracja==null){
            konfiguracja=new Konfiguracja();
        }
        return konfiguracja;
    }

    public double getKwotaRabatu() {
        return kwotaRabatu;
    }

    public double getProcentRabatu() {
        return procentRabatu;
    }

    public void setKwotaRabatu(double kwotaRabatu) {
        this.kwotaRabatu = kwotaRabatu;
    }

    public void setProcentRabatu(double procentRabatu) {
        this.procentRabatu = procentRabatu;
    }

    public ObliczCenePoRabacie getStrategiaRabatu() {
        return strategiaRabatu;
    }

    public void setStrategiaRabatu(ObliczCenePoRabacie strategiaRabatu) {
        this.strategiaRabatu = strategiaRabatu;
    }
    public double getObliczenieRabatu(double cena){
        return strategiaRabatu.obliczCenePoRabacie(cena);
    }
}
