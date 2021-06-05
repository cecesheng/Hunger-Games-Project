package classes;

import java.util.ArrayList;
import java.util.Scanner;

public class HungerGamesRunner 
{

	public HungerGamesRunner()
	{
		// intro
		System.out.println("Welcome to the Hunger Games!");
		System.out.println("You have been selected as our tribute from District 12.");
		System.out.println("Your goal is to be the last tribute standing.");
		System.out.println("In order to do so, you will need to build up your fighting and survival abilities and make sure your food bar never gets to 0.");
		System.out.println("Every day, you will be given a choice of what to do. Choose wisely.");
		System.out.println("Your three days of training begin now. Good luck!");
		
		// create list of tributes
		ArrayList<Tribute> tributeList = new ArrayList<Tribute>();
		for (int i = 0; i < 11; i++)
		{
			if (i == 0 || i == 1 || i == 3)
		{
			Tribute created = new Tribute((int)Math.random() * 3 + 8, (int)Math.random() * 3 + 8, 10, i + 1);
			tributeList.add(created);
		}
		else
		{
			Tribute created = new Tribute((int)Math.random() * 11, (int)Math.random() * 11, 10, i + 1);
			tributeList.add(created);
		}
		}
		Tribute player = new Tribute(3, 3, 10, 12);
		tributeList.add(player);
		
		System.out.println("");
		
		//training days
		boolean condition = false;
		int i=1;
		while(!condition)
		{
			Scanner in = new Scanner(System.in);
			System.out.println("Press any letter then the enter key to continue.");
			if(in.hasNext())
			{
				System.out.println("-----------------------------------------------------------");
				if(i==1)
				{
					System.out.println("-----------------------------------------------------------");
				}
				if(i==3)
				{
					condition = true;
				}
				
				System.out.println("Day " + i + " of training");
				System.out.println("");
				PreGameDay day = new PreGameDay(tributeList);
				day.choices();
				System.out.println("");
				i++;
			}
		}
		
		//end of training message
		Scanner in1 = new Scanner(System.in);
		System.out.println("Press any letter then the enter key to continue.");
		if(in1.hasNext())
		{
			System.out.println("-----------------------------------------------------------");
			System.out.println("Your Final Stats:");
			System.out.println("Fighting: " + player.getFighting() + "/10");
			System.out.println("Surviving: " + player.getSurviving() + "/10");
			System.out.println("Food: " + player.getFood() + "/10");
			System.out.println("");
			System.out.println("Now you are ready for the Hunger Games. Good luck, and may the odds be ever in your favor.");
			System.out.println("");
		}
		
		//bloodbath
		int dayCount = 1;
		Scanner in2 = new Scanner(System.in);
		System.out.println("Press any letter then the enter key to continue.");
		if(in2.hasNext())
		{
			System.out.println("-----------------------------------------------------------");
			System.out.println("-----------------------------------------------------------");
			System.out.println("Day " + dayCount);
			Feast bloodbath = new Feast(tributeList);
			bloodbath.bloodbathChoices();
			bloodbath.getHungry();
			bloodbath.killTributes();
			System.out.println("");
			bloodbath.showDead(1);
			System.out.println("Number of Tributes Left: " + tributeList.size());
			System.out.println("");
		}
		
		//game days
		dayCount = 2;
		while(player.getStatus() == false && tributeList.size() > 4)
		{
			Scanner in3 = new Scanner(System.in);
			System.out.println("Press any letter then the enter key to continue.");
			if(in3.hasNext())
			{
				System.out.println("-----------------------------------------------------------");
				System.out.println("Day " + dayCount);
				GiftList gifts = new GiftList(tributeList.get(tributeList.size() - 1));
				double giftChance = Math.random();
				if (giftChance < 0.15)
				{
					gifts.getGift();
				}
				
				Day day = new Day(tributeList);
				System.out.println("Your Stats:");
				System.out.println("Fighting: " + player.getFighting() + "/10");
				System.out.println("Surviving: " + player.getSurviving() + "/10");
				System.out.println("Food Level: " + player.getFood() + "/10");
				System.out.println("");
				day.choices();
				day.getHungry();
				day.killTributes();
				System.out.println("");
				day.showDead(dayCount);
				System.out.println("Number of Tributes Left: " + tributeList.size());
				dayCount++;
				
				System.out.println("");
			}
		}

		// feast
		if (player.getStatus() == false && tributeList.size() <= 4)
		{
			Scanner in4 = new Scanner(System.in);
			System.out.println("Press any letter then the enter key to continue.");
			if(in4.hasNext())
			{
				System.out.println("-----------------------------------------------------------");
				System.out.println("Day " + dayCount);
				Feast feast = new Feast(tributeList);
				feast.feastChoices();
				feast.getHungry();
				feast.killTributes();
				System.out.println("");
				feast.showDead(dayCount);
				System.out.println("Number of Tributes Left: " + tributeList.size());
			}
		}
		
		//post-feast
		while (player.getStatus() == false && tributeList.size() > 1)
		{
			Scanner in5 = new Scanner(System.in);
			System.out.println("Press any letter then the enter key to continue.");
			if(in5.hasNext())
			{
				System.out.println("-----------------------------------------------------------");
				System.out.println("Day " + dayCount);
				GiftList gifts = new GiftList(tributeList.get(tributeList.size() - 1));
				double giftChance = Math.random();
				if (giftChance < 0.15)
				{
					gifts.getGift();
				}
				
				Day day = new Day(tributeList);
				System.out.println("Your Stats:");
				System.out.println("Fighting: " + player.getFighting() + "/10");
				System.out.println("Surviving: " + player.getSurviving() + "/10");
				System.out.println("Food Level: " + player.getFood() + "/10");
				System.out.println("");
				day.choices();
				day.getHungry();
				System.out.println("");
				day.showDead(dayCount);
				System.out.println("Number of Tributes Left: " + tributeList.size());
				dayCount++;
				
				System.out.println("");
			}
		}
		
		//end message
		System.out.println("-----------------------------------------------------------");
		System.out.println("-----------------------------------------------------------");
		
		if (player.getStatus() == false)
		{
			System.out.println("Congratulations! You won the Hunger Games.");
		}
		else
		{
			System.out.println("Game over!");
		}
		
	}
	
	//main method
	public static void main(String[] args)
	{
		HungerGamesRunner game = new HungerGamesRunner();
	}
}