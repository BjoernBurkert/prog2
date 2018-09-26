package aufgabe12b;

public class Person {

	private String vorname;
	private String nachname;
	private int geburtsjahr;
	
	public Person(String vorname, String nachname, int geburtsjahr) {
		this.vorname = vorname;
		this.nachname = nachname;
		this.geburtsjahr = geburtsjahr;
	}
	
	public String getVorname() {
		return this.vorname;
	}
	
	public void setVorname(String vorname) {
		this.vorname = vorname;
	}
	
	public String getNachname() {
		return this.nachname;
	}
	
	public Person setNachname(String nachname) {
		this.nachname = nachname;
		return this;
	}
	
	public int getGeburtsjahr() {
		return this.geburtsjahr;
	}
	
	public void setGeburtsjahr(int geburtsjahr) {
		this.geburtsjahr = geburtsjahr;
	}
	
	public String toString() {
		String personString = this.vorname + " " + this.nachname + " " + this.geburtsjahr;
		return personString;
	}
}
