public interface A4List {
    
	/*****************************************************************
	* The first 3 methods are completed for you in A4LinkedList.java *
	*****************************************************************/
	
	/*
	 * Purpose: get the number of elements in the list
	 * Parameters: none
	 * Returns: int - the number of elements in the list
	 */	
	public int size();
	
	/*
	 * Purpose: determines whether the list is empty
	 * Parameters: none
	 * Returns: boolean - true if empty, false otherwise
	 */	
	public boolean isEmpty();
	
	/*
	 * Purpose: inserts a student at the back of the list
	 * Parameters: Student s - the student to insert
	 * Returns: void - nothing
	 */
	public void insert(Student s);
	
	
	/****************************************************
	* You will need to complete the following 5 methods *
	****************************************************/
	
	/*
	 * Purpose: determines whether the list contains
	 *          a student in the given program
	 * Parameters: String - the program to search for
	 * Returns: true if a student in the given program is found, false otherwise
	 * Precondition: program is not null
	 */
	public boolean inProgram(String program);
	
	/*
	 * Purpose: gets a student with the given sID, if the 
	 *          list contains a student with the given sID
	 * Parameters: String - the sID to search for
	 * Returns: Student - the student if found, null otherwise
	 * Precondition: sID is not null
	 */
	public Student getStudent(String sID);
	
	/*
	 * Purpose: get the average GPA of all students in the list
	 * Parameters: none
	 * Returns: double - the average GPA of all students
	 */
	public double averageGPA();
	
	/*
	 * Purpose: gets the average GPA of all students in the given program
	 * Parameters: String - the program to search for
	 * Returns: double - the average gpa of all students in the program
	 * Precondition: program is not null
	 */
	public double programAverage(String program);
	
	/*
	 * Purpose: get the student with the highest GPA in the list
	 * Parameters: none
	 * Returns: Student - the student with the highest GPA
	 */
	public Student highestGPA();

}



