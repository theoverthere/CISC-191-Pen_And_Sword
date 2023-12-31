package penAndSword;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.*;

import javax.imageio.ImageIO;

/*
 * The purpose of the Dungeon class is to determine what will be spawned in to each dungeon that the player encounters.
 * Dungeons are randomly populated with enemies, loot items, and coins each time the class is called.
 */
public class Dungeon
{
	//fields for generating random elements of dungeon
	private static int numEnemies;
	private static int numLoot;
	private static int numCoins;
	private Enemy enemy1;
	private Enemy enemy2;
	private Enemy enemy3;
	private Enemy enemy4;
	private static int maxCoinRange = 10;
	private static int minCoinRange = 1;
	private int diceRoll;
	private static boolean coins;
	//fields for initializing dungeon objects (with intro text and bg picture)
	String openingText;
	private BufferedImage bg;
	//fields for exporting finalized dungeon
	private Dungeon finalDungeon;
	static Dungeon GUIdungeon;
	private static Dungeon newDungeon;
	final int finalCoins;
	final Stack<Enemy> finalEnemies;
	private final Items[] finalItems;
	
	//array list to hold opening lines upon entering a dungeon level
	private static List<Dungeon> dungeonRooms = new ArrayList<>();
	
	//constructor to initialize dungeon opening texts and backgorund images
	public Dungeon(String newOpeningText)//, String bgPath) 
	{
		this.openingText = newOpeningText;
//		BufferedImage BGImage = null;
//		try 
//		{
//			BGImage = ImageIO.read(new File(bgPath));
//		} 
//		catch (IOException e) 
//		{
//			e.printStackTrace();
//		}
//		this.bg = BGImage;
		this.finalCoins = 0;
		this.finalEnemies = null;
		this.finalItems = null;
		dungeonRooms.add(this);
		
	}
	
	//constructor to append a value for coins, enemies, and items to each generated dungeon
	public Dungeon(Dungeon dungeon, int numCoins2, Stack<Enemy> dungeonEnemies, Items[] item)
	{
		this.openingText = dungeon.openingText;
		this.finalCoins = numCoins2;
		this.finalEnemies = dungeonEnemies;
		this.finalItems = item;
		
	}

	private static Dungeon d1 = new Dungeon("You enter a dark room, rats scurry past your feet as the door opens. Various metal instruments can be seen hanging from the ceiling, glimmering as the light from the doorway enters the room. This appears to be some kind of dungeon");//, "./Images/RatDungeon.png");
	private static Dungeon d2 = new Dungeon("As you open the door ahead of you, you are blinded by the outside light! Your vision begins to normalize and you see that you are in a courtyard, trees everywhere. You spy another doorway at the opposite end of the courtyard");//, "./Images/TreeCourtyard.png");
	private static Dungeon d3 = new Dungeon("The heavy door creaks open, revealing a long hallway ahead of you. The passageway is lined with suits of armor and armaments belonging to those who must've built this place");//, "./Images/SuitsOfArmor.png");
	
