package csGroupProject;

import java.util.Scanner;
import java.util.List;



public class Main extends UserInterface {
	

public static void main(String[] args) {
		
		Library library = new Library();
		int navigator;
		String input = "";
		
		Scanner keyboard = new Scanner(System.in);
		displayMainMenu();
		
		navigator = keyboard.nextInt();
		while(navigator != 6) {
			switch(navigator) {
			case 0:
				System.out.println("\nYou have returned to the main menu.");
				displayMainMenu();
				navigator = keyboard.nextInt();
			 	break;
			case 1:
				System.out.print("--------\nSearching by title. Enter title to search for: ");
				keyboard.nextLine();
				input = keyboard.nextLine();
				Sort.sortByTitle(library.getBooks());
				List<Book> booksByName = Search.byName(library, input);
		        displayBooks(booksByName);
				System.out.print("Enter a command to continue. Press 0 to display list of options again: ");
				
				navigator = keyboard.nextInt();
				break;
			case 2:
				System.out.print("--------\nSearching by author. Enter author to search for: ");
				keyboard.nextLine();
				input = keyboard.nextLine();
				Sort.sortByAuthor(library.getBooks());
				List<Book> booksByAuthor = Search.byAuthor(library, input);
				displayBooks(booksByAuthor);
				System.out.print("Enter a command to continue. Press 0 to display list of options again: ");
				
				navigator = keyboard.nextInt();
				break;
			case 3: 
				  System.out.print("--------\nSearching by first letter of the title.\nEnter letter to search for: ");
                  input = keyboard.next();

                  // Nested if loop for input validation
                  if (!input.isEmpty()) {
                      // Nested if loop for additional validation if needed
                      if (Character.isLetter(input.charAt(0))) {
                          Sort.sortByTitle(library.getBooks());
                          List<Book> booksByFirstLetter = Search.byFirstLetter(library, input.charAt(0));
                          displayBooks(booksByFirstLetter);
                      } else {
                          System.out.println("Invalid input. Please enter a letter.");
                      }
                  } else {
                      System.out.println("Invalid input. Please enter a letter.");
                  }

                  System.out.print("\nEnter a command to continue. Press 0 to display list of options: ");
                  navigator = keyboard.nextInt();
                  break;
                  
			case 4:
				System.out.print("--------\nSearching by ISBN. Enter ISBN to search for: ");
				input = keyboard.next();
				Book bookByISBN = Search.byISBN(library, input);
				displayBook(bookByISBN);
				System.out.print("Enter a command to continue. Press 0 to display list of options: ");
				navigator = keyboard.nextInt();
				break;
			case 5:
				System.out.print("--------\nSearching by print date. Enter print date to search for: ");
				input = keyboard.next();
				Sort.sortByPrintDate(library.getBooks());
				List<Book> booksByPrintDate = Search.byPrintDate(library, input);
				displayBooks(booksByPrintDate);
				System.out.print("Enter a command to continue. Press 0 to display list of options: ");
				navigator = keyboard.nextInt();
				break;
			case 7:
				System.out.println("--------\nAdding a book to the database.\nEnter information in the following order: title, author, ISBN, print date\n*Note: Date should be formatted mm-dd-yyyy ");
				System.out.println("Ensure that you press enter between each: ");
				
				keyboard.nextLine();
				String title = keyboard.nextLine();

				String author = keyboard.nextLine();

				String ISBN = keyboard.nextLine();  // Use next() for non-space separated input

				String printDate = keyboard.nextLine();  // Use next() for non-space separated input

				Book addedBook = new Book(title, author, ISBN, printDate);
				library.addBook(addedBook);
				System.out.println("\nEnter a command to continue. Press 0 to display list of options: ");
				navigator = keyboard.nextInt();
				break;
			case 8:
				System.out.print("--------\nRemoving a book from the database. Enter the ISBN of the book being removed: ");
				String isbn = keyboard.next();
				if(library.removeBook(isbn)) {
				System.out.println("Book with ISBN:" + isbn + " has been removed!");
				}
				else {
					System.out.println("\nNo book with this IBSN was found.");
				}
				System.out.print("\nEnter a command to continue. Press 0 to display list of options: ");
				navigator = keyboard.nextInt();
				break;
			default:
				System.out.print("--------\nYour input did not match the expected type.\nPlease enter a number 1-8, or press 0 to display options again:\n");
				navigator = keyboard.nextInt();
				break;
			}
		}
		
		System.out.println("You have exited the library program.");
		keyboard.close();
		
		
	}
	
}
