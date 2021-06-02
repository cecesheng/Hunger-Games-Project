package classes;

import java.util.ArrayList;
import java.util.Scanner;

public class Day 
{
	private Tribute player;
	private ArrayList<Tribute> tributeList;
	private boolean alive;
	
	public Day(ArrayList<Tribute> list)
	{
		tributeList = list;
		player = tributeList.get(tributeList.size()-1);
		alive = true;
	}
	
	public void choices()
	{
		Scanner in = new Scanner(System.in);
		System.out.println("Food Level: " + player.getFood() + "/10");
		System.out.println("What will you do today?");
		System.out.println("[1] Hide");
		System.out.println("[2] Search for Food");
		System.out.println("[3] Look for a Fight");
		int choice = in.nextInt();
		if(choice==1)
		{
			hide();
		}
		else if(choice==2)
		{
			//haven't written the search for food method yet
		}
		else if(choice==3)
		{
			fight();
		}
		else
		{
			System.out.println("Enter a valid choice.");
		}
	}
	
	/**
	 * Updates alive based on whether the player wins or loses the fight
	 * 
	 */
	public void fight()
	{
		int randNum = (int)Math.random()*tributeList.size();
		Tribute randTribute = tributeList.get(randNum);
		if(player.getFighting()>randTribute.getFighting())
		{
			alive = true;
		}
		else if(player.getFighting()<randTribute.getFighting())
		{
			alive = false;
		}
		else
		{
			double val = Math.random();
			if(val>0.5)
			{
				alive = true;
			}
			else
			{
				alive = false;
			}
		}
	}
	
	/**
	 * Updates alive based on whether the player is still alive or not
	 */
	public void hide()
	{
		double val = Math.random();
		if(player.getSurviving()<=3 && val<0.25)
		{
			fight();
		}
		else if(player.getSurviving()>3 && player.getSurviving()<=6 && val<0.15)
		{
			fight();
		}
	}
}

