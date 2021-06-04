package classes;

import java.util.ArrayList;
import java.util.Scanner;

public class PreGameDay extends Day
{
	private Tribute player;

	public PreGameDay(ArrayList<Tribute> tributeList)
	{
		super(tributeList);
		player = tributeList.get(11);
	}
	
	public void choices()
	{
		int choice;
		do
		{
			Scanner in = new Scanner(System.in);
			System.out.println("Fighting: " + player.getFighting() + "/10");
			System.out.println("Surviving: " + player.getSurviving() + "/10");
			System.out.println("[1] Improve Fighting Ability");
			System.out.println("[2] Improve Survival Ability");
			while(!in.hasNextInt())
			{
				System.out.println("Please enter a valid choice (either 1 or 2)");
				in.next();
			}
			choice = in.nextInt();
			if(choice==1)
			{
				player.addFight(2);
				break;
			}
			else if(choice==2)
			{
				player.addSurvive(3);
				break;
			}
			else
			{
				System.out.println("Please enter a valid choice (either 1 or 2).");
			}
		}
		while(choice==(int)choice);
	}
}