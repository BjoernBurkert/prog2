package aufgabe4;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedListSet<T> extends AbstractSet<T> {
	
	private Node<T> head;
	private int size;
	private int modCount = 0;
	
	public LinkedListSet(){
		clear();
	}
	
	public final void clear() {
		head = new Node<T>(null, null);
		size = 0;
		modCount++;
	}
	
	static private class Node<T>{
		private Node<T> next;
		private T data;
		public Node(T x, Node<T> p){
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
	public boolean add(T x) {
		if (contains(x)){
			return false;
		}

		head.next = new Node<T>(x, head.next);
		size++;
		modCount++;
		return true;
	}

	@Override
	public boolean remove(Object x) {
		if(!contains(x)){
			return false;
		}
		Node<T> p = head;
		while(p.next != null && p.next.data != x){
			p = p.next;
		}
		p.next = p.next.next;
		size--;
		return true;
	}

	@Override
	public boolean contains(Object x) {
		for(Object a : this){
			if(a.equals(x)){
				return true;
			}
		}
		return false;
	}

	@Override
	public T get(int idx) throws IndexOutOfBoundsException {
		if (idx < 0 || idx >= size){
			throw new IndexOutOfBoundsException();
		} else {
			Node<T> p = head.next;
			for (int i = 0; i < idx; i++){
				p = p.next;
			}
			return p.data;
		}
	}
	
	@Override
	public String toString(){
		StringBuilder list = new StringBuilder("");
		list.append("{");
		Node<T> p = head.next;
		if (size == 0){
			list.append(" }");
		}
		for(p = head.next; p != null; p = p.next){
			if(p.next == null){
				list.append(p.data).append("}").append(";");
				
			} else {
				list.append(p.data).append(" ,");
			}
		}
		return list.toString();
		
	}

	@Override
	public Iterator<T> iterator() {
		return new LinkedListIterator();
	}
	
	private class LinkedListIterator implements Iterator<T>{
		private Node<T> current = head;
		private int expectedMod = modCount;
		
		@Override
		public boolean hasNext() {
			return current.next != null;
		}
		@Override
		public T next() {
			if(expectedMod != modCount){
				throw new ConcurrentModificationException();
			}
			if(!hasNext()){
				throw new NoSuchElementException();
			}
			
			current = current.next;
			return current.data;
		}
		
		public void remove(){
			throw new UnsupportedOperationException();
		}
	}
}
