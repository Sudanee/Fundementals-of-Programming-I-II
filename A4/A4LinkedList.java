public class A4LinkedList implements A4List {
    
	// Completed for you, should not be changed
	private StudentNode head;
	private StudentNode tail;
	private int numElements;

	// Completed for you, should not be changed
	public A4LinkedList() {
		head = null;
		tail = null;
		numElements = 0;
	}
	
	// Completed for you, should not be changed
	public int size(){
		return numElements;
	}
	
	// Completed for you, should not be changed
	public boolean isEmpty() {
		return head == null;
	}
	
	// Completed for you, should not be changed
	public void insert(Student s) {
		StudentNode n = new StudentNode(s);
		if (head == null) {
			head = n;
		} else {
			tail.next = n;
		}
		tail = n;
		numElements++;
	}
	
	/*
	 * Purpose: create a string representation of list 
	 * Parameters: none
	 * Returns: String - the string representation
	 *
	 * Completed for you, should not be changed
	 */
	public String toString() {
		return "{" + toStringRecursive(head) + "}";
	} 
	
	public String toStringRecursive(StudentNode cur) {
		if (cur == null) {
			return "";
		} else if (cur.next == null) {
			return cur.getData().toString() + toStringRecursive(cur.next);
		} else {
			return cur.getData().toString() + ", " + toStringRecursive(cur.next);
		}
	}

	public boolean inProgram(String program) {
		return inProgramRecursive(head, program);
	}
	
	private boolean inProgramRecursive(StudentNode cur, String program) {
		boolean result = false;
		if (cur == null){
			return result;
		}
		
		Student data = cur.getData();
		boolean compare = data.getProgram().equals(program);
		
		if (compare == false){
			return inProgramRecursive(cur.next, program);
		}
		else{
			result = true;
		}
		return result;// so it compiles
	}

	public Student getStudent(String sID) {
		return getStudentRecursive(head, sID);
	}
	
	private Student getStudentRecursive(StudentNode cur, String sID) {
		if (cur == null){
			return null;
		}
		
		Student data = cur.getData();
		String dataID = data.getSID();

		if (dataID.equals(sID)){
			return data;
		}
		else{
			return getStudentRecursive(cur.next, sID);
		}
	}
	
	public double averageGPA() {
		if (size() == 0) {
			return 0.0;
		} else {
			return sumGPARecursive(head)/size();
		}
	}
	
	private double sumGPARecursive(StudentNode cur) {
		if (cur == null){
			return 0.0;
		}
		else{
			Student data = cur.getData();
			double datagpa = data.getGPA();
			double nextgpa = sumGPARecursive(cur.next);
			return datagpa + nextgpa;
		}

	}
	
	public double programAverage(String program) {
		if (size() == 0) {
			return 0.0;
		} else {
			int num = numberofstudentsinprogram(head, program);
			return programAverageRecursive(head, program)/num;
		}
	}
	private int numberofstudentsinprogram(StudentNode cur, String program){
		int count = 0;
		while (cur != null){
			Student data = cur.getData();
			if (data.getProgram().equals(program)){
				count++;
			}
			cur = cur.next;
		}
		return count;
	}

	private double programAverageRecursive(StudentNode cur, String program){
		double result = 0.0;
		if (cur==null){
			return result;
		}

		else{
			Student data = cur.getData();
			if (data.getProgram().equals(program)){
				
				double datagpa = data.getGPA();
				double nextgpa = programAverageRecursive(cur.next, program);
				result = datagpa + nextgpa;
				return result;
			}
			else{
				return programAverageRecursive(cur.next, program);
			}
		}
		
	}

	public Student highestGPA() {
		if (size() == 0){
			return null;
		}
		else{
			return highestGPArecursive(head, tail);
		}
		
		
	}

	private Student highestGPArecursive(StudentNode cur, StudentNode last){
		if (cur==null){
			return null;
		}
		else{
			if(cur == last){
				return cur.getData();
			}
			else if(cur.getData().getGPA() <= last.getData().getGPA()){
				return highestGPArecursive(cur.next, last);
			}
			else{
				return cur.getData();
			}
		}
		
		
		
	}	
		
}



