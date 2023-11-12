package penAndSword;
import java.util.*;

/*
 * The purpose of the entity class is to define the basic parameters that the player will have along with 
 * what the enemies and bosses will have
 */
abstract class Entities {
	//fields 
	private int health;
	private String name;
	private int damage;
	private int money;
	private int experience;
	private int level;
	private int armor;
	
	//empty constructor for values that all entities must have
	public Entities()
	{
		this.health = 0;
		this.damage = 0;
		this.level = 0;
		this.armor = 0;
	}
	
	public Entities(String name, int health, int damage, int level) 
	{
		this.name = name;
		this.health = health;
		this.damage = damage;
		this.level = level;
	}
	
	//abstract method for combat, will calculate damage done during one turn of combat
	public void combat(int playerHealth, int playerDamage, int playerArmor, int enemyHealth, int enemyDamage)
	{
		
	}
	
	//abstract method to calculate the players damage values during combat
	public void playerDamage(String playerWeapon, int playerDamage)
	{
		
	}
	
	//abstract method to calculate players level
	public void levelCounter(int playerLevel, int xpDrop)	
	{
		
	}
	
	//abstract method to calculate what amount of xp and which items an enemy drops on defeat
	public void dropsDecider()
	{
		
	}
	
	
	

}
