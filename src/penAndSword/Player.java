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
	public static Player player1 = new Player("Duncan");
 int levelCounter;
	//data structure to hold items that the player finds on their journey
	private static List<Items> playerInventory = new ArrayList<>();

	
	
//constructor
	public Player(String newName) 
	{
		super();
		this.playerName = newName;
		this.playerHealth = 10;
		this.playerDamage = 5;
		this.playerLevel = 1;
		this.playerExp = 0;
		this.playerArmor = 5;
		this.playerMoney = 0;
		this.levelCounter = 0;
	}
	
	public String getName() 
	{
		return this.playerName;
	}

//gets player health
	@Override
	public String getHealth() 
	{
		String pHealth = Integer.toString(this.playerHealth);
		return pHealth;
	}

//takes or gives player health
	@Override
	public void setHealth(int incoming) 
	{
		this.playerHealth += incoming;
	}

//gets players EXP
	public static int getplayerExp(Player player) 
	{
		return player.playerExp;
	}

//adds incoming player exp to player exp
	public void changePlayerExp(Player player, int newPlayerExp) {
		player.playerExp += newPlayerExp;
	}

//gets player armor
	@Override
	public String getArmor() {
		String pArmor = Integer.toString(this.playerArmor);
		return pArmor;
	}

//replaces the player armor with incoming armor
	@Override
	public void setArmor(int newArmor) 
	{ 
		this.playerArmor = newArmor;
	}

//returns player money
	public static int getPlayerMoney(Player player) {
		return player.playerMoney;
	}

//changes player money
	public void changePlayerMoney(Player player, int newPlayerMoney) 
	{
		player.playerMoney += newPlayerMoney;
	}

	// gets player damage
	@Override
	public int getDamage() 
	{
		return this.playerDamage;
	}

	// replaces player damage with new player damage
	@Override
	public void setDamage(int newDamage) 
	{ 
		this.playerDamage += newDamage;
	}

	@Override
	public int getLevel() 
	{
		return this.playerLevel;
	}
	
	@Override
	public void setLevel() 
	{ 
		this.playerLevel++;

	}
	public void addToInventory(Player player, Items newItem) {

		player.playerInventory.add(newItem);
	}
	public void replaceitem(Player player, Items newItem, int placement) 
	{
		 player.playerInventory.set(placement, newItem);
	}
	
	public static List<Items> getInventory(Player player) 
	{
		return player.playerInventory;
	}
	
	public static void  main(String[] args)
		{
			//printInventory();
		}
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
