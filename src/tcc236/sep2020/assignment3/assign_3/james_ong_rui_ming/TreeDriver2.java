package tcc236.sep2020.assignment3.assign_3.james_ong_rui_ming;

public class TreeDriver2 {
    public static void main(String[] args) {
        TreeModule bst = new TreeModule();
        
        DetailsModule d0 = new DetailsModule("Grant-Jacobson", "Cristoph", "Fiction");
        DetailsModule d1 = new DetailsModule("Bailey Group", "Berk", "Action");
        DetailsModule d2 = new DetailsModule("Raynor LLC", "Daloris", "Horror");
        DetailsModule d3 = new DetailsModule("Johnson, Baumbach and Denesik", "Constantine", "Comedy");
        DetailsModule d4 = new DetailsModule("Denesik and Sons", "Wylma", "Romance");
        
        bst.insert(d0);
        bst.insert(d1);
        bst.insert(d2);
        bst.insert(d3);
        bst.insert(d4);
        
        bst.inOrder();
        
        bst.search("Denesik and Sons");
    }
}
