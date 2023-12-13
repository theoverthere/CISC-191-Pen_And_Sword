package penAndSword;
import java.util.*;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
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
	private int enemyArmor;
	ImageIcon icon;
	String iconPath;
	//private BufferedImage bg;
	
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
	
	public static int getHordeLength(int key) 
	{
		return theHorde.get(key).size();
	}
	
	//empty constructor to create enemies
//	public Enemy()
//	{
//		super();
//	}
	
	//Parameterized constructor, receives enemy health, damage, name, and level
	public Enemy(int newEnemyHealth, int newEnemyDamage, String newEnemyName, int newEnemyLevel, int newEnemyArmor, String imgPath)
	{
		super();
		this.enemyName = newEnemyName;
		this.enemyHealth = newEnemyHealth;
		this.enemyDamage = newEnemyDamage;
		this.enemyLevel = newEnemyLevel;
		this.enemyArmor = newEnemyArmor;
		this.icon = new ImageIcon(imgPath);
		this.iconPath = imgPath;
//		BufferedImage BGImage = null;
//		try 
//		{
//			BGImage = ImageIO.read(new File(imgPath));
//		} 
//		catch (IOException e) 
//		{
//			e.printStackTrace();
//		}
//		this.bg = BGImage;
		Enemy.addToHorde(newEnemyLevel, this);
	}
	
	//area to create new enemy objects
	static Enemy goblin = new Enemy(1, 1, "goblin", 1, 0, "./Images/goblin.png");
	static Enemy troll = new Enemy(5, 2, "troll", 1, 0, "./Images/troll.png");
	static Enemy bandit = new Enemy(4, 3, "bandit", 1, 0, "./Images/goblin.png");
	static Enemy ghost = new Enemy(2,1,"ghost",1,0,"./Images/goblin.png");
	static Enemy fireArcher = new Enemy(2, 5, "Fire Archer", 2, 0, "./Images/goblin.png");
	static Enemy abomination = new Enemy(5, 3, "abomination",3, 0, "./Images/goblin.png" );
	static Enemy tarnishedKnight = new Enemy(3,3,"tarnished knight", 2, 0,"./Images/goblin.png");

	//required methods
	@Override
	public String getHealth()
	{
		String eHealth = Integer.toString(this.enemyHealth);
		return eHealth;
	}

	@Override
	public void setHealth(int incoming)
	{
		this.enemyHealth = this.enemyHealth - incoming;
	}

	@Override
	public int getDamage()
	{
		return this.enemyDamage;
	}

	@Override
	public void setDamage(int newDamage)
	{
		this.enemyDamage += newDamage;
		
	}

	@Override
	public int getLevel()
	{
		return this.enemyLevel;
	}

	@Override
	public void setLevel()
	{
		this.enemyLevel++;
		
	}

	@Override
	public String getArmor()
	{
		String eArmor = Integer.toString(this.enemyArmor);
		return eArmor;
	}

	@Override
	public void setArmor(int newArmor)
	{
		this.enemyArmor = newArmor;
		
	}
	
	@Override
	public boolean isDead()
	{
		int eHealth = Integer.parseInt(this.getHealth());
		if(eHealth <= 0) 
		{
			return true;
		}
		else 
		{
			return false;
		}
	}
	
	public static String getName(Enemy enemy) 
	{
		return enemy.enemyName;
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
		System.out.println(theHorde.get(1).toString());
		
		//System.out.println(Trivia.getQuestion(0));	
	}



	
		
}
