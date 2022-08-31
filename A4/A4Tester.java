import java.util.Arrays;


public class A4Tester {
	
	private static int testPassCount = 0;
	private static int testCount = 0;
	private static double THRESHOLD = 0.1; // allowable margin of error for floating point results
	
	private static A4List list0 = null;
	private static A4List list1 = null;
	private static A4List list2 = null;
	private static A4List list3 = null;
	
    public static void main(String[] args) {
		
		/*
		 * PART I:
		 *   implement and test each of the following methods
		 *   found in A4Exercises.java, one at a time
		 */
		
		testAddToAll();
		testArrayContains();
		testSameInARow();

		/*
		 * PART II
		 *   implement and test each of the following methods
		 *   found in A4LinkedList.java, one at a time.
		 *   Documentation can be found in A4List.java
		 */

		initLists(); // do not modify
		testInProgram();
		testGetStudent();
		testAverageGPA();
		testProgramAverage();
		testHighestGPA();
		
		System.out.println("\nPASSED " + testPassCount + " / " + testCount + " tests");
	}
	
	public static void testAddToAll() {
		System.out.println("\nStarting atToAll tests");
		
		int[] arr0 = {};
		int[] arr1 = {7, 1, 3};
		int[] arr2 = {9, 2, 7, 3, 0, 6};
		
		int[] expected0 = {};
		int[] expected1 = {8, 2, 4};
		int[] expected2 = {11, 5, 7};
		int[] expected3 = {14, 7, 12, 8, 5, 11};
		
		A4Exercises.addToAll(arr0, 1);
		displayResults(Arrays.equals(arr0, expected0), "add 1 to all values in empty array");
		
		A4Exercises.addToAll(arr1, 1);
		displayResults(Arrays.equals(arr1, expected1), "add 1 to all values in arr1");
		
		A4Exercises.addToAll(arr1, 3);
		displayResults(Arrays.equals(arr1, expected2), "add 3 to all values in updated arr1");
		
		A4Exercises.addToAll(arr2, 5);
		displayResults(Arrays.equals(arr2, expected3), "add 5 to all values in arr2");
	}
	
	public static void testArrayContains() {
		System.out.println("\nStarting arrayContains tests");
		int[] arr0 = {};
		int[] arr1 = {7, 1, 3};
		int[] arr2 = {9, 2, 7, 3, 0, 6};
		
		boolean result = false;
		
		result = A4Exercises.arrayContains(arr0, 4);
		displayResults(!result, "empty array contains 4");
		
		result = A4Exercises.arrayContains(arr1, 1);
		displayResults(result, "arr1 contains 1");
		result = A4Exercises.arrayContains(arr1, 2);
		displayResults(!result, "arr1 contains 2");

		result = A4Exercises.arrayContains(arr2, 9);
		displayResults(result, "arr2 contains 9");		
		result = A4Exercises.arrayContains(arr2, 6);
		displayResults(result, "arr2 contains 6");
		result = A4Exercises.arrayContains(arr2, 5);
		displayResults(!result, "arr2 contains 5");
		
	}
		
	public static void testSameInARow() {
		System.out.println("\nStarting sameInARow tests");
		int[] arr0 = {};
		int[] arr1 = {7, 1, 3};
		int[] arr2 = {7, 1, 1, 3};
		int[] arr3 = {7, 7, 1, 3};
		int[] arr4 = {7, 1, 3, 3};
		int[] arr5 = {7, 7, 1, 1, 3, 3};
		int[] arr6 = {7, 7, 1, 1, 1, 3, 3};
		int[] arr7 = {2, 2, 2, 2, 2, 2, 2};
		
		int result = 0;
		int expected = 0;
		
		result = A4Exercises.sameInARow(arr0);
		displayResults(result==expected, "same in a row, empty array");
		
		result = A4Exercises.sameInARow(arr1);
		displayResults(result==expected, "same in a row, {7,1,3}");
		
		result = A4Exercises.sameInARow(arr2);
		expected = 1;
		displayResults(result==expected, "same in a row, {7,1,1,3}");
		
		result = A4Exercises.sameInARow(arr3);
		expected = 1;
		displayResults(result==expected, "same in a row, {7,7,1,3}");
		
		result = A4Exercises.sameInARow(arr4);
		expected = 1;
		displayResults(result==expected, "same in a row, {7,1,3,3}");
	
		result = A4Exercises.sameInARow(arr5);
		expected = 3;
		System.out.println(result);
		displayResults(result==expected, "same in a row, {7,7,1,1,3,3}");
		
		result = A4Exercises.sameInARow(arr6);
		expected = 4;
		System.out.println(result);
		displayResults(result==expected, "same in a row, {7,7,1,1,1,3,3}");
		
		result = A4Exercises.sameInARow(arr7);
		expected = 6;
		System.out.println(result);
		displayResults(result==expected, "same in a row, {2,2,2,2,2,2,2}");
	}
	
