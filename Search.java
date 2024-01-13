package csGroupProject;

import java.util.ArrayList;
import java.util.List;

public class Search {
	// Method to search books by name (case-insensitive)
	public static List<Book> byName(Library library, String name) {
		List<Book> result = new ArrayList<>();
		for (Book book : library.getBooks()) {
			if (book.getTitle().toLowerCase().contains(name.toLowerCase())) {
				result.add(book);
			}
		}
		return result;
	}

	// Method to search books by author (case-insensitive)
	public static List<Book> byAuthor(Library library, String author) {
		List<Book> result = new ArrayList<>();
		for (Book book : library.getBooks()) {
			if (book.getAuthor().toLowerCase().contains(author.toLowerCase())) {
				result.add(book);
			}
		}
		return result;
	}

	// Method to search books by ISBN (case-sensitive)
	public static Book byISBN(Library library, String ISBN) {
		for (Book book : library.getBooks()) {
			if (book.getISBN().equals(ISBN)) {
				return book;
			}
		}
		// Log a message or throw an exception if ISBN is not found
		return null;
	}

	// Method to search books by print date (null-safe)
	public static List<Book> byPrintDate(Library library, String printDate) {
		List<Book> result = new ArrayList<>();
		for (Book book : library.getBooks()) {
			// Check for null before comparing print dates
			if (printDate != null && book.getPrintDate().equals(printDate)) {
				result.add(book);
			}
		}
		return result;
	}
	
	// Method to search books by first letter of the title
    public static List<Book> byFirstLetter(Library library, char firstLetter) {
        List<Book> result = new ArrayList<>();
        for (Book book : library.getBooks()) {
            if (Character.toLowerCase(book.getTitle().charAt(0)) == Character.toLowerCase(firstLetter)) {
                result.add(book);
            }
        }
        return result;
    }
}