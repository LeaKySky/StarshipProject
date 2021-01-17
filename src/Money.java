
public class Money {
	public static int credits = 70; 
	private int reward = 0; //Reward is randomized
	private static int min_reward = 20; //This is min. to ensure player doesn't go bankrupt
	private int lightCost = 50;
	private int mediumCost = 70;
	private int heavyCost = 120; 
	
	public String retMoney(int i)
	{
		System.out.println("You currently have " + credits + " credits");
		return " ";
	}

	public int getLightCost() 
	{
		return lightCost;
	}

	public int getMediumCost()
	{
		return mediumCost;
	}
	
	public int getHeavyCost()
	{
		return heavyCost;
	}
	
	public static int getMin()
	{
		return min_reward; 
	}
	
	public static int getMoney()
	{
		return credits; 
	}
}
