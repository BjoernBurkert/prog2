package aufgabe7a;

public class Buch {
	
	private String name;
	private Person meinEntleiher;
	
	public Buch (String name){
		this.name = name;
	}
	
	public void setAusleiher(Person p){
		if(meinEntleiher != null)
			return;
		meinEntleiher = p;
		p.addAusleihen(this);
	}
	
	public void zurückgegeben(){
		if(meinEntleiher == null)
			return;
		Person p = meinEntleiher;
		meinEntleiher = null;
		p.zurückgeben(this);
	}
	
	public Person getEntleiher(){
		return meinEntleiher;
	}
	
	@Override
	public String toString(){
		return name;
	}

}
