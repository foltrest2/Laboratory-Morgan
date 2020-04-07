package model;

public class Company {
	
	//attributes
	
	private String name;
	
	//constants
	
	public static final int MAXCLIENTS = 5;
	
	//relation
	
	private String[] client;
	
	//methods
	
	public Company(String pName){
		name = pName;
	}
	
	
}