package classes;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * A Pre-Game Training day.
 */
public class PreGameDay extends Day
{
	private Tribute player; //a player (tribute) in the Hunger Games
	
	/**
	 * Constructs a training day using super Day constructor.
	 * Initializes player with Tribute at last index of tributeList.
	 * @param tributeList a list of all tributes
	 */
	public PreGameDay(ArrayList<Tribute> tributeList)
	{
		super(tributeList);
		player = tributeList.get(11);
	}
	/**
	 * Prints out what choices a tribute has each day in the Hunger Games. Calls appropriate methods according to user input.
	 */
	public void choices()
	{
		System.out.println("Your Stats:");
		System.out.println("Fighting: " + player.getFighting() + "/10");
		System.out.println("Surviving: " + player.getSurviving() + "/10");
		System.out.println("");
		System.out.println("Your choices: Press 1 or 2 to choose what you want to do.");
		System.out.println("[1] Improve Fighting Ability");
		System.out.println("[2] Improve Survival Ability");
		System.out.println("");
		int choice;
		do
		{
			Scanner in = new Scanner(System.in);
			
			while(!in.hasNextInt())
			{
				System.out.println("Please enter a valid choice (either 1 or 2)");
				in.next();
			}
			choice = in.nextInt();
			if(choice==1)
			{
				player.addFight(2);
				System.out.println("You have successfully improved your fighting ability.");
				break;
			}
			else if(choice==2)
			{
				player.addSurvive(3);
				System.out.println("You have successfully improved your survival ability.");
				break;
			}
			else
			{
				System.out.println("Please enter a valid choice (either 1 or 2).");
			}
		}
		while(choice==(int)choice);
	}
}