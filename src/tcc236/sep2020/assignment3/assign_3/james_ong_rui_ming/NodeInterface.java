package tcc236.sep2020.assignment3.assign_3.james_ong_rui_ming;

public interface NodeInterface {
	public DetailsModule getData();
	public NodeModule getParent();
	public NodeModule getLeft();
	public NodeModule getRight();
	public void setData(DetailsModule data);
	public void setParent(NodeModule n);
	public void setLeft(NodeModule n);
	public void setRight(NodeModule n);
}
