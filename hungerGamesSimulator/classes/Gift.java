package classes;
/**
 * A gift from a sponsor.
 */
public class Gift 
{
	private String name; //name of gift
	private int value; //value of gift in terms of survival skill, fighting power, or food supply
	
	/**
	 * Constructs a gift with name and value parameters.
	 * @param n the name of the gift
	 * @param v the value of the gift
	 */
	public Gift(String n, int v)
	{
		name = n;
		value = v;
	}
	/**
	 * Returns name of gift.
	 * @return name the name of the gift
	 */
	public String getName()
	{
		return name;
	}
	/**
	 * Returns value of gift.
	 * @return value the value of the gift
	 */
	public int getValue()
	{
		return value;
	}
}
