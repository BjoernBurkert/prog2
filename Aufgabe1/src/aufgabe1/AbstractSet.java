package aufgabe1;

public abstract class AbstractSet implements Set {

	@Override
	public boolean containsAll(Set s) {
		for (int i = 0; i < s.size(); i++) {
			if (!this.contains(s.get(i)))
				return false;
		}
		return true;
	}

	@Override
	public void removeAll(Set s) {
		if (s==this)
			clear();
		else {
			for (int i = 0; i < s.size(); i++) {
				if (this.remove(s.get(i)))
					continue;
			}
		}
	}

	@Override
	public void addAll(Set s) {
		if (s==this)
			return;
		for (int i = 0; i < s.size(); i++) {
			if (this.add(s.get(i)))
				continue;
		}
	}

}
