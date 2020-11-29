package tcc236.sep2020.assignment3.assign_3.james_ong_rui_ming;

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
