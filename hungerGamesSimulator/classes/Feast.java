package classes;

import java.util.Scanner;
import java.util.ArrayList;

public class Feast extends Day
{	
	public Feast(ArrayList<Tribute> tributeList)
	{
		super(tributeList);
	}
	
	public void choices()
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
			//haven't written a method for a weapon yet
		}
		else if(choice==2)
		{
			//haven't written a method for a backpack yet
		}
		else if(choice==3)
		{
			fight();
		}
		else if(choice==4)
		{
			//haven't written a method to run away yet
		}
		else
		{
			System.out.println("Please enter a valid game choice.");
		}
	}
}
