package csGroupProject;

import java.util.ArrayList;
import java.util.List;

/**
 * The Library class manages a collection of books and provides methods to add,
 * remove, and retrieve books. It handles the persistence of the book data
 * through the FileHandler class.
 */

public class Library 
{
	
	private List<Book> books;//List to store the book objects
	
	
	private FileHandler fileHandler; //FileHandler for reading and writing books to a file
	
	/**
	 * Constructor for the Library class. Initializes the books list and
	 * loads existing books from the file.
	 */
	public Library()
	{
		this.books = new ArrayList<>();
		this.fileHandler = new FileHandler("books_data.txt");
		this.loadBooksFromFile(); //Loads books from the file on creation		
	}
	
	/**
	 * Adds a book to the library and persists the updated collection to the file
	 * @param book The Book object to be added to the library
	 */	
	public void addBook(Book book)
	{
		//Check if a book with the same ISBN already exists in the library
		for (Book b : books)
			{
			if (b.getISBN().equals(book.getISBN()))
				{
				System.out.println("A book with this ISBN already exists.");
				return;
				}
			}
		//If no duplicates are found, add the book and save the list to the file
		books.add(book);
		fileHandler.writeToFile(books); //Save changes to the file
		System.out.println(book.getTitle() + " has been added!");
	}
	/**
	 * Removes a book from the library by its ISBN and updates the file.
	 * @param ISBN The ISBN of the book to be removed
	 * @return true if the book was successfully removed, false otherwise
	 */
	public boolean removeBook(String ISBN)
	{
		boolean removed = books.removeIf(book -> book.getISBN().equals(ISBN));
		fileHandler.writeToFile(books); //Save changes to the file
		return removed;
	}

	/**
	 * Retrieves the list of all books in the library.
	 * @return A list of all books
	 */
	public List<Book> getBooks()
	{
		return books;
	}
	
	/**
	 * Loads the book data from the file into the library's book list.
	 */
	private void loadBooksFromFile()
	{
		List<Book> loadedBooks = fileHandler.readFromFile();
		if (loadedBooks != null)
		{
			books.addAll(loadedBooks);
		}
	}
}
