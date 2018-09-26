package aufgabe3;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;

public class BraceUtitlity {

	public static void printBrackets(String fn) throws FileNotFoundException, IOException {
		LineNumberReader in = new LineNumberReader(new FileReader(fn));
		String line;
		while ((line = in.readLine()) != null) {
			System.out.println(line);
			System.out.print("Klammern: ");
			for (int i = 0; i < line.length(); i++) {
				char c = line.charAt(i);
				switch (c) {
				case '(':
				case '{':
				case '[':
					System.out.print(c + ", ");
					break;
				case ')':
				case '}':
				case ']':
					System.out.print(c + ", ");
					break;
				}
			}
			System.out.println();
		}
	}

	public static void checkBrackets(String fn) throws FileNotFoundException, IOException {
		LineNumberReader in = new LineNumberReader(new FileReader(fn));
		Deque<Character> stack = new LinkedList<Character>(); // JDK 1.2
																// Collections

		// ...
		String line;
		while ((line = in.readLine()) != null) {
			if (line.contains("//")) {
				line = line.substring(0, line.indexOf("//"));
				if (line.length() <= 0) {
					continue;
				}
			}
			for (int i = 0; i < line.length(); i++) {
				char c = line.charAt(i);
				if (!stack.isEmpty() && stack.element() == '"') { // Grade in string																	// String
					if (c == '"') {
						stack.pop();
						continue;
					} else {
						continue;
					}
				}
				switch (c) {

				case '"':
				case '(':
				case '{':
				case '[':
					stack.push(c);
					break;
				case ')':
					if (stack.isEmpty()) {
						System.err.println("Öffnende Klammer fehlt");
						return;
					} else if (stack.element() == '(') {
						stack.pop();
					} else {
						System.err.println("Klammerpaar nicht passend");
						return;
					}
					break;
				case '}':
					if (stack.isEmpty()) {
						System.err.println("Öffnende Klammer fehlt");
						return;
					} else if (stack.element() == '{') {
						stack.pop();
					} else {
						System.err.println("Klammerpaar nicht passend");
						return;
					}
					break;
				case ']':
					if (stack.isEmpty()) {
						System.err.println("Öffnende Klammer fehlt");
						return;
					} else if (stack.element() == '[') {
						stack.pop();
					} else {
						System.err.println("Klammerpaar nicht passend");
						return;
					}
					break;
				}

			}
		}
		if (stack.size() == 0) {
			System.out.println("Klammerung korrekt");
		} else {
			System.err.println("Schließende Klammer fehlt");
			System.err.println(stack.pop());
			System.exit(0);
		}
		in.close();
	}

	public static void main(String[] args) throws FileNotFoundException, IOException {
		printBrackets(args[0]);
		checkBrackets(args[0]);
	}
}