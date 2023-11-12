package penAndSword;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

/*
 * The purpose of the boss class is to instantiate boss objects that can be called by other classes in this program
 */
public class Boss extends Enemy{
	//fields
	private int bossHealth;
	private int bossArmor;
	private int bossDamage;
	private int bossLevel;
	private String bossName;
	
	//
	public static List<Boss> bossList = new ArrayList<>();
	
	private static void addBoss(Boss newBoss) 
	{
		bossList.add(newBoss);
	}
	
	public Boss() 
	{
		super();
	}
	
	//Constructor to allow creation of boss objects
	public Boss(int newBossHealth, int newBossDamage, int newBossLevel, String newBossName)
	{
		super(newBossDamage, newBossHealth, newBossName, newBossLevel);
		bossName = newBossName;
		bossHealth = newBossHealth;
		bossDamage = newBossDamage;
		bossLevel = newBossLevel;
		Boss.addBoss(this);
	}
	
	static Boss gorgonTheDestroyer = new Boss(10, 10, 5, "Gorgon the Destroyer");
	
	public static Boss getBoss(int index) 
	{
		return bossList.get(index);
	}
	
	//toString method to display boss object properties
	public String toString()
	{
		return 	"Name: " + bossName + " Health: " + bossHealth + " Damage: " + bossDamage + " Level: "+ bossLevel;
	}
	
	public static void main(String[] args) 
	{
		
		System.out.println(getBoss(0));
	}

}
