package csGroupProject;

import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.File;

/**
 * The FileHandler class is responsible for reading from and writing to the file
 * that stores the library's book data.
 */

public class FileHandler {
	private String filePath; //The path to the file that stores book data

	/**
	 * Constructor for FileHandler.
	 * @param filePath The path to the file used for storage
	 */
	public FileHandler(String filePath) {
		this.filePath = filePath;
	}

	/**
	 * Reads the book data from the file and returns it as a list of Book objects.
	 * @return A list of Book objects read from the file
	 */
	public List<Book> readFromFile()
	{
		List<Book> books = new ArrayList<>();
		File file = new File(filePath);
		
		
		//Check if file exists before attempting to read
		if (!file.exists()) 
		{
			return books; // File does not exist, return empty list
		}
		
		try (BufferedReader reader = new BufferedReader(new FileReader(file)))
		{
			String line;
			while ((line = reader.readLine()) != null)
			{
				Book book = parseBook(line); //Convert the line into a Book object 
				books.add(book);
			}
		}
		
		catch (IOException e)
		{
			//basic error handling, display error in console
			System.out.println("An error occurred while reading from the file: " + e.getMessage());
		}
		
		return books;	
	}

	/**
	 * Writes the provided list of Book objects to the file.
	 * @param books The list of Book objects to be written to the file
	 */
	public void writeToFile(List<Book> books)
	{
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath)))
		{
			for (Book book : books)
			{
				String bookAsString = book.toString(); //Convert the Book object to a string
				writer.write(bookAsString);
				writer.newLine(); //Write each book on a new line
			}
		}
		catch (IOException e)
		{
			//Basic error handling, display error in console
			System.out.println("An error occurred while writing to the file: " + e.getMessage());
		}
	}
	
	/**
	 * Parses a line o text from the file into a Book object.
	 * @param bookData A line of text representing a book
	 * @return The Book object parsed from the given text
	 */
	private Book parseBook(String bookData)
	{
		//Split the input String by commas
		String[] parts = bookData.split(",");
		//Create and return a new Book object using the parts
		//Assumes the Book constructor takes four arguments: title, author, ISBN, and printDate
		return new Book(parts[0], parts[1], parts[2], parts[3]); 
	}
}
