package mcij.appel.ch01.ds;

/**
 * exercise 1.1
 * balanced search trees
 * @author Deng Li (li.zandeng@gmail.com)
 * @version Create time：2017年9月12日 下午8:05:35
 * 
 */
public class Tree {

	Tree left; // left subtree
	String key;
	Object binding;
	Tree right; // right subtree

	Tree(Tree l, String k, Object b, Tree r) {
		left = l;
		key = k;
		binding = b;
		right = r;
	}

	/**
	 * persistent functional binary search trees, so that if
	 * tree2=insert(x,tree1), then tree1 is still available for lookups even
	 * while tree2 can be used.
	 * 
	 * exercise 1.1 b : Extend the program to include not just membership, but the mapping of
	 * keys to bindings:
	 * 
	 * @param key
	 * @param t
	 * @return
	 */
	Tree insert(String key, Object binding, Tree t) {
		if (t == null)
			return new Tree(null, key, binding, null);
		else if (key.compareTo(t.key) < 0)
			return new Tree(insert(key, binding, t.left), t.key, t.binding, t.right);
		else if (key.compareTo(t.key) > 0)
			return new Tree(t.left, t.key, t.binding, insert(key, binding, t.right));
		else
			return new Tree(t.left, key, binding, t.right);
	}
	
	/**
	 *  exercise 1.1 e:
	 *  Rewriteinanobject-oriented (but still “functional”) style,sothat insertion
	 *  is now t.insert(key) instead of insert(key,t) .
	 * @param key
	 * @param binding
	 * @return
	 */
	Tree insert(String key, Object binding) {
		if(this instanceof EmptyTree)
			return new Tree(new EmptyTree(),key, binding, new EmptyTree());
	    else if (key.compareTo(this.key) < 0)
			return new Tree(this.left.insert(key, binding), this.key, this.binding, this.right);
		else if (key.compareTo(this.key) > 0)
			return new Tree(this.left, this.key, this.binding, this.right.insert(key, binding));
		else
			return new Tree(this.left, key, binding, this.right);
	}

	/**
	 * exercise 1.1 a:
	 * Implement a member function that returns true if the item is found, else
	 * false.
	 * @param item
	 * @return
	 */
	public boolean member(String item) {

		if (item.equals(this.key)) {
			return true;
		} else if (item.compareTo(this.key) < 0) {
			return this.left.member(item);
		} else if (item.compareTo(this.key) > 0) {
			return this.right.member(item);
		}
		return false;
	}
	
	/**
	 * exercise 1.1 c :  not a balanced search tree test
	 * @param args
	 */
	public static void main(String args[]){
		
		//sequence 1:  t s p i p f b s t
//		Tree t1 = new Tree(null,"t","t",null);
//		t1 = t1.insert("s", "s", t1);
//		t1 = t1.insert("p", "p", t1);
//		t1 = t1.insert("i", "i", t1);
//		t1 = t1.insert("p", "p", t1);
//		t1 = t1.insert("f", "f", t1);
//		t1 = t1.insert("b", "b", t1);
//		t1 = t1.insert("s", "s", t1);
//		t1 = t1.insert("t", "t", t1);
//		System.out.println(t1);
		
		//sequence 2:  a b c d e f g h i
//		Tree t2 = new Tree(null,"a","b",null);
//		t2 = t2.insert("a", "a", t2);
//		t2 = t2.insert("b", "b", t2);
//		t2 = t2.insert("c", "c", t2);
//		t2 = t2.insert("d", "d", t2);
//		t2 = t2.insert("e", "e", t2);
//		t2 = t2.insert("f", "f", t2);
//		t2 = t2.insert("g", "g", t2);
//		t2 = t2.insert("h", "h", t2);
//		t2 = t2.insert("i", "i", t2);
//		System.out.println(t2);
		
//		Tree t2 = new Tree(null,"a","b",null);
//		t2 = t2.insert("a", "a");
//		t2 = t2.insert("b", "b");
//		t2 = t2.insert("c", "c");
//		t2 = t2.insert("d", "d");
//		t2 = t2.insert("e", "e");
//		t2 = t2.insert("f", "f");
//		t2 = t2.insert("g", "g");
//		t2 = t2.insert("h", "h");
//		t2 = t2.insert("i", "i");
//		System.out.println(t2);
		
		Tree t3 = new EmptyTree();
		t3 = t3.insert("a", "a");
		t3 = t3.insert("b", "b");
		t3 = t3.insert("c", "c");
		t3 = t3.insert("d", "d");
		t3 = t3.insert("e", "e");
		t3 = t3.insert("f", "f");
		t3 = t3.insert("g", "g");
		t3 = t3.insert("h", "h");
		t3 = t3.insert("i", "i");
		System.out.println(t3);
	}
}



