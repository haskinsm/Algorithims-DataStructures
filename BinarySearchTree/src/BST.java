
/*************************************************************************
 *  Binary Search Tree class.
 *  Adapted from Sedgewick and Wayne.
 *
 *  @version 3.0 1/11/15 16:49:42
 *
 *  @author TODO  Michael Haskins
 *
 *************************************************************************/

import java.util.NoSuchElementException;

public class BST<Key extends Comparable<Key>, Value> {
    private Node root;             // root of BST

    /**
     * Private node class.
     */
    private class Node {
        private Key key;           // sorted by key
        private Value val;         // associated data
        private Node left, right;  // left and right subtrees
        private int N;             // number of nodes in subtree

        public Node(Key key, Value val, int N) {
            this.key = key;
            this.val = val;
            this.N = N;
        }
    }

    // is the symbol table empty?
    public boolean isEmpty() { return size() == 0; }

    // return number of key-value pairs in BST
    public int size() { return size(root); }

    // return number of key-value pairs in BST rooted at x
    private int size(Node x) {
        if (x == null) return 0;
        else return x.N;
    }

    /**
     *  Search BST for given key.
     *  Does there exist a key-value pair with given key?
     *
     *  @param key the search key
     *  @return true if key is found and false otherwise
     */
    public boolean contains(Key key) {
        return get(key) != null;
    }

    /**
     *  Search BST for given key.
     *  What is the value associated with given key?
     *
     *  @param key the search key
     *  @return value associated with the given key if found, or null if no such key exists.
     */
    public Value get(Key key) { return get(root, key); }

    private Value get(Node x, Key key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if      (cmp < 0) return get(x.left, key);
        else if (cmp > 0) return get(x.right, key);
        else              return x.val;
    }

    /**
     *  Insert key-value pair into BST.
     *  If key already exists, update with new value.
     *
     *  @param key the key to insert
     *  @param val the value associated with key
     */
    public void put(Key key, Value val) {
        if (val == null) { delete(key); return; }
        root = put(root, key, val);
    }

    private Node put(Node x, Key key, Value val) {
        if (x == null) return new Node(key, val, 1);
        int cmp = key.compareTo(x.key);
        if      (cmp < 0) x.left  = put(x.left,  key, val);
        else if (cmp > 0) x.right = put(x.right, key, val);
        else              x.val   = val;
        x.N = 1 + size(x.left) + size(x.right);
        return x;
    }

    /**
     * Tree height.
     *
     * Asymptotic worst-case running time using Theta notation: TODO
     * 			The asymptotic worst-case running time is Theta N. As this function only contains constant time 
     * 			operations, such as if statements and assignments which have a running time of Theta 1. However this function 
     * 			is  recursively called N times which gives it an overall asymptotic worst-case running time of Theta N.
     *         
     *
     * @return the number of links from the root to the deepest leaf.
     *
     * Example 1: for an empty tree this should return -1.
     * Example 2: for a tree with only one node it should return 0.
     * Example 3: for the following tree it should return 2.
     *   B
     *  / \
     * A   C
     *      \
     *       D
     */
    public int height() {
      //TODO fill in the correct implementation.
    	//Need to make private function and pass in the root. (Root is the Node at the top of the BST)
    	return recursiveHeight( root);
    }
    
    private int recursiveHeight( Node x){
    	if(x == null) //if BST empty returns -1
    	{
    		return -1;
    	}
    	int rightHeight = recursiveHeight(x.right); //Need to check height right and then left
    	int leftHeight = recursiveHeight(x.left);
    	if( leftHeight > rightHeight ) //Returns the integer height of the BST to public function 
    	{
    		return leftHeight + 1;
    	}
    	else 
    	{
    		return rightHeight + 1;	
    	}
    }

    /**
     * Median key.
     * If the tree has N keys k1 < k2 < k3 < ... < kN, then their median key 
     * is the element at position (N+1)/2 (where "/" here is integer division)
     *
     * @return the median key, or null if the tree is empty.
     */
    public Key median() {
      if (isEmpty()) return null;
      //TODO fill in the correct implementation. The running time should be Theta(h), where h is the height of the tree.
      else
      {
    	  int median = ((size(root) - 1) / 2); // int median gives the integer position of the median key in the BST.
    	  Node medianNode = medianNode(root, median);
    	  return medianNode.key;
    	  /* Note that the median is always a key, not the average of keys. If there is an even number of keys. 
    	   * For example if the keys in the tree are the A, C, U, W then the median is the key at position (4-1)/2=1, 
    	   * which is key C -- position numbers start at zero.
    	   */
      }
    }
    
