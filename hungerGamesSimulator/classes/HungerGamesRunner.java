package classes;

import java.util.ArrayList;

public class HungerGamesRunner 
{
	private ArrayList<Tribute> tributeList;

	public HungerGamesRunner()
	{
		tributeList = new ArrayList<Tribute>();
		for (int i = 0; i < 11; i++)
		{
			if (i == 0 || i == 1 || i == 3)
		{
			Tribute created = new Tribute((int)Math.random() * 3 + 8, (int)Math.random() * 3 + 8, 10, i + 1);
			tributeList.add(created);
		}
		else
		{
			Tribute created = new Tribute((int)Math.random() * 11, (int)Math.random() * 11, 10, i + 1);
			tributeList.add(created);
		}
		}
		tributeList.add(new Tribute(3, 3, 10, 12));
		
		for (int i = 0; i < 3; i++)
		{
			PreGameDay day = new PreGameDay(tributeList);
		}
	}
	
	public static void main(String[] args)
	{
		
	}
}
