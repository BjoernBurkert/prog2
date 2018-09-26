package aufgabe3;

import java.util.Scanner;
import java.util.EmptyStackException;
/**
 * Klasse zum Auswerten von arithmetischen Ausdrücken.
 * O. Bittel; 22.03.2018
 */
public class Evaluator {

	private static final String ANSI_BLUE = "\u001B[34m";
	
	private static final Object[] stack = new Object[100]; // Stack
	private static int size = 0;   // Anzahl Elemente im Stack
	
	private static Object token;
	private static Tokenizer tokenizer;
	
	/**
	 * Wertet expr als arithmetischen Ausdruck aus.
	 *
	 * @param expr Arthmetischer Ausdruck als String
	 * @return Wert des Ausdrucks oder null, falls der Ausdruck fehlerhaft ist.
	 */
	public static Double eval(String expr) {
		size = 0;
		tokenizer  = new Tokenizer(expr);
		token  = tokenizer.nextToken();
		
		while (token != null) {
			// Ihr Code:
			// ...
			if (shift()){
				continue;
			} else if (reduce()){
				continue;
			} else if (accept()){
				return (Double) stack[0];
			} 
		}
		return null;
	}

	private static boolean shift() {
		// Prüfe, ob shift gemacht werden muss und führe shift durch.
		// Liefere true zurück, falls shift gemacht wurde, sonst false.
		
		// Ihr Code:
		if(size == 0 && (isKlAuf(token)) || (isVal(token))){
			doShift();
			return true;
		} else if(size > 0 && (isOp(stack[size-1])) || (isKlAuf(token)) || (isOp(token))){
			doShift();
			return true;
		} else if(size == 1 &&  (isKlAuf(stack[size-1])) || (isKlAuf(token)) || (isOp(token))){
			doShift();
			return true;
		} else if(size >= 1 && (isVal(stack[size-1])) || (isOp(token))){
			doShift();
			return true;
		} else if(size >= 2 && isKlAuf(stack[size-2]) && isOp(stack[size-1]) || isKlAuf(token) || isVal(token)){
			doShift();
			return true;
		} else if(size >= 3 && isVal(stack[size-3]) && isOp(stack[size-2]) && isVal(stack[size-1]) || isOp(token) || isPlus(token) || isMinus(token) || isMult(token) || isDiv(token)){
			doShift();
			return true;
		} else {
			return false;
		}
	}


	private static void doShift() {
		System.out.println("shift");
		
		// Ihr Code:
		// ...
		stack[size++] = token;
		token = tokenizer.nextToken();
	}
	
	private static boolean reduce() {
		// Prüfe ob reduce gemacht werden muss und führe reduce durch.
		// Liefere true zurück, falls reduce gemacht wurde, sonst false.
		
		// Ihr Code:
		// ...
		if(size == 0 && (isKlAuf(token)) && (isVal(token)) && (isKlZu(token))){
			doReduceKlAufValKlZu();
		} else if(size > 0 && (isVal(token)) && isOp(stack[size-1]) && (isVal(token))){
			doReduceValOpVal();
		} else {
			return false;
		}
		
		return true;
	}
	
	private static void doReduceKlAufValKlZu() {
		System.out.println("reduce ( val )");
		
		// Ihr Code:
		// ...
		stack[size-2] = stack[size-1];
		stack[size-1] = null;
		stack[size] = null;
		
		
	}

	private static void doReduceValOpVal() {
		System.out.println("reduce val op val");
		
		// Ihr Code:
		// ...
		if(isPlus(token)){
			double a = Double.parseDouble((String) stack[size-2]);
			double b = Double.parseDouble((String) stack[size]);
			
			stack[size-1] = a+b;
			
		} else if(isMinus(token)){
			double a = Double.parseDouble((String) stack[size-2]);
			double b = Double.parseDouble((String) stack[size]);
			
			stack[size-1] = a-b;
			
		} else if(isMult(token)){
			double a = Double.parseDouble((String) stack[size-2]);
			double b = Double.parseDouble((String) stack[size]);
			
			stack[size-1] = a*b;
			
		} else if(isDiv(token)){
			double a = Double.parseDouble((String) stack[size-2]);
			double b = Double.parseDouble((String) stack[size]);
			
			stack[size-1] = a/b;
		}
		
		
		
	}
	
	private static boolean accept() {
		// Prüfe ob accept vorliegt und liefere true zurück, sonst false.
		
		// Ihr Code:
		// ...
		if(size > 0 && (isDollar(token)) || (isVal(token))){
			return true;
		} else {
			return false;
		}
	}

	private static boolean isKlAuf(Object o) {
		return o instanceof String && ((String) o).equals("(");
	}

	private static boolean isKlZu(Object o) {
		return o instanceof String && ((String) o).equals(")");
	}

	private static boolean isPlus(Object o) {
		return o instanceof String && ((String) o).equals("+");
	}

	private static boolean isMinus(Object o) {
		return o instanceof String && ((String) o).equals("-");
	}

	private static boolean isMult(Object o) {
		return o instanceof String && ((String) o).equals("*");
	}

	private static boolean isDiv(Object o) {
		return o instanceof String && ((String) o).equals("/");
	}
	
	private static boolean isDollar(Object o) {
		return o instanceof String && ((String) o).equals("$");
	}

	private static boolean isOp(Object o) {
		if (!(o instanceof String))
			return false;
		String s = (String) o;
		return (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/"));
	}

	private static boolean isVal(Object o) {
		return o instanceof Double;
	}


	/**
	 * Liest von der Konsole eine Folge von Zeilen, wertet jede Zeile als
	 * Ausdruck aus und gibt seinen Wert aus. (repl = read-evaluate-print-loop).
	 */
	public static void repl() {
		Scanner in = new Scanner(System.in);
		System.out.print(ANSI_BLUE + ">> ");
		
		while (in.hasNextLine()) {
			String line = in.nextLine();
			// Ihr Code:
			// ...
			try{
				if(line.equals("end")){
					System.out.println("bye!");
				}else{
					System.out.println(eval(line));
				}
			}catch(EmptyStackException x){
				System.out.println("!!!error");
			}
		}
		
	}

	/**
	 * Testprogramm.
	 *
	 * @param args wird nicht benutzt.
	 */
	public static void main(String[] args) {
		// Tests:
		String s1 = "(2+3*4-4)/2";
		String s2 = "(2+3*4-4))/2";
		String s3 = "(2+3*4-4)//2";
		String s4 = "1/2*2";
		String s5 = "1+2";

		System.out.println(eval(s1));	// 5.0
		System.out.println(eval(s2));	// null; Syntaxfehler
		System.out.println(eval(s3));	// null; Syntaxfehler
		System.out.println(eval(s4));	// 1.0
		System.out.println(eval(s5));	// 3.0
		
		// read-evaluate-print-loop:
		repl();
	}
}
