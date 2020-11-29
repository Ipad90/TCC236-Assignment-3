package tcc236.sep2020.assignment3.assign_3.james_ong_rui_ming;

public class TreeModule {
    private NodeModule root;
    private int size;
 
    public TreeModule() {
        this.root = null;
        this.size = 0;
    }
    
    public int getSize() {
    	return this.size;
    }
    
    public Boolean search(String keyword) {    	
    	long start_time = System.nanoTime();
    	
    	NodeModule result = searchRec(this.root, keyword);
    	
    	long end_time = System.nanoTime();
    	long time_taken = end_time - start_time;
		time_taken /= 1000000;
		
		System.out.println("Time taken (Milliseconds): " + time_taken);
		
    	if (result != null) {
    		System.out.println("Book by title: " + keyword + ", found.");
    		return true;
    	} else {
    		System.out.println("Book by title: " + keyword + ", not found.");
    		return false;
    	}
    }
    
    private NodeModule searchRec(NodeModule root, String keyword) { 
    	// Base Cases: root is null or key is present at root 
	    if (root == null || root.details.getTitle() == keyword) {
	    	return root;     	
	    }
	  
	    // Key is greater than root's key 
	    if (root.details.getTitle().compareTo(keyword) < 0) {
	    	return searchRec(root.right, keyword);     	
	    } else {
	    	// Key is smaller than root's key 
	    	return searchRec(root.left, keyword);     	
	    } 
    }

    public void inOrder() { 
        inOrderRec(this.root);
        System.out.println();
    } 
   
    private void inOrderRec(NodeModule root) { 
        if (root != null) { 
            inOrderRec(root.left); 
            root.details.displayAllDetails();
            inOrderRec(root.right); 
        }
    }

    public void insert(DetailsModule details)  { 
        this.root = insertRec(this.root, details); 
    } 
   
    private NodeModule insertRec(NodeModule root, DetailsModule details) {
    	String success_msg = "Book successfully recorded";
    	//	tree is empty
        if (root == null) {
            root = new NodeModule(details); 
            System.out.println(success_msg);
            this.size++;
            return root; 
        } 

        //traverse the tree
        if (details.getTitle().compareTo(root.details.getTitle()) < 0) {
            root.left = insertRec(root.left, details); 
        } else if (details.getTitle().compareTo(root.details.getTitle()) > 0) {
            root.right = insertRec(root.right, details); 
        } else {
        	//	Book with title already exist
        	System.out.println("Book with that title, " + details.getTitle() + " already exists");
        }

        return root; 
    }
    
    public void delete(DetailsModule details) { 
        this.root = deleteRec(this.root, details);
    } 
   
    private NodeModule deleteRec(NodeModule root, DetailsModule details)  { 
        //tree is empty
        if (root == null) {
            return root;
        }
   
        //traverse the tree
        if (details.getTitle().compareTo(root.details.getTitle()) < 0) {     //traverse left subtree 
            root.left = deleteRec(root.left, details); 
        } else if (details.getTitle().compareTo(root.details.getTitle()) > 0) { //traverse right subtree
            root.right = deleteRec(root.right, details); 
        } else { 
            // node contains only one child
            if (root.left == null) {
                return root.right; 
            } else if (root.right == null) {
                return root.left; 
            }
            // node has two children; 
            //get inorder successor (min value in the right subtree) 
            root.details = minValue(root.right); 
   
            // Delete the inorder successor 
            root.right = deleteRec(root.right, root.details); 
            this.size--;
        } 
        return root; 
    } 
   
    private DetailsModule minValue(NodeModule root)  { 
        //initially minval = root
        DetailsModule min_val = root.details; 
        //find minval
        while (root.left != null)  { 
        	min_val = root.left.details; 
            root = root.left; 
        } 
        return min_val; 
    }
}
