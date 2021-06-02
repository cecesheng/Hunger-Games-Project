public class Tribute 
{
	private int fighting;
	private int survival;
	private int food;
	private int district;
	private boolean dead;
	
	public Tribute(int fight, int s, int f, int d)
	{
		fighting = fight;
		survival = s;
		food = f;
		district = d;
	}
	
	public int getFighting()
	{
		return fighting;
	}
	
	public int getSurviving()
	{
		return survival;
	}
	
	public int getFood()
	{
		return food;
	}
	
	public int getDistrict()
	{
		return district;
	}
	
	public void addFight(int num)
	{
		fighting += num;
	}
	
	public void addSurvive(int num)
	{
		survival += num;
	}
	
	public void addFood(int num)
	{
		food += num;
	}
}