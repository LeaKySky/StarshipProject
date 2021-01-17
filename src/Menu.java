import java.util.InputMismatchException;
import java.util.Scanner;
import java.math.*;

public class Menu 
{
	//Setting up menu options
	private int attack = 1;
	private int build = 2; 
	private int repair = 3; 
	private int upgrade = 4;
	private int sell = 5;
	private int quit = 6;
	
	//General money and storage getters for consistency =
	static Money money = new Money(); 
	static Storage storage = new Storage();
	
	public static void showMenu() //Displays main menu options
	{
		System.out.println("Welcome to the starship, what would you like to do?");
		System.out.println("1.) Send troops to fight");
		System.out.println("2.) Build some troops");
		System.out.println("3.) Repair some troops");
		System.out.println("4.) Upgrade some troops");
		System.out.println("5.) Sell some troops");
		System.out.println("6.) Quit");
		System.out.println("Choose by typing the number and the return key");
	}
	
	private static int readInput() //Takes input in main menu
	{
		Scanner scanner = new Scanner(System.in);
		int choice = scanner.nextInt();
		return choice;
	}
	
	public static void choices() //Used to call methods based on user input
	{
		showMenu();
		System.out.println("What would you like to do now? || Type 6 to quit");
		//int z = readInput(); 
		int z = 1;
		do 
		{
			z = readInput(); 
			switch (z) 
			{
			case 1: 
			{
				int x = 0;
				for (int i = 0; i < storage.getStorageLength(); i++) 
				{
					if (storage.getParticularTroop(i) == null) 
					{
						x++; 
					}
				}
				if (x == 5) 
				{
					System.out.println("Please make sure your storage array is not empty, do so by pressing 2 to build some troops");
				}
				else 
				{
					attack();
				}
				showMenu();
				break;
			}
			case 2:
			{
				if (money.getMoney() < 20) 
				{
					System.out.println("Please ensure you have more than 20 credits");
				}
				else {
					build();
				}
				showMenu();
				break;
			}
			
			case 3:
			{
				int x = 0;
				for (int i = 0; i < storage.getStorageLength(); i++) 
				{
					if (storage.getParticularTroop(i) == null) 
					{
						x++; 
					}
				}
				if (x == 5 || money.getMoney() < 5) 
				{
					System.out.println("Please make sure your storage array is not empty, do so by pressing 2 to build some troops");
					System.out.println("Or if your credits are lesser than 5, please make sure they're above 5");
				}
				else 
				{
					repair();
				}
				showMenu();
				break;
			}
			case 4:
			{
				int x = 0;
				for (int i = 0; i < storage.getStorageLength(); i++) 
				{
					if (storage.getParticularTroop(i) == null) 
					{
						x++; 
					}
				}
				if (x == 5) 
				{
					System.out.println("Please make sure your storage array is not empty, do so by pressing 2 to build some troops");
				}
				if (money.getMoney() < 5) 
				{
					System.out.println("Please make sure you have at least 5 credits");
				}
				else 
				{
					upgrade();
				}
				showMenu();
				break;
			}
			case 5:
			{
				int x = 0;
				for (int i = 0; i < storage.getStorageLength(); i++) 
				{
					if (storage.getParticularTroop(i) == null) 
					{
						x++; 
					}
				}
				if (x == 5) 
				{
					System.out.println("Please make sure your storage array is not empty, do so by pressing 2 to build some troops");
				}
				else 
				{
					sell();
				}
				showMenu();
				break;
			}
			case 6:
			{
				System.out.println("Thanks for playing, have a great day");
				break;
			}
			default:
				System.out.println("Please enter a valid input");
				choices();
				//throw new IllegalArgumentException("Unexpected value: " + z);
			}
		} while (z != 6 && z > 0 && z < 6);
	}
	
	private static double random_num() //Used for coming up with random no.  
	{
		double x = 0;
		x = 10 + Math.random() * 100;
		return x;
	}
	
