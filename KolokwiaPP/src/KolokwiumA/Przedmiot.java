package KolokwiumA;


import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.Iterator;


public class Przedmiot {
	String nazwaP;
	SortedSet<Zaliczenie> zal;
	
	public Przedmiot(){
		zal = new TreeSet <Zaliczenie> ();
	}
	
	public Set <String> dajNazwiska(){
		Set<String> zb= new HashSet <String>();
		
		for(Zaliczenie z : zal){
			if(z.ocena>0){
				zb.add(z.nazwisko);
			}
		}
		return zb;
	}
	
	boolean maOcenePozytywna(String nazw){
		boolean ma = false;
		for(Zaliczenie z : zal){
			if(z.nazwisko.equals(nazw)&&(z.ocena>=3))
				ma=true;
				break;
		}
		return ma;
	}
	
	void nowaOcena(){	
		Scanner sc = new Scanner(System.in);
		System.out.println("Podaj nazwisko");
		String nazwisko = sc.nextLine();
		System.out.println("Podaj ocene");
		double ocena = sc.nextDouble();		
		boolean jest = false;
		sc.close();		
		
		Iterator <Zaliczenie> it = zal.iterator();
		
		while(it.hasNext() && !jest){
			Zaliczenie z = it.next();
				if(z.nazwisko.equals(nazwisko)){
					jest = true;
				}
		}
		if(!jest)
			zal.add(new Zaliczenie(nazwisko, ocena));
	}
	
	
}
