package model;
import java.util.ArrayList;
public class Ship {
	
	//Constants
	
	public static final int MAXWEIGHT = 28000;
	public static final int MINWEIGHT = 12000;
	public static final int MINLOAD = 2;
	
	//Relations
	
	public ArrayList<Load> capacity;
	
	//Methods
	
	public Ship (){	
	capacity = new ArrayList<Load>();	
	}
	public boolean addLoad() {
		boolean x=true;
		if(calculateTotalWeight()>MAXWEIGHT) {
			x=false;
		}
		return x;
	}
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
	public void unloadShipAutomatly() {
		capacity.clear();
	}
	public String unloadShip(){
		String message="";
		capacity.clear();
		message="The ship was succesfull unloaded";
		return message;
	}	
	public boolean shipSail() {
		boolean toSail;
		if((calculateTotalWeight()>= MINWEIGHT || capacity.size()>=MINLOAD) && verifySanityRule()==true && calculateTotalWeight()<=MAXWEIGHT)
			toSail = true;
		else	
			toSail = false;

		return toSail;
	}
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