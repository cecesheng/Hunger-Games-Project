package classes;

import java.util.Scanner;
import java.util.ArrayList;

public class Feast extends Day
{	
private Tribute player;

	public Feast(ArrayList<Tribute> tributeList)
	{
		super(tributeList);
		player = tributeList.get(tributeList.size() - 1);
	}
	
	public void bloodbathChoices()
	{
		Scanner in = new Scanner(System.in);
		System.out.println("You see weapons and backpacks in the cornucopia. What will you do?");
		System.out.println("[1] Run for a weapon");
		System.out.println("[2] Run for a backpack");
		System.out.println("[3] Look for a fight");
		System.out.println("[4] Run away");
		int choice = in.nextInt();
		if(choice==1)
		{
			weapon();
		}
		else if(choice==2)
		{
			backpack();
		}
		else if(choice==3)
		{
			fight();
		}
		else if(choice==4)
		{
			run();
		}
		else
		{
			System.out.println("Please enter a valid game choice.");
		}
	}
	
	public void feastChoices()
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
		}
		else if(choice==2)
		{
			backpack();
		}
		else if(choice==3)
		{
			fight();
		}
		else if(choice==4)
		{
			run();
		}
		else
		{
			System.out.println("Please enter a valid game choice.");
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
			fight();
		}
		else
		{
			System.out.println("You successfully run away.");
		}
	}
}