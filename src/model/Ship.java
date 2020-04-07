package model;

import java.util.ArrayList;
public class Ship {

	//attributes
	
	private String name;
	private double totalWeight;
	
	//Constants
	
	public static final int MAXWEIGHT = 28000;
	public static final int MINWEIGHT = 12000;
	
	//Relations
	
	ArrayList<Load> capacity;
	
	//Methods
	
	public Ship (String pName, double pTotalWeight){	
	name = pName;
	totalWeight = pTotalWeight;
	capacity = new ArrayList<Load>();	
	}
	
	public String getName(){	
	return name;	
	}
	
	public void setName(String pName){
	this.name = pName;
	}
	
	public double getTotalWeight(){
	return totalWeight;
	}
	
	public void setTotalWeight(double pTotalWeight){
	this.totalWeight = pTotalWeight;
	}
	
	
	
	/*public int calculateNumLoad(){
	
		
		int num = 0;
		for (int i = 0; i<MAXCAPACITY; i++){
			if(capacity[i]!= null){
			num++;
			}
		}
	return num;
	}
*/
}