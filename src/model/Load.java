package model;

public class Load{

	//attributes

	private int boxes;
	private int boxesWeight;
	private String loadType;
	private String owner;
	
	//Constants
	
	public final static int DANGEROUS = 390000;
	public final static int PERISHABLE = 250000;
	public final static int NOTPERISHABLE = 80000;

	//Methods

	public Load(int boxes, int boxesWeight, String loadType, String owner){
		this.boxes = boxes;
		this.boxesWeight = boxesWeight;
		this.loadType = loadType;
		this.owner = owner;

	}
	public void setBoxes(int boxes){
		this.boxes = boxes;
	}
	public int getBoxes(){
		return boxes;
	}
	public void setBoxesWeight(int boxesWeight){
		this.boxesWeight = boxesWeight;
	}
	public int getBoxesWeight(){
		return boxesWeight;
	}
	public void setLoadType(String loadType){
		this.loadType = loadType;
	}
	public String getLoadType(){
		return loadType;
	}
	public String getOwner() {
		return owner;
	}
}