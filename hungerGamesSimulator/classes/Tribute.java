package classes;

public class Tribute
{
	private int fighting;
	private int surviving;
	private int food;
	private int district;
	private boolean dead; 

	public Tribute(int fight, int survive, int f, int d)
	{
		fighting = fight;
		surviving = survive;
		food = f;
		district = d;
		dead = false;
	}
	
	public int getFighting()
	{
		return fighting;
	}
	
	public int getSurviving()
	{
		return surviving;
	}
	
	public int getFood()
	{
		return food;
	}
	
	public int getDistrict()
	{
		return district;
	}
	
	public boolean getStatus()
	{
		return dead;
	}
	
	public void addFight(int num)
	{
		if(fighting+num<=10)
		{
			fighting += num;
		} 
		else
		{
			fighting = 10;
		}
	}
	
	public void addSurvive(int num)
	{
		if(surviving+num<=10)
		{
			surviving += num;
		}
		else
		{
			surviving = 10;
		}
	}
	
	public void changeFood(int num)
	{
		if(food+num<=10)
		{
			food += num;
		}
		else
		{
			food = 10;
		}
		
		if (food == 0)
		{
			updateStatus(true);
		}
	}
	
	public void updateStatus(boolean dead)
	{
		this.dead = dead;
	}
}