	/*
	 * Purpose: this method will be used to generate a new dungeon each time it is called. 
	 * Each dungeon should have intro text that lets the player know what is in the room and should generate enemies and loot 
	 * based on the player's level
	 * 
	 * @param: int playerLevel
	 */
	public static Dungeon dungeonLevel(int playerLevel) 
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
				newDungeon = generateDungeon(playerLevel, numEnemies, numLoot, coins);
			}
			if(playerLevel > 2 && playerLevel <= 4) 
			{
				numEnemies = 3;
				numLoot = 2;
				coins = true;
				newDungeon = generateDungeon(playerLevel, numEnemies, numLoot, coins);
			}
			if(playerLevel >4) 
			{
				numEnemies = 4;
				numLoot = 3;
				coins = true;
				newDungeon = generateDungeon(playerLevel, numEnemies, numLoot, coins);
			}
			return newDungeon;
		}
		//if diceRoll was less than 5 than there is no coins in dungeon
		else 
		{
			if(playerLevel <= 2) 
			{
				numEnemies = 2;
				numLoot = 1;
				coins = false;
				newDungeon = generateDungeon(playerLevel, numEnemies, numLoot, coins);
			}
			if(playerLevel > 2 && playerLevel <= 4) 
			{
				numEnemies = 3;
				numLoot = 2;
				coins = false;
				newDungeon = generateDungeon(playerLevel, numEnemies, numLoot, coins);
			}
			if(playerLevel >4) 
			{
				numEnemies = 4;
				numLoot = 3;
				coins = false;
				newDungeon = generateDungeon(playerLevel, numEnemies, numLoot, coins);
			}
		}
		return newDungeon;
	}
	
	/*
	 * Purpose: The generateDungeon method uses the parameters passed by the dungeonLevel method to decide what exactly is spawned into each new dungeon
	 * 
	 * @param: int playerLevel, int enemies, int loot, boolean coins
	 * @return: Dungeon dungeon
	 */
	@SuppressWarnings("null")
	public static Dungeon generateDungeon(int playerLevel, int enemies, int loot, boolean coins) 
	{
		//create an arraylist that will hold the enemies in the room
		Stack<Enemy> dungeonEnemies = new Stack<>();
		Items[] item = null;
		Random random = new Random();
		if(coins = true) {
			for(int i = 0; i <= enemies; i++) 
			{
				dungeonEnemies.push(Enemy.theHorde.get(playerLevel).get(random.nextInt(0, Enemy.getHordeLength(playerLevel)-1)));
			}
			for(int i= 0; i <= loot; i++) 
			{
				//item[i] = Items.
			}
			numCoins = random.nextInt(1, 10);
			Dungeon dungeon = new Dungeon(dungeonRooms.get(random.nextInt(0, dungeonRooms.size())), numCoins, dungeonEnemies, item);
			return dungeon;
		}
		else 
		{
			for(int i = 0; i <= enemies; i++) 
			{
				dungeonEnemies.add(Enemy.theHorde.get(playerLevel).get(random.nextInt(0, Enemy.getHordeLength(playerLevel)-1)));
			}
			for(int i= 0; i <= loot; i++) 
			{
				//item[i] = Items.
			}
			numCoins = 0;
			Dungeon dungeon = new Dungeon(dungeonRooms.get(random.nextInt(0, dungeonRooms.size())), numCoins, dungeonEnemies, item);
			return dungeon;
		}
	
	}
	
	public static Boss bossLevel(int playerLevel) 
	{
		switch(playerLevel) 
		{
			case 1:
				return Boss.getBoss(playerLevel - 1);
			case 2: 
				return Boss.getBoss(playerLevel - 1);
			case 3:
				return Boss.getBoss(playerLevel - 1);
			case 4:
				return Boss.getBoss(playerLevel - 1);
			case 5:
				return Boss.getBoss(playerLevel - 1);
		}
		return null;
	}
	
	public static String getDungeonText(Dungeon dungeon) 
	{
		return dungeon.openingText;
	}
	
	public static Enemy getEnemy(Dungeon dungeon, int index) 
	{
		return dungeon.finalEnemies.elementAt(index);
	}
	
	public static Stack<Enemy> getEnemies(Dungeon dungeon) 
	{
		return dungeon.finalEnemies;
	}
	
	public static String getEnemyName(Enemy enemy) 
	{
		return Enemy.getName(enemy);
	}
	
	public static String getEnemyHP(Enemy enemy) 
	{
		return enemy.getHealth();
	}
	
	public static String printDungeon(Dungeon dungeon) 
	{
		return "Intro text: " + dungeon.openingText + "Enemies: " + dungeon.finalEnemies + "Coins: " + dungeon.finalCoins;
	}
	
	public void main(String[] args)
	{
		//System.out.println(openingText);
		System.out.println(bossLevel(5));
		
	
		
	}
}