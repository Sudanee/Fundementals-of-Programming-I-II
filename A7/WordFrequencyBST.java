import java.util.*;

/*
 * An implementation of a binary search tree.
 *
 * This tree stores both keys and values associated with those keys.
 *
 * More information about binary search trees can be found here:
 *
 * http://en.wikipedia.org/wiki/Binary_search_tree
 *
 */ 
class WordFrequencyBST <K extends Comparable<K>, V>  {

	private static int testPassCount = 0;
	private static int testCount = 0;

	public static final int BST_PREORDER  = 1;
	public static final int BST_POSTORDER = 2;
	public static final int BST_INORDER   = 3;

	private TreeNode<K,V> root;
	private int numElements;

	public WordFrequencyBST(){
		root = null;
		numElements = 0;
	}


	/*
	 * Purpose: Update the BST by handling input word 
	 * Parameters: K key - The key to handle
	 * Returns: Nothing
	 * Explanation: If there is no element in the tree 
	 *   with the given key, then a new element 
	 *   should be created and placed into the correct 
	 *   location of the BST (determined by the Binary
	 *   Search Tree property). Otherwise, the existing
	 *   element with the given key should have its 
	 *   value incremented by one.
	 */	
	public void handleWord(K key) {
		if (root==null){
			root = new TreeNode<K,V>(key);
			numElements++;
		}
           
        else{
			handleWordHelper(null, root, key);
		}
            
        
	}
	private void handleWordHelper(TreeNode<K,V> parent, TreeNode<K,V> t, K key) {
        TreeNode<K,V> insert = new TreeNode<K,V>(key);
        
		if (t.key.equals(key)){
			t.incrementValue();
			return;
		}

        if (t.right == null && t.left == null){
            if (t.key.compareTo(key) < 0){
                t.right = insert;
				numElements++;
            }
            if (t.key.compareTo(key) > 0){
                t.left = insert;
				numElements++;
            } 
        }

        else if (t.left == null){
			if (t.key.compareTo(key) < 0){
				handleWordHelper(parent, t.right, key);
			}

			else{
				boolean check = checkDupli(t, key);
			
				if (check){
					return;
				}
				else{
					t.left = insert;
					numElements++;
				}
			}
			
            
        }

    	else if (t.right == null){
			if (t.key.compareTo(key) > 0){
				handleWordHelper(parent, t.left, key);
			}

			else{
				boolean check = checkDupli(t, key);
			
				if (check){
					return;
				}
				else{
					t.right = insert;
					numElements++;
				}
			}
        }
        else if (t.key.compareTo(key) < 0){
            handleWordHelper(parent, t.right, key);
        }
        else if (t.key.compareTo(key) > 0){
            handleWordHelper(parent, t.left, key);
        }
    }

	private boolean checkDupli(TreeNode<K,V> n, K key){
		if (n == null){
			return false;
		}
		
		if (n.key.equals(key)){
			n.incrementValue();
			return true;
		}

		boolean result = checkDupli(n.left, key);
		boolean result2 = checkDupli(n.right, key);

		if (result == false && result2 == false){
			return false;
		}
		else if (result == true || result2 == true){
			return true;
		}

		return false;
	}	
	/*
	 * Purpose: Get the  value of the given key
	 * Parameters: K key - the key to search for
	 * Returns: int - the key's associated value
	 * Note: Although we are using generic entries
	 *       where the value could be any type, for 
	 *       this particular application of the BST
	 *       we will assume the value is an integer.
	 */	
	public int getFrequency(K key) {
		TreeNode<K,V> n = this.root;
		return getFrequencyHelper(n, key);
		
	}

	private int getFrequencyHelper(TreeNode<K,V> n, K key){
		if (n == null){
			return 0;
		}
		if (n.key.equals(key)){
			return (int) n.value;
		}

		int result = getFrequencyHelper(n.left, key);

		int result2 = getFrequencyHelper(n.right, key);

		if (result != 0){
			return result;
		}
		else if (result2 != 0){
			return result2;
		}

		return 0;
	}
	
	/*
	 * Purpose: Get the total number of nodes in the tree
	 * Parameters: None
	 * Returns: int - the total number of nodes in the tree
	 */	
	public int size() {
		return numElements;
	}

