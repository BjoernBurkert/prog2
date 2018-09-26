package aufgabe12b;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;

public class Testklasse {

	
	public static void main(String[] args) {
		List<Person> persList = new LinkedList<Person>();
		Person person1 = new Person("Klaus", "Müller", 1992);
		Person person2 = new Person("Thomas", "Bäcker", 2000);
		Person person3 = new Person("Lara", "Hofmaier", 1996);
		persList.add(person1);
		persList.add(person2);
		persList.add(person3);
		
		Predicate<Person> istVolljaehrig = (person)-> 2017 - person.getGeburtsjahr()  >= 18;
		
		for (Person person : persList) {
			System.out.println(istVolljaehrig.test(person));
		}
		Comparator<Person> PListe = (p2, p1)-> p2.getGeburtsjahr() - p1.getGeburtsjahr();
		Collections.sort(persList, PListe);
		persList.forEach( (person)-> {
				System.out.println(person);
		});
		System.out.println();
		Collections.sort(persList, Collections.reverseOrder((personA, personB)-> (personA.getGeburtsjahr() - personB.getGeburtsjahr())));
		persList.forEach( (person)-> {
				System.out.println(person);
		});
		System.out.println();
		for (Person P : persList){
			if (istVolljaehrig.test(P)) {
				System.out.println(P);
			}
		}
		System.out.println();	
		persList.removeIf(istVolljaehrig.negate());
		for (Person P : persList) {
			System.out.println(P);
		}
		System.out.println();
		persList.replaceAll((Person person)-> person.setNachname(person.getNachname().toUpperCase()));
		for (Person P : persList) {
			System.out.println(P);
		}
		

	}
}
