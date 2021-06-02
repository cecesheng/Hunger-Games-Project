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
		Scanner in = new Scanner(System.in);
		System.out.println("Fighting: " + player.getFighting());
		System.out.println("Surviving: " + player.getSurviving());
		System.out.println("[1] Improve Fighting Ability   [2] Improve Survival Skills");
		int choice = in.nextInt();
		if(choice==1)
		{
			player.addFight(3);
		}
		else if(choice==2)
		{
			player.addSurvive(3);
		}
	}
}