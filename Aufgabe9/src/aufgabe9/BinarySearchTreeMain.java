package aufgabe9;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchTreeMain {

    public static void main(String[] args) {

        BinarySearchTree t = new BinarySearchTree();
        List<Integer> list = new ArrayList<Integer>();      

        t.insert(5);
        t.insert(3);
        t.insert(8);
        t.insert(1);
        t.insert(4);
        t.insert(6);
        t.insert(7);
        System.out.println(t);
        t.prettyPrint();
        System.out.println("height: " + t.height());
		t.subSet(3, 8, list);
		System.out.println(list.toString());
		System.out.println(t);

        for (int i : t) {
            System.out.println(i);
        }
    }
}
