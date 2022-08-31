// Name: Migdad Izzeldin
// Student number: V00955271

public class A3LinkedList implements A3List {
	private A3Node head;
	private A3Node tail;
	private int length;
	
	public A3LinkedList() {
		head = null;
		tail = null;
		length = 0;
	}
	
	public void addFront(String s) {
		A3Node newelement = new A3Node(s);
		if (tail == null){
			tail = newelement;
		}else{
			head.prev = newelement;
			newelement.next = head;
		}
		
		head = newelement;
		length++;
	}

	public void addBack(String s) {
		A3Node newelement = new A3Node(s);
		if (head == null){
			head = newelement;
		}
		else{
			tail.next = newelement;
			newelement.prev = tail;
		}
		tail = newelement;
		length++;
	}
	
	public int size() {
		return length;
	}
	
	public boolean isEmpty() {
		return length==0;
	}
	
	public void removeFront() {
		A3Node first = this.head;
		if(head == null){
			return;
		}
		
		else if (first.next == null){
			head = null;
		}
		
		else{
			first.next.prev = first.prev;
			head = first.next;
			first = null;
			
		}
		length--;
		
	}
	
	public void removeBack() {
		A3Node first = this.tail;
		if (first.prev == null){
			this.head = null;
		}else{
			first.prev.next = first.next;
			tail = first.prev;
			first = null;
			
		}
		length--;
	}
	
	
	public void rotate(int n) {
		if (n == 0 || n >= this.size()){
			return;
		}
		else{
			for (int i = 1; i <= n; i++){
				tail.prev.next = tail.next;
				head.prev = tail;
				tail = tail.prev;
				head.prev.prev = null;
				head.prev.next = head;
				head = head.prev;
			}
		}
			
	}
	
	public void interleave(A3LinkedList other) {
		A3Node list1 = this.head;
		A3Node list2 = other.head;

		A3Node list1next = list1.next;
		A3Node list2next = list2.next;
		
		while (list1next != null && list2next != null){
			list1.next = list2.next;
			list2.next = list1next;
			list1 = list1next;
			list2 = list2next;
			list1next = list1next.next;
			list2next = list2next.next;
		}
		
	}
	
	/* Purpose: return a string representation of the list 
	 *          when traversed from front to back
	 * Parameters: none
	 * Returns: nothing
	 */
	public String frontToBack() {
		String result = "{";
		A3Node cur = head;
		while (cur != null) {
			result += cur.getData();
			cur = cur.next;
		}
		result += "}";
		return result;
	}
	
	/* Purpose: return a string representation of the list 
	 *          when traversed from back to front
	 * Parameters: none
	 * Returns: nothing
	 */
	public String backToFront() {
		String result = "{";
		A3Node cur = tail;
		while (cur != null) {
			result += cur.getData();
			cur = cur.prev;
		}
		result += "}";
		return result;
	}


	public void movetoBack(int pos){
		int count = 1;
		A3Node cur = head;
		while (count != pos){
			cur = cur.next;
			count++;
		}
		cur.prev.next = cur.next;
		cur.next.prev = cur.prev;
		tail.next = cur;
		tail = cur;
		tail.next = null;
	}







}
	