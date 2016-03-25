package KolokwiumA;


import java.util.HashSet;
import java.util.Set;

public class Grupa {
	Set <Przedmiot> przedm;
	
	public Grupa(){
		przedm = new HashSet<Przedmiot>();
	}
	
	Set <String> wszyscyStudenci(){
		Set <String> zb = new HashSet<String>();

		for(Przedmiot p : przedm){
			zb.addAll(p.dajNazwiska());
			}
		return zb;		
	}
	
	
	
	
	
}

