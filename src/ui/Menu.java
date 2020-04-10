package ui;
import java.util.Scanner;
import model.*;
public class Menu {

//	Constants
	private final static int SHOW_CLIENTS = 1;
	private final static int LOAD_SHIP = 2;
	private final static int UNLOAD_SHIP = 3;
	private final static int SAIL = 4;
	private final static int EXIT = 5;
// Objects initialized
	private Ship ship = new Ship();
	private Company company= new Company(); 
	private Client client = new Client(null, 0, 0, null, 0, 0, 0, 0);
// Methods
	/**
	 *This method initialize the menu.
	 *<b> <br>
	 *<b>post:</b> The Menu is ready.<br>
	 */
	public Menu() {
		this.company = readInitialData();
	}
	/**
	 *This method initialize the company.
	 *
	 *<b>pre:</b> The ship is already created.<br>
	 *<b>post:</b> Returns ship.<br>
	 */
	public Company readInitialData() {
		String name = company.MORGAN;
		System.out.println("Hello captain " + name +"!");
		return company;
	}
	/**
	 * This method create the clients
	 * 
	 * <b>pre:</b>
	 * <b>post:</b> show a message that says what happened with the action.<br>
	 * 
	 */
	public void createClients() {
		Scanner lector = new Scanner(System.in);
		System.out.println("Enter the client name");
		String name = lector.nextLine();
		int kgSent = 0;
		double valuePaid =0;
		String clientType = "NORMAL";
		System.out.println("Enter the register number of the client");
		int register = lector.nextInt();
		System.out.println("What date is? Enter it, please");
		System.out.print("Day: ");
		int expDay = lector.nextInt();
		System.out.print("Month: ");
		int expMonth = lector.nextInt();
		System.out.print("Year: ");
		int expYear = lector.nextInt();
		String message = company.addClient(name, kgSent, valuePaid, clientType, register, expDay, expMonth, expYear);
		System.out.println(message);
	}
	/**
	 *This method show the five clients.
	 *<b>pre:</b> Clients are already created.<br>
	 *<b>pre:</b> Kilograms transported will be visible after ship sail (option "sail") that means after complete the travel .<br>
	 *
	 *<b>post:</b> Show the five clients updated.<br>
	 */	
	public void showClients() {
		for (int i = 0; i < company.clients.length; i++) {
			System.out.println("CLIENT #"+ (i+1) +"\n"+"Name: "+company.clients[i].getName()+"\n"+""+"Kilograms transported: " + company.clients[i].getKgSent() + "\n"+""+"Historical value paid: "+company.clients[i].getValuePaid()+ "\n"+""+"Client type: "+company.clients[i].getClientType()+"\n"+""+"Register number: "+company.clients[i].getRegister()+"\n"+"Day: "+company.clients[i].getDay()+"\n"+"Month: "+company.clients[i].getMonth()+"\n"+"Year: "+company.clients[i].getYear()+"\n");
		}																																																	
	}
	/**
	 * This method save the historical value paid by the client (realize the set in the attribute)
	 * 
	 * <b>pre:</b> The clients were already creates
	 * <b>post:</b> Save the historical value paid
	 */
	public void acV() {
		double x = 0.0;
		for (int i = 0; i < company.clients.length; i++) {
			for (int j = 0; j < ship.capacity.size(); j++) {
				x = client.calculateTotalValuePaid(client.calculateParcialValue(ship.accumulateKgSentByClient(company.clients[i].getName()), ship.capacity.get(occupatePosition()).getLoadType()), company.clients[i].getClientType(), ship.capacity.get(j).getLoadType());
			}
			company.totalValuePaidAccumulate(x, company.clients[i].getName());
		}
	}
	/**
	 *This method reads the entry data by the client and decide if the load can create or no.
	 *<b>pre:</b> Clients are already created. <br> 
	 *<b>pre:</b> The ArrayList are already initialized. <br> 
	 *
	 *<b>post:</b> Load is created or not, depend of the data entry of user. <br>
	 */
	public void addLoad() {
		Scanner lector = new Scanner(System.in);	
		System.out.println("Enter the boxes quantity");
		int boxes = lector.nextInt();
		System.out.println("Enter the weight of all the boxes (in grams please)");
		int x = lector.nextInt();
		int boxesWeight = x/1000;
		lector.nextLine();
		System.out.println("Please select load type");
		System.out.println("1. Dangerous \n2. Perishable \n3. Not perishable");
		int type = lector.nextInt();
		lector.nextLine();
		String loadType;
		switch (type) {
		case 1:
			loadType = "DANGEROUS";
			System.out.println("Entry the owner");
			System.out.println("clients are: \n"+"1 "+company.clients[0].getName()+"\n"+"2 "+company.clients[1].getName()+"\n"+"3 "+company.clients[2].getName()+"\n"+"4 "+company.clients[3].getName()+"\n"+"5 "+company.clients[4].getName()+"\n");
			int g = lector.nextInt();
			lector.nextLine(); 
			String owner = switchMenuClients(g);
			if(boxesWeight > ship.MAXWEIGHT)
				System.out.println("Load cant be added due maximum load excess");
			else if((ship.calculateTotalWeight()+boxesWeight) > ship.MAXWEIGHT) {
				System.out.println("Load cant be added due maximum load excess");
			}
			else if(ship.addLoad()== false) {
				System.out.println("Load cant be added");
			} else {
				Load load = new Load(boxes, boxesWeight, loadType, owner); 
				ship.capacity.add(load);
				System.out.println("Load added!");
			}
			break;
		case 2:
			loadType = "PERISHABLE";
			System.out.println("Entry the owner");
			System.out.println("clients are: \n"+"1 "+company.clients[0].getName()+"\n"+"2 "+company.clients[1].getName()+"\n"+"3 "+company.clients[2].getName()+"\n"+"4 "+company.clients[3].getName()+"\n"+"5 "+company.clients[4].getName()+"\n");
			int f = lector.nextInt();
			lector.nextLine(); 
			String owner2 = switchMenuClients(f);
			if(boxesWeight > ship.MAXWEIGHT)
				System.out.println("Load cant be added due maximum load excess");
			else if((ship.calculateTotalWeight()+boxesWeight) > ship.MAXWEIGHT) {
				System.out.println("Load cant be added due maximum load excess");
			}
			else if(ship.addLoad()== false) {
				System.out.println("Load cant be added");
			} else {
				Load load = new Load(boxes, boxesWeight, loadType, owner2); 
				ship.capacity.add(load);
				System.out.println("Load added!");
			}
			break;
		case 3:
			loadType = "NOTPERISHABLE";
			System.out.println("Entry the owner");
			System.out.println("clients are: \n"+"1 "+company.clients[0].getName()+"\n"+"2 "+company.clients[1].getName()+"\n"+"3 "+company.clients[2].getName()+"\n"+"4 "+company.clients[3].getName()+"\n"+"5 "+company.clients[4].getName()+"\n");
			int v = lector.nextInt();
			lector.nextLine();
			String owner3 = switchMenuClients(v);
			if(boxesWeight > ship.MAXWEIGHT)
				System.out.println("Load cant be added due maximum load excess");
			else if((ship.calculateTotalWeight()+boxesWeight) > ship.MAXWEIGHT) {
				System.out.println("Load cant be added due maximum load excess");
			}
			else if(ship.addLoad()== false) {
				System.out.println("Load cant be added");
			} else {
				Load load = new Load(boxes, boxesWeight, loadType, owner3); 
				ship.capacity.add(load);
				System.out.println("Load added!");
			}
			break;
		default:
			System.out.println("Please select a correct option");
			break;
		} 	
	}
	/**
	 *This is an auxiliary method for the method "readLoad".
	 *<b>pre:</b> Clients are already created. <br>
	 *<b>pre:</b> Select an option between 1 to 5. <br>
	 *
	 *@param x is the option of client  
	 *
	 *<b>post:</b> returns owner is the String of client name. <br>
	 */
	public String switchMenuClients(int x) {
		String owner = "";
		switch (x) {
		case 1:
			owner = company.clients[0].getName();
			break;
		case 2:
			owner = company.clients[1].getName();
			break;
		case 3:
			owner = company.clients[2].getName();
			break;
		case 4:
			owner = company.clients[3].getName();
			break;
		case 5:
			owner = company.clients[4].getName();
			break;
		default: 
			System.out.println("Select a correct option");
			break;
		}
		return owner;
	}
	/**
	 * This method receives the boolean result of the method shipSail in the class ship to decide if the ship can sail or not and actualize all the information of the clients
	 * 
	 * <b>pre:</b> Clients are already created. <br>
	 * <b>pre:</b> the array clients in the class company are already created. <br>
	 * <b>pre:</b> the ArrayList loads are already created. <br>
	 * 
	 * <b>post:</b> SHow a message that says if the ship can sail or not
	 */
	public void shipSail() {
		if(ship.shipSail()==true) {
			System.out.println("Good travel!\n");
			for (int i = 0; i < company.clients.length; i++) {
				int x = ship.accumulateKgSentByClient((company.clients[i].getName()));
				company.totalKgAccumulate(x, company.clients[i].getName());
			}
			for (int i = 0; i < company.clients.length; i++) {
				boolean x = company.calculateClientType(company.clients[i].getKgSent(), company.clients[i].getValuePaid(), i);
				String message = company.notifyNewClientType(x, i);
				System.out.println(message);

			}
			acV();
			ship.unloadShipAutomatly();
		}
		else
			System.out.println("You can't sail, sorry\n");
	}
	/**
	 *This method analize the position of the array list of loads.
	 *<b>pre:</b>A load was created as minimum. <br>
	 *
	 *<b>post:</b>Returns the position of the loads array. <br>
	 */
	public int occupatePosition() {
		int a = -1;
		for (int i = 0; i < ship.capacity.size(); i++) {
			if(ship.capacity.get(i)!=null)
				a+=1;
		}
		return a;
	}
	/**
	 *This method is a switch that allows entering the options of the Main menu by an user selection.
	 *<b>pre:</b>Clients are already created.<br>
	 *
	 *<b>post:</b>Redirect to the entered option. <br>
	 *@param choice is the option by the user
	 */
	public void operation(int choice) {
		switch (choice) {

		case SHOW_CLIENTS:
			showClients();
			break;

		case LOAD_SHIP:
			addLoad();
			break;

		case UNLOAD_SHIP:
			String message = ship.unloadShip();
			System.out.println(message);
			break;

		case SAIL:
			shipSail();
			break;
			
		case EXIT:
			break;
		default: System.out.println("Select a valid choice");
		break;
		}
	}
	public void initializeMenu() {
		System.out.println("Add your five clients please");
		do {		
			createClients();
		}
		while(company.clients[4]==null);
	}
	/**
	 *This method shows the Main menu.
	 *<b>pre:</b> <br>
	 *
	 *<b>post:</b> shows the options. <br>
	 */
	public void showMenu() {
		System.out.println("What do you want to do?\n 1. Show clients\n 2. Load ship\n 3. Unload ship\n 4. Sail\n 5. Exit\n");
	}
	/**
	 *This method read the option entry by the client for the Main menu.
	 *<b>pre:</b>Select an option between 1 to 5. <br>
	 *
	 *<b>post:</b><br>
	 */
	public int readOption() {	
		Scanner lector = new Scanner(System.in);
		int choice = lector.nextInt();
		lector.nextLine();
		return choice;
	}	
	/**
	 *This method starts the program and keeps showing the Main menu until user select option "EXIT".
	 *<b>pre:</b>.<br>
	 *
	 *<b>post:</b>the program starts and the clients are initialized and show menu . <br>
	 */
	public void startProgram() {
		int choice;
		initializeMenu();
		do {
			showMenu();
			choice = readOption();
			operation(choice);
		}
		while(choice!=EXIT);
	}
}
