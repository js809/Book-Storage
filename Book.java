package csGroupProject;

/**
 * Represents a book in the library system.
 */

public class Book extends Printable
{
	private String title;
	private String author;
	private String ISBN;
	private String printDate;
	
	/**
	 * Constructs a new Book with the specified details.
	 * 
	 * @param title     The title of the book.
	 * @param author    The author of the book.
	 * @param ISBN      The ISBN of the book.
	 * @param printDate The print date of the book.
	 */
	public Book(String title, String author, String ISBN, String printDate)
	{
		this.title = title;
		this.author = author;
		this.ISBN = ISBN;
		this.printDate = printDate;
	}
	
	//Getters for the book attributes
	public String getTitle()
	{
		return title;
	}
	
	public String getAuthor()
	{
		return author;
	}
	
	public String getISBN()
	{
		return ISBN;
	}
	
	public String getPrintDate()
	{
		return printDate;
	}
	
	/**
	 * Returns a string representation of the book in CSV format.
	 * @return A CSV representation of the book.
	 */
	@Override
	public String toString()
	{
		return title + "," + author + "," + ISBN + "," + printDate;
	}
	
	@Override
	public void printDetails() {
		System.out.println("Title: " + title);
		System.out.println("Author: " + author);
		System.out.println("ISBN: " + ISBN);
		System.out.println("Print Date: " + printDate);
	}
}
