package BST_A2;

public class BST_Node {
  String data;
  BST_Node left;
  BST_Node right;
  
  BST_Node(String data){ this.data=data; }

  // --- used for testing  ----------------------------------------------
  //
  // leave these 3 methods in, as is

  public String getData(){ return data; }
  public BST_Node getLeft(){ return left; }
  public BST_Node getRight(){ return right; }

  // --- end used for testing -------------------------------------------

  
  // --- fill in these methods ------------------------------------------
  //
  // at the moment, they are stubs returning false 
  // or some appropriate "fake" value
  //
  // you make them work properly
  // add the meat of correct implementation logic to them

  // you MAY change the signatures if you wish...
  // make the take more or different parameters
  // have them return different types
  //
  // you may use recursive or iterative implementations

  
  public boolean containsNode(String s) {
// contains:
// in: a string (the element to be seaarched for)
// return: boolean, return true if the string being looked for is in the tree;
//		   return false otherwise
//		   this means return false if tree size is 0
// effect: no change to the state of the tree
	  if (this.data.compareTo(s) == 0) {
		  // found it
		  return true;
	  } else if (this.data.compareTo(s) > 0) {
		  // this.data > s
		  // if reaches end and can't find it, false
		  if (this.left == null) return false;
		  else return this.left.containsNode(s);
	  } else {
		  // this.data < s
		  // if reaches end and can't find it, false
		  if (this.right == null) return false;
		  else return this.right.containsNode(s);  
	  }
  }
  
  public boolean insertNode(String s) { 
// insert:
// in: a string (the element to be stored into the tree)
// return: boolean, return true if insert is successful, false otherwise
// effect: if the string is already in the tree, then there is no change to
//		   the tree state, and return false
//		   if the string is not already in the tree, then a new tree cell/node
//		   is created, the string put into it as data, the new node is linked
//		   into the tree at the proper place; size is incremented by 1,
//		   and return a true
	  if (this.data.compareTo(s) == 0) {
		  // already in there
		  return false;
	  } else if (this.data.compareTo(s) > 0) {
		  // left subtree
		  if (this.left == null) {
			  this.left = new BST_Node(s);
			  return true;
		  }
		  else return this.left.insertNode(s);
	  } else {
		  // this.data.compareTo(s) < 0, "this" < s
		  // right subtree
		  if (this.right == null) {
			  this.right = new BST_Node(s);
			  return true;
		  }
		  else return this.right.insertNode(s);
	  }
  }
  
  public BST_Node removeNode(String s, BST_Node ing) {

	  // only for situations: ing.size != 0, s is in the tree, and s is not in root
	  // need ing because cannot this == null
	  if (ing == null) return null;
	  if (ing.data.compareTo(s) > 0) {
		  // ing.data > s
		  // recurse left side
		  ing.left = ing.left.removeNode(s, ing.left);
	  } else if (ing.data.compareTo(s) < 0) {
		  // ing.data < s
		  // recurse right side
		  ing.right = ing.right.removeNode(s, ing.right);
	  } else {
		  // one child
		  if (ing.left == null) {
			  // skip ing
			  return ing.right;
		  } else if (ing.right == null) {
			  return ing.left;
		  } else {
			  // two children
			  String temp = ing.right.findMin();
			  ing.data = temp;
			  ing.right = removeNode(temp, ing.right);
		  }
	  }
	  return ing;
  }

  
  public String findMin() {
// findMin:
// in: none
// return: string, the element value from the tree that is smallest
// effect: no tree state change
// error: is tree size is 0, return null
	  if (this.left == null) {
		  // end
		  return this.data;
	  } else {
		  return this.left.findMin();
	  }
  }
  
  public String findMax() {
// findMax:
// in: none
// return: string, the element value from the tree that is largest
// effect: no tree state change
// error: is tree size is 0, return null
	  if (this.right == null) {
		  // end
		  return this.data;
	  } else {
		  return this.right.findMax();
	  } 
  }
  
  public int getHeight(BST_Node ing) { 
// height:
// in: none
// return: integer, the length of the longest path in the tree from root to a leaf
// effect: no change in tree state
// error: return -1 is tree is empty (size is 0, root is null)
	  if (ing == null) {
		  return 0;
	  } else {
		  int lHeight = getHeight(ing.left);
		  int rHeight = getHeight(ing.right);
		  
		  if (lHeight > rHeight) {
			  return lHeight + 1;
		  } else {
			  return rHeight + 1;
		  }
	  }
  }
  

  // --- end fill in these methods --------------------------------------


  // --------------------------------------------------------------------
  // you may add any other methods you want to get the job done
  // --------------------------------------------------------------------
  
  public String toString(){
    return "Data: "+this.data+", Left: "+((this.left!=null)?left.data:"null")
            +",Right: "+((this.right!=null)?right.data:"null");
  }
}