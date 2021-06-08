package classes;
import java.util.ArrayList;
/**
 * A List of gifts that could potentially be given to a tribute.
 */
public class GiftList 
{
	private ArrayList<Gift> giftList; //a list of gifts
	private Tribute player; //a player (tribute) in the Hunger Games

	/**
	 * Constructs a list of gifts, initializes giftList with 6 gifts.
	 * @param player the tribute
	 */
	public GiftList(Tribute player)
	{
		this.player = player;
		giftList = new ArrayList<Gift>();
		giftList.add(new Gift("beef", 3));
		giftList.add(new Gift("crackers", 1));
		giftList.add(new Gift("knives", 3));
		giftList.add(new Gift("a spear", 2));
		giftList.add(new Gift("a spile", 3));
		giftList.add(new Gift("rope", 2));
	}
	/**
	 * Gives gift to a tribute.
	 * About 17% chance to get specific gift from giftList and call changeFood(), addFight(), or addSurvive().
	 */
	public void getGift()
	{
		Gift given;
		double giftChance = Math.random();
		if (giftChance < 0.16)
		{
			given = giftList.get(0);
			player.changeFood(given.getValue());
		}
		else if (giftChance < 0.33)
		{
			given = giftList.get(1);
			player.changeFood(given.getValue());
		}
		else if (giftChance < 0.40)
		{
			given = giftList.get(2);
			player.addFight(given.getValue());
		}
		else if (giftChance < 0.67)
		{
			given = giftList.get(3);
			player.addFight(given.getValue());
		}
		else if (giftChance < 0.84)
		{
			given = giftList.get(4);
			player.addSurvive(given.getValue());
		}
		else
		{
			given = giftList.get(5);
			player.addSurvive(given.getValue());
		}
			
		System.out.println("You received " + given.getName() + " from your sponsor.");
	}
}
