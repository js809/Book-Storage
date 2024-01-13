package csGroupProject;

import java.util.Scanner;
import java.util.List;



public class UserInterface {
	
	private static int count = 0;
	private static int total = 0;
	
	//Welcomes user to the library program. Explains how to navigate the program.
	public static void displayMainMenu() {
		if(count < 1) {
		System.out.println("Welcome to the library book database\nUse the commands below to help navigate");
		count++;
		}
		System.out.println("\nMain Menu");
		System.out.println("-------------");
		System.out.println("Press 1 to search by title");
		System.out.println("Press 2 to search by author");
		System.out.println("Press 3 to search by first letter of the title");
		System.out.println("Press 4 to search by ISBN");
		System.out.println("Press 5 to search by print date");
		System.out.println("Press 6 to end");
		System.out.println("Press 7 to add a book to the database");
		System.out.println("Press 8 to remove a book from the database");
		System.out.println("Press 0 to display options again");
		System.out.println("-------------");
		System.out.println("Enter a command to continue: ");
	}
	
	//Displays results with multiple books
	protected static void displayBooks(List<Book> books) {
        if (books == null || books.isEmpty()) {
            System.out.println("No matching books found.\n");
        } else {
            for (Book book : books) {
            	total++;
            	System.out.println("------------");
                book.printDetails();
                
            }
            System.out.println("\nBooks found: " + total + "\n");
            total = 0;
        }
    }
	
	//Displays results with only one book
	protected static void displayBook(Book book) {
        if (book == null) {
            System.out.println("Book not found.\n");
        } else {
        	System.out.println("------------");
            System.out.println("Title: " + book.getTitle());
            System.out.println("Author: " + book.getAuthor());
            System.out.println("ISBN: " + book.getISBN());
            System.out.println("Print Date: " + book.getPrintDate());        }
    }
	

	
		
	}


