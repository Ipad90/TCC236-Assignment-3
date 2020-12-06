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

public class BookDetailsModule implements BookDetailsInterface {
	private String ISBN;
	private String title;
	private String author;
	private String genre;
	
	public BookDetailsModule(String ISBN, String title, String author, String genre) {
		this.ISBN = ISBN;
		this.title = title;
		this.author = author;
		this.genre = genre;
	}
	
	@Override
	public String getISBN() {
		return this.ISBN;
	}

	@Override
	public String getTitle() {
		return this.title;
	}

	@Override
	public String getGenre() {
		return this.genre;
	}

	@Override
	public String getAuthor() {
		return this.author;
	}
	
	public void displayAllDetails() {
		System.out.print("ISBN Number: " + this.ISBN + " | ");
		System.out.print("Title: " + this.title + " | ");
		System.out.print("Author: " + this.author + " | ");
		System.out.print("Genre: " + this.genre + "\n");
	}
}
