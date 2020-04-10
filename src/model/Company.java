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
	/**
	 *This method is the constructor of company.
	 *
	 *<b>pre:</b> <br>
	 *
	 *@param name is the name of the company called "Morgan" 
	 *
	 *<b>post:</b> Returns an object of company type. <br>
	 *<b>post:</b> Create the array of clients. <br>
	 */
	public Company(){
		this.name = MORGAN;
		clients = new Client[MAXCLIENTS];
	}
	/**
	 * This method add a new client depending of the result of the method searchClient
	 * 
	 * @param name is the name of the client to create
	 * @param kgSent is the kgSent of the client to create
	 * @param valuePaid is the value paid of the client to create
	 * @param clientType is the type of the client to create
	 * @param register is the mercantile register number of the client to create
	 * @param expDay is the day of expedition of the register of the client to create
	 * @param expMonth is the month of expedition of the register of the client to create
	 * @param expYear is the year of expedition of the register of the client to create
	 * @return returns a message that says what happened with the client 
	 */
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
	/**
	 *This is method search the client by his name.
	 *
	 *<b>pre:</b>A client was created as minimum. <br>
	 *<b>pre:</b>The client has successfully submitted a load at least. <br>
	 *
	 *@param name the name of client to search  
	 *
	 *<b>post:</b> Returns objSearch as an object of Client type. <br>
	 */
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
	/**
	 *This is method adds a new load weight to the historical kilograms transported by client.
	 *
	 *<b>pre:</b>A client was created as minimum. <br>
	 *<b>pre:</b>The client has successfully submitted a load at least. <br>
	 *
	 *@param name the name of client to search  
	 *@param x is the weight of the load of a client
	 */
	public void totalKgAccumulate(int x, String name) {
		for (int i = 0; i < clients.length; i++) {
			if(clients[i].getName().equalsIgnoreCase(name)) {
				double a = clients[i].getKgSent();
				a+=x;
				clients[i].setKgSent(a);
			}
		}
	}
	/**
	 * This method save the historical value paid by the client
	 * 
	 * @param x is the total value paid at the moment of add loads to the ship
	 * @param name is the name of the client
	 */
	public void totalValuePaidAccumulate(double x, String name) {
		for (int i = 0; i < clients.length; i++) {
			if(clients[i].getName().equalsIgnoreCase(name)) {
				double a = clients[i].getValuePaid();
				a+=x;
				clients[i].setValuePaid(a);
			}
		}
	}
	/**
	 *This is method calculate the type of client.
	 *
	 *<b>pre:</b>A load of client was created as minimum. <br>
	 *<b>pre:</b>The client has successfully submitted a load at least. <br>
	 *
	 *@param kgSent is the attribute of client about the historical kilograms sent  
	 *@param totalValue is value with discount to pay
	 *@param select is the position of the array of clients
	 *
	 *<b>post:</b> Returns updated as boolean that means if the client was upgraded to a new category or not. <br>
	 *<b>post:</b> Sets the new category of client or not. <br>
	 */
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
	/**
	 *This is method shows if the client was upgraded or not.
	 *
	 *<b>pre:</b>A load of client was created as minimum. <br>
	 *<b>pre:</b>The client has successfully submitted a load at least. <br>
	 *
	 *@param updated is a boolean that means if the client was upgraded to a new category or not  
	 *@param select is the position of the array of clients
	 *
	 *<b>post:</b> Returns message if the client was upgraded to a new category or not. <br>
	 */
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