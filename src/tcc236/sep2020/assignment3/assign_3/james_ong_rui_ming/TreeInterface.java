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

public interface TreeInterface {
	public int getSize();
	public Boolean search(String keyword);
	public void inOrder();
	public void insert(DetailsModule details);
	public void delete(String keyword);
}
