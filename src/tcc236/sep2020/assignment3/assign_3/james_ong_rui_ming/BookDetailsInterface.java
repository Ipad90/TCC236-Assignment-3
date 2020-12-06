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

public interface BookDetailsInterface {
	public String getISBN();
	public String getTitle();
	public String getGenre();
	public String getAuthor();
	public void displayAllDetails();
}
