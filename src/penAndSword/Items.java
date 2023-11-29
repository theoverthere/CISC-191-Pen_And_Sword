package penAndSword;

import java.util.*;
public class Items{

	public static int damageValue=0;
	public static String weaponName="nothing";
	private int healthValue;
	public static int armorValue=0;
	public static String armorName="nothing";
	public static int purse;
	private static int EXP;
	public static boolean backToStore=false;
	public String price2;
	public String price1;
	
	//called in store or after fight when new armor is equipped
public static void equipArmor(int value, String name) {
	armorValue = value;
	armorName = name;
}
public static void armorStatus() {
	System.out.println("++++++++++++++++++++++++");
	System.out.println("equipped armor value: "+armorValue);
	System.out.println("equipped armor name: " +armorName);}
public static void equipTheWeapon(int value, String name) {
	damageValue = value;
	weaponName = name;
}
public static void weaponStatus() {
	System.out.println("++++++++++++++++++++++++");
	System.out.println("equipped weapon damage: "+damageValue);
	System.out.println("equipped weapon name: " +weaponName);}
	
	 //string is the name and key, interger is the damage value or the armor value
		public static HashMap<String, Integer> armor = new HashMap<>(); { //armor for shop
		armor.put("Leather Armor", 3);
		armor.put("Plate Armor", 4);
		armor.put("Steel Armor", 6);
		
		}
	public static HashMap<String, Integer> weapons = new HashMap<>();{ //weapons for shop
		weapons.put("Basic Sword", 1);
		weapons.put("Spear", 2);
		weapons.put("Copper Broadsword", 3);
		weapons.put("Heavy Jade Hammer", 5);
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
		String arm = (String) key;   
		//assigns "arm" to the key and will add the price after checking what type of armor it is
		if (arm.contains("Leather")) {
			price1=" :: price= 1 coins";
		}
		if (arm.contains("Plate")) {
			price1=" :: price= 3 coins";
		}
		if (arm.contains("Steel")) {
			price1=" :: price= 6 coins";
		}
		
		String output = "Armor slot: " + key + " :: Protection " +armor.get(key)+price1;
		//String output = (String) key; //for the string like "leather armor"
		//Integer output = armor.get(key); //for the integer like "3"
 		return output;
	}
	public String getOneWeapon() {
		
		Object[] getArmor = weapons.keySet().toArray();
		Object key = getArmor[new Random().nextInt(getArmor.length)];
		String weap = (String) key;
		//assigns "weap" to the key and will add the price after checking what type of weapon it is
		if (weap.contains("Basic")) {
			price2=" :: price= 2 coins";
		}
		if (weap.contains("Spear")) {
			price2=" :: price= 3 coins";
		}
		if (weap.contains("Broad")) {
			price2=" :: price= 4 coins";
		}
		if (weap.contains("Jade")) {
			price2=" :: price= 6 coins";
		}
		String output = "Weapon slot: " + key + " :: Damage " +weapons.get(key)+price2;
		//String output = (String) key; //for the string like "leather armor"
		//Integer output = armor.get(key); //for the integer like "3"
return output;}
	public static void main(String[] args) {
		

		
		System.out.println(weapons);
	}

		

		public static void levelchecker() {
		//tatement saying "you are now level blah"
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
	public int giveXCoins(int x) {
		return purse = getPurse() + x;
	}

	// takes the first value and minuses it by the second value
	public static boolean Transaction(int m) {
				
				
				if (getPurse() - m < 0) {
					System.out.println("insuficient funds");
					System.out.println("you could not buy the item");
					return false;
				}
					else {
						purse =purse -m;
						System.out.println("You have bought and equipped the item!");
					    System.out.println("you have "+purse+ " coins left in your purse");
						backToStore = true;
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
