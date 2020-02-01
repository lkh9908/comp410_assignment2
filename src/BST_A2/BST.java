package BST_A2;

public class BST implements BST_Interface {
  public BST_Node root;
  int size;
  
  public BST(){ size=0; root=null; }
  
  @Override
  //used for testing, please leave as is
  public BST_Node getRoot(){ return root; }

@Override
public boolean insert(String s) {
	if (size == 0) {
		// empty
		root = new BST_Node(s);
		size++;
		return true;
	} else {
		if (root.insertNode(s)) {
			// add size by one
			size ++;
			return true;
		} else {
			return false;
		}	
	}
}

@Override
public boolean remove(String s) {
	
// remove:
// in: a string (the element to be taken out of the tree) and root
// return: boolean, return true if the remove is successful, false otherwise
//			   this means return false if the tree size is 0
//			   effect: if the element being looked for is in the tree, unlink the node containing
//			   it and return true (success); size decreases by one
//			   if the element being looked for is not in the tree, return false and
//			   make no change to the tree state
	if (size == 0) {
		// empty
		return false;
	} else if (root.containsNode(s) == false) {
		return false;
	} else {
		if (root.data.compareTo(s) == 0) {
			// removing root
			if (root.left == null && root.right == null) {
				root.data = null;
			} else if (root.left == null) root = root.right;
			else if (root.right == null) root = root.left;
			else {
				root.removeNode(s, root);
			}
			size--;
			return true;
		} else {
			// everything else -- delegation
			root.removeNode(s, root);
			size--;
			return true;
		}
	}
}

@Override
public String findMin() {
	if (size == 0) return null;
	else return root.findMin();
}

@Override
public String findMax() {
	if (size == 0) return null;
	else return root.findMax();
}

@Override
public boolean empty() {
// empty:
// in: nothing
// return: boolean, true if the tree has no elements in it, true if size is 0
// return false otherwise
// effect: no change to tree state
	if (size == 0) return true;
	else return false;
}

@Override
public boolean contains(String s) {
	if (size == 0) return false;
	else return root.containsNode(s);
}

@Override
public int size() {
// size:
// in: nothing
// return: number of elements stored in the tree
// effect: no change to tree state
	return size;
}

@Override
public int height() {
	if (size == 0) return -1;
	else return root.getHeight(root) - 1;
}

}