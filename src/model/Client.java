package model;

public class Client {

	//attributes

	private String name;
	private int kgSent;
	private double valuePaid;
	private String clientType;
	private int register;
	private int expDay;
	private int expMonth;
	private int expYear;

	//Constants

	public final static double SILVER = 0.015;
	public final static double GOLD = 0.03;
	public final static double PLATINUM = 0.05;

	//Methods

	public Client(String name, int kgSent, double valuePaid, String clientType, int register, int expDay, int expMonth, int expYear){
		this.name = name;
		this.kgSent = kgSent;
		this.valuePaid = valuePaid;
		this.clientType = clientType;
		this.register = register;
		this.expDay = expDay;
		this.expMonth = expMonth;
		this.expYear = expYear;
	}
	public double calculateParcialValue(double x, String loadType){

		if(loadType.equalsIgnoreCase("DANGEROUS")) 
			x*=390000;
		else if(loadType.equalsIgnoreCase("PERISHABLE"))
			x*=250000;
		else if(loadType.equalsIgnoreCase("NOTPERISHABLE"))
			x*=80000;

		return x;
	}
	public double calculateTotalValuePaid(double x, String clientType, String loadType) {
		if(clientType.equalsIgnoreCase("SILVER") && loadType.equalsIgnoreCase("PERISHABLE")) {
			double value=x*SILVER;
			x-=value;
		}
		else if(clientType.equalsIgnoreCase("GOLD") && (loadType.equalsIgnoreCase("PERSISHABLE") || loadType.equalsIgnoreCase("NOTPERISHABLE"))) {
			double value=x*GOLD;
			x-=value;
		}
		else if(clientType.equalsIgnoreCase("PLATINUM")) {
			double value=x*PLATINUM;
			x-=value;
		}
		else {
			return x;
		}
		return x;
	}
	public void setName(String name){
		this.name = name;
	}
	public String getName(){
		return name;
	}
	public void setKgSent(int kgSent){
		this.kgSent = kgSent;
	}
	public int getKgSent(){
		return kgSent;
	}
	public String getClientType(){
		return clientType;
	}
	public void setClientType(String clientType) {
		this.clientType = clientType;
	}
	public void setRegister(int register){
		this.register = register;
	}
	public int getRegister(){
		return register;
	}
	public void setDay(int expDay){
		this.expDay = expDay;
	}
	public int getDay(){
		return expDay;
	}
	public void setMonth(int expMonth){
		this.expMonth = expMonth;
	}
	public int getMonth(){
		return expMonth;
	}
	public void setYear(int expYear){
		this.expYear = expYear;
	}
	public int getYear(){
		return expYear;
	}
	public void setValuePaid(double valuePaid){
		this.valuePaid = valuePaid;
	}
	public double getValuePaid(){
		return valuePaid;
	}
}