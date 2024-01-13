package csGroupProject;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * The Sort class provides methods for sorting books in the library.
 */
public class Sort {
    
    /**
     * Sorts the list of books by title in ascending order.
     *
     * @param books The list of books to be sorted.
     */
    public static void sortByTitle(List<Book> books) {
        Collections.sort(books, Comparator.comparing(Book::getTitle));
    }

    /**
     * Sorts the list of books by author in ascending order.
     *
     * @param books The list of books to be sorted.
     */
    public static void sortByAuthor(List<Book> books) {
        Collections.sort(books, Comparator.comparing(Book::getAuthor));
    }

    /**
     * Sorts the list of books by ISBN in ascending order.
     *
     * @param books The list of books to be sorted.
     */
    public static void sortByISBN(List<Book> books) {
        Collections.sort(books, Comparator.comparing(Book::getISBN));
    }

    /**
     * Sorts the list of books by print date in ascending order.
     *
     * @param books The list of books to be sorted.
     */
    public static void sortByPrintDate(List<Book> books) {
        Collections.sort(books, Comparator.comparing(Book::getPrintDate));
    }
}