package penAndSword;

import java.util.*;
public class Items{

	private int damageValue;
	private int healthValue;
	private int armorValue;
	private static int purse;
	private static int EXP;

	public Items() {
		this.damageValue = 0;
		this.healthValue = 0;
		this.armorValue = 0;
		
	}


	
	 //string is the name and key, interger is the damage value or the armor value
		public static HashMap<String, Integer> armor = new HashMap<>(); {
		armor.put("Leather Armor", 3);
		armor.put("Plate Armor", 4);
		armor.put("Steel Armor", 6);
		}
	public static HashMap<String, Integer> weapons = new HashMap<>();{
		weapons.put("Basic Sword", 1);
		weapons.put("spear", 2);
		weapons.put("broadsword", 3);
	}
	public static HashMap<String, Integer> healthPotion = new HashMap<>(); {
		healthPotion.put("Standard Health Potion", 4);
		healthPotion.put("tasty Health Potion", 8);
	}

	 // 3 types of armor
	public HashMap<String, Integer> getarmorsMap1() {
        return armor;
	}
	public String getOneArmor() {
		Object[] getArmor = armor.keySet().toArray();
		Object key = getArmor[new Random().nextInt(getArmor.length)];
		
		String output = "armor slot: " + key + "::" +armor.get(key);
		//String output = (String) key; //for the string like "leather armor"
		//Integer output = armor.get(key); //for the integer like "3"
 		return output;
	}
	public String getOneWeapon() {
		Object[] getArmor = weapons.keySet().toArray();
		Object key = getArmor[new Random().nextInt(getArmor.length)];
		
		String output = "weapon slot: " + key + "::" +weapons.get(key);
		//String output = (String) key; //for the string like "leather armor"
		//Integer output = armor.get(key); //for the integer like "3"
 		return output;
	}
	/**
	public Integer getOneArmor() {
		Object[] getArmor = armor.keySet().toArray();
		Object key = getArmor[new Random().nextInt(getArmor.length)];
		
		//String output = "armor value: " + key + "::" +armor.get(key);
		Integer output = armor.get(key);
		return output;
	}
	*/

	// types of weapons
		

		
	
	public static void main(String[] args) {
		

		
		System.out.println(weapons);
		

		

		//System.out.println(armor);

		// purpose makes 2 health potions

		

		
		
		
		// the following will check exp and return a statement saying "you are now level blah"
		if (EXP == 5) {
			System.out.println("you are now level 1");
		}
		if (EXP == 10) {
			System.out.println("you are now level 2");
		}
		if (EXP == 15) {
			System.out.println("you are now level 3");
			
			
		}
	}

	// just gives one coin
	public int giveOneCoin() {
		return purse = getPurse() + 1;
	}

	// takes the first value and minuses it by the second value
	public static boolean Transaction(int m) {
				
				
				if (getPurse() - m < 0) {
					System.out.println("You are out of money");
					return false;
				}
					else
					{
						purse -= m;
						return true;
						
					}
				
				
				}
	

	// designate the exp level
	private void putNewExp(int newexp) {
		this.EXP = newexp;
	}

	public static int getPurse() {
		return purse;
	}

	
	
}




