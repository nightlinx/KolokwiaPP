package KolokwiumA2;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.Iterator;

public class Towar {
	String nazwa;
	List<Dostawa> dost;
	
	public Towar(String nazwa){
		this.nazwa=nazwa;
		dost = new ArrayList<Dostawa>();
	}
	
	int ileDostawcow(){ //ilu roznych dostawcow ma jeden wybrany towar

		Set <String> dostawcy = new HashSet <String>();
		
		for(Dostawa d : dost){
			dostawcy.add(d.nazwaDostawcy);
		}
		return dostawcy.size();
	}
	

	boolean czyDostarczal(String nazwaDostawcy){
		boolean dostarczal = false;
		for(Dostawa d : dost){
			if(d.nazwaDostawcy.equals(nazwaDostawcy))
				return true;
		}		
		return dostarczal;
	}
	
	
	
	void usunDostawcow(String nazwa){
		Iterator<Dostawa> it = dost.iterator();
		
		while(it.hasNext()){
			Dostawa d = it.next();
			if(d.ilosc==0)
				dost.remove(d);
		}
	}
	
	void usunDostawce(String nazwisko){
		Iterator<Dostawa> it = dost.iterator();
		boolean usuniety = false;
		while(it.hasNext() && !usuniety){
			Dostawa d = it.next();
//			if(d.nazwa.equals(nazwisko)){
//				dost.remove(d);
//			}
		}
	}
	
/*	void usunDostawy(String nazwaTowaru){
		i=0;
		while(i<liczbaTowarow){
			if(towar[i].nazwaTowaru.equals(nazwaTowaru)){
				towar[i]=towar[liczbaTowarow-1]
				liczbaTowarow--;
			}	
			else
				i++;
		}	
	}
*/	
	
	
	Set<String> wszyscy(){
		Set<String> zb = new HashSet<String>();
		for(Dostawa d : dost){
			zb.add(d.nazwaDostawcy);
		}
		return zb;
	}
	
	
	
	
}
