package penAndSword;

import java.lang.reflect.Array;
import java.util.*;

/*
 * The purpose of the Dungeon class is to determine what will be spawned in to each dungeon that the player encounters.
 * Dungeons are randomly populated with enemies, loot items, and coins each time the class is called.
 */
public class Dungeon
{
	private static int numEnemies;
	private static int numLoot;
	private static int numCoins;
	private Enemy enemy1;
	private Enemy enemy2;
	private Enemy enemy3;
	private Enemy enemy4;
//	Item loot1;
//	Item
	private static int maxCoinRange = 10;
	private static int minCoinRange = 1;
	private int coinRange = maxCoinRange - minCoinRange + 1;
	private int diceRoll;
	private static boolean coins;
	
	//array list to hold opening lines upon entering a dungeon level
	private static List<String> openingText = new ArrayList<>();
	private static String s1 = "You enter a dark room, rats scurry past your feet as the door opens";
	
	static 
	{
		openingText.add(s1);
	}
	
	
	/*
	 * Purpose: this method will be used to generate a new dungeon each time it is called. 
	 * Each dungeon should have intro text that lets the player know what is in the room and should generate enemies and loot 
	 * based on the player's level
	 * 
	 * @param: int playerLevel
	 */
	public static void dungeonLevel(int playerLevel) 
	{
		//decide if dungeon will have coins
		Random random = new Random();
		int diceRoll = random.nextInt(minCoinRange, maxCoinRange);
		
		//if diceRoll is equal to or greater than 5 there will be coins in dungeon
		if(diceRoll >= 5) 	
		{
			//look for player level and generate number of enemies and loot items by level
			if(playerLevel <= 2) 
			{
				numEnemies = 2;
				numLoot = 1;
				coins = true;
				generateDungeon(playerLevel, numEnemies, numLoot, coins);
			}
			if(playerLevel > 2 && playerLevel <= 4) 
			{
				numEnemies = 2;
				numLoot = 2;
				coins = true;
				generateDungeon(playerLevel, numEnemies, numLoot, coins);
			}
			if(playerLevel >4) 
			{
				numEnemies = 3;
				numLoot = 3;
				coins = true;
				generateDungeon(playerLevel, numEnemies, numLoot, coins);
			}
		}
		//if diceRoll was less than 5 than there is no coins in dungeon
		else 
		{
			if(playerLevel <= 2) 
			{
				numEnemies = 2;
				numLoot = 1;
				coins = false;
				generateDungeon(playerLevel, numEnemies, numLoot, coins);
			}
			if(playerLevel > 2 && playerLevel <= 4) 
			{
				numEnemies = 3;
				numLoot = 2;
				coins = false;
				generateDungeon(playerLevel, numEnemies, numLoot, coins);
			}
			if(playerLevel >4) 
			{
				numEnemies = 4;
				numLoot = 3;
				coins = false;
				generateDungeon(playerLevel, numEnemies, numLoot, coins);
			}
		}
	}
	
	public void addLine(String line) 
	{
		openingText.add(line);
	}
	
	public static String generateDungeon(int playerLevel, int enemies, int loot, boolean coins) 
	{
		//create an array that will hold the enemies in the room
		Enemy[] enemy = null;
		Items[] item = null;
		Random random = new Random();
		if(coins = true) {
			for(int i = 0; i <= enemies; i++) 
			{
				enemy[i] = Enemy.theHorde.get(playerLevel).get(random.nextInt(0, Enemy.getHordeLength(playerLevel)));
			}
			for(int i= 0; i <= loot; i++) 
			{
				//item[i] = Items.
			}
			numCoins = random.nextInt(1, 10);
			return "Dungeon";
		}
		else 
		{
			for(int i = 0; i <= enemies; i++) 
			{
				enemy[i] = Enemy.theHorde.get(playerLevel).get(random.nextInt(0, Enemy.getHordeLength(playerLevel)));
			}
			for(int i= 0; i <= loot; i++) 
			{
				//item[i] = Items.
			}
			return "Dungeon";
		}
		
}
	public void main(String[] args) 
	{
		System.out.println(openingText);
	}
}