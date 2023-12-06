package penAndSword;

import java.util.Scanner;

/*
 * The purpose of this class is to move the player through the games levels and decide what levels (either dungeon, boss, shop, or library)
 * the player can access next
 */
public class LevelExplorer
{
	private static int currentXP = Player.player1.getLevel();
	private static int numLevels;
	private static int finalLevel = 15;
	private static Dungeon dungeon;
	
	Scanner sc = new Scanner(System.in);
	
	public static int playerChooseNextLevel(int input) throws InvalidInputException
	{
		if(input < 1 || input > 2)
		{
			throw new InvalidInputException("Input must be between 1-2");
		}
		else 
		{
			return input;
		}
	}
	
	public static void levelChooser(int input)
	{
		switch(input) 
		{
			case 1:
				nextLevel();
//			case 2:
//				nextShop();
		}
	}
	
	/*
	 * Purpose: the nextLevel method will take in input from the player and check the players level to 
	 * determine which type of level will be loaded next
	 * 
	 * @param: int input
	 */
	public static Dungeon nextLevel()
	{
		if(Player.player1.levelCounter == 0) 
		{
			Player.player1.levelCounter++;
			dungeon = Dungeon.dungeonLevel(currentXP);	
		}
		if(Player.player1.levelCounter > 1 && Player.player1.levelCounter < 5) 
		{
			Player.player1.levelCounter++;
			dungeon = Dungeon.dungeonLevel(currentXP);					
		}
		if(Player.player1.levelCounter == 5) 
		{
			Player.player1.levelCounter++;
			Dungeon.bossLevel(currentXP);
		}
		if(Player.player1.levelCounter > 5 && Player.player1.levelCounter < 10) 
		{
			Player.player1.levelCounter++;
			System.out.println("level 5 - 10");
			Dungeon.dungeonLevel(currentXP);				
		}
		if(Player.player1.levelCounter == 10) 
		{
			Player.player1.levelCounter++;
			Dungeon.bossLevel(currentXP);
		}
		if(Player.player1.levelCounter > 10 && Player.player1.levelCounter < 15) 
		{
			Player.player1.levelCounter++;
			System.out.println("level 10 - 15");
			Dungeon.dungeonLevel(currentXP);		
		}
		if(Player.player1.levelCounter == 15) 
		{
			Player.player1.levelCounter++;
			Dungeon.bossLevel(currentXP);
		}
		
		else 
		{
			//Dungeon.gameOver();
		}
		return dungeon;
		}
	
//	public static Shop nextShop()
//	{
//		return populateShop();
//	}
	
	
	
	
	
	public static void main(String[] args) throws InvalidInputException 
	{
		//nextLevel(1);
		System.out.println(nextLevel());
	}
}
