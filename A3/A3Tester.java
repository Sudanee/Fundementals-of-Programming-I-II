/*
 * A3Tester
 *
 * A class to test the methods required for Assignment 3
 *
 */
public class A3Tester {
    
	private static int testPassCount = 0;
	private static int testCount = 0;

    public static void main(String[] args) {
		
		// Uncomment each method one at a time, 
		// and implement the method in A3LinkedList.java 
		// until all tests pass. It is strongly
		// recommended that you add additional tests 
		// to ensure the correctness of your implementation.
		
		// testAddFront();
		// testAddBack();
		// testSizeAndIsEmpty();
		// testRemoveFront();
		// testRemoveBack();
		// testRotate();
		// testInterleave();
		midTerm();
		
		System.out.println("Passed " + testPassCount + "/" + testCount + " tests");
    }
	
	public static void midTerm() {	
		A3LinkedList list1 = new A3LinkedList();
		list1.addFront("8");
		list1.addFront("2");
		list1.addFront("1");
		list1.addFront("6");
		list1.addFront("3");
		list1.movetoBack(4);
		
		String result = list1.frontToBack();
		System.out.println(result);
		displayResults(result.equals("{82136}"), "testAddFront");

	}
	
	
	
	public static void testAddFront() {
		String result = "";
		A3LinkedList list1 = new A3LinkedList();
		
		result = list1.frontToBack();
		displayResults(result.equals("{}"), "testAddFront");
		
		list1.addFront("A");
		result = list1.frontToBack();
		displayResults(result.equals("{A}"), "testAddFront");
		
		list1.addFront("V");
		list1.addFront("A");
		list1.addFront("J");
		result = list1.frontToBack();
		result = list1.frontToBack();
		displayResults(result.equals("{JAVA}"), "testAddFront");
		System.out.println(result);
		result = list1.backToFront();
		System.out.println(result);
		displayResults(result.equals("{AVAJ}"), "testAddFront");
		
	}
	
	public static void testAddBack() {
		String result = "";
		A3LinkedList list1 = new A3LinkedList();
		
		result = list1.frontToBack();
		displayResults(result.equals("{}"), "testAddBack");
		
		list1.addBack("F");
		result = list1.frontToBack();
		displayResults(result.equals("{F}"), "testAddBack");
		
		list1.addBack("U");
		list1.addBack("N");
		result = list1.frontToBack();
		displayResults(result.equals("{FUN}"), "testAddBack");
		result = list1.backToFront();
		displayResults(result.equals("{NUF}"), "testAddBack");
	}
	
	public static void testSizeAndIsEmpty() {
		int result = 0;
		A3LinkedList list1 = new A3LinkedList();

		result = list1.size();
		displayResults(result==0, "testSizeAndIsEmpty");
		displayResults(list1.isEmpty()==true, "testSizeAndIsEmpty");
		
		list1.addFront("C");
		list1.addFront("S");
		list1.addFront("C");
		result = list1.size();
		displayResults(result==3, "testSizeAndIsEmpty");
		displayResults(list1.isEmpty()==false, "testSizeAndIsEmpty");
		
		list1.addBack("115");
		result = list1.size();
		displayResults(result==4, "testSizeAndIsEmpty");
		
	}
	
	public static void testRemoveFront() {
		String result = "";
		int resultn = 0;
		A3LinkedList list1 = new A3LinkedList();
		
		list1.addBack("P");
		list1.addBack("I");
		list1.addBack("N");
		list1.addBack("K");
		
		result = list1.frontToBack();
		displayResults(result.equals("{PINK}"), "testRemoveFront");
		
		list1.removeFront();
		result = list1.frontToBack();
		displayResults(result.equals("{INK}"), "testRemoveFront");
		

		resultn = list1.size();
		displayResults(resultn==3, "testSize");
		displayResults(list1.isEmpty()==false, "IsEmpty");

		list1.removeFront();
		result = list1.frontToBack();
		displayResults(result.equals("{NK}"), "testRemoveFront");

		resultn = list1.size();
		displayResults(resultn==2, "testSize");
		displayResults(list1.isEmpty()==false, "IsEmpty");

		list1.removeFront();
		result = list1.frontToBack();
		displayResults(result.equals("{K}"), "testRemoveFront");

		resultn = list1.size();
		displayResults(resultn==1, "testSize");
		displayResults(list1.isEmpty()==false, "IsEmpty");
		
		list1.removeFront();
		result = list1.frontToBack();
		displayResults(result.equals("{}"), "testRemoveFront");

		resultn = list1.size();
		displayResults(resultn==0, "testSize");
		displayResults(list1.isEmpty()==true, "IsEmpty");
		
		list1.removeFront();
		resultn = list1.size();
		displayResults(result.equals("{}"), "testRemoveFront");
		displayResults(resultn==0, "testSize");
		displayResults(list1.isEmpty()==true, "IsEmpty");
		
		/* Write additional tests here to ensure all of your pointers
		   have been updated correctly.
		
		   You should also ensure that your size and isEmpty 
		   methods work with removal as well as addition */
				
	}
	
