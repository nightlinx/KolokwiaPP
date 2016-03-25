package KolokwiumA2;

import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Sklep {
	Set<Towar> tow;

	public Sklep() {
		tow = new HashSet<Towar>();
	}

	Towar maks() { // zwraca towar dostarczany najwieksza ilosc razy
		double p_ile = 0;
		double ile = 0;
		Towar towar = null;

		for (Towar t : tow) {
			p_ile = t.dost.size();

			if (p_ile > ile) {
				ile = p_ile;
				towar = t;
			}
		}
		return towar;
	}

	String maksD() { // zwraca nazwe towaru dost przez najw. ilosc dostawcow
		String nazwa = null;
		int ile = 0;
		int maksIle = 0;
		for (Towar t : tow) {
			ile = t.ileDostawcow();

			if (ile > maksIle) {
				maksIle = ile;
				nazwa = t.nazwa;
			}
		}
		return nazwa;
	}

	boolean dostarczal(String nazwaTow, String nazwaDost) {
		boolean dostarczal = false;

		for (Towar t : tow) {
			if (t.nazwa.equals(nazwaTow)) {
				dostarczal = t.czyDostarczal(nazwaDost);
			}
		}
		return dostarczal;
	}

	Set<String> wszyscyDostawcy() {
		Set<String> zb = new HashSet<String>();

		for (Towar t : tow)
			zb.addAll(t.wszyscy());
		return zb;
	}
	
	Set<String> wszyscyDostawcy2() {
		Set<String> zb = new HashSet<String>();

		for (Towar t : tow){
			for(Dostawa d : t.dost)
				zb.add(d.nazwaDostawcy);
		}
		return zb;
	}	
	

	void nowaDostawa() {
		PrintWriter wyj = new PrintWriter(System.out,true);
		Scanner sc = new Scanner(System.in);
		wyj.printf("Podaj nazwe towaru");
		String towar = sc.next();
		wyj.printf("Podaj nazwe dostawcy");
		String dostawca = sc.next();
		wyj.printf("Podaj ilosc towaru");
		double ilosc = sc.nextDouble();
		wyj.printf("Podaj cene");
		double cena = sc.nextDouble();
		sc.close();
		boolean jestTowar = false;
		
		for (Towar t : tow) {
			if (t.nazwa.equals(towar)) {
				t.dost.add(new Dostawa(dostawca, ilosc, cena));
				jestTowar = true;
			}
		}
		if(!jestTowar){
			Towar t = new Towar(towar);
			tow.add(t);
			t.dost.add(new Dostawa(dostawca, ilosc, cena));
		}
	}
}