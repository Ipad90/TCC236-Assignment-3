package tcc236.sep2020.assignment3.assign_3.james_ong_rui_ming;

/**
* Course Code : TCC236/05
* Course Title : Data Structures and Algorithms
* Student ID : 141190169
* Author : James Ong Rui Ming
* Date : (Enter the assignment submission date)
* Honor Code : I pledge that this is my own program code.
* I received assistance from no one in understanding and debugging my program.
*/

public class DetailsModule implements DetailsInterface {
	private String title;
	private String author;
	private String genre;
	
	public DetailsModule(String title, String author, String genre) {
		this.title = title;
		this.author = author;
		this.genre = genre;
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
		System.out.print("Title: " + this.title + " | ");
		System.out.print("Author: " + this.author + " | ");
		System.out.print("Genre: " + this.genre + "\n");
	}
}
