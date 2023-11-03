package penAndSword;
import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Enemy extends Entities{
	//fields for values necessary to create enemy objects
	private int enemyHealth;
	private int enemyDamage;
	private String enemyName;
	private String enemyLevel;
	
	//instantiate data structure to hold created enemies and sort by level
	private static Hashtable<String, List<Enemy>> theHorde = new Hashtable<>();
	
	/*
	 * Purpose: adds enemy objects to proper place in "theHorde" hashtable. 
	 * Enemies should be added to list by level.
	 * 
	 * @param: String newEnemyLevel (key for hashtable)
	 * @param: Enemy newEnemyName
	 */
	public void addToHorde(String newEnemyLevel, Enemy newEnemyName)
	{
		if(!theHorde.containsKey(newEnemyLevel)) 
		{
			List<Enemy> newList = new ArrayList<>();
			newList.add(newEnemyName);
			theHorde.put(newEnemyLevel, copyList(newList));	
		}
		else 
		{
		theHorde.get(newEnemyLevel).add(newEnemyName);
		}
	}
	
	//copyList constructor
	private List<Enemy> copyList(List<Enemy> list) 
	{
		List<Enemy> copyList = (List<Enemy>) ((ArrayList<Enemy>) list).clone();
		return copyList;
	}
	
	//empty constructor to create enemies
	public Enemy()
	{
		super();
	}
	
	//Parameterized constructor, receives enemy health, damage, name, and level
	public Enemy(int newEnemyHealth, int newEnemyDamage, String newEnemyName, String newEnemyLevel)
	{
		super(newEnemyName, newEnemyHealth, newEnemyDamage, newEnemyLevel);
		enemyName = newEnemyName;
		enemyHealth = newEnemyHealth;
		enemyDamage = newEnemyDamage;
		enemyLevel = newEnemyLevel;
		this.addToHorde(newEnemyLevel, this);
	}
	
	//toString method to print enemy object properties
	public String toString()
	{
		return 	"Name: " + enemyName + " Health: " + enemyHealth + " Damage: " + enemyDamage + " Level: "+ enemyLevel;
	}
	
	public static void main(String[] args)
	{
		Enemy goblin = new Enemy(1, 1, "goblin", "1");
		Enemy troll = new Enemy(5, 2, "troll", "1");
		Enemy fireArcher = new Enemy(2, 5, "Fire Archer", "2");
		
		
		System.out.println(theHorde.get("2").get(0).toString());
		Trivia test = new Trivia("What number am I thinking of?", "1", "2", "3", "4", 3);
		System.out.println(Trivia.getQuestion(0));
		//System.out.println(Items.armor.get("Leather Armor"));
		
		
	}
		
}
