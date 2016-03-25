//package Kolokwiuma2;
package KolokwiumA2;

public class Dostawa {
	String nazwaDostawcy;
	double ilosc;  //towaru
	double cena;
	
	public Dostawa(String n, double i,double c){
		nazwaDostawcy=n;
		ilosc=i;
		cena=c;
	}
	
	public int hashCode(){
		return nazwaDostawcy.hashCode();
	}
	
	public int compareTo(Dostawa d){
		return nazwaDostawcy.compareTo(d.nazwaDostawcy);
	}
	
	boolean equals(Dostawa d){
		return nazwaDostawcy.equals(((Dostawa)d).nazwaDostawcy);
		
	}
}
