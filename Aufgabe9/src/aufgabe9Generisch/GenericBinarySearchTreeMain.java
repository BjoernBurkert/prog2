package aufgabe9Generisch;

import java.util.ArrayList;
import java.util.List;

public class GenericBinarySearchTreeMain {

    public static void main(String[] args) {

        GenericBinarySearchTree<String> t = new GenericBinarySearchTree<>();
        List<String> list = new ArrayList<>();

        t.insert("cde");
        t.insert("abc");
        t.insert("fgh");
        t.insert("efg");
        t.insert("bcd");
        t.insert("ijk");
        t.insert("lmn");
        System.out.println(t);
        t.prettyPrint();
        System.out.println("height: " + t.height());
		t.subSet("b", "f", list);
		System.out.println(list.toString());

        for (String i : t) {
            System.out.println(i);
        }
    }
}
