// O. Bittel
// 17.5.2011

package aufgabe9;

import java.util.*;
import java.util.Iterator;

public class BinarySearchTree implements Iterable<Integer> {

    @Override
    public Iterator<Integer> iterator() {
        return new IntIterator(this);
    }

    class IntIterator implements Iterator<Integer> {

        private List<Node> nodeList = new ArrayList<>();
        private int index = 0;

        public IntIterator(BinarySearchTree tree)  {
            if (tree != null) {
            	inOrderList(tree.root, nodeList);
            }              
        }
        
        private void inOrderList(Node p, List<Node> nodeList) {      	
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
        public Integer next() {
        	int returnData = nodeList.get(index).data;
        	index++;
        	return returnData;
        }
    }

    private static class Node {
        private int data;
        private Node left;
        private Node right;
        private Node(int x) {
            data = x;
            left = null;
            right = null;
        }
    }

    private Node root = null;
    private int size = 0;

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder("GenericBinarySearchTree: ");
        appendR(s,root);
        s.append(" size = ").append(size);
        return s.toString();
    }

    private static void appendR(StringBuilder s, Node p) {
        if (p != null) {
            appendR(s,p.left);
            s.append(p.data).append(", ");
            appendR(s,p.right);
        }
    }

    public boolean contains(int x) {
        return containsR(x,root);
    }

    private boolean containsR(int x, Node p) {
	if (p == null)
            return false;
	else if (x < p.data)
            return containsR(x,p.left);
	else if (x > p.data)
            return containsR(x,p.right);
	else
            return true;
    }

    public void insert(int x) {
        root = insertR(x,root);
    }

    private Node insertR(int x, Node p) {
	if (p == null) {
            size++;
            return new Node(x);
        }
	if (x < p.data)
            p.left = insertR(x,p.left);
	else if (x > p.data)
            p.right = insertR(x,p.right);
	// im else-Fall ist nicht zu tun; keine doppelten Werte
	return p;
    }

    public void remove(int x) {
        root = removeR(x,root);
    }

    private Node removeR(int x, Node p) {
        if (p == null)
            return null;
	if (x < p.data)
            p.left = removeR(x,p.left);
	else if (x > p.data)
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

    private int getMin(Node p) {
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
    	Node p = this.root;
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
    
    private void prettyPrintRecursive(Node p, int x) {
    	int einrueckung = x;
    	for (int i = 0; i < einrueckung; i++) {
    		System.out.print("    ");
    	}
    	System.out.println("|___" + p.data);
    	einrueckung++;
    	if (p.left != null) {
    		prettyPrintRecursive(p.left, einrueckung);
    	}  	
    	if (p.right != null && p.left == null) {
    		for (int i = 0; i < einrueckung; i++){
    			System.out.print("    ");
    		}
    		System.out.println("|___#");
    	}
    	if (p.right != null){
    		prettyPrintRecursive(p.right, einrueckung);
    	}
    	if (p.left != null && p.right == null) {
        	for (int i = 0; i < einrueckung; i++) {
        		System.out.print("    ");
        	}
        	System.out.println("|___#");
    	}

    }
    
    public int height() {
    	
    	Node p = this.root;
        List<Integer> heightList = new ArrayList<Integer>();
        
    	if (p.left != null) {
    		
    			heightR(p.left, 0, heightList);
    	}
    	
    	if (p.right != null) {

    			heightR(p.right, 0, heightList);
    	}
   	
    	return Collections.max(heightList);
    	
    }
    
    private void heightR(Node p, int height, List<Integer> heightList) {

    	height++;
    	heightList.add(height);
    	
    	if (p.right != null) {
    		heightR(p.right, height, heightList);
    	}
    	
    	if (p.left != null) {
    		heightR(p.left, height, heightList);
    	}
     }
    
    public void subSet(int min, int max, List<Integer> list) {
    	
    	Node p = this.root;
    	
    	if (p == null) {
    		return;
    	}
    	
    	if (p.data > min && p.data < max) {
    		list.add(p.data);
    	}
    	
    	subSetR(p.left, min, max, list);
    	subSetR(p.right, min, max, list);
    }
    
    private void subSetR(Node p, int min, int max, List<Integer> list) {
    	if (p == null) {
    		return;
    	} 
    	
    	if (p.data > min && p.data < max) {
    		list.add(p.data);
    	}
    	
    	if (p.data > max) {
    		subSetR(p.left, min, max, list);
    	} else if (p.data < min) {
    		subSetR(p.right, min, max, list);
    	} else {
    		subSetR(p.left, min, max, list);
    		subSetR(p.right, min, max, list);
    	}
    }

}
    	
    	