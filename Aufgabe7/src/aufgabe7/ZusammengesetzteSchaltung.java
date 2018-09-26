package aufgabe7;

import java.util.LinkedList;

public abstract class ZusammengesetzteSchaltung implements Schaltung {	
	
	
	
	protected LinkedList<Schaltung>schaltung = new LinkedList<>();
	
	public int getAnzahlWiderstaende(){
		int anzahlWiderstaende = 0;
		for(Schaltung single : schaltung){
			anzahlWiderstaende += single.getAnzahlWiderstaende();
		}	
		return anzahlWiderstaende;
	}
	
	public void add(Schaltung s){
		schaltung.add(s);
	}
	
	public void remove(Schaltung s){
		schaltung.remove(s);
	}
}
