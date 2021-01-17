import java.util.Scanner;

public class Storage 
{
		Troop [ ] storage = new Troop[5];

		public Storage()
		{
				//nothing to put here 
		}
		
		//Adds the troop to the array 
		public void addTroop(Troop T)
		{
			for (int i = 0; i < storage.length; i++) 
			{
				if (storage[i] == null) 
				{
					storage[i]= T;  
					break; 
				}
			}
		}
		
		public String printStorage()
		{
			for (int i = 0; i < storage.length; i++)
			{
				if (storage[i] != null) 
				{
					System.out.print(storage[i].getName() + "(" + storage[i].getType() + "), ");
				}
				else 
				{
					System.out.print("Empty slot" + ", ");
				}
			}
			return " ";
			
		}
		
		public int getStorageLength() //used to access storage length
		{
			return storage.length; 
		}
		
		public Troop[] getStorageArray() //Used to access full array
		{
			return storage; 
		}
		
		public Troop getParticularTroop(int t) //Used to access a certain troop
		{
			return storage[t];
		}
}
