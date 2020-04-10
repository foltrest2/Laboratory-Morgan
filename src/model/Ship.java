package model;
import java.util.ArrayList;
public class Ship {

	//	attributes

	private String name;

	//Constants

	public static final int MAXWEIGHT = 28000;
	public static final int MINWEIGHT = 12000;
	public static final int MINLOAD = 2;
	public static final String EL_PIRATA = "El pirata";

	//Relations

	public ArrayList<Load> capacity;

	//Methods

	public Ship (){	
		this.name = EL_PIRATA;
		capacity = new ArrayList<Load>();	
	}
	/**
	 *This is method check if a new load can be added or not depend of the total weight in the ship.
	 *
	 *<b>pre:</b> <br>
	 *
	 *<b>post:</b> Returns add is a boolean when decide if a new load can be added. <br>
	 */
	public boolean addLoad() {
		boolean x=true;
		if(calculateTotalWeight()>MAXWEIGHT) {
			x=false;
		}
		return x;
	}
	/**
	 *This is method calculate the historical kilograms sent by the client.
	 *
	 *<b>pre:</b>A client was created as minimum. <br>
	 *<b>pre:</b>The client has successfully submitted a load at least. <br>
	 *
	 *@param name the name of client  
	 *
	 *<b>post:</b> Returns result of calculate the historical kilograms per client. <br>
	 */
	public int accumulateKgSentByClient(String name) {
		int accumulate=0;
		if(capacity!=null) {
			for (int i = 0; i < capacity.size(); i++) {
				String x = capacity.get(i).getOwner();
				if(name.equalsIgnoreCase(x))
					accumulate+=(capacity.get(i).getBoxes()*capacity.get(i).getBoxesWeight());
			}
		}
		return accumulate;
	} 
	/**
	 *This is method calculate the total weight in the ship.
	 *
	 *<b>pre:</b>A load was created as minimum (the array is not null). <br>
	 *
	 *<b>post:</b> Returns totalWeight int is the total weight added to the ship. <br>
	 */
	public int calculateTotalWeight(){
		int totalWeight = 0;
		if(capacity!=null) {
			for(int i = 0; i < capacity.size(); i++) {
				int x = 0;
				x = (capacity.get(i).getBoxes()*capacity.get(i).getBoxesWeight());
				totalWeight += x;
			}
		}
		return totalWeight;
	}
	/**
	 * This method unload the ship 
	 * 
	 * <b>pre:</b> <br>
	 *
	 *<b>post:</b> clear the array of loads. <br>
	 */
	public void unloadShipAutomatly() {
		capacity.clear();
	}
	/**
	 *This is method unload the ship.
	 *
	 *<b>pre:</b> <br>
	 *
	 *<b>post:</b> Returns message if the notifying the ship was unload. <br>
	 */
	public String unloadShip(){
		String message="";
		capacity.clear();
		message="The ship was succesfull unloaded";
		return message;
	}	
	/**
	 *This is method check if the ship can sail or not depend of the conditions.
	 *
	 *<b>pre:</b>A load of a client was created as minimum. <br>
	 *
	 *<b>post:</b> Returns toSail as boolean to know if the ship can sail or not. <br>
	 */
	public boolean shipSail() {
		boolean toSail;
		if((calculateTotalWeight()>= MINWEIGHT || capacity.size()>=MINLOAD) && verifySanityRule()==true && calculateTotalWeight()<=MAXWEIGHT)
			toSail = true;
		else	
			toSail = false;

		return toSail;
	}
	/**
	 *This is method check the sanity conditions of the loads.
	 *
	 *<b>pre:</b>A load of client was created as minimum. <br>
	 *
	 *<b>post:</b> Returns correct as boolean if the loads accomplish with the sanity conditions. <br>
	 */
	public boolean verifySanityRule() {
		boolean correct = true;
		for (int i = 0; i < capacity.size(); i++) {
			for (int j = 1; j < capacity.size(); j++) {
				if((capacity.get(i).getLoadType().equalsIgnoreCase("DANGEROUS") && capacity.get(j).getLoadType().equalsIgnoreCase("PERISHABLE"))||(capacity.get(i).getLoadType().equalsIgnoreCase("PERISHABLE")&&capacity.get(j).getLoadType().equalsIgnoreCase("DANGEROUS")))
					correct = false;
			}
		}
		return correct;
	}
}