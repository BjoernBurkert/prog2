// O. Bittel
// 17.5.2011

package aufgabe9Generisch;

import java.util.*;

public class GenericBinarySearchTree<T extends Comparable<T>> implements Iterable<T> {

    @Override
    public Iterator<T> iterator() {
        return new GenericIterator<T>(this);
    }

    private static class GenericIterator<T extends Comparable<T>> implements Iterator<T> {

        private List<Node<T>> nodeList = new ArrayList<>();
        private int index = 0;

        public GenericIterator(GenericBinarySearchTree<T> tree)  {
            if (tree != null) {
            	inOrderList(tree.root, nodeList);
            }              
        }
        
        private void inOrderList(Node<T> p, List<Node<T>> nodeList) {      	
        	if (p != null) {
        		inOrderList(p.left, nodeList);
        		nodeList.add(p);
        		inOrderList(p.right, nodeList); 
        	}	
        }

        @Override
        public boolean hasNext() {
        	return (index < nodeList.size());
        }

        @Override
        public T next() {
        	T returnData = nodeList.get(index).data;
        	index++;
        	return returnData;
        }
    }

    private static class Node<T extends Comparable<T>> {
        private T data;
        private Node<T> left;
        private Node<T> right;
        private Node(T x) {
            data = x;
            left = null;
            right = null;
        }
    }

    private Node<T> root = null;
    private int size = 0;

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder("GenericBinarySearchTree: ");
        appendR(s,root);
        s.append(" size = ").append(size);
        return s.toString();
    }


	private void appendR(StringBuilder s, Node<T> p) {
        if (p != null) {
            appendR(s,p.left);
            s.append(p.data).append(", ");
            appendR(s,p.right);
        }
    }

    public boolean contains(T x) {
        return containsR(x,root);
    }

    private boolean containsR(T x, Node<T> p) {
        if (p == null) {
            return false;
        }
        else if (x.compareTo(p.data) < 0 ) {
            return containsR(x,p.left);
        } else if (x.compareTo(p.data) > 0) {
            return containsR(x,p.right);
        }
        else {
            return true;
        }
    }

    public void insert(T x) {
        root = insertR(x,root);
    }

    private Node<T> insertR(T x, Node<T> p) {
        if (p == null) {
            size++;
            return new Node<T>(x);
        }

        if (x.compareTo(p.data) < 0) {
            p.left = insertR(x, p.left);
        } else if (x.compareTo(p.data) > 0 ) {
            p.right = insertR(x,p.right);
        }

        return p;
    }

    public void remove(T x) {
        root = removeR(x,root);
    }

    private Node<T> removeR(T x, Node<T> p) {
        if (p == null) {
            return null;
        }

	if (x.compareTo(p.data) < 0)
            p.left = removeR(x,p.left);
	else if (x.compareTo(p.data) > 0)
            p.right = removeR(x,p.right);
    else {
        // Knoten loeschen:
        if (p.left == null || p.right == null) {
            // One or no child can be deleted directly:
            size--;
            p = (p.left != null) ? p.left : p.right;
        }
        else {
            // Two children
            p.data = getMin(p.right);
            p.right = removeR(p.data,p.right);
        }
        }
	return p;
    }

    private T getMin(Node<T> p) {
        assert (p != null);
        while(p.left != null)
            p = p.left;
        return p.data;
    }

    public void clear() {
        root = null;
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public void prettyPrint() {
    	Node<T> p = this.root;
    	if (p != null) {
    		System.out.println(this.root.data);
    	}    	
    	if(p.left != null) {
    		prettyPrintRecursive(p.left, 0);
    	}
    	if (p.right !=null) {
    		prettyPrintRecursive(p.right, 0);
    	}

    }
    
    private void prettyPrintRecursive(Node<T> p, int x) {
    	int einrueckung = x;
        String emptySpaces = "    ";
    	for (int i = 0; i < einrueckung; i++) {
    		System.out.print(emptySpaces);
    	}
    	System.out.println("|___" + p.data);
    	einrueckung++;
    	if (p.left != null) {
    		prettyPrintRecursive(p.left, einrueckung);
    	}  	
    	if (p.right != null && p.left == null) {
    		for (int i = 0; i < einrueckung; i++) {
        		System.out.print(emptySpaces);
        	}
    	}
    	if (p.right != null ) {
        	for (int i = 0; i < einrueckung; i++) {
        		System.out.print(emptySpaces);
        	}
        	System.out.println("|___#");
    	}

    }
    
    public int height() {
    	Node<T> p = this.root;
        List<Integer> heightList = new ArrayList<>();

    	if (p.left != null) {
            heightR(p.left, 0, heightList);
    	}

    	if (p.right != null) {
            heightR(p.right, 0, heightList);
    	}

    	return Collections.max(heightList);
    }
    
    private void heightR(Node<T> p, int height, List<Integer> heightList) {
    	height++;
    	heightList.add(height);
    	
    	if (p.right != null) {
    		heightR(p.right, height, heightList);
    	}
    	
    	if (p.left != null) {
    		heightR(p.left, height, heightList);
    	}
     }
    
    public void subSet(T min, T max, List<T> list) {
    	
    	Node<T> p = this.root;
    	
    	if (p == null) {
    		return;
    	}
    	
    	if (p.data.compareTo(min) > 0 && p.data.compareTo(max) < 0) {
    		list.add(p.data);
    	}
    	
    	subSetR(p.left, min, max, list);
    	subSetR(p.right, min, max, list);
    }
    
    private void subSetR(Node<T> p, T min, T max, List<T> list) {
    	if (p == null) {
    		return;
    	} 
    	
    	if (p.data.compareTo(min) > 0 && p.data.compareTo(max) < 0) {
    		list.add(p.data);
    	}
    	
    	if (p.data.compareTo(max) > 0) {
    		subSetR(p.left, min, max, list);
    	} else if (p.data.compareTo(min) < 0) {
    		subSetR(p.right, min, max, list);
    	} else {
            subSetR(p.left, min, max, list);
            subSetR(p.right, min, max, list);
        }
    }

}