	public static void initLists() {
		
		// This function creates lists of students for you 
		// to use for testing the A4LinkedList methods
		
		// It does not need to be modified, but you are welcome
		// to create new lists for further testing
		
		Student s1 = new Student("v00123", 6.7, "Geography");
		Student s2 = new Student("v00555", 7.8, "Physics");
		Student s3 = new Student("v00987", 4.5, "Psychology");
		Student s4 = new Student("v00246", 9.0, "Geography");
		Student s5 = new Student("v00357", 8.2, "Mathematics");
		Student s6 = new Student("v00149", 7.2, "Physics");
		Student s7 = new Student("v00001", 8.4, "Geography");
				
		list0 = new A4LinkedList();
		
		list1 = new A4LinkedList();
		list1.insert(s1);
		
		list2 = new A4LinkedList();
		list2.insert(s1);
		list2.insert(s4);
		list2.insert(s5);
		
		list3 = new A4LinkedList();
		list3.insert(s1);
		list3.insert(s2);
		list3.insert(s3);
		list3.insert(s4);
		list3.insert(s5);
		list3.insert(s6);
		list3.insert(s7);
		
		// System.out.println(list0);
		// System.out.println(list1);
		// System.out.println(list2);
		// System.out.println(list3);
	}

	
	public static void testInProgram() {
		System.out.println("\nStarting inProgram tests");
		/* List contents:
		list0: empty
		
		list1: v00123:6.7:Geography
		
		list2: v00123:6.7:Geography, v00246:9.0:Geography, v00357:8.2:Mathematics
		
		list3: v00123:6.7:Geography, v00555:7.8:Physics, v00987:4.5:Psychology, v00246:9.0:Geography
					v00357:8.2:Mathematics, v00149:7.2:Physics, v00001:8.4:Geography
		*/
		Student s1 = new Student("v00123", 6.7, "Geography");
		Student s2 = new Student("v00555", 7.8, "Physics");
		Student s3 = new Student("v00987", 4.5, "Psychology");
		Student s4 = new Student("v00246", 9.0, "Geography");
		Student s5 = new Student("v00357", 8.2, "Mathematics");
		Student s6 = new Student("v00149", 7.2, "Physics");
		Student s7 = new Student("v00001", 8.4, "Geography");

		list0 = new A4LinkedList();
		
		list1 = new A4LinkedList();
		list1.insert(s1);
		
		list2 = new A4LinkedList();
		list2.insert(s1);
		list2.insert(s4);
		list2.insert(s5);
		
		list3 = new A4LinkedList();
		list3.insert(s1);
		list3.insert(s2);
		list3.insert(s3);
		list3.insert(s4);
		list3.insert(s5);
		list3.insert(s6);
		list3.insert(s7);
		
		boolean result = false;
		
		result = list0.inProgram("Geography");
		System.out.println(result);
		displayResults(!result, "inProgram on empty list searching for Geography");
		
		result = list1.inProgram("Geography");
		System.out.println(result);
		displayResults(result, "inProgram on list1 searching for Geography");
		
		result = list2.inProgram("Mathematics");
		System.out.println(result);
		displayResults(result, "inProgram on list2 searching for Mathematics");
		
		result = list3.inProgram("Geography");
		System.out.println(result);
		displayResults(result, "inProgram on list3 searching for Geography");
		
		result = list3.inProgram("Mathematics");
		System.out.println(result);
		displayResults(result, "inProgram on list3 searching for Mathematics");
		
		result = list3.inProgram("Biology");
		System.out.println(result);
		displayResults(!result, "inProgram on list3 searching for Biology");
		
		result = list3.inProgram("Physics");
		System.out.println(result);
		displayResults(result, "inProgram on list3 searching for Physics");
	}
	
