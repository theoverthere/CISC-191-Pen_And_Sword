package penAndSword;

import java.util.Random;
import java.util.Scanner;

import penAndSword.GUIController.BeginScreenHandler;

/*
 * The purpose of this class is to move the player through the games levels and decide what levels (either dungeon, boss, shop, or library)
 * the player can access next
 */
public class LevelExplorer
{
	private static int currentXP = GUIController.player1.getLevel();
	private static int numLevels;
	private static int finalLevel = 15;
	private static Dungeon dungeon;
	private static boolean isDungeon;
	private static boolean isShop;
	private static boolean isBoss;
	private static boolean isLevelChooser;
	private static Store newStore;
	
	
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
		isDungeon = false;
		isShop = false;
		isBoss = false;
		isLevelChooser = true;
		switch(input) 
		{
			case 1:
				BeginScreenHandler.newDungeon();
			case 2:
				BeginScreenHandler.newShop();
		}
	}
	
	/*
	 * Purpose: the nextLevel method will take input from the player and check the players level to 
	 * determine which type of level will be loaded next
	 * 
	 * @param: int input
	 */
	public static Dungeon nextLevel()
	{
		if(GUIController.player1.levelCounter == 0) 
		{
			isDungeon = true;
			isShop = false;
			isBoss = false;
			isLevelChooser = false;
			GUIController.player1.levelCounter++;
			dungeon = Dungeon.dungeonLevel(currentXP);	
		}
		if(GUIController.player1.levelCounter > 1 && GUIController.player1.levelCounter < 5) 
		{
			isDungeon = true;
			isShop = false;
			isBoss = false;
			isLevelChooser = false;
			GUIController.player1.levelCounter++;
			dungeon = Dungeon.dungeonLevel(currentXP);					
		}
		if(GUIController.player1.levelCounter == 5) 
		{
			isDungeon = false;
			isShop = false;
			isBoss = true;
			isLevelChooser = false;
			GUIController.player1.levelCounter++;
			Dungeon.bossLevel(currentXP);
		}
		if(GUIController.player1.levelCounter > 5 && GUIController.player1.levelCounter < 10) 
		{
			isDungeon = true;
			isShop = false;
			isBoss = false;
			isLevelChooser = false;
			GUIController.player1.levelCounter++;
			System.out.println("level 5 - 10");
			Dungeon.dungeonLevel(currentXP);				
		}
		if(GUIController.player1.levelCounter == 10) 
		{
			isDungeon = false;
			isShop = false;
			isBoss = true;
			isLevelChooser = false;
			GUIController.player1.levelCounter++;
			Dungeon.bossLevel(currentXP);
		}
		if(GUIController.player1.levelCounter > 10 && GUIController.player1.levelCounter < 15) 
		{
			isDungeon = true;
			isShop = false;
			isBoss = false;
			isLevelChooser = false;
			GUIController.player1.levelCounter++;
			System.out.println("level 10 - 15");
			Dungeon.dungeonLevel(currentXP);		
		}
		if(GUIController.player1.levelCounter == 15) 
		{
			isDungeon = false;
			isShop = false;
			isBoss = true;
			isLevelChooser = false;
			GUIController.player1.levelCounter++;
			Dungeon.bossLevel(currentXP);
		}
		
		else 
		{
			//Dungeon.gameOver();
		}
		return dungeon;
	}
	
	public static Store nextShop()
	{
		isDungeon = false;
		isShop = true;
		isBoss = false;
		isLevelChooser = false;
		return newStore = new Store();
	}
	
	public static boolean getIsShop() 
	{
		return isShop;
	}
	
	public static boolean getIsDungeon() 
	{
		return isDungeon;
	}
	
	public static boolean getIsBoss() 
	{
		return isBoss;
	}
	public static void setIsLevelChooser(boolean yesnt) 
	{
		isLevelChooser = yesnt;
	}
	public static boolean getIsLevelChooser() 
	{
		return isLevelChooser;
	}
	
	
	
	
	
	
	
	public static void main(String[] args) throws InvalidInputException 
	{
		//nextLevel(1);
		System.out.println(nextLevel());
	}
}
