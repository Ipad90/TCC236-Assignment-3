package tcc236.sep2020.assignment3.assign_3.james_ong_rui_ming;

public class NodeModule {
    public DetailsModule details;
    public NodeModule left;
    public NodeModule right;

    public NodeModule(DetailsModule details)
    {
        this.details = details;
        this.left = null;
        this.right = null;
    }
}
