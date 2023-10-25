package penAndSword;

public class Boss extends Enemy{
	//fields
	private int bossHealth;
	private int bossArmor;
	private int bossDamage;
	private int bossLevel;
	private String bossName;
	
	//empty boss contructor
	public Boss()
	{
		super();
	}
	
	//Parameterized boss constructor
	public Boss(int newBossHealth, int newBossArmor, int newBossDamage, int newBossLevel, String newBossName)
	{
		this.bossHealth = newBossHealth;
		this.bossArmor = newBossArmor;
		this.bossDamage = newBossDamage;
		this.bossLevel = newBossLevel;
		this.bossName = newBossName;
	}
	
	//toString method to display boss object properties
	public String toString()
	{
		return 	"Name: " + bossName + " Health: " + bossHealth + " Damage: " + bossDamage + " Level: "+ bossLevel;
	}

}
