package model;

public class Client{
	
	//Attributes
	
	private String name;
	private int weightTransported;
	private int valuePaid;
	private double type;
	private String commercialRegister;
	private String expeditionDate;
	
	//Constants
	
	public static final double NORMAL = 0;
	public static final double SILVER = 0.015;
	public static final double GOLD = 0.03;
	public static final double PLATINUM = 0.05;
	
	//Methods
	
	public Client(String pName, int pWeightTransported, int pValuePaid, double pType, String pCommercialRegister, String pExpeditionDate){
		name = pName;
		weightTransported = pWeightTransported;
		valuePaid = pValuePaid;
		type = pType;
		commercialRegister = pCommercialRegister;
		expeditionDate = pExpeditionDate;
	}
	
	public String getName (){
		return name;
	}
	
	public void setName(String pName){
		this.name = pName;
	}
	
	public int getWeightTransported(){
		return weightTransported;
	}
	
	public void setWeightTransported(int pWeightTransported){
		this.weightTransported = pWeightTransported;
	}
	
	public int getValuePaid(){
		return valuePaid;
	}
	
	public void setValuePaid(int pValuePaid){
		this.valuePaid = pValuePaid;
	}
	
	public double getType(){
		return type;
	}
	
	public void setType(double pType){
		this.type = pType;
	}
	
	public String getCommercialRegister(){
		return commercialRegister;
	}
	
	public void setCommercialRegister(String pCommercialRegister){
		this.commercialRegister = pCommercialRegister;
	}
	
	public String getExpeditionDate(){
		return expeditionDate;
	}
	
	public void setExpeditionDate(String pExpeditionDate){
		this.expeditionDate = pExpeditionDate;
	}
}