package penAndSword;

import java.util.*;

public class Player extends Entities {
//fields
	private int playerHealth;
	private int playerExp;
	private int playerArmor;
	private int playerDamage; // slash weapon
	private int playerMoney;
	private int playerLevel;
	//data structure to hold items that the player finds on their journey
	private List<String> playerInventory = new ArrayList<>();

	
	
//constructor
	public Player() {
		super();
		this.playerHealth = 10;
		this.playerExp = 0;
		this.playerDamage = 1;
		this.playerArmor = 0;
		this.playerMoney = 0;
		this.playerLevel = 1;
	}

//gets player health
	public int getPlayerHealth() {
		return this.playerHealth;
	}

//takes or gives player health
	public void changePlayerHealth(int incoming) {
		this.playerHealth += incoming;
	}

//gets players EXP
	public int getplayerExp() {
		return this.playerExp;
	}

//adds incoming player exp to player exp
	public void changePlayerExp(int newPlayerExp) {
		this.playerExp += newPlayerExp;
	}

//gets player armor
	public int getPlayerArmor() {
		return this.playerArmor;
	}

//replaces the player armor with incoming armor
	public void changePlayerArmor(int newPlayerArmor) { // replaces armor does not increase it
		this.playerArmor = newPlayerArmor;
	}

//returns player money
	public int getPlayerMoney() {
		return this.playerMoney;
	}

//changes player money
	public void changePlayerMoney(int newPlayerMoney) {
		this.playerMoney += newPlayerMoney;
	}

	// gets player damage
	public int returnPlayerDamage() {
		return this.playerDamage;
	}

	// replaces player damage with new player damage
	public void changePlayerDamage(int newPlayerDamage) { // replaces damage does not increase it
		this.playerDamage = newPlayerDamage;
	}

	public static int getPlayerLevel() {
		return this.playerLevel;
	}

	// replaces player damage with new player damage
	public void changePlayerLevel() { // replaces damage does not increase it
		this.playerLevel++;

	}
	public void addToInventory(String newItem) {

		playerInventory.add(newItem);
	}
	public void replaceitem(String newItem,int placement) 
	{
		 playerInventory.set(placement, newItem);
	}
	
	//public String printInventory() 
	{
		 //return System.out.println(this.playerInventory);
	} 
	public static void  main(String[] args)
		{
			//printInventory();
		}
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
