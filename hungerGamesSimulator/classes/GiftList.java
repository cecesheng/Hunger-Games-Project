package classes;

import java.util.ArrayList;

public class GiftList {
private ArrayList<Gift> giftList;
private Tribute player;

	public GiftList(Tribute player)
	{
		this.player = player;
		giftList = new ArrayList<Gift>();
		giftList.add(new Gift("beef", 3));
		giftList.add(new Gift("crackers", 1));
		giftList.add(new Gift("knives", 3));
		giftList.add(new Gift("spear", 2));
		giftList.add(new Gift("spile", 3));
		giftList.add(new Gift("rope", 2));
	}
	
	public void getGift()
	{
		Gift given;
		double giftChance = Math.random();
		if (giftChance < 0.16)
		{
			given = giftList.get(0);
			player.changeFood(given.getValue());
			System.out.println("You received a " + given.getName() + " from your sponsor (+" + given.getValue() + " food)");
		}
		else if (giftChance < 0.33)
		{
			given = giftList.get(1);
			player.changeFood(given.getValue());
			System.out.println("You received a " + given.getName() + " from your sponsor (+" + given.getValue() + " food)");
		}
		else if (giftChance < 0.40)
		{
			given = giftList.get(2);
			player.addFight(given.getValue());
			System.out.println("You received a " + given.getName() + " from your sponsor (+" + given.getValue() + " fighting)");
		}
		else if (giftChance < 0.67)
		{
			given = giftList.get(3);
			player.addFight(given.getValue());
			System.out.println("You received a " + given.getName() + " from your sponsor (+" + given.getValue() + " fighting)");
		}
		else if (giftChance < 0.84)
		{
			given = giftList.get(4);
			player.addSurvive(given.getValue());
			System.out.println("You received a " + given.getName() + " from your sponsor (+" + given.getValue() + " surviving)");
		}
		else
		{
			given = giftList.get(5);
			player.addSurvive(given.getValue());
			System.out.println("You received a " + given.getName() + " from your sponsor (+" + given.getValue() + " surviving)");
		}
	}
}
