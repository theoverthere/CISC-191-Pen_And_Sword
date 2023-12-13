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
	
	public abstract String getHealth();
	
	public abstract void setHealth(int incoming);
	
	public abstract int getDamage();
	
	public abstract void setDamage(int newDamage);
	
	public abstract int getLevel();
	
	public abstract void setLevel();
	
	public abstract String getArmor();
	
	public abstract void setArmor(int newArmor);
	
	public abstract boolean isDead();
		
	}
	
	
	


