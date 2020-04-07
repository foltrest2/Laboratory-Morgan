package model;

public class Load {
	
	//attributes
	
	private int boxes;
	private int weight;
	private int loadType;
	
	//Constants
	
	public static final int DANGEROUS = 390000;
	public static final int PERISHABLE = 250000;
	public static final int NOTPERISHABLE = 80000;
	
	//Methods
	
	public Load(int pBoxes, int pWeight, int pLoadType){
		boxes = pBoxes;
		weight = pWeight;
		loadType = pLoadType;
	}
	
	public int getBoxes(){
		return boxes;
	}
	
	public void setBoxes(int pBoxes){
		this.boxes = pBoxes;
	}
	
	public int getWeight(){
		return weight;
	}
	
	public void setWeight(int pWeight){
		this.weight = pWeight;
	}
	
	public int getLoadType(){
		return loadType;
	}
	
	public void setLoadType(int pLoadType){
		this.loadType = pLoadType;
	}
}