	/*
	 * Purpose: Return a list of all the key-value entries stored in the tree
	 * Parameters: none
	 * Returns: A list of all key-value entries stored in the tree, constructed 
	 *          by performining a level-order traversal of the tree.
	 *
	 * Level-order is most commonly implemented using a queue of nodes.
	 * From Wikipedia, the algorithm is:
	 *
	 * levelorder()
	 *		q = empty queue
	 *		q.enqueue(root)
	 *		while not q.empty do
	 *			node := q.dequeue()
	 *			visit(node)
	 *			if node.left != null then
	 *			      q.enqueue(node.left)
	 *			if node.right != null then
	 *			      q.enqueue(node.right)
	 */	
	public List<Entry<K,V>> entryList() {
		List<Entry<K, V>> resultList = new LinkedList<Entry<K,V>>();
		LinkedList<TreeNode<K,V>> queue = new LinkedList<TreeNode<K,V>>();
		TreeNode<K,V> n = this.root;
		int height = height(n);
		int count = 0;

		for (int i = 0; i <= height; i++){
            levelOrder(root, count, resultList);
            count++;
        }

		return resultList;
	}

	private void levelOrder(TreeNode<K,V> n, int height, List <Entry<K,V>> resultList) {
		if (n==null){
            return;
        }
        if (height == 0){
			resultList.add(new Entry<K,V>(n.key, n.value));
        }
        else if (height >= 1){
            levelOrder(n.left, height-1, resultList);
            levelOrder(n.right, height-1, resultList);
        }
	}

	private int height(TreeNode<K,V> t) {
        if (t==null) {
            return -1;
		} else {
            int highest = Math.max(height(t.left), height(t.right));
            return 1 + highest;
        }
    }

	/****************************************************
	* Helper functions for Insertion and Search testing *
	****************************************************/
	
	public List<Entry<K,V>> entryList (int which) {
		List<Entry<K,V>> resultList = new LinkedList<Entry<K,V> >();

		if (which == BST_PREORDER) {
			preOrderRecursive(root, resultList);
		}
		else if (which == BST_INORDER) {
			inOrderRecursive(root, resultList);
		}
		else if (which == BST_POSTORDER) {
			postOrderRecursive(root, resultList);
		}

		return resultList;
	}

	// completed for you
	private void inOrderRecursive (TreeNode<K,V> n, List <Entry<K,V>> resultList) {
		if (n == null) {
			return;
		}
		inOrderRecursive(n.left, resultList);
		resultList.add(new Entry<K,V>(n.key, n.value));
		inOrderRecursive(n.right,resultList);
	}

	// completed for you
	private void preOrderRecursive (TreeNode<K,V> n, List <Entry<K,V>> resultList) {
		if (n == null) {
			return;
		}
		resultList.add(new Entry<K,V>(n.key, n.value));
		preOrderRecursive(n.left, resultList);
		preOrderRecursive(n.right,resultList);
	}

	// completed for you
	private void postOrderRecursive (TreeNode<K,V> n, List <Entry<K,V>> resultList) {
		if (n == null) {
			return;
		}
		postOrderRecursive(n.left, resultList);
		postOrderRecursive(n.right,resultList);
		resultList.add(new Entry<K,V>(n.key, n.value));
	}
	
	/****************************************************
	* Helper functions to populate a Heap from this BST *
	****************************************************/
	
	public MaxFrequencyHeap<K,V> createHeapFromTree() {
		MaxFrequencyHeap<K,V> maxHeap = new MaxFrequencyHeap<K,V>();
		addToHeap(maxHeap, root);
		return maxHeap;
	}
	
	public void addToHeap(MaxFrequencyHeap<K,V> h, TreeNode<K,V> n) {
		if (n != null) {
			addToHeap(h, n.left);
			h.insert(new Entry<K,V>(n.key, n.value));
			addToHeap(h, n.right);
		}
	}

	public int sizeOfTree(K key){
		TreeNode<K,V> n = this.root;
		while (n != key){
			if (n > key){
				n = n.right;
			}
			else{
				n = n.left;
			}
		}
		return helper(n);
	}
	
	private int helper(TreeNode<K,V> n){
		if (n == null){
			return 0;
		}
		int result = 1 + helper(n.left);
		int result2 = 1 + helper(n.right);

		return result + result2;
	}
}
