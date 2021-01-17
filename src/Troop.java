//Defines troops 
public class Troop 
{
	private int hp = 0; 
	private int att = 0; 
	private String name = "";
	private String troopType = "";  //light, medium, heavy 
	//All troops have 100 health max 
	//Upgraded "Super" troops have a max health of 200 and attack of min 200
	
	//Constructor 
	public Troop() //make a overloaded constructor 
	{
		troopType = "light"; 
		name = "Default";
		hp = 50;
		att = 20;
	}
	
	public Troop(String _name, String _type, int _hp)
	{
		troopType = _type;
		name = _name; 
		hp = _hp;
	}
	
	public void Default() 
	{
		System.out.println(name + " is a troop of type" + troopType + " , it has hp of " + hp + " and " + att + " attack power");
	}
	
	//Setters
	
	public void setName(String _name)
	{
		name = _name; 
	}
	
	public void setHp(int _hp)
	{
		hp = _hp;
	}
	
	public void setAtt(int _att)
	{
		att = _att;
	}
	
	public void setType(String T)
	{
		troopType = T; 
	}
	
	//Getters 
	
	public String getName()
	{
		return name;
	}
	
	public int getAtt()
	{
		return att;
	}
	
	public int getHp()
	{
		return hp;
	}
	public String getType()
	{
		return troopType;
	}
}
