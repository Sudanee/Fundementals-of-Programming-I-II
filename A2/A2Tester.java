public class A2Tester {

	private static int testPassCount = 0;
	private static int testCount = 0;

	public static void main(String[] args) {

		// Uncomment and test one method at a time. 
		// Write additional tests as you see fit.

		/* Part 1: The Date class */
		// testBookConstructor();
		// testEquals();
		testPercentageRead();
		
		/* Part 2: The A2Exercises class */
		// testAddBook();
		// testNumberOfPages();
		// testBooksWithRating();
		// testNumOlderAuthors();
		
		System.out.println("Passed " + testPassCount + " / " + testCount + " tests");
	}
	
	public static void testBookConstructor() {
		System.out.println("\nTesting Book Constructor");
		
		Author a1 = new Author("Gillian", "Flynn", 49);
		Author a2 = new Author("Veronica", "Roth", 32);
		
		Book b1 = new Book("Gone Girl", a1, 5, 432);
		Book b2 = new Book("Divergent", a2, 4, 487);
		
		int result;
		int expected;
		
		result = b1.getTotalPages();
		expected = 432;
		displayResults("b1 construcutor totalPages initialized", result==expected);
		
		result = b2.getRating();
		expected = 4;
		displayResults("b1 construcutor rating initialized", result==expected);
		
		/* uncomment the following lines to test if the author was initialized correctly: */		
		Author resultAuthor = null;
		Author expectedAuthor = null;
		
		resultAuthor = b1.getAuthor();
		expectedAuthor = a1;
		displayResults("b1 construcutor author initialized", resultAuthor.equals(expectedAuthor));
		
		resultAuthor = b2.getAuthor();
		expectedAuthor = a2;
		displayResults("b2 construcutor author initialized", resultAuthor.equals(expectedAuthor));

	}
	
	public static void testEquals() {
		System.out.println("\nTesting Book equals method");
		
		Author a1 = new Author("Gillian", "Flynn", 49);
		Author a2 = new Author("Veronica", "Roth", 32);
		
		Book b1 = new Book("Gone Girl", a1, 5, 432);
		Book b2 = new Book("Divergent", a2, 4, 487);
		Book b3 = new Book("Allegiant", a2, 5, 526);
		Book b4 = new Book("Gone Girl", a1, 5, 456);
		Book b5 = new Book("Divergent", a2, 3, 487);
		
		boolean result = false;
		boolean expected = false;
		
		result = b1.equals(b2);
		displayResults("b1 equals b2", result==false);
		result = b1.equals(b3);
		displayResults("b1 equals b3", result==false);
		result = b2.equals(b3);
		displayResults("b2 equals b3", result==false);
		result = b1.equals(b4);
		displayResults("b1 equals b4", result==true);
		result = b2.equals(b5);
		displayResults("b2 equals d5", result==true);
		result = b4.equals(b5);
		displayResults("b4 equals b5", result==false);
	
	}
	
	public static void testPercentageRead() {
		System.out.println("\nTesting Book percentageRead method");
		Author a1 = new Author("Gillian", "Flynn", 49);
		Author a2 = new Author("Veronica", "Roth", 32);
		
		Book b1 = new Book("Gone Girl", a1, 5, 432);
		Book b2 = new Book("Divergent", a2, 4, 487);
		
		double result = 0.0;
		double expected = 0.0;
		
		result = b1.percentageRead(164);
		
		expected = 37.96;
		displayResults("b1.percentageRead(164)", Math.abs(expected-result)<0.1);
		
		
		result = b1.percentageRead(425);
		expected = 98.38;
		displayResults("b1.percentageRead(425)", Math.abs(expected-result)<0.1);
	
		result = b2.percentageRead(9);
		expected = 1.85;
		displayResults("b1.percentageRead(9)", Math.abs(expected-result)<0.1);
		
		result = b2.percentageRead(315);
		expected = 64.68;
		displayResults("b1.percentageRead(315)", Math.abs(expected-result)<0.1);
		
	}
		
	public static void testAddBook() {
		System.out.println("\nTesting addBook method");
		Author a1 = new Author("Gillian", "Flynn", 49);
		Author a2 = new Author("Veronica", "Roth", 32);
		Author a3 = new Author("Paula", "Hawkins", 48);
		Author a4 = new Author("John", "Green", 43);
		
		Book b1 = new Book("Gone Girl", a1, 5, 432);
		Book b2 = new Book("Divergent", a2, 4, 487);
		Book b3 = new Book("Allegiant", a2, 3, 526);
		Book b4 = new Book("The Girl on The Train", a3, 5, 395);
		Book b5 = new Book("The Fault in Our Stars", a4, 4, 313);
				
		Book[] arr0 = {};
		Book[] arr1 = {b3};
		Book[] arr2 = {b3, b1};
		Book[] arr3 = {b3, b1, b2, b4};
	
		boolean arraysEqual = false;
		Book[] result = null;

		arraysEqual = arrayEquals(arr0, arr1);
		displayResults("arr0 equals arr1 before add", arraysEqual==false);
		
		result = A2Exercises.addBook(arr0, b3);
		arraysEqual = arrayEquals(result, arr1);
		displayResults("after add to arr0", arraysEqual==true);
		
		result = A2Exercises.addBook(result, b1);
		arraysEqual = arrayEquals(result, arr2);
		displayResults("after second add to arr0", arraysEqual==true);
		arraysEqual = arrayEquals(arr1, arr2);
		displayResults("arr1 equals arr2", arraysEqual==false);
		
		result = A2Exercises.addBook(result, b2);
		result = A2Exercises.addBook(result, b4);
		arraysEqual = arrayEquals(result, arr3);
		displayResults("arr0 equals arr3 after 4 adds", arraysEqual==true);
	}
	
	public static boolean arrayEquals(Book[] arr1, Book[] arr2) {
		if (arr1.length != arr2.length) {
			return false;
		}
		for (int i = 0; i < arr1.length; i++) {
			if (!arr1[i].equals(arr2[i])) {
				return false;
			}
		}
		return true;
	}
	
	public static void testNumberOfPages() {
		System.out.println("\nTesting numberOfPages method");
		Author a1 = new Author("Gillian", "Flynn", 49);
		Author a2 = new Author("Veronica", "Roth", 32);
		Author a3 = new Author("Paula", "Hawkins", 48);
		Author a4 = new Author("John", "Green", 43);
		
		Book b1 = new Book("Gone Girl", a1, 5, 432);
		Book b2 = new Book("Divergent", a2, 4, 487);
		Book b3 = new Book("Allegiant", a2, 3, 526);
		Book b4 = new Book("The Girl on The Train", a3, 5, 395);
		Book b5 = new Book("The Fault in Our Stars", a4, 4, 313);
		
		Book[] arr0 = {};
		Book[] arr1 = {b3};
		Book[] arr2 = {b3, b1};
		Book[] arr3 = {b3, b1, b2, b4, b5};
		
		int result = 0;
		int expected = 0;
		
		result = A2Exercises.numberOfPages(arr0);
		displayResults("numberOfPages in arr0", result==expected);
		
		result = A2Exercises.numberOfPages(arr1);
		expected = 526;
		displayResults("numberOfPages in arr1", result==expected);
		
		result = A2Exercises.numberOfPages(arr2);
		expected = 526+432;
		displayResults("numberOfPages in arr2", result==expected);
		
		result = A2Exercises.numberOfPages(arr3);
		expected = 526+432+487+395+313;
		displayResults("numberOfPages in arr3", result==expected);
	}
	
	public static void testBooksWithRating() {
		System.out.println("\nTesting booksWithRating method");
		Author a1 = new Author("Gillian", "Flynn", 49);
		Author a2 = new Author("Veronica", "Roth", 32);
		Author a3 = new Author("Paula", "Hawkins", 48);
		Author a4 = new Author("John", "Green", 43);
		
		Book b1 = new Book("Gone Girl", a1, 5, 432);
		Book b2 = new Book("Divergent", a2, 4, 487);
		Book b3 = new Book("Allegiant", a2, 3, 526);
		Book b4 = new Book("The Girl on The Train", a3, 5, 395);
		Book b5 = new Book("The Fault in Our Stars", a4, 4, 313);
		
		Book[] arr0 = {};
		Book[] arr1 = {b3};
		Book[] arr2 = {b3, b1};
		Book[] arr3 = {b3, b1, b2, b4, b5};
		
		int result = 0;
		int expected = 0;
		
		result = A2Exercises.booksWithRating(arr0, 4);
		expected = 0;
		displayResults("booksWithRating 4 in arr0", result==expected);
		
		result = A2Exercises.booksWithRating(arr1, 4);
		expected = 0;
		displayResults("booksWithRating 4 in arr1", result==expected);
		
		result = A2Exercises.booksWithRating(arr1, 3);
		expected = 1;
		displayResults("booksWithRating 3 in arr1", result==expected);
		
		// TODO: Add more tests until you are sure your method works correctly.
		
	}
	
	public static void testNumOlderAuthors() {
		System.out.println("\nTesting numOlderAuthors method");
		Author a1 = new Author("Gillian", "Flynn", 49);
		Author a2 = new Author("Veronica", "Roth", 32);
		Author a3 = new Author("Paula", "Hawkins", 48);
		Author a4 = new Author("John", "Green", 43);
		Author a5 = new Author("Brandon", "Sanderson", 45);
		
		Book b1 = new Book("Gone Girl", a1, 5, 432);
		Book b2 = new Book("Divergent", a2, 4, 487);
		Book b3 = new Book("Allegiant", a2, 3, 526);
		Book b4 = new Book("The Girl on The Train", a3, 5, 395);
		Book b5 = new Book("The Fault in Our Stars", a4, 4, 313);
		
		Book[] arr0 = {};
		Book[] arr1 = {b4};
		Book[] arr2 = {b3, b1};
		Book[] arr3 = {b3, b1, b2, b4, b5};
		
		int result = 0;
		int expected = 0;
		
		result = A2Exercises.numOlderAuthors(arr0, a1);
		expected = 0;
		displayResults("numOlderAuthors in empty array", result==expected);
		
		result = A2Exercises.numOlderAuthors(arr1, a1);
		expected = 0;
		displayResults("numOlderAuthors in empty array", result==expected);
		
		result = A2Exercises.numOlderAuthors(arr1, a2);
		expected = 1;
		displayResults("numOlderAuthors in empty array", result==expected);
		
		result = A2Exercises.numOlderAuthors(arr1, a3);
		expected = 0;
		displayResults("numOlderAuthors in empty array", result==expected);
		
		// TODO: Add more tests until you are sure your method works correctly.
		
	}
	
	
	public static void displayResults (String testName, boolean passed) {
		/* There is some magic going on here getting the line number
		* Borrowed from:
		* http://blog.taragana.com/index.php/archive/core-java-how-to-get-java-source-code-line-number-file-name-in-code/
		*/

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
