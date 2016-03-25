package KolokwiumC2;


import java.util.HashSet;
import java.util.Set;


public class Test {

	public static void main(String[] args) {
		Turniej turniej = new Turniej();
		turniej.dodajZawody("siatkowka", 10);
		turniej.zaw.add(new Zawody("noga", 10));
		
		Zawody zawody = new Zawody("kosz", 10);
		zawody.dopiszStart2();
		zawody.dopiszStart2();		
		zawody.dopiszStart2();
		
//		zawodnicy = turniej.wszyscy();
			
		Set<String> zawodnicy = new HashSet<String>();
		int punkty;		
		for(String zaw : zawodnicy){
			System.out.println(zaw);
		}
		
//		punkty = turniej.puntyRazem();
//			System.out.println("Suma punktow wszystkich zawodnikow"+punkty);
		
		if(turniej.startowal("koszykowka", "Nowak"))
			System.out.println("Nowak startowal w zawodach koszykowki");
		
		turniej.wszyscy();
	}

}
