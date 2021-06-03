package classes;

import java.util.ArrayList;

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
		
		// training days
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
		
		// bloodbath
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
			GiftList gifts = new GiftList(tributeList.get(tributeList.size() - 1));
			double giftChance = Math.random();
			if (giftChance < 0.15)
			{
				gifts.getGift();
			}
			
			Day day = new Day(tributeList);
			day.choices();
			day.getHungry();
			day.killTributes();
			day.showDead(dayCount);
			dayCount++;
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