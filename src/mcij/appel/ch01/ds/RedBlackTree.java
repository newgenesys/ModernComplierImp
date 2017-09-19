package mcij.appel.ch01.ds;

/** 
 * 
 * exercise 1.1 d
 * Research balanced search trees in Sedgewick [1997] and recommend
 * a balanced-tree data structure for functional symbol tables.
 * 
 * solution: Red Black Tree
 * 
 * Red Black Tree is a special case of 2-3-4 tree
 * so that height <= log(n), and it is balance.
 * 
 * @author Deng Li (li.zandeng@gmail.com)
 * @version Create time：2017年9月17日 下午4:32:06 
 *  
 */

public class RedBlackTree {
//	
//	private Node root;
//	
//	private class Node { // BST node with color bit (see page 433)
//	private boolean isRed(Node h); // See page 433.
//
//	private Node rotateLeft(Node h); // See page 434.
//
//	private Node rotateRight(Node h); // See page 434.
//
//	private void flipColors(Node h); // See page 436.
//
//	private int size(); // See page 398.
//
//	public void put(Key key, Value val) { // Search for key. Update value if
//											// found; grow table if new.
//			root = put(root, key, val);
//			root.color = BLACK;
//		}
//
//		private Node put(Node h, Key key, Value val) {
//			if (h == null) // Do standard insert, with red link to parent.
//				return new Node(key, val, 1, RED);
//			int cmp = key.compareTo(h.key);
//			if (cmp < 0)
//				h.left = put(h.left, key, val);
//			else if (cmp > 0)
//				h.right = put(h.right, key, val);
//			else
//				h.val = val;
//			if (isRed(h.right) && !isRed(h.left))
//				h = rotateLeft(h);
//			if (isRed(h.left) && isRed(h.left.left))
//				h = rotateRight(h);
//			if (isRed(h.left) && isRed(h.right))
//				flipColors(h);
//			h.N = size(h.left) + size(h.right) + 1;
//			return h;
//		}
//
//		public static void main(String[] args) {
//			// TODO Auto-generated method stub
//
//		}

}
