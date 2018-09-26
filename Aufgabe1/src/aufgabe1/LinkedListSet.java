package aufgabe1;

public class LinkedListSet extends AbstractSet {

	private Node head;
	private int size; 
	
	public LinkedListSet() {
		clear();
	}
	
	public final void clear() { /* Mit clear1() legt der Konstruktor,
									eine Liste mit hilfskopfknoten an */
		head = new Node(0,null);
		size = 0;
	}
	
	static private class Node {
		private Node next;
		private int data;
		public Node (int x, Node p) {
			data = x;
			next = p;
		}
	}
	
	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}
	
	@Override
	public boolean add(int x) {
		if (contains(x)) {
			return false;
		}
		Node p = head;
		while(p.next != null && p.next.data < x) {
			p = p.next;
		}
		p.next = new Node(x,p.next);
		size++;
		return true;
	}

	@Override
	public boolean remove(int x) {
		if (!contains(x)) {
			return false;
		}
		Node p = head;
		while(p.next != null && p.next.data != x) {
			p = p.next;
		}
		p.next = p.next.next;
		size--;
		return true;
	}

	@Override
	public boolean contains(int x) {
		Node p;
		for (p = head.next; p != null; p = p.next) {
			if (p.data == x) {
				return true; 
			}
		}
		return false;
	}
 
	@Override
	public int get(int idx) throws IndexOutOfBoundsException {
		if (idx < 0 || idx >= size) {
			throw new IndexOutOfBoundsException();
		} else {
			Node p = head.next;
			for (int i = 0; i < idx; i++) {
				p = p.next;
		}
		return p.data;
	}
}

	@Override
	public String toString() {
		StringBuilder list = new StringBuilder("");
	list.append("{");
	Node p = head.next;
	if (size == 0) {
		list.append(" }");
	}
	for (p = head.next; p != null; p = p.next) {
		if(p.next == null) {
			list.append(p.data).append("}");
		} else {
			list.append(p.data).append(", ");
		}
	}
	return list.toString();
	
//	int i;
//	for (i = 0; i < size - 1; i++) {
//		s.append(data[i]).append(", ");
//	}
//	if (size == 0) {
//		s.append(" }");
//	} else {
//		s.append(data[i]).append("}");
//	}
//	return s.toString();
}
}
