package KolokwiumC2;

public class Wynik {
	String nazwisko;
	int punkty;
	
	public Wynik(String n, int p){
		nazwisko=n;
		punkty=p;
	}
	
	public String toString(){
		return nazwisko;
	}
}
