// Name: Migdad Izzeldin
// Student number: V00955271

import java.util.*;
public class WordFrequencyReport<K extends Comparable<K>, V> {
	private static final int CAPACITY = 5;
	
	/*
	 * Purpose: Obtain the 5 most frequent words found
	 * Parameters: MaxFrequencyHeap h - the heap containing all the word entry data
	 * Returns: Entry[] - an array containing the top 5 entries (which are the 
	 *     word, frequency pairs with the maximum frequency values)
	 */
	public static List<Entry<String, Integer>> overallMostFrequent(MaxFrequencyHeap<String,Integer> h) {
		List<Entry<String, Integer>> top5 = new ArrayList<Entry<String,Integer>>(CAPACITY);
		int size = h.size();
		
		if (h.size() < CAPACITY){
			for (int i = 0; i < size; i++){
				Entry<String, Integer> t = h.removeMax();
				top5.add(i, t);
			}
		}
		else{
			for (int i = 0; i < CAPACITY; i++){
				Entry<String, Integer> t = h.removeMax();
				top5.add(i, t);
			}

		}
		
		return top5;
	}
	
	/*
	 * Purpose: Obtain the 5 most frequent words found that are at least n charaters long
	 * Parameters: MaxFrequencyHeap h - the heap containing all the word entry data
	 *             int n - minimum word length to consider
	 * Returns: Entry[] - an array containing the top 5 entries (which are the 
	 *     word, frequency pairs with the maximum frequency values of words 
	 *     that are at least n characters long)
	 */
	public static List<Entry<String, Integer>> atLeastLength(MaxFrequencyHeap<String,Integer> h, int n) {
		List<Entry<String, Integer>> top5 = new ArrayList<Entry<String,Integer>>(CAPACITY);
		List<Entry<String, Integer>> list = new ArrayList<Entry<String,Integer>>(h.size());
		int count = 0;

		while (h.size() != 0){
			Entry<String, Integer> t = h.removeMax();
			if (t.getKey().length() >= n){
				list.add(count, t);
				count++;
			}
		}
		
		if (list.size() != 0){
			if (list.size() < CAPACITY){
				for (int ii = 0; ii < list.size(); ii++){
					Entry<String, Integer> tt = list.get(ii);
					top5.add(ii, tt);
				}
			}
			else{
				for (int ii = 0; ii < CAPACITY; ii++){
					Entry<String, Integer> tt = list.get(ii);
					top5.add(ii, tt);
				}
			}
			
		}

		return top5;
	}
	
	/*
	 * Purpose: Obtain the 5 most frequent words found that begin with the given letter
	 * Parameters: MaxFrequencyHeap h - the heap containing all the word entry data
	 *             char letter - only words that begin with given letter are considered
	 * Returns: Entry[] - an array containing the top 5 entries (which are the 
	 *     word, frequency pairs with the maximum frequency values of words 
	 *     that begin with the given letter)
	 */
	public static List<Entry<String, Integer>> startsWith(MaxFrequencyHeap<String,Integer> h, char letter) {
		List<Entry<String, Integer>> top5 = new ArrayList<Entry<String,Integer>>(CAPACITY);
		List<Entry<String, Integer>> list = new ArrayList<Entry<String,Integer>>(h.size());
		int count = 0;

		while (h.size() != 0){
			Entry<String, Integer> t = h.removeMax();
			if (t.getKey().charAt(0) == letter){
				list.add(count, t);
				count++;
			}
		}
		if (list.size() != 0){
			if (list.size() < CAPACITY){
				for (int i = 0; i < list.size(); i++){
					Entry<String, Integer> tt = list.get(i);
					top5.add(i, tt);
				}
			}
			else{
				for (int i = 0; i < CAPACITY; i++){
					Entry<String, Integer> tt = list.get(i);
					top5.add(i, tt);
				}
			}
			
		}
		
		
		
		return top5;
	}	
}
 
