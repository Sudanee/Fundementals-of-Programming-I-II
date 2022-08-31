/* Migdad Izzeldin -- V00955271 */

public class Book {

	private String title;
	private Author author;
	private int rating;
	private int totalPages;
	
	public Book() {
		title = "unknown";
		author = null;
		rating = 0;
		totalPages = 0;
	}
	
	public Book(String title, Author author, int rating, int totalPages) {
		this.title = title;
		this.author = author;
		this.rating = rating;
		this.totalPages = totalPages;
	}

	
	public Author getAuthor() {
		return author;
	}
	
	public int getTotalPages() {
		return totalPages;
	}
	
	public int getRating() {
		return rating;
	}
	
	/*
	 * Purpose: determine if the current book is equal to other
	 * Parameters: Book other - the other book to compare to
	 * Returns: boolean - true if the two books have the same title and author
	 *          (the same book might have a different number of pages depending
	 *          on whether the copy is hard-cover or paperback, and might
	 *          receive different ratings from different reviewers).
	 */	
	public boolean equals(Book other) {
		return (this.title.equals(other.title) && this.author.equals(other.author)); // so it compiles
	}
	
	/*
	 * Purpose: determine the percentage the book has been read
	 * Parameters: int pagesRead - the number of pages read in this book
	 * Returns: double - the percentage of the way the reader has 
	 *          progressed through the book.
	 */	
	public double percentageRead(int pagesRead) {
		int pages = this.getTotalPages();
		double math = (pagesRead*100)/pages;
		System.out.println(math);
		return math; // so it compiles
	}
	
}
	