	public static void testRemoveBack() {
		String result = "";
		int resultn = 0;
		A3LinkedList list1 = new A3LinkedList();
		
		list1.addBack("P");
		list1.addBack("I");
		list1.addBack("N");
		list1.addBack("K");
		
		result = list1.frontToBack();
		displayResults(result.equals("{PINK}"), "testRemoveBack");
		
		list1.removeBack();
		result = list1.frontToBack();
		displayResults(result.equals("{PIN}"), "testRemoveBack");
		

		resultn = list1.size();
		displayResults(resultn==3, "testSize");
		displayResults(list1.isEmpty()==false, "IsEmpty");

		list1.removeBack();
		result = list1.frontToBack();
		displayResults(result.equals("{PI}"), "testRemoveBack");

		resultn = list1.size();
		displayResults(resultn==2, "testSize");
		displayResults(list1.isEmpty()==false, "IsEmpty");

		list1.removeBack();
		result = list1.frontToBack();
		displayResults(result.equals("{P}"), "testRemoveBack");

		resultn = list1.size();
		displayResults(resultn==1, "testSize");
		displayResults(list1.isEmpty()==false, "IsEmpty");
		
		list1.removeBack();
		result = list1.frontToBack();
		displayResults(result.equals("{}"), "testRemoveBack");

		resultn = list1.size();
		displayResults(resultn==0, "testSize");
		displayResults(list1.isEmpty()==true, "IsEmpty");

		list1.removeBack();
		result = list1.frontToBack();
		displayResults(result.equals("{}"), "testRemoveBack");

		list1.addBack("P");
		list1.addBack("I");
		list1.addBack("N");
		list1.addBack("K");
		
		result = list1.frontToBack();
		displayResults(result.equals("{PINK}"), "testRemoveBack");
	}
	
	public static void testRotate() {
		String result = "";
		A3LinkedList list1 = new A3LinkedList();
		
		list1.addBack("A");
		list1.addBack("B");
		list1.addBack("C");
		list1.addBack("D");
		list1.addBack("E");
		list1.addBack("F");
		list1.addBack("G");
		result = list1.frontToBack();
		
		displayResults(result.equals("{ABCDEFG}"), "testRotate");
		
		list1.rotate(1);
		result = list1.frontToBack();
		System.out.println(result);
		displayResults(result.equals("{GABCDEF}"), "testRotate");
		
		list1.rotate(3);
		result = list1.frontToBack();
		System.out.println(result);
		displayResults(result.equals("{DEFGABC}"), "testRotate");
		
		/* Write additional tests here to ensure all of your pointers
		   have been updated correctly. */
		
	}

	public static void testInterleave() {
		A3LinkedList list1 = new A3LinkedList();
		A3LinkedList list2 = new A3LinkedList();
		A3LinkedList list3 = new A3LinkedList();
		A3LinkedList list4 = new A3LinkedList();
		String result1 = "";
		String result2 = "";
		
		list1.addBack("A");
		list1.addBack("B");
		list1.addBack("C");
		list1.addBack("D");
		list1.addBack("E");
		list1.addBack("F");
		list1.addBack("G");
		result1 = list1.frontToBack();
		displayResults(result1.equals("{ABCDEFG}"), "testInterleave");
		
		list2.addBack("L");
		list2.addBack("M");
		list2.addBack("N");
		list2.addBack("O");
		list2.addBack("P");
		list2.addBack("Q");
		list2.addBack("R");
		result2 = list2.frontToBack();
		displayResults(result2.equals("{LMNOPQR}"), "testInterleave");
		
		list1.interleave(list2);
		result1 = list1.frontToBack();
		result2 = list2.frontToBack();
		
		displayResults(result1.equals("{AMCOEQG}"), "testInterleave");
		displayResults(result2.equals("{LBNDPFR}"), "testInterleave");
		System.out.println(result1);
		System.out.println(result2);

		list3.addBack("M");
		list3.addBack("I");
		list3.addBack("G");
		list3.addBack("D");
		list3.addBack("A");
		list3.addBack("D");
		list3.addBack("S");
		result2 = list3.frontToBack();
		displayResults(result2.equals("{MIGDADS}"), "testInterleave");

		list4.addBack("L");
		list4.addBack("M");
		list4.addBack("N");
		list4.addBack("O");
		list4.addBack("P");
		list4.addBack("Q");
		list4.addBack("R");
		result2 = list4.frontToBack();
		displayResults(result2.equals("{LMNOPQR}"), "testInterleave");

		list3.interleave(list4);
		result1 = list3.frontToBack();
		result2 = list4.frontToBack();
		
		displayResults(result1.equals("{MMGOAQS}"), "testInterleave");
		displayResults(result2.equals("{LINDPDR}"), "testInterleave");
		System.out.println(result1);
		System.out.println(result2);


		/* Write additional tests here to ensure all of your pointers
		   have been updated correctly. */

	}
	
	public static void displayResults (boolean passed, String testName) {
       /* There is some magic going on here getting the line number
        * Borrowed from:
        * http://blog.taragana.com/index.php/archive/core-java-how-to-get-java-source-code-line-number-file-name-in-code/
        */
        
        testCount++;
        if (passed)
        {
            System.out.println ("Passed test: " + testName);
            testPassCount++;
        }
        else
        {
            System.out.println ("Failed test: " + testName + " at line "
                                + Thread.currentThread().getStackTrace()[2].getLineNumber());
        }
    }
	
}
