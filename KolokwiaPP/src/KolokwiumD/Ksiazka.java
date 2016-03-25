package KolokwiumD;
import java.util.HashSet;
import java.util.Set;
import java.util.Iterator;

public class Ksiazka{
	String tytul;
	Set <Wypozyczenie> wyp;
	
	Ksiazka(String tytul){
		this.tytul = tytul;
		wyp = new HashSet <Wypozyczenie>();
	}

	public void zwroc() {
		Iterator <Wypozyczenie> it = wyp.iterator();
		while(it.hasNext()){
			Wypozyczenie w = it.next();
			if(w.oddal==false)
				w.oddal = true;
		}
	}
	
}