	private static void attack() //If user chooses attack 
	{
		System.out.println("You currently have"); 
		System.out.println(storage.printStorage());
		System.out.println("How many troops would you like to send out?"); 
		int z = 0; //Counting how many troops the user wants to send out 
		Scanner scanner = new Scanner(System.in);
		z = scanner.nextInt();  
		do 
		{
			if (z < 0) 
			{
				System.out.println("Please enter a number greater than 0");
				z = scanner.nextInt();
			}
			if (z > 5) 
			{
				System.out.println("Please enter a number less than 5");
				z = scanner.nextInt();
			}
		} while (z < 0 || z > 5);
		Troop[] missionTemp = new Troop[z];
		
		/*
		 * With how many troops the user would like to send out(z)
		 * Temp array is created for troops on that mission  
		 * Using 2 for loops, 1 for counting to the no. of troops they want to send out and asking them that many times 
		 * The second for loop is to add those troops to the temp array for that mission
		 * Then the risk is used to calculate how much damage each troop will suffer 
		 * The troop in the storage array is then replaced with the troop that suffered damage on the mission 
		 * This way the troops are "updated" based on the mission chance 
		 * Credits are updated as well
		 */
		for (int i = 0; i < z; i++) 
		{
			System.out.println("Please enter the troop no. you would like to send out, EG: 0 for the 1st troop");
			Scanner scanner2 = new Scanner(System.in);
			int y = scanner2.nextInt(); 
	//		do 
	//		{
	//			System.out.println("Please enter a number less than 5");
	//			y = scanner2.nextInt();
	//		} while (y > 5 || y < 0);
			for (int j = 0; j < missionTemp.length; j++) 
			{
				if(missionTemp[j] == null)
				{
				missionTemp[j] = storage.getParticularTroop(y); //THIS FILLS IN THE TEMP ARRAY VAL !!!
				}
			}
		}
		System.out.println("You have chosen these troops for the mission"); 
		for (int c = 0; c < missionTemp.length; c++) 
		{
			System.out.println(missionTemp[c].getName());
		}
		
		for (int i = 0; i < missionTemp.length; i++)
		{
			for (int j = 0; j < missionTemp.length; j++) 
			{
				double b = random_num();
				double c = random_num();
				if (b > 50)
				{
					int x = missionTemp[i].getHp();
					x -= 20;  
					missionTemp[i].setHp(x);
					System.out.println(missionTemp[i].getName() + " suffered damage of " + 20); 
					storage.getParticularTroop(i).setHp(missionTemp[i].getHp());
					System.out.println(storage.getParticularTroop(i).getName() + "'s new HP is " + storage.getParticularTroop(i).getHp());
					if (c < 10) 
					{
						money.credits = money.credits + money.getMin();
						money.retMoney(i); 
					}
					if(c > 10)
					{
						money.credits = money.credits + 50;
						money.retMoney(i);
					}
				}
			}
			
		}
		System.out.println("---------------------------------------------------------------------"); //Confirms the menu is over and returns to main menu
	}
	
	private static void build()
	{
		/*
		 * Lets the player build troops and adds it to the first empty slot in the storage array 
		 * Asks the player what type of troop they want to build
		 * Creates a new troop type object and sets parameters according to the user 
		 * Subtracts credits from money class
		 */
		if (money.credits < 20) 
		{
			System.out.println("Not enough credits, come back with at least 20");
		}
		else 
		{
			System.out.println("Welcome to the troop builder");
			money.retMoney(0);
			System.out.println("You can build troops of types light(" + money.getLightCost() + " credits), medium(" + money.getMediumCost() + " credits), heavy(" + money.getHeavyCost() + " credits)");
			Scanner scanner3 = new Scanner(System.in);
	//Ask for troop choice
			String troopChoice = scanner3.nextLine(); 
	//Ask for troop name 
			System.out.println("What would you like to name your troop?");
			String troopName = scanner3.nextLine();
			Troop T = new Troop(troopName, troopChoice, 100); //Create a new troop object and add details, can do here since its overloaded and the params are set with commas acc. to the func. signature
			
			//Add the troop to storage
			storage.addTroop(T);
			
			System.out.println(T.getName() + " has been added");
			System.out.println("You now have");
			System.out.println(storage.printStorage());  //Confirm the troop's been added for the player  
		}
		
		
		System.out.println("---------------------------------------------------------------------"); //Confirms the menu is over and returns to main menu
		
	}
	
