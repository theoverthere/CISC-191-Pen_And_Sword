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
	private int enemyLevel;
	//field for trivia checker:
	private static String newTrivia;
	
	//data structure to hold created enemies and sort by level
	private Hashtable<String, List<String>> theHorde = new Hashtable<>();
	private static List<String> triviaAnswers = new ArrayList<>();
	
	//empty constructor to create enemies
	public Enemy()
	{
		super();
		this.enemyHealth = 0;
		this.enemyDamage = 0;
	}
	
	//Parameterized constructor, receives enemy health, damage, name, and level
	public Enemy(int newEnemyHealth, int newEnemyDamage, String newEnemyName, int newEnemyLevel)
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
	
	public void main(String[] args) throws IOException{
		Enemy goblin = new Enemy();
		Enemy troll = new Enemy(5, 2, "troll", 1);
		
		System.out.println("hello");
		System.out.println(goblin);
		System.out.println(troll);
		
		
		        
		    {
		        // Enter data using BufferReader
		        BufferedReader reader = new BufferedReader(
		            new InputStreamReader(System.in));
		 
		        // Reading data using readLine
		        this.newTrivia = reader.readLine(); }
		
	}
	//trivia answers
	public static void triviaAnswers() {
		
		triviaAnswers.add("1891");
	} 
		
	
	
	//trivia answer checker
	public static void triviaAnswerChecker() {
		 triviaAnswers.contains(newTrivia) ; {
			
			 System.out.println("wrong answer");
		}
	}
}
