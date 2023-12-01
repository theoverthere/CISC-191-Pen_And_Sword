package penAndSword;

import java.util.Scanner;

/*
 * The purpose of this class is to move the player through the games levels and decide what levels (either dungeon, boss, shop, or library)
 * the player can access next
 */
public class LevelExplorer
{
	private static int currentXP = Player.getPlayerLevel(Player.player1);
	private static int currentLevel = 1;
	private static int numLevels;
	private static int finalLevel = 15;
	
	Scanner sc = new Scanner(System.in);
	
	/*
	 * Purpose: the nextLevel method will take in input from the player and check the players level to 
	 * determine which type of level will be loaded next
	 * 
	 * @param: int input
	 */
	public static void nextLevel(int input) throws InvalidInputException
	{
		if(currentLevel == 1) 
		{
			currentLevel++;
			Dungeon.dungeonLevel(currentXP);
		}
		if(currentLevel > 1 && currentLevel < 5) 
		{
			currentLevel++;
			//System.out.println("Where would you like to go next?");
			int nextLevel1 = playerChooseNextLevel(input); 
			switch(nextLevel1) 
			{
				case 1:
					Dungeon.dungeonLevel(currentXP);
					break;
				case 2:
					Store.populateShopInventory();
					break;		
			}
		if(currentLevel == 5) 
		{
			currentLevel++;
			Dungeon.bossLevel(currentXP);
		}
		if(currentLevel > 5 && currentLevel < 10) 
		{
			currentLevel++;
			//System.out.println("Where would you like to go next?");
			int nextLevel2 = playerChooseNextLevel(input);
			switch(nextLevel2) 
			{
				case 1:
					Dungeon.dungeonLevel(currentXP);
					break;
				case 2:
					Store.populateShopInventory();
					break;		
			}
		}
		if(currentLevel == 10) 
		{
			currentLevel++;
			Dungeon.bossLevel(currentXP);
		}
		if(currentLevel > 10 && currentLevel < 15) 
		{
			currentLevel++;
			System.out.println("Where would you like to go next?");
			int nextLevel3 = playerChooseNextLevel(input);
			switch(nextLevel3) 
			{
				case 1:
					Dungeon.dungeonLevel(currentXP);
					break;
				case 2:
					Store.populateShopInventory();
					break;		
			}
		}
		if(currentLevel == 15) 
		{
			currentLevel++;
			Dungeon.bossLevel(currentXP);
		}
		else 
		{
			//Dungeon.gameOver();
		}
		}
	}
	
	public static int playerChooseNextLevel(int input) throws InvalidInputException
	{
		if(input < 0 || input > 2)
		{
			throw new InvalidInputException("Input must be between 1-2");
		}
		else 
		{
			return input;
		}
	}
	
	public static void main(String[] args) throws InvalidInputException 
	{
		nextLevel(2);
	}
}
