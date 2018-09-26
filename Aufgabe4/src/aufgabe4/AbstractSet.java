package aufgabe4;

public abstract class AbstractSet<T> implements Set<T> {

	@Override
	public boolean containsAll(Set<?> s) {
		for(Object x : s) {	
		if (contains (x)) {
				return false;
		}
	}
		return true;
	}

	@Override
	public void removeAll(Set<?> s) {
		for (Object x : s){
			remove(x);
		}
	}
	
	@Override
	public void addAll(Set<? extends T> s) {
		for (T x : s){
			add(x);
		}
    }
}
