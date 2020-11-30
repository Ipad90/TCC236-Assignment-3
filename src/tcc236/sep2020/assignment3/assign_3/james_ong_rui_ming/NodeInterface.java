package tcc236.sep2020.assignment3.assign_3.james_ong_rui_ming;

public interface NodeInterface {
	public DetailsModule getDetails();
	public NodeModule getLeft();
	public NodeModule getRight();
	public void setDetails(DetailsModule details);
	public void setLeft(NodeModule left);
	public void setRight(NodeModule right);
}
