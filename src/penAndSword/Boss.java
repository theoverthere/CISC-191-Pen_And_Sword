package penAndSword;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class Boss extends Enemy{
	//fields
	private int bossHealth;
	private int bossArmor;
	private int bossDamage;
	private String bossLevel;
	private String bossName;
	
	//
	private static List<Boss> bossList = new ArrayList<>();
	
	public Boss() 
	{
		super();
	}
	
	//Constructor to allow creation of boss objects
	public Boss(int newBossHealth, int newBossDamage, String newBossLevel, String newBossName)
	{
		super(newBossDamage, newBossHealth, newBossName, newBossLevel);
		bossName = newBossName;
		bossHealth = newBossHealth;
		bossDamage = newBossDamage;
		bossLevel = newBossLevel;
		bossList.add(this);
	}
	
	//toString method to display boss object properties
	public String toString()
	{
		return 	"Name: " + bossName + " Health: " + bossHealth + " Damage: " + bossDamage + " Level: "+ bossLevel;
	}
	
	public static void main(String[] args) 
	{
		Boss gorgonTheDestroyer = new Boss(10, 10, "5", "Gorgon the Destroyer");
		System.out.println(bossList.get(0));
	}

}
