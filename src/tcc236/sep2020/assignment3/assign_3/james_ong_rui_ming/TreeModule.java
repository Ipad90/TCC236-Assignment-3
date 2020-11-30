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

public class TreeModule implements TreeInterface {
    private NodeModule root;
    private int size;
 
    public TreeModule() {
        this.root = null;
        this.size = 0;
    }
    
    @Override
    public int getSize() {
    	return this.size;
    }
    
    @Override
    public Boolean search(String keyword) {    	
    	long start_time = System.nanoTime();
    	
    	NodeModule result = searchRec(this.root, keyword);
    	
    	long end_time = System.nanoTime();
    	long time_taken = end_time - start_time;
		time_taken /= 1000000;
		
		System.out.println("Time taken (Milliseconds): " + time_taken);
		
    	if (result != null) {
    		System.out.println("Book by title: " + keyword + ", found.");
    		result.getDetails().displayAllDetails();
    		return true;
    	} else {
    		System.out.println("Book by title: " + keyword + ", not found.");
    		return false;
    	}
    }
    
    private NodeModule searchRec(NodeModule root, String keyword) { 
    	//	Root is null or key is present at root 
	    if (root == null || root.getDetails().getTitle().equals(keyword)) {
	    	return root;     	
	    }
	  
	    //	Key is greater than root's key 
	    if (root.getDetails().getTitle().compareTo(keyword) < 0) {
	    	return searchRec(root.getRight(), keyword);     	
	    } else {
	    	//	Key is smaller than root's key 
	    	return searchRec(root.getLeft(), keyword);     	
	    } 
    }
    
    @Override
    public void inOrder() { 
        inOrderRec(this.root);
        System.out.println();
    } 
   
    private void inOrderRec(NodeModule root) { 
        if (root != null) { 
            inOrderRec(root.getLeft()); 
            root.getDetails().displayAllDetails();
            inOrderRec(root.getRight()); 
        }
    }
    
    @Override
    public void insert(DetailsModule details)  { 
        this.root = insertRec(this.root, details); 
    } 
   
    private NodeModule insertRec(NodeModule root, DetailsModule details) {
    	String success_msg = "Book successfully recorded";
    	//	Tree is empty
        if (root == null) {
            root = new NodeModule(details); 
            System.out.println(success_msg);
            this.size++;
            return root; 
        } 

        //	Traverse the tree
        if (details.getTitle().compareTo(root.getDetails().getTitle()) < 0) {
            root.setLeft(insertRec(root.getLeft(), details)); 
        } else if (details.getTitle().compareTo(root.getDetails().getTitle()) > 0) {
            root.setRight(insertRec(root.getRight(), details)); 
        } else {
        	//	Book with title already exist
        	System.out.println("Book with that title, " + details.getTitle() + " already exists");
        }

        return root; 
    }
    
    @Override
    public void delete(String keyword) {
    	NodeModule result = searchRec(this.root, keyword);
    	if (result != null) {
    		System.out.println("Deleting book from book recording system");
    		DetailsModule result_details = result.getDetails();
    		this.root = deleteRec(this.root, result_details);
    		this.size--;
    	} else {
    		System.out.println("Book by that title does not exist");
    	}
    } 
   
    private NodeModule deleteRec(NodeModule root, DetailsModule details)  {
        //	Tree is empty
        if (root == null) {
            return root;
        }
   
        //	Traverse the tree
        if (details.getTitle().compareTo(root.getDetails().getTitle()) < 0) {     
        	//	Traverse left subtree 
            root.setLeft(deleteRec(root.getLeft(), details)); 
        } else if (details.getTitle().compareTo(root.getDetails().getTitle()) > 0) { 
        	//	Traverse right subtree
            root.setRight(deleteRec(root.getRight(), details)); 
        } else { 
            //	Node contains only one child
            if (root.getLeft() == null) {
                return root.getRight(); 
            } else if (root.getRight() == null) {
                return root.getLeft(); 
            }
            //	Node has two children; 
            //	Get inorder successor (min value in the right subtree) 
            root.setDetails(minValue(root.getRight())); 
   
            //	Delete the inorder successor 
            root.setRight(deleteRec(root.getRight(), root.getDetails())); 
        } 
        return root; 
    } 
   
    private DetailsModule minValue(NodeModule root)  { 
        //	Initially minval = root
        DetailsModule min_val = root.getDetails(); 
        //	Find minval
        while (root.getLeft() != null)  { 
        	min_val = root.getLeft().getDetails(); 
            root = root.getLeft(); 
        } 
        return min_val; 
    }
}