	public static void testGetStudent() {
		System.out.println("\nStarting getStudent tests");
		/* List contents:
		list0: empty
		
		list1: v00123:6.7:Geography
		
		list2: v00123:6.7:Geography, v00246:9.0:Geography, v00357:8.2:Mathematics
		
		list3: v00123:6.7:Geography, v00555:7.8:Physics, v00987:4.5:Psychology, v00246:9.0:Geography
					v00357:8.2:Mathematics, v00149:7.2:Physics, v00001:8.4:Geography
		*/
		Student s1 = new Student("v00123", 6.7, "Geography");
		Student s2 = new Student("v00555", 7.8, "Physics");
		Student s3 = new Student("v00987", 4.5, "Psychology");
		Student s4 = new Student("v00246", 9.0, "Geography");
		Student s5 = new Student("v00357", 8.2, "Mathematics");
		Student s6 = new Student("v00149", 7.2, "Physics");
		Student s7 = new Student("v00001", 8.4, "Geography");

		list0 = new A4LinkedList();
		
		list1 = new A4LinkedList();
		list1.insert(s1);
		
		list2 = new A4LinkedList();
		list2.insert(s1);
		list2.insert(s4);
		list2.insert(s5);
		
		list3 = new A4LinkedList();
		list3.insert(s1);
		list3.insert(s2);
		list3.insert(s3);
		list3.insert(s4);
		list3.insert(s5);
		list3.insert(s6);
		list3.insert(s7);

		Student toFind1 = new Student("v00123", 6.7, "Geography");
		Student toFind2 = new Student("v00321", 7.2, "Chemistry");
		Student toFind3 = new Student("v00001", 8.4, "Geography");
		
		Student result = null;
		
		result = list0.getStudent("v00123");
		displayResults(result==null, "searching for student v00123 in empty list");
		
		result = list1.getStudent("v00123");
		displayResults(result.equals(toFind1), "searching for student v00123 in list1");
		
		result = list1.getStudent("v00001");
		displayResults(result==null, "searching for student v00001 in list1");
		
		result = list3.getStudent("v00123");
		displayResults(result.equals(toFind1), "searching for student v00123 in list3");
		
		result = list3.getStudent("v00321");
		displayResults(result==null, "searching for student v00321 in list3");
		
		result = list3.getStudent("v00001");
		displayResults(result.equals(toFind3), "searching for student v00001 in list3");
		
	}
	
	public static void testAverageGPA() {
		System.out.println("\nStarting averageGPA tests");
		/* List contents:
		list0: empty
		
		list1: v00123:6.7:Geography
		
		list2: v00123:6.7:Geography, v00246:9.0:Geography, v00357:8.2:Mathematics
		
		list3: v00123:6.7:Geography, v00555:7.8:Physics, v00987:4.5:Psychology, v00246:9.0:Geography
					v00357:8.2:Mathematics, v00149:7.2:Physics, v00001:8.4:Geography
		*/

		Student s1 = new Student("v00123", 6.7, "Geography");
		Student s2 = new Student("v00555", 7.8, "Physics");
		Student s3 = new Student("v00987", 4.5, "Psychology");
		Student s4 = new Student("v00246", 9.0, "Geography");
		Student s5 = new Student("v00357", 8.2, "Mathematics");
		Student s6 = new Student("v00149", 7.2, "Physics");
		Student s7 = new Student("v00001", 8.4, "Geography");

		list0 = new A4LinkedList();
		
		list1 = new A4LinkedList();
		list1.insert(s1);
		
		list2 = new A4LinkedList();
		list2.insert(s1);
		list2.insert(s4);
		list2.insert(s5);
		
		list3 = new A4LinkedList();
		list3.insert(s1);
		list3.insert(s2);
		list3.insert(s3);
		list3.insert(s4);
		list3.insert(s5);
		list3.insert(s6);
		list3.insert(s7);
		
		double result = 0.0;
		double expected = 0.0;
		
		result = list0.averageGPA();
		displayResults(result==expected, "average GPA in an empty list");
		
		result = list1.averageGPA();
		expected = 6.7;
		displayResults(Math.abs(result-expected)<THRESHOLD, "average GPA in list1");
		
		result = list3.averageGPA();
		expected = 7.4;
		displayResults(Math.abs(result-expected)<THRESHOLD, "average GPA in list3");
		
	}
	
