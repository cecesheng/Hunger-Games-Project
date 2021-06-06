package classes;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
/**
 * A day in the Hunger Games.
 */
public class Day 
{
	private Tribute player; //a player (tribute) in the Hunger Games
	private ArrayList<Tribute> tributeList; //a list of all players (tributes) in the Hunger Games
	
	/**
	 * Constructs a Day in the Hunger Games. Initializes player with Tribute at last index of tributeList.
	 * @param list an ArrayList of tributes
	 */
	public Day(ArrayList<Tribute> list)
	{
		tributeList = list;
		player = tributeList.get(tributeList.size()-1);
	}
	/**
	 * Prints out what choices a tribute has each day in the Hunger Games. Calls appropriate methods according to user input.
	 */
	public void choices()
	{
		System.out.println("What will you do today? (Press 1, 2, or 3 to choose)");
		System.out.println("[1] Hide");
		System.out.println("[2] Search for Food");
		System.out.println("[3] Look for a Fight");
		int choice;
		do
		{
			Scanner in = new Scanner(System.in);
			while(!in.hasNextInt()) //Protects against non-integer input
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
				System.out.println("Please enter a valid choice (either 1, 2, or 3)"); //Protects against int input out of [1,3] range
			}
		}
		while(choice == (int) choice);
	}
	/**
	 * Picks a random number of 0-2 to determine the number of tributes to die.
	 * Ranks the tributeList based on the average of fighting and surviving stats.
	 * Sets the 0-2 tributes with the lowest stat’s statuses as dead
	 */
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
	/**
	 * Create ArrayList<Tribute> of dead tributes.
	 * Loop through tributeList, call getStatus() for every tribute, if true, then add tribute to dead array and remove from tributeList.
	 * Print all tributes in dead array using for loop.
	 * @param dayCount the number of days that have passed
	 */
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
	/**
	 * Decreases player’s food bar by 2 by calling changeFood().
	 * If player's food is 0 or lower, updates status to dead.
	 */
	public void getHungry()
	{
		player.changeFood(-2);
		if(player.getFood()<=0)
		{
			player.updateStatus(true);
			System.out.println("You died of hunger.");
		}
	}
	/**
	 * 20% chance of calling method fight()
	 * If player is still alive, finds amounts of food based on survival skill 
	 * (chance of finding more food is greater with higher survival skill)
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
	/**
	 * Gets random Tribute from tributeList
	 * If player’s fighting > random’s fighting, random becomes dead
	 * If player’s fighting < random’s fighting, player becomes dead
	 * If player’s fighting = random’s fighting, 50% chance of player becoming dead and 50% chance of random becoming dead
	 */
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
	/**
	 * Chance to call fight method based on random value and player’s surviving value.
	 */
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