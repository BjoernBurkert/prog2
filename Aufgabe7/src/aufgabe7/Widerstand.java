package aufgabe7;


public class Widerstand implements Schaltung{
	
	public Widerstand(double w ){
		this.widerstand = w;
	}
	
	double widerstand = 0;
	int anzahlWiderstaende = 0;
	
	@Override
	public double getWiderstand() {
		return this.widerstand;
	}

	@Override
	public int getAnzahlWiderstaende() {
		return 1;
	}

	@Override
	public void add(Schaltung s) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(Schaltung s) {
		// TODO Auto-generated method stub
		
	}

}
