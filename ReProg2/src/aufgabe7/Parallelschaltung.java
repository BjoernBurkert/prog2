package aufgabe7;

public class Parallelschaltung extends ZusammengesetzteSchaltung{
	
	int anzahlWiderstaende = 0;

	@Override
	public double getWiderstand() {
		double si = 0;
		for(Schaltung s : schaltung){
			si += 1/ s.getWiderstand();
		}
		return 1/si;
	}
	

}
