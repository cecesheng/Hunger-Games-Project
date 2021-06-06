package classes;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

/**
 * A day where the gamemakers host a feast.
 */
public class Feast extends Day
{	
	private Tribute player; //a player (tribute) in the Hunger Games
	private ArrayList<Tribute> tributeList; //a list of all players (tributes) in the Hunger Games

	/**
	 * Constructs a feast by calling super Day constructor with parameter of tributeList.
	 * Initializes player with Tribute at last index of tributeList.
	 * @param tributeList
	 */
	public Feast(ArrayList<Tribute> tributeList)
	{
		super(tributeList);
		this.tributeList = tributeList;
		player = tributeList.get(tributeList.size() - 1);
	}
	/**
	 * Prints out what choices a tribute has on the bloodbath day. Calls appropriate methods according to user input.
	 */
	public void bloodbathChoices()
	{
		System.out.println("You see weapons and backpacks in the cornucopia. What will you do? (Press 1, 2, 3, or 4 to choose)");
		System.out.println("[1] Run for a weapon");
		System.out.println("[2] Run for a backpack");
		System.out.println("[3] Look for a fight");
		System.out.println("[4] Run away");
		int choice;
		do
		{
			Scanner in = new Scanner(System.in);
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
	/**
	 * Prints out what choices a tribute has on the feast day. Calls appropriate methods according to user input.
	 */
	public void feastChoices()
	{
		System.out.println("The Gamemakers have decided to throw a feast. What will you do? (Press 1, 2, 3, or 4 to choose)");
		System.out.println("[1] Run for a weapon");
		System.out.println("[2] Run for a backpack");
		System.out.println("[3] Look for a fight");
		System.out.println("[4] Don't go to the feast");
		int choice;
		do
		{
			Scanner in = new Scanner(System.in);
			
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
		while((int)choice == choice);
	}
	/**
	 * 80% chance of calling method fight().
	 * If player is still alive, calls method addFight(4)
	 */
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
	/**
	 * 80% chance of calling method fight().
	 * If player is still alive, called method addSurvive(2).
	 */
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
	/**
	 * 10% chance of calling method fight().
	 */
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
	/**
	 * Gets number between 1 and 3
	 * Loops through tributeList the number of times and sets tribute with the lowest fighting stat to dead.
	 */
	public void killTributes()
	{
		int numDead = (int)(Math.random() * 3) + 1;
		
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