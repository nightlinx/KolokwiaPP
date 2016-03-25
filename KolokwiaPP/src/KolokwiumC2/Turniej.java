package KolokwiumC2;

import java.util.HashSet;
import java.util.Set;
import java.util.Iterator;


public class Turniej {
	Set<Zawody> zaw;
	
	public Turniej(){
		zaw=new HashSet<Zawody>();
		zaw.add(new Zawody("koszykowka",10));
		zaw.add(new Zawody("siatkowka",10));
	}
	
	public void dodajZawody(String nazwa, int maxWynikow){
		zaw.add(new Zawody(nazwa,maxWynikow));
	}
	
	public int puntyRazem(){
		int sumaPunktow=0;
		for(Zawody z : zaw){
			sumaPunktow=sumaPunktow+z.punkty();
		}
		return sumaPunktow;
	}
	
	public boolean startowal(String nazwa, String nazwisko){
		boolean startowal=false;
		Iterator<Zawody> it = zaw.iterator();
		while(it.hasNext() && !startowal){
			Zawody z = it.next();
			if(z.nazwa.equals(nazwa) && z.startowal(nazwisko))
				startowal=true;
		}
		return startowal;
	}
	
	public Set<String> wszyscy(){
		Set<String> zb = new HashSet<String>();
		for(Zawody z: zaw){
			zb.addAll(z.wszyscy());
		}
		return zb;
	}
	
	
	
}
