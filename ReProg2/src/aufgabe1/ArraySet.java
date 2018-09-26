package aufgabe1;

public class ArraySet extends AbstractSet{
	private static final int DEF_CAPACITY = 32;
	private int size;
	private int[] data;
	
	
	public ArraySet(){
		clear();
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		if(size == 0){
			return true;
		}
		return false;
	}

	@Override
	public boolean add(int x) {
		if(contains(x)){
			return false;
		}
		if (data.length == size){
			ensureCapacity(2 * size);
		}
		int i;
		for(i = 0; i < size; i++){
			if(x < data[i]){
				break;
			}
		}
		for(int j = size; j > i; j--){
			data[j] = data[j -1];
		}
		data[i] = x;
		size++;
		return true;
		
	}

	private void ensureCapacity(int newCapacity) {
		if(newCapacity < size)
			return;
			int[] old = data;
			data = new int[newCapacity];
			System.arraycopy(old, 0, data, 0, size);
		
	}

	@Override
	public boolean remove(int x) {
		if (!contains(x)){
			return false;
		}
		int i;
		for (i = 0; i < size; i++){
			if (x == data[i]){
				break;
			}
		}
		for (int j = i; j < size; j++){
			data[j] = data[j + 1];
		}
		size--;
		return true;
	}

	@Override
	public boolean contains(int x) {
		for (int i = 0; i < size; i++){
			if (x == data[i]){
				return true;
			}
		}
		return false;
	}

	@Override
	public int get(int i) throws IndexOutOfBoundsException {
		if(i < 0 || i >= size) {
			throw new IndexOutOfBoundsException();
		}
		return data[i];
	}
	
	@Override
	public String toString() {
		StringBuilder s = new StringBuilder("");
		s.append("{");
		int i;
		for (i = 0; i < size - 1; i++){
			s.append(data[i]).append(", ");
		}
		if (size == 0){
			s.append(" }");
		} else {
			s.append(data[i]).append("}");
		}
		return s.toString();
	}



	@Override
	public void clear() {
		size = 0;
		data = new int[DEF_CAPACITY];
		
	}

}
