public class A5Stack<T> implements Stack<T> {
	
	private Node<T> head;

	public A5Stack() {
		head = null;

	}
	
	public void push(T v) {
		Node<T> insert = new Node<T>(v);
		Node<T> n = this.head;
		if (head==null){
			head = insert;
			head.next = null;
		}
		else{
			while (n != null){
            	if (n.next == null){
					insert.setNext(head);
					head = insert;
				}
            	n = n.getNext();
        	}
		}
	}
	
	public T pop(){
		Node<T> intQ = this.head;	
		if (head == null){
			throw new EmptyStackException("Stack is empty");
		}
    	head = head.next;	
		return intQ.getData();  
	}

	public T top() {
		if (head == null){
			throw new EmptyStackException("Stack is empty");
		}
		return head.getData(); // so it compiles
	}	
	
	public void popAll() {
		head = null;	
	}
	
	public boolean isEmpty() {	
		return head == null; // so it compiles
	}
	
}