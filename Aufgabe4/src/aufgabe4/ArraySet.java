package aufgabe4;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArraySet<T> extends AbstractSet<T> {

	private static final int DEF_CAPACITY = 32;
	private int size;
	private T[] data;
	

	public ArraySet() {
		clear();
	}

	@Override
	public int size() {
		return size;
	}
	
	
	@Override
	public boolean isEmpty() {
		if (size == 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean add(T x) {
		if (contains(x)) {
			return false;
		}
		if (data.length == size) {
			ensureCapacity(2 * size);
		}
		data[size] = x;
		size++;
		return true;
	}
	
	@SuppressWarnings("unchecked")
	private void ensureCapacity(int newCapacity) {
		if (newCapacity < size){
			return;
		}
		T[] old = data;
		data = (T[])new Object[newCapacity];
		System.arraycopy(old, 0, data, 0, size);
	}

	@Override
	@SuppressWarnings("unchecked")
	public boolean remove(Object x) {
		if (!contains(x)) {
			return false;
		}
		int i;
		for (i = 0; i < size; i++) {
			if (data[i].equals(x)) {
				break;
			}
		}
		for (int j = i; j < size; j++) {
			data[j] = data[j + 1];
		}
		size--;
		return true;

	}

	@Override
	public String toString() {
		StringBuilder s = new StringBuilder("");
		s.append("{");
		int i;
		for (i = 0; i < size - 1; i++) {
			s.append(data[i]).append(", ");
		}
		if (size == 0) {
			s.append(" }");
		} else {
			s.append(data[i]).append("}");
		}
		return s.toString();
	}

	@Override
	public boolean contains(Object x) {
		for (int i = 0; i < size; i++) {
			if (data[i].equals(x)) {
				
				return true;
			}
		}
		return false;
	}

	

	@Override
	@SuppressWarnings("unchecked")
	public void clear() {
		size = 0;
		data = (T[]) new Object[DEF_CAPACITY];
	}
	
	@Override
	public Iterator<T> iterator() {
		return new ArraySetIterator();
	}
	
	private class ArraySetIterator implements Iterator<T> {
		private int zeiger = 0;
		
		
		public boolean hasNext() {
			return zeiger < size;
		}
		
		public T next() {
			if(hasNext()) {
				return data[zeiger++];
			} else {
				throw new NoSuchElementException();
			}
		}
		
		public void remove() {
			throw new UnsupportedOperationException();
		}
	}

	@Override
	public T get(int i) throws IndexOutOfBoundsException {
		return null;
	}

}