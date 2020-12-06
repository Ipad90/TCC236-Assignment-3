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

public class NodeModule implements NodeInterface {
    private BookDetailsModule details;
    private NodeModule left;
    private NodeModule right;

    public NodeModule(BookDetailsModule details)
    {
        this.details = details;
        this.left = null;
        this.right = null;
    }
    
    @Override
    public BookDetailsModule getDetails() {
    	return this.details;
    }
    
    @Override
    public NodeModule getLeft() {
    	return this.left;
    }
    
    @Override
    public NodeModule getRight() {
    	return this.right;
    }
    
    @Override
    public void setDetails(BookDetailsModule details) {
    	this.details = details;
    }
    
    @Override
    public void setLeft(NodeModule left) {
    	this.left = left;
    }
    
    @Override
    public void setRight(NodeModule right) {
    	this.right = right;
    }
}
