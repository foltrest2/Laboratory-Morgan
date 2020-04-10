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

	/**
	 *This method is the constructor of Load.
	 *
	 *<b>pre:</b> <br>
	 *
	 *@param boxes is the quantity of boxes
	 *@param boxesWeight is the weight per each box
	 *@param loadType is the type of load (dangerous, pershable or not perishable)
	 *@param owner is the name of the respective owner
	 *
	 *<b>post:</b> Returns an object of Load type. <br>
	 */
	public Load(int boxes, int boxesWeight, String loadType, String owner ){
		this.boxes = boxes;
		this.boxesWeight = boxesWeight;
		this.loadType = loadType;
		this.owner = owner;

	}
	/**
	 *This method set the boxes of the load.
	 *
	 *<b>pre:</b> <br>
	 *
	 *@param boxes is quantity of boxes in the load 
	 *
	 *<b>post:</b>Set the boxes in the load. <br>
	 */
	public void setBoxes(int boxes){
		this.boxes = boxes;
	}
	/**
	 *This method get the boxes quantity of the load.
	 *
	 *<b>pre:</b>load was already created.<br>
	 *
	 *<b>post:</b>Returns the boxes quantity of the load. <br>
	 */
	public int getBoxes(){
		return boxes;
	}
	/**
	 *This method set the boxes weight per box.
	 *
	 *<b>pre:</b> <br>
	 *
	 *@param boxesWeight is the weight per boxes of the load.
	 *
	 *<b>post:</b>Set the boxes weight in the load. <br>
	 */
	public void setBoxesWeight(int boxesWeight){
		this.boxesWeight = boxesWeight;
	}
	/**
	 *This method get the the weight per boxes of the load.
	 *
	 *<b>pre:</b>load was already created.<br>
	 *
	 *<b>post:</b>Returns the boxes weight in the load. <br>
	 */
	public int getBoxesWeight(){
		return boxesWeight;
	}
	/**
	 *This method set the load type of load (perishable, dangerous or not perishable).
	 *
	 *<b>pre:</b> <br>
	 *
	 *@param loadType is the type of load.
	 *
	 *<b>post:</b>Set the load type  <br>
	 */
	public void setLoadType(String loadType){
		this.loadType = loadType;
	}
	/**
	 *This method get load type of load (perishable, dangerous or not perishable).
	 *
	 *<b>pre:</b>load was already created.<br>
	 *
	 *<b>post:</b>Returns the load type. <br>
	 */
	public String getLoadType(){
		return loadType;
	}
	/**
	 *This method get owner of the load.
	 *
	 *<b>pre:</b>load was already created.<br>
	 *<b>pre:</b>client was already created.<br>
	 *
	 *<b>post:</b>Returns the owner of the load. <br>
	 */
	public String getOwner() {
		return owner;
	}
}