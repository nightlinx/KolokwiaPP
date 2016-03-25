package KolokwiumC2;


import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Locale;
import java.util.Scanner;
import java.util.Set;

public class Zawody {
	String nazwa;
	Wynik[] wyn;
	int licWynikow=0;
	
	public Zawody(String nazwaZawodow, int maksWynikow){
		nazwa=nazwaZawodow;
		wyn=new Wynik[maksWynikow];
	}
	
	public int punkty(){
		int suma=0;
		for(int i=0;i<licWynikow;i++){
			suma=suma+wyn[i].punkty;
		}
		return suma;
	}
	
	public boolean startowal(String nazwisko){
		boolean znaleziony = false;
		int i=0;
		while(i<licWynikow && !znaleziony){
			if(wyn[i].nazwisko.equals(nazwisko))
					znaleziony=true;
		}
		return znaleziony;
	}
	
	Set<String> wszyscy(){
		Set<String> zb = new HashSet<String>();
		for(int i=0;i<licWynikow;i++){
			System.out.println(wyn[i].nazwisko);
			zb.add(wyn[i].nazwisko);
		}
		return zb;
	}
	
	void dopiszStart(){
		PrintWriter out = new PrintWriter(System.out,true);
		Scanner in = new Scanner(System.in);
		
		out.printf("Podaj nazwisko");
		String nazwisko = in.nextLine();
		out.printf("Podaj punkty");
		int punkty = in.nextInt();
			
		wyn[licWynikow]=new Wynik(nazwisko, punkty);
		licWynikow++;
		System.out.println("dodano");			
	}
	

	void dopiszStart2(){
		Scanner in = new Scanner(System.in);
		
		System.out.println("Podaj nazwisko");
		String nazwisko = in.nextLine();
		System.out.println("Podaj punkty");
		int punkty = in.nextInt();
		
		wyn[licWynikow]=new Wynik(nazwisko, punkty);
		licWynikow++;
		System.out.println("dodano");		
	}
	
}
