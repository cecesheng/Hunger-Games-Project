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
		fighting += num;
	}
	
	public void addSurvive(int num)
	{
		surviving += num;
	}
	
	public void changeFood(int num)
	{
		food += num;
	}
	
	public void updateStatus(boolean dead)
	{
		this.dead = dead;
	}
}