    private Node medianNode(Node x, int median)
    {
    	int leftChildSize = size(x.left); //leftChildSize is like a count that goes down the closer you get to the median
		if (leftChildSize < median) //if median is greater than number of nodes in left half of BST implies median root is to the right
		{
			return (medianNode(x.right, (median - leftChildSize - 1))); //Need to -1 to account for node x
		} 
		else if (leftChildSize > median) 
		{
			return (medianNode(x.left, median)); //This and the return above recursively call the medianNode function 
		} 
		else 
		{
			return (x); //returns the median node to public method
		}
	}


    /**
     * Print all keys of the tree in a sequence, in-order.
     * That is, for each node, the keys in the left subtree should appear before the key in the node.
     * Also, for each node, the keys in the right subtree should appear before the key in the node.
     * For each subtree, its keys should appear within a parenthesis.
     *
     * Example 1: Empty tree -- output: "()"
     * Example 2: Tree containing only "A" -- output: "(()A())"
     * Example 3: Tree:
     *   B
     *  / \
     * A   C
     *      \
     *       D
     *
     * output: "((()A())B(()C(()D())))"
     *
     * output of example in the assignment: (((()A(()C()))E((()H(()M()))R()))S(()X()))
     *
     * @return a String with all keys in the tree, in order, parenthesized.
     */
    public String printKeysInOrder() {
	    if (isEmpty()) return "()";
	    // TODO fill in the correct implementation
		else return printKeysNode(root);
    }

	private String printKeysNode(Node x)
	{
		int size = size();
		if(x == null) //Need to check again as will be recursively calling
		{
			return "()";
		}
		else if( size == 1) // Parent with no children
		{
			return "(()"+ x.key.toString() + "())"; 
		}
		else // Parent with one or more children (Nodes)
		{
			return "(" + printKeysNode(x.left) + x.key.toString() + printKeysNode(x.right) + ")";
		}
	}
    /**
     * Pretty Printing the tree. Each node is on one line -- see assignment for details.
     *
     * @return a multi-line string with the pretty ascii picture of the tree.
     */
     public String prettyPrintKeys() {
      //TODO fill in the correct implementation.
    	if(isEmpty())
    	{
    		return "-null\n";
    	}
    	else
    	{
    		return prettyPrintKeysString(root, "");
    	}
	 }
    
	  private String prettyPrintKeysString(Node node, String stringSoFar)
	  {
	  	if(node == null)
	  	{
	  		return stringSoFar + "-null\n"; // adds null then a new line
	  	}
	  	else
	  	{
	  		String prettyPrintKeysString = stringSoFar + "-" + node.key.toString() + "\n" + 
	  				prettyPrintKeysString(node.left, (stringSoFar + " |")) + 
	  				prettyPrintKeysString(node.right, (stringSoFar + "  ")); //Right nodes will be bellow their sibling left node
	  		return prettyPrintKeysString;
	  	}
	 }

    /**
     * Deletes a key from a tree (if the key is in the tree).
     * Note that this method works symmetrically from the Hibbard deletion:
     * If the node to be deleted has two child nodes, then it needs to be
     * replaced with its predecessor (not its successor) node.
     *
     * @param key the key to delete
     */
    public void delete(Key key) {    //Deleted node to be replaced by highest value key in left child's tree. i.e. its predecessor
      //TODO fill in the correct implementation.  
    	root = delete(root, key); 
    }
    
    private Node delete(Node x, Key key)
    {
    	if( x == null)	
    	{
    		return x; // for empty BST, could return null either
    	}
    	 int cmp = key.compareTo(x.key);
         if(cmp < 0) //Then node to delete is in left tree
         {
        	 x.left = delete( x.left, key);
         }
         else if(cmp > 0) //Then node to delete is in right tree
    	 {
    	 	 x.right = delete( x.right, key);
    	 }
         else // Key is the same as x's key, so x is the node to be deleted
         {
        	 if( x.left == null) //No predecessor
        	 {
        		 return x.right; //shift right tree up
        	 }
        	 else if( x.right == null ) 
        	 {                                   
        	 	 return x.left;
        	 }
        	 // node with two children: Get the in-order predecessor (largest
             // in the left subtree) 
             x.key = maxValue(x.left); // Sets key of to be deleted node to equal key of predecessor, which effectively deletes the node you want to be deleted
             // Delete the in-order predecessor from its original position, as it is now in the position of the deleted node 
             x.left = delete(x.left, x.key); 
         }
    	return x;
    }
    
    private Key maxValue(Node x) // returns key with max value in BS tree with root x
    {
    	Key maxValue = x.key;
    	while( x.right != null)
    	{
    		x = x.right;
    		maxValue = x.key;
    	}
    	return maxValue;
    }
    
}
