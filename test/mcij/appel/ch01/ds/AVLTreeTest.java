package mcij.appel.ch01.ds;

import static org.junit.Assert.*;

import org.junit.Test;

/** 
 * @author Deng Li (li.zandeng@gmail.com)
 * @version Create time：2017年9月17日 下午9:54:20 
 *  
 */
public class AVLTreeTest {

	@Test
	public void testSearch() {
		fail("Not yet implemented");
	}

	@Test
	public void testInsertBinarySearchTree() {
		AVLTree tree = new AVLTree();
		tree.insertWithoutAdjust("e", 0);
		tree.insertWithoutAdjust("f", 0);
		tree.insertWithoutAdjust("a", 0);
		tree.insertWithoutAdjust("b", 0);
		tree.insertWithoutAdjust("d", 0);
		tree.insertWithoutAdjust("c", 0);
		tree.showValue();
	}
	
	@Test
	public void testInsert() {
		fail("Not yet implemented");		
	}

	@Test
	public void testRemove() {
		fail("Not yet implemented");
	}

	@Test
	public void testRightRotate() {
		
		AVLTree tree = new AVLTree();
		tree.insertWithoutAdjust("5", 0); // root
		
		tree.insertWithoutAdjust("2", 0); // left subtree
		tree.insertWithoutAdjust("1", 0);
		tree.insertWithoutAdjust("3", 0);
	
		tree.insertWithoutAdjust("7", 0); // right subtree
		tree.insertWithoutAdjust("6", 0);
		tree.insertWithoutAdjust("8", 0);
		
		/**
		 *                5
		 *             2     7
		 *           1   3| 6  8
		 */
		tree.showValue();
		System.out.println(tree);
		
		
		//rotate right
		tree.rightRotate();
		/**
		 *                2
		 *             1     5
		 *                 |3  7
		 *                   |6  8
		 */
		tree.showValue();
		System.out.println(tree);
		
		
		//rotate left, then will be the same with the original structure
		tree.leftRotate();
		/**
		 *                5
		 *             2     7
		 *           1   3| 6  8
		 */
		tree.showValue();
		System.out.println(tree);
		
	}

	@Test
	public void testLeftRotate() {
		
		AVLTree tree = new AVLTree();
		tree.insertWithoutAdjust("5", 0); // root
		
		tree.insertWithoutAdjust("2", 0); // left subtree
		tree.insertWithoutAdjust("1", 0);
		tree.insertWithoutAdjust("3", 0);
	
		tree.insertWithoutAdjust("7", 0); // right subtree
		tree.insertWithoutAdjust("6", 0);
		tree.insertWithoutAdjust("8", 0);
		
		/**
		 *                5
		 *             2     7
		 *           1   3| 6  8
		 */
		tree.showValue();
		System.out.println(tree);
		
		
		//rotate right
		tree.rightRotate();
		/**
		 *                2
		 *             1     5
		 *                 |3  7
		 *                   |6  8
		 */
		tree.showValue();
		System.out.println(tree);
		
		
		//rotate left, then will be the same with the original structure
		tree.leftRotate();
		/**
		 *                5
		 *             2     7
		 *           1   3| 6  8
		 */
		tree.showValue();
		System.out.println(tree);
	}

}
