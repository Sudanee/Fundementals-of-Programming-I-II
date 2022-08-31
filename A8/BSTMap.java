import java.util.*;

public class BSTMap<K extends Comparable<K>, V > implements  Map<K, V>  {

	BinarySearchTree<K,V> bst;

	public BSTMap () {
		bst = new BinarySearchTree<K,V>();
	}

	public boolean containsKey(K key) {
		List<Entry<K,V>> list = this.bst.entryList();
		boolean result = false;
		
		for (int i = 0; i < list.size(); i++){
			Entry<K,V> find = list.get(i);
			if (find.getKey().equals(key)){
				result = true;
			}
		}

		return result;
	}

	public V get (K key) throws KeyNotFoundException {
		return this.bst.find(key);
	}

	public List<Entry<K,V>>	entryList() {
		return this.bst.entryList();
	}

	public void put (K key, V value) {
		this.bst.insert(key, value);
	}

	public int size() {
		return this.bst.size();
	}

	public void clear() {
		this.bst.clear();
	}


	// The remaining methods are for Part III:
	public long getGetLoopCount() {
		return bst.getFindLoopCount();
	}

	public long getPutLoopCount() {
		return bst.getInsertLoopCount();
	}

	public void resetGetLoops() {
		bst.resetFindLoops();
	}
	public void resetPutLoops() {
		bst.resetInsertLoops();
	}
}
