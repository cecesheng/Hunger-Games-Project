package classes;

import java.util.ArrayList;
import java.util.Collections;
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

		int choice;
		do
		{
			Scanner in = new Scanner(System.in);
			System.out.println("Food Level: " + player.getFood() + "/10");
			System.out.println("What will you do today?");
			System.out.println("[1] Hide");
			System.out.println("[2] Search for Food");
			System.out.println("[3] Look for a Fight");
			while(!in.hasNextInt())
			{
				System.out.println("Please enter a valid choice (either 1, 2, or 3)");
				in.next();
			}
			choice = in.nextInt();
			if(choice==1)
			{
				hide();
				break;
			}
			else if(choice==2)
			{
				food();
				break;
			}
			else if(choice==3)
			{
				fight();
				break;
			}
			else
			{
				System.out.println("Please enter a valid choice (either 1, 2, or 3)");
			}
		}
		while(choice == (int) choice);
		/*
		boolean valid = false;
		while(!valid)
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
				valid = true;
			}
			else if(choice==2)
			{
				food();
				valid = true;
			}
			else if(choice==3)
			{
				fight();
				valid = true;
			}
			else
			{
				System.out.println("Please enter a valid choice (either 1, 2, or 3)");
			}	
		}
		*/
	}
	public void killTributes()
	{
		int numDead = (int)(3*Math.random());
		ArrayList<Integer> totalStats = new ArrayList<Integer>();
		for(int i=0; i<tributeList.size()-1; i++)
		{
			Tribute chosen = tributeList.get(i);
			totalStats.add(chosen.getFighting()+chosen.getSurviving());
		}
		Collections.sort(totalStats);
		for(int i=0; i<numDead; i++)
		{
			int index = 0;
			boolean found = false;
			while(!found)
			{
				Tribute current = tributeList.get(index);
				boolean status = current.getStatus();
				int sum = current.getFighting()+current.getSurviving();
				if(!status && sum==totalStats.get(i))
				{
					current.updateStatus(true);
					found=true;
				}
				else
				{
					index++;
				}
			}
		}
		
	}
	
	public void showDead(int dayCount)
	{
		ArrayList<Tribute> dead = new ArrayList<Tribute>();
		for (int i = 0; i < tributeList.size(); i++)
		{
			if (tributeList.get(i).getStatus() == true)
			{
				dead.add(tributeList.remove(i));
				i--;
			}
		}
		
		System.out.println("Deaths from day " + dayCount + ":");
		for (int i = 0; i < dead.size(); i++)
		{
			System.out.println("District " + dead.get(i).getDistrict());
		}
	}
	
	public void getHungry()
	{
		player.changeFood(-2);
	}
	
	public void food()
	{
		double val = Math.random();
		if(val < 0.2)
		{
			fight();
		}
		
		if (player.getStatus() == false)
		{
			double rand = Math.random();
			if (player.getSurviving() > 8)
			{
				if(rand<0.8)
				{
					System.out.println("You find a lot of food.");
					player.changeFood(3);
				}
				else
				{
					System.out.println("You find some food.");
					player.changeFood(2);
				}
			}
			else if (player.getSurviving() > 5)
			{
				if(rand<0.2)
				{
					System.out.println("You find a lot of food.");
					player.changeFood(3);
				}
				else if(rand<0.8)
				{
					System.out.println("You find some food.");
					player.changeFood(2);
				}
				else
				{
					System.out.println("You find a little bit of food.");
					player.changeFood(1);
				}
			}
			else if (player.getSurviving() > 2)
			{
				if(rand<0.5)
				{
					System.out.println("You find a little bit of food.");
					player.changeFood(1);
				}
				else if(rand<0.7)
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
	
	public void fight()
	{
		int randNum = (int)(Math.random()*(tributeList.size()-1));
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

	public void hide()
	{
		double val = Math.random();
		if(player.getSurviving()<=3 && val<0.25)
		{
			System.out.println("You unsuccessfully hide and were found.");
			fight();
		}
		else if(player.getSurviving()>3 && player.getSurviving()<=6 && val<0.15)
		{
			System.out.println("You unsuccessfully hide and were found.");
			fight();
		}
		else
		{
			System.out.println("You successfully hide.");
		}
	}
}