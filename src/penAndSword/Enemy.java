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
	
	//field for trivia checker:
	private static String newTrivia;
	
	//instantiate data structure to hold created enemies and sort by level
	private static Hashtable<String, List<Enemy>> theHorde = new Hashtable<>();
	//instantiate data structure to hold trivia questions
	private static Hashtable<String, List<String>> triviaQuestions = new Hashtable<>();
	
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
	
	private List<Enemy> copyList(List<Enemy> list) 
	{
		List<Enemy> copyList = (List<Enemy>) ((ArrayList<Enemy>) list).clone();
		return copyList;
	}
	
	//empty constructor to create enemies
	public Enemy()
	{
		super();
		this.enemyHealth = 0;
		this.enemyDamage = 0;
	}
	
	//Parameterized constructor, receives enemy health, damage, name, and level
	public Enemy(int newEnemyHealth, int newEnemyDamage, String newEnemyName, String newEnemyLevel)
	{
		this.enemyHealth = newEnemyHealth;
		this.enemyDamage = newEnemyDamage;
		this.enemyName = newEnemyName;
		this.enemyLevel = newEnemyLevel;
	}
	
	//toString method to print enemy object properties
	public String toString()
	{
		return 	"Name: " + enemyName + " Health: " + enemyHealth + " Damage: " + enemyDamage + " Level: "+ enemyLevel;
	}
	
//	//trivia answers
//	public static void triviaAnswers()
//	{
//		triviaAnswers.add("1891");
//	}
//
//	// trivia answer checker
//	public static void triviaAnswerChecker() 
//	{
//		triviaAnswers.contains(newTrivia) ; 
//		System.out.println("wrong answer");
//	}
	
	public static void main(String[] args)
	{
		Enemy goblin = new Enemy(1, 1, "goblin", "1");
		Enemy troll = new Enemy(5, 2, "troll", "1");
		
		goblin.addToHorde("1", goblin);
		troll.addToHorde("1", troll);
		
		System.out.print(theHorde.get("1").get(0));
		
		
	}
		
}
