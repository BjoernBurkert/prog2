package aufgabe7a;

public class Testfile {

	public static void main(String[] args) {
		
		
		Benutzer b1 = new Benutzer("Björn");
		Benutzer b2 = new Benutzer("Link");
		//Benutzer b3 = new Benutzer("Paul");
		
		Buch bu1 = new Buch("SAO Progessive");
		Buch bu2 = new Buch("Percey Jackson");
		Buch bu3 = new Buch("DATE A LIVE");
		
		b1.addAusleihen(bu1);
		b2.addAusleihen(bu2);
		b1.addAusleihen(bu3);
		
		System.out.println(bu1.getEntleiher());
		System.out.println(bu2.getEntleiher());
		System.out.println(b1.getBuecher());
		System.out.println(b2.getBuecher());
		
		
		
		

	}

}
