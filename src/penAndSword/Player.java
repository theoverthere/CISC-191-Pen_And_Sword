package penAndSword;
import java.util.*;

/*
 * The player class is responsible for tracking the stats and inventory of the player.
 */
public class Player extends Entities {
//fields
	private static int playerHealth = 10;
	private static int playerExp = 0;
	private static int playerArmor = 0;
	private static int playerDamage = 1; // slash weapon
	private static int playerMoney = 0;
	private static int playerLevel = 1;
	private static String playerName = "";
	public static Player player1;
	//data structure to hold items that the player finds on their journey
	private static List<Items> playerInventory = new ArrayList<>();

	
	
//constructor
	public Player(String newName) 
	{
		super(newName, playerHealth, playerDamage, playerLevel);
		this.playerExp = playerExp;
		this.playerArmor = playerArmor;
		this.playerMoney = playerMoney;	
	}

//gets player health
	public static String getPlayerHealth(Player player) {
		String pHealth = Integer.toString(player.playerHealth);
		return pHealth;
	}

//takes or gives player health
	public void changePlayerHealth(Player player, int incoming) {
		player.playerHealth += incoming;
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
	public static String getPlayerArmor(Player player) {
		String pArmor = Integer.toString(playerArmor);
		return pArmor;
	}

//replaces the player armor with incoming armor
	public void changePlayerArmor(Player player, int newPlayerArmor) { // replaces armor does not increase it
		player.playerArmor = newPlayerArmor;
	}

//returns player money
	public static int getPlayerMoney(Player player) {
		return player.playerMoney;
	}

//changes player money
	public void changePlayerMoney(Player player, int newPlayerMoney) {
		player.playerMoney += newPlayerMoney;
	}

	// gets player damage
	public int getPlayerDamage(Player player) {
		return player.playerDamage;
	}

	// replaces player damage with new player damage
	public void changePlayerDamage(Player player, int newPlayerDamage) { // replaces damage does not increase it
		player.playerDamage = newPlayerDamage;
	}

	public static int getPlayerLevel(Player player) {
		return player.playerLevel;
	}

	// replaces player damage with new player damage
	public void changePlayerLevel(Player player) { // replaces damage does not increase it
		player.playerLevel++;

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

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
