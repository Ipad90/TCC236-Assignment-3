package tcc236.sep2020.assignment3.assign_3.james_ong_rui_ming;

import java.util.*;

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
		
		System.out.println("Time taken (Milliseconds): " + time_taken + ".");
		
    	if (result != null) {
    		System.out.println("Book with ISBN: " + keyword + ", found.");
    		result.getDetails().displayAllDetails();
    		return true;
    	} else {
    		System.out.println("Book with ISBN: " + keyword + ", not found.");
    		return false;
    	}
    }
    
    private NodeModule searchRec(NodeModule root, String keyword) { 
    	//	Tree is empty or key is present at root 
	    if (root == null || root.getDetails().getISBN().equals(keyword)) {
	    	return root;     	
	    }
	  
	    //	Key is greater than root's key 
	    if (root.getDetails().getISBN().compareTo(keyword) < 0) {
	    	return searchRec(root.getRight(), keyword);     	
	    } else {
	    	//	Key is smaller than root's key 
	    	return searchRec(root.getLeft(), keyword);     	
	    } 
    }
    
    @Override
    public void inOrder(List<String> identifiers) {  	
    	System.out.println();
    	System.out.println("----- Start of search results -----");

    	List<BookDetailsModule> list = new ArrayList<BookDetailsModule>();
        list = inOrderRec(this.root, list, identifiers);
        if (list != null) {

        	for (BookDetailsModule details : list) {
        		details.displayAllDetails();
        	}
        	
        	if (identifiers.size() > 0) {
        		System.out.println();
        		System.out.println(list.size() + " books found that match the identifier type and keyword.");
        	}
        	
        }
        
        System.out.println("----- End of search results -----");        		
    }
   
    private List<BookDetailsModule> inOrderRec(NodeModule root, List<BookDetailsModule> list, List<String> identifiers) {
        if (root != null) { 
            inOrderRec(root.getLeft(), list, identifiers); 
            if (identifiers.size() > 0) {
            	boolean[] validator = new boolean[identifiers.size()];
            	boolean flag = true;
            	String checker = null;
            	for (int i = 0; i < identifiers.size(); i++) {
        			String temp[] = identifiers.get(i).split("\\|");
        			
        			int identifier_type = Integer.parseInt(temp[0]);
        			String keyword = temp[1];
        			
        			switch (identifier_type) {
        			case 1:
        				checker = root.getDetails().getAuthor();
        				break;
        			case 2:
        				checker = root.getDetails().getGenre();
        				break;
        			case 3:
        				checker = root.getDetails().getTitle();
        				break;
        			default:
        				break;
        			}
        			
        			if (checker.equals(keyword)) {
        				validator[i] = true;
        			}
            	}
            	
            	for (boolean validity : validator) {
            		if (validity == false) {
            			flag = false;
            		}
            	}
            	
            	if (flag) {
            		list.add(root.getDetails());
            	}
            	
            } else {
            	root.getDetails().displayAllDetails();
            }
            inOrderRec(root.getRight(), list, identifiers); 
        }
        return list;
    }
    
    @Override
    public void insert(BookDetailsModule details)  { 
        this.root = insertRec(this.root, details); 
    } 
   
    private NodeModule insertRec(NodeModule root, BookDetailsModule details) {
    	//	Tree is empty
        if (root == null) {
            root = new NodeModule(details); 
            System.out.println("Book successfully recorded.");
            this.size++;
            return root; 
        } 

        //	Traverse the tree
        if (details.getISBN().compareTo(root.getDetails().getISBN()) < 0) {
            root.setLeft(insertRec(root.getLeft(), details)); 
        } else if (details.getISBN().compareTo(root.getDetails().getISBN()) > 0) {
            root.setRight(insertRec(root.getRight(), details)); 
        } else {
        	//	Book with title already exist
        	System.out.println("Book with that ISBN, " + details.getISBN() + " already exists.");
        }

        return root; 
    }
    
    @Override
    public void delete(String keyword) {
    	NodeModule result = searchRec(this.root, keyword);
    	if (result != null) {
    		BookDetailsModule result_details = result.getDetails();
    		System.out.println("Deleting " + result_details.getTitle() + " by " + result_details.getAuthor() + " from book recording system.");
    		this.root = deleteRec(this.root, result_details);
    		this.size--;
    		System.out.println("Deleted book from book recording system.");
    	} else {
    		System.out.println("Book by that ISBN does not exist.");
    	}
    } 
   
    private NodeModule deleteRec(NodeModule root, BookDetailsModule details)  {
        //	Tree is empty
        if (root == null) {
        	System.out.println("Tree is empty, nothing to delete");
            return root;
        }
   
        //	Traverse the tree
        if (details.getISBN().compareTo(root.getDetails().getISBN()) < 0) {     
        	//	Traverse left subtree 
            root.setLeft(deleteRec(root.getLeft(), details)); 
        } else if (details.getISBN().compareTo(root.getDetails().getISBN()) > 0) { 
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
   
    private BookDetailsModule minValue(NodeModule root)  { 
        //	Initially minval = root
        BookDetailsModule min_val = root.getDetails(); 
        //	Find minval
        while (root.getLeft() != null)  { 
        	min_val = root.getLeft().getDetails(); 
            root = root.getLeft(); 
        } 
        return min_val; 
    }
}
