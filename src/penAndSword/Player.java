package penAndSword;
import java.util.*;

/*
 * The player class is responsible for tracking the stats and inventory of the player.
 */
public class Player extends Entities {
//fields
	private int playerHealth;
	private int playerExp;
	private int playerArmor;
	private int playerDamage; // slash weapon
	private int playerMoney;
	private int playerLevel;
	private String playerName = "";
	//public static Player player1 = new Player("Duncan");
 int levelCounter;
	//data structure to hold items that the player finds on their journey
	private String[][] playerInventory = new String[3][1];

	
	
//constructor
	public Player(String newName) 
	{
		super();
		this.playerName = newName;
		this.playerHealth = 10;
		this.playerDamage = 2;
		this.playerLevel = 1;
		this.playerExp = 0;
		this.playerArmor = 1;
		this.playerMoney = 0;
		this.levelCounter = 0;
	}
	
	public String getName() 
	{
		return GUIController.player1.playerName;
	}

//gets player health
	@Override
	public String getHealth() 
	{
		String pHealth = Integer.toString(GUIController.player1.playerHealth);
		return pHealth;
	}
  
//takes or gives player health
	@Override
	public void setHealth(int incoming) 
	{
		this.playerHealth = GUIController.player1.playerHealth - incoming;
	}

//gets players EXP
	public static int getplayerExp(Player player) 
	{
		return GUIController.player1.playerExp;
	}
	//another way to get player exp
	public static int getExp() {
		return GUIController.player1.playerExp;
	}

//adds incoming player exp to player exp
	public static void changePlayerExp(Player player) {
		GUIController.player1.playerExp += 1;
	}

//gets player armor
	@Override
	public String getArmor() {
		String pArmor = Integer.toString(GUIController.player1.playerArmor);
		return pArmor;
	}

//replaces the player armor with incoming armor
	@Override
	public void setArmor(int newArmor) 
	{ 
		GUIController.player1.playerArmor = newArmor;
	}

//returns player money
	public static int getPlayerMoney(Player player) {
		return GUIController.player1.playerMoney;
	}

//changes player money
	public void changePlayerMoney(Player player, int newPlayerMoney) 
	{
		GUIController.player1.playerMoney += newPlayerMoney;
	}

	// gets player damage
	@Override
	public int getDamage() 
	{
		return GUIController.player1.playerDamage;
	}

	// replaces player damage with new player damage
	@Override
	public void setDamage(int newDamage) 
	{ 
		GUIController.player1.playerDamage += newDamage;
	}

	@Override
	public int getLevel() 
	{
		return GUIController.player1.playerLevel;
	}
	
	@Override
	public void setLevel() 
	{ 
		GUIController.player1.playerExp = 0;
		GUIController.player1.playerLevel++;

	}
	
	@Override
	public boolean isDead()
	{
		int pHealth = Integer.parseInt(GUIController.player1.getHealth());
		if(pHealth <= 0) 
		{
			return true;
		}
		else 
		{
			return false;
		}
		
	}
	
	public void addWeaponToInventory(Player player, String weapon) 
	{
		player.playerInventory[0][0] = weapon;
	}
	
	public void addArmorToInventory(Player player, String armor)
	{
		
		player.playerInventory[0][1] = armor;
	}
	
	public void addPotionToInventory(Player player, String potion) throws IndexOutOfBoundsException
	{
		try
		{
			for(int i = 0; i <= 1; i++) 
			{
				if(player.playerInventory[1][i].isEmpty()) 
				{
					player.playerInventory[1][i] = potion;
				}
				
			}
		}
		catch(IndexOutOfBoundsException e) 
		{
			System.out.println("Your potion slots are full");
		}
	}
	
	public void addLootToInventory(Player player, String loot) 
	{
		for(int i = 2; i < 4; i++) 
		{
			for(int j = 0; j <2; j++) 
			{
				if(player.playerInventory[i][j].isBlank()) 
				{
				player.playerInventory[i][j] = loot;
				}
			}
		}
		if (player.playerInventory[2][0] != null && player.playerInventory[2][1] != null && player.playerInventory[3][0] != null && player.playerInventory[3][1] != null) 
		{
			int[] sortThis = new int[3];
			String[] comparisonArray = {player.playerInventory[2][0], player.playerInventory[2][1], player.playerInventory[3][0], player.playerInventory[3][1]};
			
			for(int i = 0; i < 5; i++) 
			{
				int temp = Items.armor.get(loot).intValue();
				
				sortThis[i] = temp;
			}
			Arrays.sort(sortThis);
			if(sortThis[3] < Items.armor.get(loot).intValue()) 
			{
				player.playerInventory[3][1] = loot;
			}
		
		
		}
	}
	

	
	public void replaceitem(Player player, String newItem, int x, int y) 
	{
		 player.playerInventory[x][y] = newItem;
	}
	
	public static String[][] getInventory(Player player) 
	{
		return player.playerInventory;
	}
	
	public static void  main(String[] args)
		{
			//printInventory();
		}

	
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
