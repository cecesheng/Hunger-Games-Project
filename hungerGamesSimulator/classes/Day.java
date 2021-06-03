package classes;

import java.util.ArrayList;
import java.util.Scanner;

public class Day 
{
	private Tribute player;
	private ArrayList<Tribute> tributeList;
	
	public Day(ArrayList<Tribute> list)
	{
		tributeList = list;
		player = tributeList.get(tributeList.size()-1);
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
			food();
		}
		else if(choice==3)
		{
			fight();
		}
		else
		{
			System.out.println("Please enter a valid choice.");
		}
	}
	
	/**
	 * Updates alive based on whether the player is still alive or not and whether they found food or not
	 */
	public void food()
	{
		double val = Math.random();
		if(val < 0.2)
		{
			fight();
		}
		
		if (player.getStatus() == false)
		{
			if (player.getSurviving() > 8)
			{
				System.out.println("You find a lot of food.");
				player.changeFood(3);
			}
			else if (player.getSurviving() > 5)
			{
				System.out.println("You find some food.");
				player.changeFood(2);
			}
			else if (player.getSurviving() > 2)
			{
				System.out.println("You find a little bit of food.");
				player.changeFood(1);
			}
			else
			{
				val = Math.random();
				if (val < 0.5)
				{
					System.out.println("You eat poison berries and die.");
					player.updateStatus(true);
				}
				else
				{
					System.out.println("You don't find any food.");
				}
			}
		}
		
		System.out.println("Food Level: " + player.getFood() + "/10");
	}
	
	/**
	 * Updates alive based on whether the player wins or loses the fight
	 * 
	 */
	public void fight()
	{
		int randNum = (int)Math.random()*tributeList.size();
		Tribute randTribute = tributeList.get(randNum);
		System.out.println("You get into a fight with the tribute from District " + randTribute.getDistrict() + ".");
		if(player.getFighting()>randTribute.getFighting())
		{
			System.out.println("You kill the tribute from District " + randTribute.getDistrict() + ".");
			player.updateStatus(false); 
			randTribute.updateStatus(true);
			player.updateStatus(false); 
		}
		else if(player.getFighting()<randTribute.getFighting())
		{
			System.out.println("The tribute from District " + randTribute.getDistrict() + " kills you.");
			player.updateStatus(true);
		}
		else
		{
			double val = Math.random();
			if(val>0.5)
			{
				System.out.println("You kill the tribute from District " + randTribute.getDistrict() + ".");
				player.updateStatus(false);
				randTribute.updateStatus(true);
				player.updateStatus(false);
			}
			else
			{
				System.out.println("The tribute from District " + randTribute.getDistrict() + " kills you.");
				player.updateStatus(true);
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
		else
		{
			System.out.println("You successfully hide.");
		}
	}
}