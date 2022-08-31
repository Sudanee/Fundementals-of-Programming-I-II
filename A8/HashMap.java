import java.util.*;

public class HashMap<K extends Comparable<K>, V> implements Map<K,V> {

	private List<List<Entry<K,V>>> 	table;
	private int	count;
	private int  tableSize;

	// For Part III
	private long getLoops;
	private long putLoops;
	

	public HashMap() {
		tableSize = 1000003; // prime number
		table = new ArrayList<List<Entry<K,V>>>(tableSize);

		// initializes table as a list of empty lists
		for (int i = 0; i < tableSize; i++) {
			table.add(new LinkedList<Entry<K,V>>());
		}

		count = 0;

		// For Part III:
		resetGetLoops();
		resetPutLoops();
	}

	// For Part III
	public long getGetLoopCount() {
		return getLoops;
	}

	// For Part III
	public long getPutLoopCount() {
		return putLoops;
	}

	// For Part III
	public void resetGetLoops() {
		getLoops = 0;
	}
	
	// For Part III
	public void resetPutLoops() {
		putLoops = 0;
	}

	public boolean containsKey(K key) {
		// gets the index in the table this key should be in
		int index = Math.abs(key.hashCode()) % tableSize;
		List<Entry<K,V>> list = this.table.get(index);
		boolean result = false;

		for (int i = 0; i < list.size(); i++){
			if (list.get(i).getKey().equals(key)){
				result = true;
			}
		}


		return result; // so it compiles
	}

	public V get (K key) throws KeyNotFoundException {
		// gets the index in the table this key should be in
		int index = Math.abs(key.hashCode()) % tableSize;
		List<Entry<K,V>> list = this.table.get(index);
		V listget = null;

		for (int i = 0; i < list.size(); i++){
			if (list.get(i).getKey().equals(key)){
				listget = list.get(i).getValue();
			}
		}

		if (listget == null){
			throw new KeyNotFoundException();
		}
		else{
			return listget;
		}


		
	}

	// Tip: you will need to iterate through each index in the table (and each index holds a list)
	//      you will THEN need to iterate through each element in the linked list chain at a 
	//      specific index and add each element to l
	
	public List<Entry<K,V>>	entryList() {
		List <Entry<K,V>> resultList = new LinkedList<Entry<K,V>>();
		List<List<Entry<K,V>>> list = this.table;
		
		Iterator<List<Entry<K, V>>> iter = list.iterator();

		while (iter.hasNext()){
			List<Entry<K,V>> cur = iter.next();
			if (cur.size() != 0){
				entryHelper(cur, resultList);
			}
		}

		return resultList;
	}

	private List<Entry<K,V>> entryHelper(List<Entry<K,V>> list, List<Entry<K,V>> other){
		Iterator<Entry<K,V>> iter = list.iterator();
		
		while (iter.hasNext()){
			Entry<K,V> cur = iter.next();
			other.add(cur);
		}
		
		return other;
	}

	public void put (K key, V value){
		// gets the index in the table this key should be in
		int index = Math.abs(key.hashCode())%tableSize;
		List<List<Entry<K,V>>> list = this.table;
		List<Entry<K,V>> list2 = list.get(index);
		Entry<K,V> insert = new Entry(key, value);
		
		List<Entry<K,V>> insertl = new ArrayList<Entry<K,V>>();
		
		if (list.get(index) != null){
			if (putHelper(list.get(index), key)){
				
				for (int i = 0; i < list2.size(); i++){
					if (list2.get(i).getKey().equals(key)){
						list2.get(i).setValue(value);
					}
				}
				return;
			}
			else if (!putHelper(list.get(index), key)){
				list2.add(insert);
				count++;
				return;
			}

			else if (list.get(index) != null){
				int index2 = 5 - (Math.abs(key.hashCode())%5);
			
				if (list.get(index2) == null){
					list.add(insertl);
					count++;
				}
				else{
					for (int i = 0; i < tableSize; i++){
						index += index2;
						if (list.get(index) == null){
							list.add(insertl);
							count++;
						} 
					}
				}
				return;
			}

			list.add(insertl);
			count++;
		}




		// if key is found, update value.  if key is not found add a new Entry with key,value
		// The tester expects that you will add the newest Entry to the END of the list


	}

	private boolean putHelper(List<Entry<K,V>> list, K key){
		boolean result = false;
		for (int i = 0; i < list.size(); i++){
			if (list.get(i).getKey().equals(key)){
				result = true;
			}
		}
		return result;
	}

	public int size() {
		return count;
	}

	public void clear() {
		table.clear();
		count = 0;
	}

	public int totalCollisions(){
		List<List<Entry<K,V>>> n = this.table;
		int count = 0;

		for (int i = 0; i < n.size(); i++){
			List<Entry<K,V>> ninner = n.get(i);
			if (ninner.size() > 1){
				count = countCollisions(ninner);
			}
		}
		return count;
	}

	private int countCollisions(List<Entry<K,V>> ninner){
		int count = 0;
		for (int i = 1; i < ninner.size(); i++){
			count++;
		}
		return count;
	}

}