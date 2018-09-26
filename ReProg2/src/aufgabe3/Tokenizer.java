package aufgabe3;

/*
 * class Tokenizer
 * Zerlegt einen String in eine Folge von Tokens.
 * Tokens: +, -, *, /, (, ), $ oder Gleitkommazahl (ohne Vorzeichen und Exponent).
 *
 * O. Bittel; 22.03.2018
 * 
 */

import java.util.Scanner;

/**
 *
 * @author oliverbittel
 */
public class Tokenizer {

	public final static String[] KEYWORDS = {"(", "+", "*", "-", "/", ")", "$"};
	private final Scanner in;

	/**
	 * 
	 * @param s String, der in eine Folge von Tokens zerlegt werden soll.
	 */
	public Tokenizer(String s) {
		s = s.replaceAll("\\(", " ( ");
		s = s.replaceAll("\\)", " ) ");
		s = s.replaceAll("\\+", " + ");
		s = s.replaceAll("\\*", " * ");
		s = s.replaceAll("\\/", " / ");
		s = s.replaceAll("\\-", " - ");
		s += " $";
		in = new Scanner(s);
	}
	
	/**
	 * Liefert den nächsten Token. 
	 * @return String aus KEYWORDS oder 
	 * double-Wert, falls das nächste Token eine Gleitkommazahl ist; 
	 * null bei Fehler.
	 * Bei String-Ende wird "$" zurückgeliefert. 
	 */
	public Object nextToken() {
		if (!in.hasNext()) 
			return null; // Eingabeende
		if (in.hasNextDouble())
			return in.nextDouble();
		String token = in.next();
		for (String t : KEYWORDS)
			if (token.equals(t))
				return token;
		System.out.println("Error: wrong token");
		return null;
	}
	
	// Zu Testzwecken:

	/**
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		String s = "(2+3*4-4)/2";
		Tokenizer tokenizer = new Tokenizer(s);
		Object token;
		while ((token = tokenizer.nextToken()) != null)
			System.out.println(token);
	}
}