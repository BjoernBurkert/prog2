package aufgabe7a;

public class Buch {
	
	private String name;
	private Benutzer meinEntleiher;
	
	public Buch (String name){
		this.name = name;
	}
	
	public void setAusleiher(Benutzer p){
		if(meinEntleiher != null)
			return;
		meinEntleiher = p;
		p.addAusleihen(this);
	}
	
	public void zurückgegeben(){
		if(meinEntleiher == null)
			return;
		Benutzer p = meinEntleiher;
		meinEntleiher = null;
		p.zurückgeben(this);
	}
	
	public Benutzer getEntleiher(){
		return meinEntleiher;
	}
	
	@Override
	public String toString(){
		return name;
	}

}
