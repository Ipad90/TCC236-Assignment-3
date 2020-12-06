package tcc236.sep2020.assignment3.assign_3.james_ong_rui_ming;

/**
* Course Code : TCC236/05
* Course Title : Data Structures and Algorithms
* Student ID : 141190169
* Author : James Ong Rui Ming
* Date : 7 / 12 / 2020
* Honor Code : I pledge that this is my own program code.
* I received assistance from no one in understanding and debugging my program.
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Driver {
	private static TreeModule bst = new TreeModule();
	
    public static void main(String[] args) {
        Scanner user_input = new Scanner(System.in);
        
        initializer();
		
		while (true) {
			displayingFunctions();
			
			int input = user_input.nextInt();
			user_input.nextLine();
			switch (input) {
				case 1:
					List<String> identifiers = new ArrayList<String>();
										
					for (int i = 0; i < 3; i++) {
						System.out.println("List of identifiers");
						System.out.println("1. Author");
						System.out.println("2. Genre");
						System.out.println("3. Title");
						System.out.println("4. No identifiers or stop adding identifiers, list out all books");
						
						int identifier_type = user_input.nextInt();
						user_input.nextLine();
						
						if (identifier_type != 4) {
							String keyword = "Action";
							System.out.println("Specify the keyword to find");
							keyword = user_input.nextLine();
							identifiers.add(identifier_type + "|" + keyword); 					
						} else {
							break;
						}
					}

					bst.inOrder(identifiers);
					break;
				case 2:
					System.out.println("Insert book ISBN.");
					String book_to_find = user_input.nextLine();
					System.out.println("Searching for book from book recording system");
					bst.search(book_to_find);
					break;
				case 3:
					System.out.println("Amount of books in book recording system is: " + bst.getSize());
					break;
				case 4:
					System.out.println("Insert book ISBN");
					String book_ISBN = user_input.nextLine();
					System.out.println("Insert book title.");
					String book_title = user_input.nextLine();
					System.out.println("Insert book author.");
					String book_author = user_input.nextLine();
					System.out.println("Insert book genre.");
					String book_genre = user_input.nextLine();
					
					BookDetailsModule book_details = new BookDetailsModule(book_ISBN, book_title, book_author, book_genre);
					
					bst.insert(book_details);
					break;
				case 5:
					System.out.println("Insert book ISBN.");
					String book_to_delete = user_input.nextLine();
					bst.delete(book_to_delete);
					break;
				case 6:
					System.out.println("Book recording system stopped");
					user_input.close();
					return;
				default:
					break;
			}
		}
    }
    
    private static void displayingFunctions() {
    	System.out.println("");
		System.out.println("List of functions");
		System.out.println("1. Display in order - Displays the books in the book recording system using an in order sequence.");
		System.out.println("2. Search - Finds and displays the details of book within the book recording system based on the ISBN specified.");
		System.out.println("3. Get count - Displays the amount of books in the book recording system.");
		System.out.println("4. Insert - Adds a book into the book recording system.");
		System.out.println("5. Delete - Removes a book from the book recording system.");
		System.out.println("6. Exit - Stops the book recording system.");
		System.out.println("Input here");
    }
    
    private static void initializer() {
		try {
			File file = new File("mockdata.txt");
			Scanner reader = new Scanner(file);
			
			long start_time = System.nanoTime();
			
			System.out.println("----- Begin inserting default data in BST -----");
			
			while (reader.hasNextLine()) {
				String new_line = reader.nextLine();
				String[] line = new_line.split("\\|");
				BookDetailsModule details = new BookDetailsModule(line[0], line[1], line[2], line[3]);
				bst.insert(details);
			}
					
			long end_time = System.nanoTime();
	    	long time_taken = end_time - start_time;
			time_taken /= 1000000;
			
			System.out.println("Time taken (Milliseconds): " + time_taken);
			System.out.println("----- Finish inserting default data in BST -----");
			
			reader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
    }
}
