package classes;
/**
 * A player in the Hunger Games.
 */
public class Tribute
{
	private int fighting; //fighting power
	private int surviving; //survival skill
	private int food; //food supply
	private int district; //district (1-12) of tribute
	private boolean dead; //dead or alive status (true = dead)

	/**
	 * Constructs a Tribute object.
	 * @param fight the fighting power
	 * @param survive the survival skill
	 * @param f the food supply
	 * @param d the district
	 */
	public Tribute(int fight, int survive, int f, int d)
	{
		fighting = fight;
		surviving = survive;
		food = f;
		district = d;
		dead = false;
	}
	/**
	 * Returns fighting power value.
	 * @return fighting
	 */
	public int getFighting()
	{
		return fighting;
	}
	/**
	 * Returns survival skill value.
	 * @return surviving
	 */
	public int getSurviving()
	{
		return surviving;
	}
	/**
	 * Returns food supply value.
	 * @return food
	 */
	public int getFood()
	{
		return food;
	}
	/**
	 * Returns district of tribute.
	 * @return district
	 */
	public int getDistrict()
	{
		return district;
	}
	/**
	 * Returns status (dead or alive) of tribute. Returns true if dead, false if alive.
	 * @return dead
	 */
	public boolean getStatus()
	{
		return dead;
	}
	/**
	 * Adds num to value of fighting if less than or equal to 10 and keeps at 10 otherwise.
	 * @param num
	 */
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
	/**
	 * Adds num to value of surviving if less than or equal to 10 and keeps at 10 otherwise.
	 * @param num
	 */
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
	/**
	 * Adds num to value of food if less than or equal to 10 and keeps at 10 otherwise.
	 * If food reaches zero, calls updateStatus() method with parameter of true.
	 * @param num
	 */
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
	/**
	 * Updates tribute's dead or alive status (this.dead) with dead parameter.
	 * @param dead
	 */
	public void updateStatus(boolean dead)
	{
		this.dead = dead;
	}
}
