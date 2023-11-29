package penAndSword;
import java.util.*;

/*
 * The player class is responsible for tracking the stats and inventory of the player.
 */
public class Player extends Entities {
//fields
	private static int playerHealth;
	private static int playerExp;
	private static int playerArmor;
	private static int playerDamage; // slash weapon
	private static int playerMoney;
	private static int playerLevel;
	private static String playerName;
	//data structure to hold items that the player finds on their journey
	private static List<Items> playerInventory = new ArrayList<>();

	
	
//constructor
	public Player() {
		super();
		this.playerHealth = 10;
		this.playerExp = 0;
		this.playerDamage = 1;
		this.playerArmor = 0;
		this.playerMoney = 0;
		this.playerLevel = 1;
		this.playerName = "";
	}
	
	public static Player player1 = new Player();

//gets player health
	public int getPlayerHealth() {
		return this.playerHealth;
	}

//takes or gives player health
	public void changePlayerHealth(int incoming) {
		player1.playerHealth += incoming;
	}

//gets players EXP
	public static int getplayerExp() {
		return player1.playerExp;
	}

//adds incoming player exp to player exp
	public void changePlayerExp(int newPlayerExp) {
		player1.playerExp += newPlayerExp;
	}

//gets player armor
	public static int getPlayerArmor() {
		return player1.playerArmor;
	}

//replaces the player armor with incoming armor
	public void changePlayerArmor(int newPlayerArmor) { // replaces armor does not increase it
		player1.playerArmor = newPlayerArmor;
	}

//returns player money
	public static int getPlayerMoney() {
		return player1.playerMoney;
	}

//changes player money
	public void changePlayerMoney(int newPlayerMoney) {
		player1.playerMoney += newPlayerMoney;
	}

	// gets player damage
	public int getPlayerDamage() {
		return player1.playerDamage;
	}

	// replaces player damage with new player damage
	public void changePlayerDamage(int newPlayerDamage) { // replaces damage does not increase it
		player1.playerDamage = newPlayerDamage;
	}

	public static int getPlayerLevel() {
		return player1.playerLevel;
	}

	// replaces player damage with new player damage
	public void changePlayerLevel() { // replaces damage does not increase it
		player1.playerLevel++;

	}
	public void addToInventory(Items newItem) {

		playerInventory.add(newItem);
	}
	public void replaceitem(Items newItem,int placement) 
	{
		 playerInventory.set(placement, newItem);
	}
	
	public static List<Items> getInventory() 
	{
		return playerInventory;
	}
	
	public static void  main(String[] args)
		{
			//printInventory();
		}
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
