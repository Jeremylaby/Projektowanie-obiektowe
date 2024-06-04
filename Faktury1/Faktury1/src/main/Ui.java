package main;

import java.util.Calendar;

import rabaty.adapter.AdapterKlasowy;
import dokumenty.Druk;
import magazyn.Towar;

import dokumenty.Faktura;

//ZEWNETRZNY RABAT
import rabatlosowy.LosowyRabat;
import rabaty.Konfiguracja;


public class Ui {

	public static void main(String[] args) {
		Calendar teraz=Calendar.getInstance();
        AdapterKlasowy adapterKlasowy = new AdapterKlasowy();
        Konfiguracja.getInstance().setProcentRabatu(adapterKlasowy.losujRabat());
        Konfiguracja.getInstance().setStrategiaRabatu(adapterKlasowy);
		//Tworzymy towary
		Towar t1=new Towar(10,"buty");
		Towar t2=new Towar(2,"skarpety");
		
		//I przykladowa fakture
		Faktura f=new Faktura(teraz.getTime(),"Fido");
		f.dodajPozycje(t1,3);
		f.dodajPozycje(t2, 5);

        Druk.wypiszFakture(f);

		
		//TEST ZEWN. rabatu
		LosowyRabat lr=new LosowyRabat();
		System.out.println(lr.losujRabat());
	}


}