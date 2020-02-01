package BST_A2;

public class BST_Playground {
/*
 * you will test your own BST implementation in here
 *
 * we will replace this with our own when grading, and will
 * do what you should do in here... create BST objects,
 * put data into them, take data out, look for values stored
 * in it, checking size and height, and looking at the BST_Nodes
 * to see if they are all linked up correctly for a BST
 * 
*/
  
  public static void main(String[]args){

   // you should test your BST implementation in here
   // it is up to you to test it thoroughly and make sure
   // the methods behave as requested above in the interface
  
   // do not simple depend on the oracle test we will give
   // use the oracle tests as a way of checking AFTER you have done
   // your own testing

   // one thing you might find useful for debugging is a print tree method
   // feel free to use the printLevelOrder method to verify your trees manually
   // or write one you like better
   // you may wish to print not only the node value, and indicators of what
   // nodes are the left and right subtree roots,
   // but also which node is the parent of the current node
	  
	  
	  // insert, contains, remove, getmin, getmax, getroot, size, empty, height
	  // test1();
	  // test2();
	  test3();
	  
  }
  
  public static void test1() {
	// insert, contains, remove, getmin, getmax, getroot, size, empty, height
	  BST test1 = new BST();
	  System.out.println(test1.root);
	  test1.insert("A");
	  test1.insert("B");
	  test1.insert("C");
	  test1.insert("D");
	  test1.insert("E");
	  test1.insert("F");
	  System.out.println(test1.root);
	  printLevelOrder(test1);
	  System.out.println("");
	  System.out.println("-------------------");
	  printGivenLevel(test1.root, 0);
	  printGivenLevel(test1.root, 1);
	  printGivenLevel(test1.root, 2);
	  printGivenLevel(test1.root, 3);
	  printGivenLevel(test1.root, 4);
	  printGivenLevel(test1.root, 5);
	  System.out.println("");
	  System.out.println("-------------------");
	  printInOrder(test1.root);
	  System.out.println("");
	  System.out.println("-------------------");
	  System.out.print("contains: ");
	  System.out.print(test1.contains("A") + " ");
	  System.out.print(test1.contains("C") + " ");
	  System.out.print(test1.contains("F") + " ");
	  System.out.println(test1.contains("X") + " ");
	  System.out.print("size and empty: ");
	  System.out.print(test1.size + " ");
	  System.out.println(test1.empty());
	  System.out.println("-------------------");
	  System.out.print("remove: ");
	  System.out.print(test1.remove("F") + " ");
	  System.out.print(test1.remove("B") + " ");
	  System.out.print(test1.remove("A") + " ");
	  System.out.println(test1.remove("Z"));
	  System.out.println(test1.size);
	  System.out.println("-------------------");
	  printGivenLevel(test1.root, 5);
	  System.out.println("");
	  System.out.println("-------------------");
	  printLevelOrder(test1);
  }
  
  public static void test2() {
	// insert, contains, remove, getmin, getmax, getroot, size, empty, height
	  BST test2 = new BST();
	  System.out.println("height: " + test2.height());
	  System.out.println("size: " + test2.size);
	  System.out.println("empty: " + test2.empty());
	  test2.insert("A");
	  test2.insert("A");
	  test2.insert("A");
	  test2.insert("A");
	  test2.insert("A");
	  test2.insert("A");
	  printLevelOrder(test2);
	  System.out.println("");
	  System.out.println("min: " + test2.findMin());
	  System.out.println("max: " + test2.findMax());
	  System.out.println("height: " + test2.height());
	  System.out.println("size: " + test2.size);
	  System.out.println("empty: " + test2.empty());
	  
	  System.out.println("");
	  System.out.println("remove: " + test2.remove("A"));
	  System.out.println("height: " + test2.height());
	  System.out.println("size: " + test2.size);
	  System.out.println("empty: " + test2.empty());
	  printLevelOrder(test2);
	  System.out.println("");
	  System.out.println(test2.insert("A"));
	  printLevelOrder(test2);
  }
  
  
  public static void test3() {
	// insert, contains, remove, getmin, getmax, getroot, size, empty, height
	  BST test3 = new BST();
	  
	  test3.insert("B");
	  test3.insert("X");
	  test3.insert("Q");
	  test3.insert("C");
	  test3.insert("A");
	  test3.insert("Z");
	  // 	B
	  // A  	X
	  // 	  Q   Z
	  //    C
	  printLevelOrder(test3);
	  System.out.println("");
	  printGivenLevel(test3.root, 0);
	  System.out.println("");
	  printGivenLevel(test3.root, 1);
	  System.out.println("");
	  printGivenLevel(test3.root, 2);
	  System.out.println("");
	  printGivenLevel(test3.root, 3);
	  System.out.println("");
	  printGivenLevel(test3.root, 4);
	  System.out.println("");
	  System.out.println("max: " + test3.findMax());
	  System.out.println("min: " + test3.findMin());
	  
	  
	  System.out.println("");
	  System.out.println("");
	  test3.remove("B");
	  printGivenLevel(test3.root, 0);
	  System.out.println("");
	  printGivenLevel(test3.root, 1);
	  System.out.println("");
	  printGivenLevel(test3.root, 2);
	  System.out.println("");
	  printGivenLevel(test3.root, 3);
	  System.out.println("");
	  printGivenLevel(test3.root, 4);
  }

  static void printLevelOrder(BST tree){ 
  //will print your current tree in Level-Order...
  //https://en.wikipedia.org/wiki/Tree_traversal
    int h=tree.getRoot().getHeight(tree.getRoot());
    for(int i=0;i<=h;i++){
      printGivenLevel(tree.getRoot(), i);
    }
    
  }
  static void printGivenLevel(BST_Node root,int level){
    if(root==null)return;
    if(level==0)System.out.print(root.data+" ");
    else if(level>0){
      printGivenLevel(root.left,level-1);
      printGivenLevel(root.right,level-1);
    }
  }
  static void printInOrder(BST_Node root){
  //will print your current tree In-Order
  if(root!=null){
    printInOrder(root.getLeft());
    System.out.print(root.getData() + " ");
    printInOrder(root.getRight());
  }
  }
}