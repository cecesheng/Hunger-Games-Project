package classes;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class Feast extends Day
{	
private Tribute player;
private ArrayList<Tribute> tributeList;

	public Feast(ArrayList<Tribute> tributeList)
	{
		super(tributeList);
		this.tributeList = tributeList;
		player = tributeList.get(tributeList.size() - 1);
	}
	
	public void bloodbathChoices()
	{
		System.out.println("Tributes Remaining: " + tributeList.size());
		System.out.println("Fighting: " + player.getFighting() + "/10");
		System.out.println("Surviving: " + player.getSurviving() + "/10");
		System.out.println("Food Level: " + player.getFood() + "/10");
		int choice;
		do
		{
			Scanner in = new Scanner(System.in);
			System.out.println("You see weapons and backpacks in the cornucopia. What will you do?");
			System.out.println("[1] Run for a weapon");
			System.out.println("[2] Run for a backpack");
			System.out.println("[3] Look for a fight");
			System.out.println("[4] Run away");
			while(!in.hasNextInt())
			{
				System.out.println("Please enter a valid choice (either 1, 2, 3, or 4)");
				in.next();
			}
			choice = in.nextInt();
			if(choice==1)
			{
				weapon();
				break;
			}
			else if(choice==2)
			{
				backpack();
				break;
			}
			else if(choice==3)
			{
				fight();
				break;
			}
			else if(choice==4)
			{
				run();
				break;
			}
			else
			{
				System.out.println("Please enter a valid choice (either 1, 2, 3, or 4).");
			}
		}
		while(choice == (int) choice);
	}
	
	public void feastChoices()
	{
		System.out.println("Tributes Remaining: " + tributeList.size());
		System.out.println("Fighting: " + player.getFighting() + "/10");
		System.out.println("Surviving: " + player.getSurviving() + "/10");
		System.out.println("Food Level: " + player.getFood() + "/10");
		boolean valid = false;
		while(!valid)
		{
			Scanner in = new Scanner(System.in);
			System.out.println("The Gamemakers have decided to throw a feast. What will you do?");
			System.out.println("[1] Run for a weapon");
			System.out.println("[2] Run for a backpack");
			System.out.println("[3] Look for a fight");
			System.out.println("[4] Don't go to the feast");
			int choice = in.nextInt();
			if(choice==1)
			{
				weapon();
				valid = true;
			}
			else if(choice==2)
			{
				backpack();
				valid = true;
			}
			else if(choice==3)
			{
				fight();
				valid = true;
			}
			else if(choice==4)
			{
				run();
				valid = true;
			}
			else
			{
				System.out.println("Please enter a valid game choice.");
			}
		}
	}
	
	public void weapon()
	{
		double val = Math.random();
		if (val < 0.8)
		{
			fight();
		}
		
		if (player.getStatus() == false)
		{
			System.out.println("You find a weapon and increase your fighting ability by 4 points.");
			player.addFight(4);
		}
	}
	
	public void backpack()
	{
		double val = Math.random();
		if (val < 0.8)
		{
			fight();
		}
		
		if (player.getStatus() == false)
		{
			System.out.println("You find a backpack and increase your survival ability by 2 points.");
			player.addSurvive(2);
		}
	}
	
	public void run()
	{
		double val = Math.random();
		if (val < 0.1)
		{
			System.out.println("You did not successfully run away and found another tribute.");
			fight();
		}
		else
		{
			System.out.println("You successfully run away.");
		}
	}
	
	public void killTributes()
	{
		int numDead = (int)(Math.random() * 4) + 2;
		
		while (numDead > 0)
		{
			int min = 0;
			for (int i = 1; i < tributeList.size() - 1; i++)
			{
				if (tributeList.get(i).getFighting() < tributeList.get(min).getFighting())
				{
					min = i;
				}
			}
			tributeList.get(min).updateStatus(true);
			numDead--;
		}
	}
}