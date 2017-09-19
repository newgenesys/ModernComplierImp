package mcij.appel.ch01.ds;

/** 
 * exercise 1.1 d
 * Research balanced search trees in Sedgewick [1997] and recommend
 * a balanced-tree data structure for functional symbol tables.
 * 
 * solution: AVL tree
 * 
 * simple example here, node stores a single String/int pair;
 * 
 * @author Deng Li (li.zandeng@gmail.com)
 * @version Create time：2017年9月17日 下午4:32:06 
 *  
 */

public class AVLTree {
	
	AVLTree leftTree; //left subtree
	AVLTree rightTree; //right subtree
	Node node;  // current node
	
	/**
	 * Node class of the tree
	 */
	class Node{
		String id; //the id name of the Node
		int iValue; //actual value of the node
		int iHeightDiff; // -1,0,1
		
		Node(String id, int iValue){
			this.id = id;
			this.iValue = 0;
			this.iHeightDiff = 0;
		}
	}
	
	/**
	 * constructor, new an empty tree
	 * tree height: 0
	 */
	AVLTree(){
		this.node = null;
		leftTree = null;
		rightTree = null;
	}
	
	/**
	 * constructor, new an single-node tree
	 * tree height: 1
	 * @param id
	 * @param iValue
	 */
	AVLTree(String id, int iValue){
		this.node = new Node(id,iValue);
		leftTree = null;
		rightTree = null;
	}
	
	/**
	 * search for a certain id
	 * binary search tree
	 * @param iSearch
	 * @return
	 */
	public boolean search(String idString){
		
		if(idString.equals(this.node.id)){
			return true;
		}else if(idString.compareTo(this.node.id)>0){
			if(null != this.rightTree)
				return this.rightTree.search(idString);
		}else if(idString.compareTo(this.node.id)<0){
			if(null != this.leftTree)
				return this.leftTree.search(idString);
		}
		return false;
	}
	
	/**
	 * insert a new node into the tree, and adjust to a balance tree
	 * property: left nodes< node < right nodes
	 * for each node: iHeightDiff in {-1,0,1}
	 * @param id
	 * @param iValue
	 */
	public void insert(String id, int iValue){
		
//		while(){
//			
//		}
		
	}
	
	/**
	 * naive insert method
	 * insert a new node into the tree, and don't adjust to a balance tree
	 * property: left nodes< node < right nodes
	 * 
	 * @param iInsert
	 */
	public void insertWithoutAdjust(String id, int iValue){
		
		if(this.node == null){
			Node newNode = new Node(id,iValue);
			this.node = newNode;
		}else if(id.compareTo(this.node.id)>0){
			if(this.rightTree==null)
				this.rightTree = new AVLTree();
			this.rightTree.insertWithoutAdjust(id,iValue);
		}else if(id.compareTo(this.node.id)<0){
			if(this.leftTree==null)
				this.leftTree = new AVLTree();
			this.leftTree.insertWithoutAdjust(id,iValue);
		}
	}
	
	public void remove(String id){
		
	}
	
	/**
	 * right rotate
	 * is reversible with left rotate
	 */
	void rightRotate(){
		AVLTree newRightTree = new AVLTree();
		newRightTree.node = this.node;
		newRightTree.rightTree = this.rightTree;
		newRightTree.leftTree = this.leftTree.rightTree;
		
		this.node = this.leftTree.node;
		this.leftTree = this.leftTree.leftTree;
		this.rightTree = newRightTree;
	}
	
	/**
	 * left rotate
	 * is reversible with right rotate
	 */
	void leftRotate(){
		AVLTree newLeftTree = new AVLTree();
		newLeftTree.node = this.node;
		newLeftTree.leftTree = this.leftTree;
		newLeftTree.rightTree = this.rightTree.leftTree;
		
		this.node = this.rightTree.node;
		this.rightTree = this.rightTree.rightTree;
		this.leftTree = newLeftTree;
	}
	
	public void showValue(){

		if(this.leftTree != null)
			this.leftTree.showValue();
		
		System.out.print(this.node.id+" ");
		
		if(this.rightTree != null)
			this.rightTree.showValue();

	}
	
//	public String toString(){
//		
//		StringBuilder sb= new StringBuilder();
//		
//		
//		
//		return sb.toString();
//	}
	
	public static void main(String args[]){
//		AVLTree tree = new AVLTree();
//		tree.insert("a",1);
//		tree.insert("b",1);
//		tree.insert("c",1);
//		tree.insert("B", 0);
		
//		AVLTree tree = new AVLTree();
//		tree.insert("e", 0);
//		tree.insert("f", 0);
//		tree.insert("a", 0);
//		tree.insert("b", 0);
//		tree.insert("d", 0);
//		tree.insert("c", 0);
//		tree.showValue();
		
		AVLTree tree = new AVLTree();
		tree.insertWithoutAdjust("5", 0);
		
		tree.insertWithoutAdjust("2", 0);
		tree.insertWithoutAdjust("1", 0);
		tree.insertWithoutAdjust("3", 0);
		
		tree.insertWithoutAdjust("7", 0);
		tree.insertWithoutAdjust("6", 0);
		tree.insertWithoutAdjust("8", 0);
		
//		tree.to
		tree.showValue();
		System.out.println(tree);
		
		
		tree.rightRotate();
		tree.showValue();
		System.out.println(tree);
		
		
		tree.leftRotate();
		tree.showValue();
		System.out.println(tree);
	}
	
}
