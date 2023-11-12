package penAndSword;
import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * The purpose of the enemy class is to provide the capability to instantiate enemy objects, organize them by
 * level, and have these enemy objects be accessed by other classes
 */
public class Enemy extends Entities{
	//fields for values necessary to create enemy objects
	private int enemyHealth;
	private int enemyDamage;
	private String enemyName;
	private int enemyLevel;
	
	//instantiate data structure to hold created enemies and sort by level
	public static Hashtable<Integer, List<Enemy>> theHorde = new Hashtable<>();
	
	/*
	 * Purpose: adds enemy objects to proper place in "theHorde" hashtable. 
	 * Enemies should be added to list by level.
	 * 
	 * @param: String newEnemyLevel (key for hashtable)
	 * @param: Enemy newEnemyName
	 */
	public static void addToHorde(int newEnemyLevel, Enemy newEnemyName)
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
	public static List<Enemy> copyList(List<Enemy> list) 
	{
		List<Enemy> copyList = (List<Enemy>) ((ArrayList<Enemy>) list).clone();
		return copyList;
	}
	
	//area to create new enemy objects
	static Enemy goblin = new Enemy(1, 1, "goblin", 1);
	static Enemy troll = new Enemy(5, 2, "troll", 1);
	static Enemy fireArcher = new Enemy(2, 5, "Fire Archer", 2);
	
	public static int getHordeLength(int key) 
	{
		return theHorde.get(key).size();
	}
	
	//empty constructor to create enemies
	public Enemy()
	{
		super();
	}
	
	//Parameterized constructor, receives enemy health, damage, name, and level
	public Enemy(int newEnemyHealth, int newEnemyDamage, String newEnemyName, int newEnemyLevel)
	{
		super(newEnemyName, newEnemyHealth, newEnemyDamage, newEnemyLevel);
		enemyName = newEnemyName;
		enemyHealth = newEnemyHealth;
		enemyDamage = newEnemyDamage;
		enemyLevel = newEnemyLevel;
		Enemy.addToHorde(newEnemyLevel, this);
	}
	
	//toString method to print enemy object properties
	@Override
	public String toString()
	{
		return 	"Name: " + enemyName + " Health: " + enemyHealth + " Damage: " + enemyDamage + " Level: "+ enemyLevel;
	}
	
	public static void main(String[] args)
	{
		System.out.println(theHorde.get(2).get(0).toString());
		
		System.out.println(Trivia.getQuestion(0));	
	}
		
}