	private static void repair()
	{
		System.out.println("Welcome to the repair menu");
		/*
		 * Create a for loop which takes troops with health < 100 and adds them to a temporary array 
		 * Print the names and health vals of these troops 
		 * Ask the user which ones they want to repair and print out how much it cost them 
		 */
		System.out.println("how many troops would you like to repair?");
		Scanner scanner8 = new Scanner(System.in);
		int y = scanner8.nextInt();
		Troop[] repairArrayTroops = new Troop[y]; //temp array
		
		for (int i = 0; i < repairArrayTroops.length; i++) //Add to temp array 
		{ 
			if (storage.getParticularTroop(i).getHp() < 100) 
			{
				for (int j = 0; j < repairArrayTroops.length; j++) 
				{
					if (repairArrayTroops[j] == null) 
					{
						repairArrayTroops[j] = storage.getParticularTroop(i) ;
					}
				}
			}
		}
		System.out.println("The troops you can repair are");
		for (int e = 0; e < repairArrayTroops.length; e++) 
		{
			System.out.println(repairArrayTroops[e].getName());
		}
		
		Scanner scanner5 = new Scanner(System.in);
		System.out.println("Type in the number of the troop you would like to repair starting with 0, eg: 0 for the first troop, and so on");
		int h = scanner5.nextInt();  //Get the array index of the troop that the user wishes to repair 
		for (int k = 0; k < repairArrayTroops.length; k++) 
		{
			if(k == h)
			{
				//Subtracting credits based on health needing repair and setting health to 100
				if(repairArrayTroops[k].getHp() < 100)
				{
					money.credits = money.credits - 5; 
					System.out.println("The repair for troop " + repairArrayTroops[k].getName() + " is 5 credits as it's health was under 100" );
					money.retMoney(0);
				}
					
				if(repairArrayTroops[k].getHp() < 80)
				{
					money.credits = money.credits - 10; 
					System.out.println("The repair for troop " + repairArrayTroops[k].getName() + " is 10 credits as it's health was under 80" );
					money.retMoney(0);
				}
				
				if (repairArrayTroops[k].getHp() < 50) 
				{
					money.credits = money.credits - 20;
					System.out.println("The repair for troop " + repairArrayTroops[k].getName() + " is 20 credits as it's health was under 50" );
					money.retMoney(0);
				}
				
				if(repairArrayTroops[k].getHp() < 20)
				{
					money.credits = money.credits - 30;
					System.out.println("The repair for troop " + repairArrayTroops[k].getName() + " is 30 credits as it's health was under 20" );
					money.retMoney(0);
				}
				repairArrayTroops[k].setHp(100);
				storage.getParticularTroop(h).setHp(repairArrayTroops[k].getHp());
			}
		}
		System.out.println("---------------------------------------------------------------------"); //Confirms the menu is over and returns to main menu
		
	}
	
	private static void upgrade()
	{
		System.out.println("Welcome to the upgrade menu");
		System.out.println("Any troop needs to be at 100 health to be upgraded");
		System.out.println("How many troops would you like to upgrade?");
		Scanner scanner6 = new Scanner(System.in);
		int g = scanner6.nextInt();
		Troop[] upgradeTroops = new Troop[g];
		System.out.println("You currently have ");
		System.out.println(storage.printStorage());
		
		for (int w = 0; w < g; w++) 
		{
			System.out.println("Which troop would like to upgrade?, eg type 0 for troop 1 and so on");
			int k = scanner6.nextInt(); 
			for (int i = 0; i < storage.getStorageLength(); i++) 
			{
				if (i == k) 
				{
					if (storage.getParticularTroop(i).getHp() == 100) 
					{
						System.out.println("Troop " + storage.getParticularTroop(i).getName() + " has been upgraded for 30 credits, it now has health of 200!");
						money.credits = money.credits - 30;
						storage.getParticularTroop(i).setHp(200); //Type up last 2 func's tom.
					}
					else 
					{
						System.out.println("You cannot upgrade troop" + storage.getParticularTroop(i).getName() + " as its health is < 100, please make sure its health is 100 before upgrading");
						//System.out.println("Would you like to repair the troop?"); //keep for later
					}
				}
			}
			money.retMoney(0);
		}
		System.out.println("---------------------------------------------------------------------"); //Confirms the menu is over and returns to main menu
		
	}
	
	private static void sell()
	{
		System.out.println("Welcome to the sell menu"); 
		System.out.println("You currently have ");
		storage.printStorage();  
		int x = 0;
		System.out.println("How many troops would you like to sell?");
		Scanner scanner7 = new Scanner(System.in);
		x = scanner7.nextInt();
		for (int i = 0; i < x; i++) 
		{
			System.out.println("Type in the index of the troop you would like to sell, eg: 0 for troop no 1., 1 for troop no. 2 etc...");
			int y = 0; 
			y = scanner7.nextInt();
			if (storage.getParticularTroop(y).getHp() < 50) 
			{
				System.out.println("You have successfully sold " + storage.getParticularTroop(y).getName() + " for 50 credits");
				money.credits = money.credits + 50;
			}
			if (storage.getParticularTroop(y).getHp() > 100) 
			{
				System.out.println("You have successfully sold " + storage.getParticularTroop(y).getName() + " for 80 credits");
				money.credits = money.credits + 80;
			}
		}
		money.retMoney(0);
		System.out.println("---------------------------------------------------------------------"); //Confirms the menu is over and returns to main menu
	}
	
}
