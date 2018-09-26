package aufgabe4;

public class SetApplication {

	public static void main(String[] args) {
		Set list1 = new LinkedListSet();
        Set list2 = new LinkedListSet();
        Set list3 = new LinkedListSet();

        System.out.println(list1.add(1));		// true
        System.out.println(list1.add(5));		// true
        System.out.println(list1.add(8));		// true
		System.out.println(list1.add(0));		// true
        System.out.println(list1.add(5));		// false
		System.out.println(list1 + " sortierte Reihenfolge!"); // {0, 1, 5, 8}; sortierte Reihenfolge!
		
		System.out.println(list1.remove(5));	// true
		System.out.println(list1.remove(5));	// false
        System.out.println(list1); // {0, 1, 8}

        for (int i = 1; i <= 50; i++)
            list2.add(2*i);
        System.out.println(list2); // {2, 4, 6, ..., 100}

        list3.add(4);
        list3.add(8);

        // Teilmengenbeziehung pruefen:
		System.out.println(list1.containsAll(list2));  // false
        System.out.println(list1.contains(0));	     // true
        System.out.println(list2.containsAll(list3));  // true
		System.out.println(list2.contains(0));     // false
        System.out.println(list2.containsAll(list2));  // true

        Set s4 = new LinkedListSet();
        for (int i = 1; i <= 40; i++)
            s4.add(5*i);
        System.out.println(s4); // {5, 10, 15, ..., 200}
		s4.remove(200);
		System.out.println(s4); // {5, 10, 15, ..., 195}

        // Vereinigung:
        list2.addAll(s4);
        System.out.println(list2); // {2, 4, 5, 6, ..., 100, 105, ..., 195}

        // Differenzmenge:
        list2.removeAll(s4); 
		System.out.println(list2); // {2, 4, 6, 8, 12, ..., 98}
		System.out.println(s4); // {5, 10, 15, ..., 195}
		
		// Leere Menge:
		list2.clear();
		System.out.println(list2); // { }
    }

}

