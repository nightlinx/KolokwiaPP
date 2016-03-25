package KolokwiumD;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class Biblioteka {
	Ksiazka[] ks;
	int licKsiazek;
	
	public Biblioteka (int maksKsiazek){
		ks = new Ksiazka[maksKsiazek];
		licKsiazek = 0;
	}

	public int liczbaWypozyczen(){
		int n=0;
		
		for(int i=0; i<licKsiazek; i++){
			n=n+ks[i].wyp.size();   //liczba wypozyzczen z kazdej ksiazki z osobna
		}
		return n;
	}
	
	boolean wypozyczal(String tytul, String nazwisko){
		boolean wypozyczal = false;

		for(int i=0;i<licKsiazek &&!wypozyczal; i++){				
			if(ks[i].tytul.equals(tytul)){  
				for(Wypozyczenie w : ks[i].wyp){ 
					if(w.nazwisko.equals(nazwisko))
						wypozyczal=true;
				}
			}
		}
		return wypozyczal;			
	}
	
	Set <String> wszyscy(){  		 //zbior wszystkich nazwisk czytelnikow
		Set <String> zb = new HashSet<String>();
		
		for(int i=0;i<licKsiazek;i++){
			Iterator<Wypozyczenie> it=ks[i].wyp.iterator();			
			while(it.hasNext()){
				Wypozyczenie w = it.next();
				zb.add(w.nazwisko);
			}
		}
		return zb;
	}
	
	Set <String> wszyscy2(){
		Set <String> zb = new HashSet<String>();
		
		for(int i=0;i<licKsiazek;i++){	
			for(Wypozyczenie w : ks[i].wyp){
				zb.add(w.nazwisko);
			}
		}
		return zb;		
	}

	void zwrot(){
	      Scanner sc = new Scanner(System.in);
	      
	      System.out.println("Podaj tytul: ");
	      String tytul = sc.nextLine();
	      
//	      System.out.println("Podaj nazwisko: ");
//	      String nazwisko = sc.nextLine();	      
	      
	      
			for(int i=0;i<licKsiazek;i++){
				if(ks[i].tytul.equals(tytul)){  
					ks[i].zwroc();
				}
	      sc.close();
		}
	}
}
