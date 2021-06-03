package classes;

import java.util.ArrayList;

public class HungerGamesRunner 
{

	public HungerGamesRunner()
	{
		System.out.println("Welcome to the Hunger Games!");
		System.out.println("INSERT REST OF INTRO");
		System.out.println("Your three days of training begin now. Good luck!");
		
		ArrayList<Gift> giftList = new ArrayList<Gift>();
		giftList.add(new Gift("beef", 3));
		giftList.add(new Gift("crackers", 1));
		giftList.add(new Gift("knives", 3));
		giftList.add(new Gift("spear", 2));
		giftList.add(new Gift("spile", 3));
		giftList.add(new Gift("rope", 2));
		
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
		
		for (int i = 1; i <= 3; i++)
		{
			System.out.println("Day " + i + " of training");
			PreGameDay day = new PreGameDay(tributeList);
			day.choices();
		}
		
		System.out.println("Fighting: " + player.getFighting() + "/10");
		System.out.println("Surviving: " + player.getSurviving() + "/10");
		
		System.out.println("");
		
		System.out.println("Now you are ready for the Hunger Games. Good luck, and may the odds be ever in your favor.");
		
		System.out.println("");
		
		Feast bloodbath = new Feast(tributeList);
		bloodbath.bloodbathChoices();
		System.out.println("Deaths from day 1");
		ArrayList<Tribute> bloodbathDeaths = new ArrayList<Tribute>();
		for (int i = 0; i < tributeList.size(); i++)
		{
			if (tributeList.get(i).getStatus() == true)
			{
				bloodbathDeaths.add(tributeList.remove(i));
				i--;
			}
		}
		for (int i = 0; i < bloodbathDeaths.size(); i++)
		{
			System.out.println("District " + bloodbathDeaths.get(i).getDistrict());
		}
		
		int dayCount = 2;
		while (player.getStatus() == false && tributeList.size() > 4)
		{
			System.out.println("Day " + dayCount);
			double giftChance = Math.random();
			if (giftChance < 0.15)
			{
				int num = 0;
				if (giftChance < 0.02)
				{
					num = 0;
					player.changeFood(3);
				}
				else if (giftChance < 0.05)
				{
					num = 1;
					player.changeFood(1);
				}
				else if (giftChance < 0.07)
				{
					num = 2;
					player.addFight(3);
				}
				else if (giftChance < 0.10)
				{
					num = 3;
					player.addFight(2);
				}
				else if (giftChance < 0.12)
				{
					num = 4;
					player.addSurvive(3);
				}
				else
				{
					num = 5;
					player.addSurvive(2);
				}
				
				System.out.println("You received a " + giftList.get(num).getName() + " from your sponsor.");
			}
			
			Day day = new Day(tributeList);
			day.choices();
			
			ArrayList<Tribute> dead = new ArrayList<Tribute>();
			for (int i = 0; i < tributeList.size(); i++)
			{
				if (tributeList.get(i).getStatus() == true)
				{
					dead.add(tributeList.remove(i));
					i--;
				}
			}
			
			System.out.println("Deaths from day " + dayCount);
			for (int i = 0; i < dead.size(); i++)
			{
				System.out.println("District " + dead.get(i).getDistrict());
			}
			dayCount++;
			player.changeFood(-2);
			System.out.println("\n");
		}
		
		if (player.getStatus() == false && tributeList.size() <= 4)
		{
			Feast feast = new Feast(tributeList);
			feast.feastChoices();
		}
		
		System.out.println("Game over!");
		
	}
	
	public static void main(String[] args)
	{
		HungerGamesRunner game = new HungerGamesRunner();
	}
}