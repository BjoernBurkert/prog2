package aufgabe7a;

import java.util.LinkedList;
import java.util.List;

public class Person {
	
	List<Buch>meineBuecher = new LinkedList<Buch>();
	private String name;
	
	public Person(String name){
		this.name = name;
	}
	
	public void addAusleihen (Buch a){
		if(meineBuecher.contains(a))
			return;
		if(a.getEntleiher() != null && a.getEntleiher() != this)
			return;
		meineBuecher.add(a);
		a.setAusleiher(this);
	}
	
	public void zurückgeben(Buch a){
		if(!meineBuecher.contains(a))
			return;
		meineBuecher.remove(a);
		a.zurückgegeben();
	}
	
	public List<Buch>getBuecher(){
		return meineBuecher;
		
	}
	
	@Override
	public String toString(){
		return "Benutzer: " + this.name + " | Ausgeliehene B�cher: " + meineBuecher;
	}

}
