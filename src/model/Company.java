package model;
import java.util.ArrayList;
import model.*;

public class Company {
	
	//attributes
	
	private String name;
	
	//constants
	
	public static final int MAXCLIENTS = 5;
	public static final String MORGAN = "Morgan";
	
	//relation
	
	public Client [] clients;
	
	//methods
	
	public Company(){
		this.name = MORGAN;
		clients = new Client[MAXCLIENTS];
	}
	
	public String addClient(String name, int kgSent, double valuePaid, String clientType, int register, int expDay, int expMonth, int expYear) {	
		String message = "";
		boolean addClient=false;
		Client objSearch=searchClient(register);
		if (objSearch!=null)
			message="The client already exists";
		else
		{
			for (int i=0;i<clients.length && !addClient;i++){
				if (clients[i]== null){
					clients[i] = new Client(name, kgSent, valuePaid, clientType, register, expDay, expMonth, expYear);
					addClient=true;
					message="The new client was successfully registered";
				}
			}
			if (addClient==false)
				message="The client arrangement has reached its maximum capacity";
		}
		return message;
	}
	public Client searchClient(int register){
		Client objSearch=null;
		boolean findClient=false;
		for (int i=0;i<clients.length&&!findClient;i++){
			if (clients[i]!= null){
				if(clients[i].getRegister()==register) {
					objSearch=clients[i];
					findClient=true;
				}
			}
		}
		return objSearch;
	}
	public void totalKgAccumulate(int x, String name) {
		for (int i = 0; i < clients.length; i++) {
			if(clients[i].getName().equalsIgnoreCase(name)) {
				int a = clients[i].getKgSent();
				a+=x;
				clients[i].setKgSent(a);
			}
		}
	}
	public void totalValuePaidAccumulate(double x, String name) {
		for (int i = 0; i < clients.length; i++) {
			if(clients[i].getName().equalsIgnoreCase(name)) {
				double a = clients[i].getValuePaid();
				a+=x;
				clients[i].setValuePaid(a);
			}
		}
	}
	public boolean calculateClientType(double kgSent, double valuePaid, int position) {
        boolean updated = false;
        if(kgSent>=35000 && clients[position].getClientType() == "NORMAL") {
             clients[position].setClientType("SILVER");
            updated = true;
        }
        else if(kgSent>=55000||valuePaid>=2000000 && clients[position].getClientType() == "SILVER") {
            clients[position].setClientType("GOLD");
            updated = true;
        }

        else if(valuePaid>=5000000 && clients[position].getClientType() == "GOLD") {
            clients[position].setClientType("PLATINUM");
        updated = true;
        }
        return updated;
	}
	public String notifyNewClientType(boolean updated, int position) {
		String message = "";
		int a = position;
		a+=1;
		 if(updated == true) {
	            message = "The client #"+ a + " called " +clients[position].getName()+" has the new category: "+clients[position].getClientType()+" \n";
	        } 
	        else if
	        (updated == false) {
	            message = "The client #"+ a + " called " +clients[position].getName()+" cannot upgrade his category, remains on: "+clients[position].getClientType()+" \n";
	        }
		 return message;
	}
}