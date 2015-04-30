import java.io.*;
import java.util.*;

public class BTree<T> {

    public static final int PRE_ORDER = 0;
    public static final int IN_ORDER = 1;
    public static final int POST_ORDER = 2;
    
    private TreeNode<T> root;

    private Random r;

    public BTree() {
	root = null;
    }

    /*======== public void add() ==========
      Inputs:   E d
      Returns: 
      
      Wrapper method for the recursive add()
      ====================*/     
    public void add(T data) {
	TreeNode<T> a = new TreeNode<T>(data);
	add(root, a);
    }

    /*======== public void add() ==========
      Inputs:   TreeNode<E> curr, TreeNode<E> bn  
      Returns: 
      
      Adds bn to the tree rooted at curr. If curr has 
      an available child space, then attach bn there.

      Otherwise, try to add at the subtree rooted at
      one of curr's children. Choose the child to be
      added to randomly.
      ====================*/
    private void add( TreeNode<T> curr, TreeNode<T> bn ) {
	if(curr == null){
	    curr = bn;
	}
	if(curr.getLeft() == null){
	    curr.setLeft(bn);
	}
	if(curr.getRight() == null){
	    curr.setRight(bn);
	}else{
	    int rand = r.nextInt(2);
	    if(rand == 0){
		add(curr.getRight(), bn);
	    }else{
		add(curr.getLeft(), bn);
	    } 
	}

    }
    
    public void traverse( int mode) {
	if (mode == PRE_ORDER)
	    preOrder( root );
	else if ( mode == IN_ORDER )
	    inOrder( root );
	else
	    postOrder( root );
	System.out.println();
    }

    /*======== public void preOrder() ==========
      Inputs:   TreeNode<E> curr  
      Returns: 
      
      Prints out the elements in the tree by doing an
      pre-order Traversal
      ====================*/
    public void preOrder( TreeNode<T> curr ) {
	if(curr != null){
	    System.out.println(curr.getData());
	    preOrder(curr.getLeft());
	    preOrder(curr.getRight());
	}
    }

    /*======== public void inOrder() ==========
      Inputs:   TreeNode<E> curr  
      Returns: 
      
      Prints out the elements in the tree by doing an
      in-order Traversal
      ====================*/
    public void inOrder( TreeNode<T> curr ) {
	if(curr != null){
	    inOrder(curr.getLeft());
	    System.out.print(curr.getData());
	    inOrder(curr.getRight());
	}
    }

    /*======== public void postOrder() ==========
      Inputs:   TreeNode<E> curr  
      Returns: 
      
      Prints out the elements in the tree by doing a
      post-order Traversal    
      ====================*/
    public void postOrder( TreeNode<T> curr ) {
	if(curr != null){
	    postOrder(curr.getLeft());
	    postOrder(curr.getRight());
	    System.out.print(curr.getData());
	}

 }
    
    /*======== public int getHeight()) ==========
      Inputs:   
      Returns: The height of the tree

      Wrapper for the recursive getHeight method
      ====================*/
    public int getHeight() {
	return getHeight(root);
    }
    /*======== public int getHeight() ==========
      Inputs:   TreeNode<E> curr  
      Returns:  The height of the tree rooted at node curr
      
      ====================*/
    public int getHeight( TreeNode<T> curr ) {
	return getHeight(curr,0);
    }

    private int getHeight(TreeNode<T> curr, int currHeight) {
	if (curr == null){
	    return currHeight;
	}else{
	    return Math.max(getHeight(curr.getLeft(), currHeight + 1), getHeight(curr.getRight(), currHeight + 1));
	}
    }
	/*======== private String getLevel() ==========
      Inputs:   TreeNode<E> curr
                int level
                int currLevel  
      Returns: A string containing all the elements on the
               given level with respect to the curr treenode
               ordered left -> right
      
	       ====================*/
    private String getLevel( TreeNode<T> curr, int level, int currLevel ) {
	if (currLevel == level){
	    return "" + curr.getData() + " ";
	}else{
	    return getLevel(curr.getLeft(), level, currLevel + 1) + getLevel(curr.getRight(), level, currLevel + 1);
	}
    }

    
	/*======== public String toString()) ==========
      Inputs:   
      Returns: A string representation of the tree
     
      This string should display each level as a separate line.
      A simple version might look something like this:

      0
      1 2
      3 4 5

      Note that you cannot tell exactly where 3, 4 and 5 lie.
      That is ok, but if you want a CHALLENGE, you can try to
      get the output to look nicer, something like this:
             0
          1      2
            3  4   5
	    ====================*/