	public static void testProgramAverage() {
		System.out.println("\nStarting programAverage tests");
		/* List contents:
		list0: empty
		
		list1: v00123:6.7:Geography
		
		list2: v00123:6.7:Geography, v00246:9.0:Geography, v00357:8.2:Mathematics
		
		list3: v00123:6.7:Geography, v00555:7.8:Physics, v00987:4.5:Psychology, v00246:9.0:Geography
					v00357:8.2:Mathematics, v00149:7.2:Physics, v00001:8.4:Geography
		*/

		Student s1 = new Student("v00123", 6.7, "Geography");
		Student s2 = new Student("v00555", 7.8, "Physics");
		Student s3 = new Student("v00987", 4.5, "Psychology");
		Student s4 = new Student("v00246", 9.0, "Geography");
		Student s5 = new Student("v00357", 8.2, "Mathematics");
		Student s6 = new Student("v00149", 7.2, "Physics");
		Student s7 = new Student("v00001", 8.4, "Geography");

		list0 = new A4LinkedList();
		
		list1 = new A4LinkedList();
		list1.insert(s1);
		
		list2 = new A4LinkedList();
		list2.insert(s1);
		list2.insert(s4);
		list2.insert(s5);
		
		list3 = new A4LinkedList();
		list3.insert(s1);
		list3.insert(s2);
		list3.insert(s3);
		list3.insert(s4);
		list3.insert(s5);
		list3.insert(s6);
		list3.insert(s7);
		
		double result = 0.0;
		double expected = 0.0;
		
		result = list0.programAverage("Geography");
		displayResults(result==expected, "average GPA of students in Geography, empty list");
		
		result = list1.programAverage("Geography");
		expected = 6.7;
		displayResults(Math.abs(result-expected)<THRESHOLD, "average GPA of students in Geography, list1");
		
		result = list3.programAverage("Physics");
		expected = 7.5;
		displayResults(Math.abs(result-expected)<THRESHOLD, "average GPA of students in Physics, list1");

		//TODO: add more tests here
		
	}
	
	public static void testHighestGPA() {
		System.out.println("\nStarting programAverage tests");
		/* List contents:
		list0: empty
		
		list1: v00123:6.7:Geography
		
		list2: v00123:6.7:Geography, v00246:9.0:Geography, v00357:8.2:Mathematics
		
		list3: v00123:6.7:Geography, v00555:7.8:Physics, v00987:4.5:Psychology, v00246:9.0:Geography
					v00357:8.2:Mathematics, v00149:7.2:Physics, v00001:8.4:Geography
		*/
		Student s1 = new Student("v00123", 6.7, "Geography");
		Student s2 = new Student("v00555", 7.8, "Physics");
		Student s3 = new Student("v00987", 4.5, "Psychology");
		Student s4 = new Student("v00246", 9.0, "Geography");
		Student s5 = new Student("v00357", 8.2, "Mathematics");
		Student s6 = new Student("v00149", 7.2, "Physics");
		Student s7 = new Student("v00001", 8.4, "Geography");

		list0 = new A4LinkedList();
		
		list1 = new A4LinkedList();
		list1.insert(s1);
		
		list2 = new A4LinkedList();
		list2.insert(s1);
		list2.insert(s4);
		list2.insert(s5);
		
		list3 = new A4LinkedList();
		list3.insert(s1);
		list3.insert(s2);
		list3.insert(s3);
		list3.insert(s4);
		list3.insert(s5);
		list3.insert(s6);
		list3.insert(s7);
		
		Student result = null;
		Student expected = null;
		
		result = list0.highestGPA();
		displayResults(result==expected, "highest GPA student in empty list");
		
		result = list1.highestGPA();
		expected = new Student("v00123", 6.7, "Geography");
		displayResults(result.equals(expected), "highest GPA student in list1");

		result = list3.highestGPA();
		expected = new Student("v00246", 9.0, "Geography");
		displayResults(result.equals(expected), "highest GPA student in list1");

		result = list2.highestGPA();
		expected = new Student("v00246", 9.0, "Geography");
		displayResults(result.equals(expected), "highest GPA student in list1");
		
		//TODO: add more tests here
	}
	
	public static void displayResults (boolean passed, String testName) {
		testCount++;
		if (passed) {
			System.out.println ("Passed test: " + testName);
			testPassCount++;
		} else {
			System.out.println ("Failed test: " + testName + " at line "
				+ Thread.currentThread().getStackTrace()[2].getLineNumber());
		}
    }
}