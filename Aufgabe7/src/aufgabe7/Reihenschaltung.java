package aufgabe7;

public class Reihenschaltung extends ZusammengesetzteSchaltung{

	int anzahlWiderstaende = 0;
	
	@Override
	public double getWiderstand() {
		double si = 0;
		for(Schaltung s : schaltung)
			si += s.getWiderstand();
		return si;
	}

	

}