    private int maxLength() {
	// returns the minimum number of characters required
	// to print the data from any node in the tree
	if (root == null)
	    return 0;
	return maxLength(root);
    }

    private int maxLength(TreeNode<T> curr) {
	int max = curr.toString().length();
	int temp;
	if (curr.getLeft() != null) {
	    temp = maxLength(curr.getLeft());
	    if (temp > max)
		max = temp;
	}
	if (curr.getRight() != null) {
	    temp = maxLength(curr.getRight());
	    if (temp > max)
		max = temp;
	}
	return max;
    }

    private String spaces(double n) {
	// returns a String of n spaces
	String result = "";
	for (int i = 0; i < n; i++)
	    result += " ";
	return result;
    }

    /*
      getLevel will produce a String for each level of the tree.
      The resulting Strings will look like this:

      ._______________________________
      ._______________._______________
      ._______._______._______._______
      .___.___.___.___.___.___.___.___
      ._._._._._._._._._._._._._._._._

      toString will combine those Strings and provide an output that
      will look like this:

      _______________.
      _______._______________.
      ___._______._______._______.
      _.___.___.___.___.___.___.___.
      ._._._._._._._._._._._._._._._.

      In these diagrams, each dot represents wordLength characters,
      each underscore represents wordLength spaces, and, for any nodes
      that are null, the dots will be "replaced" by underscores.
    */

    private String getLevel(TreeNode<T> curr, int currLevel, int targetLevel, int height, int wordLength) {
	if (currLevel == 1)
	    return curr.toString() + spaces(wordLength - curr.toString().length()) +
		spaces(wordLength * Math.pow(2, height - targetLevel + 1) - wordLength);
	String result = "";
	if (curr.getLeft() != null)
	    result += getLevel(curr.getLeft(), currLevel - 1, targetLevel, height, wordLength);
	else result += spaces(wordLength * Math.pow(2, height - targetLevel + currLevel - 1));
	if (curr.getRight() != null)
	    result += getLevel(curr.getRight(), currLevel - 1, targetLevel, height, wordLength);
	else result += spaces(wordLength * Math.pow(2, height - targetLevel + currLevel - 1));
	return result;
    }

    public String toString() {
	if (root == null)
	    return "";
	String result = "";
	int height = getHeight();
	int wordLength = maxLength();
	// add the every level of the tree except the last one
	for (int level = 1; level < height; level++)
	    // remove extra spaces from the end of each level's String to prevent lines from
	    // getting unnecessarily long and add spaces to the front of each level's String
	    // to keep everything centered
	    result += spaces(wordLength * Math.pow(2, height - level) - wordLength) +
		getLevel(root, level, level, height, wordLength).replaceFirst("\\s+$", "") +
		"\n";
	// now add the last level (level = height)
	result += getLevel(root, height, height, height, wordLength).replaceFirst("\\s+$", "");
	return result;
    }

    
    public static void main( String[] args ) {
	
	BTree<Integer> t = new BTree<Integer>();
	
	for ( int i=0; i < 16; i++ ){ 
	    t.add( i );
	}
	    System.out.println( "Pre-order: ");
	    t.traverse( PRE_ORDER );
	    System.out.println( "In-order: ");
	    t.traverse( IN_ORDER );
	    System.out.println( "Post-order: ");
	    t.traverse( POST_ORDER );
	    System.out.println( "Height: " + t.getHeight() );
	    
	    System.out.println( t );
    }
}