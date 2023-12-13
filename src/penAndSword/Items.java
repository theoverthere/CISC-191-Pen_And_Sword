package penAndSword;

import java.util.*;
public class Items{
	
	public static int damageValue = 0;
	public static String weaponName = "No weapon";
	private int healthValue;
	public static int armorValue = 0;
	public static String armorName = "No armor";
	public static int purse;
	private static int EXP;
	public static boolean backToStore = false;
	public String price2;
	public String price1;
	static String loot;
	static int lootValue;
	// strings to hold loot name in 5 slots
	static ArrayList inventoryLootString = new ArrayList(5);
    
	// integers to hold monetary values
	static ArrayList inventoryLootValue = new ArrayList(5);
	//itegers to show potion you have 
	static int potionValue=0;
	//queue to show the names of the potions
	static String potionName="No Potion";
	
	 static Queue<String> armorQueueName = new LinkedList<>();
	
	//called in store or after fight when new armor is equipped
public static void equipArmor(int value, String name) {
		armorValue = value;
		armorName = name;
		
		GUIController.player1.setArmor(value);
		//something wrong here
		armorQueueName.poll();
		armorQueueName.add(name);
		}

public static void armorStatus() {
	System.out.println("++++++++++++++++++++++++");
	System.out.println("equipped armor value: "+armorValue);
	System.out.println("equipped armor name: " +armorName);}
	public static String getArmorStats() {
		return armorName+" protection: "+armorValue;
	}
public static void equipTheWeapon(int value, String name) {
	damageValue = value;
	weaponName = name;
	
	GUIController.player1.setDamage(value);
}
public static void weaponStatus() {
	System.out.println("++++++++++++++++++++++++");
	System.out.println("equipped weapon damage: "+damageValue);
	System.out.println("equipped weapon name: " +weaponName);}
	public static String getWeaponStats() {
		return weaponName+" Damage: "+damageValue;
	}
	 //string is the name and key, interger is the damage value or the armor value
		public static HashMap<String, Integer> armor = new HashMap<>();
	{ // armor for shop
		armor.put("Leather Armor", 3);
		armor.put("Plate Armor", 4);
		armor.put("Steel Armor", 6);
		armor.put("Mithril Armor", 9);
		armor.put("Ancient Armor", 12);
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
		// assigns "arm" to the key and will add the price after checking what type of
		// armor it is
		if (arm.contains("Leather")) {
			price1 = " :: price= 5 coins";
		}
		if (arm.contains("Plate")) {
			price1 = " :: price= 8 coins";
		}
		if (arm.contains("Steel")) {
			price1 = " :: price= 11 coins";
		}
		if (arm.contains("Mith")) {
			price1 = " :: price= 18 coins";
		}
		if (arm.contains("Ancient")) {
			price1 = " :: price= 23 coins";
			
		}

		String output = "Armor slot: " + key + " :: Protection " + armor.get(key) + price1;
		// String output = (String) key; //for the string like "leather armor"
		// Integer output = armor.get(key); //for the integer like "3"
		return output;
	}

	public String getOneWeapon() {

		Object[] getArmor = weapons.keySet().toArray();
		Object key = getArmor[new Random().nextInt(getArmor.length)];
		String weap = (String) key;
		// assigns "weap" to the key and will add the price after checking what type of
		// weapon it is
		if (weap.contains("Basic")) {
			price2 = " :: price= 6 coins";
		}
		if (weap.contains("Spear")) {
			price2 = " :: price= 8 coins";
		}
		if (weap.contains("Broad")) {
			price2 = " :: price= 10 coins";
		}
		if (weap.contains("Jade")) {
			price2 = " :: price= 15 coins";
		}
		String output = "Weapon slot: " + key + " :: Damage " + weapons.get(key) + price2;
		// String output = (String) key; //for the string like "copper Broadsword"
		// Integer output = armor.get(key); //for the integer like "3"
		return output;}
		
		public static String getOnePotion() {
		
		if (GUIController.player1.getLevel() > 10) {
			return "Tasty Health Potion :: Health 8 :: Price 10";
		}else return "Standard Health Potion:: Health 4 ::Price 5";
	}
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
	public static int giveXCoins(int x) {
		return purse = getPurse() + x;
	}
	public static int replaceXCoins(int x) {
		purse = x;
		return purse;
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
	public static void regularAfterBattleLoot() {
		final HashMap<String, Integer> poorCoins = new HashMap<>();
		{
			poorCoins.put("Small pouch of coins", 2);
			poorCoins.put("Large stash of silver", 4);
			poorCoins.put("Bronze trophy", 1);
			poorCoins.put("Snail", 0);
			poorCoins.put("Silver platter", 3);
			poorCoins.put("Small idol of Xampthe the keyholder", 4);
			poorCoins.put("Fork", 0);
			poorCoins.put("Soldier rations",2);
			poorCoins.put("American coin",1);
			poorCoins.put("Gold nugget",2);
			poorCoins.put("Broken sword handle",0);
			poorCoins.put("Paper clip",0);
			poorCoins.put("Fake jade ring", 1);
			//more valuable and rare
			poorCoins.put("Erdtree seed", 5);
			poorCoins.put("Magic beans", 5);
			poorCoins.put("Elder scroll", 6);
			poorCoins.put("Golden Grasshopper", 7);
		}
		if (poorCoins.isEmpty()) {
			throw new IllegalArgumentException("HashMap is empty");
		}
		if (GUIController.player1.getLevel() >= 1) {
			int lootIndex = (int) (Math.random() * 5);

			Object[] getLoot = poorCoins.keySet().toArray();

			Object key = getLoot[new Random().nextInt(getLoot.length)];
			loot = (String) key;
			lootValue = poorCoins.get(key);
			inventoryLootString.add(loot);
			inventoryLootValue.add(lootValue);
		}

	}
	public static void printAfterBattleLoot() { // ment to be used after the battle of regular enemies, will print out
												// everything won
		for (int i = 0; i < inventoryLootString.size(); i++) {
			System.out.print("You have found a " + inventoryLootString.get(i));
			System.out.print(" worth: " + inventoryLootValue.get(i) + " coin(s)");
			System.out.println();
		}
	}
	public static void sellLoot() {
		 int totalValue = 0;
		for (int i = 0; i < inventoryLootString.size(); i++) {
			totalValue = totalValue + (int) inventoryLootValue.get(i);
			giveXCoins(totalValue);
			System.out.println("you have sold: " + inventoryLootString.get(i) + " you now have " + purse + " coin(s)");

			inventoryLootString.remove(i);// will remove the loot at the index i
			inventoryLootValue.remove(i);
			totalValue = 0;
			i--;
		}

	}
	public static void printLootInInventory() {// ment to be held in a box in the main GUI to show player loot
		for (int i = 0; i < inventoryLootString.size(); i++) {
			System.out.println("loot: " + inventoryLootString.get(i) + " worth: " + inventoryLootValue.get(i));
		}
	}
	
	public static String getPlayerToString() {// returns a tostring version of the loot
		String Ret = inventoryLootString.toString();
		return Ret;
	}

	public static String getPlayerLootAt(int i) {// retruns loot at a certain point
		String nothing = "nothing";
		if (inventoryLootString.get(i) == null) {// major problem cant call an index if there is nothing at the index
			return nothing;
		}else {
		String Val1 = (String) inventoryLootString.get(i);
		int val2 = (int) inventoryLootValue.get(i);
		return "loot: " + Val1 + " worth: " + val2 + " coin(s).";
		}
	}
	public static void printPlayerLoot() { 
		for (int i=0; i<inventoryLootString.size(); i++) {
			
			 System.out.println(inventoryLootString.get(i));
			 System.out.print("Worth: " + inventoryLootValue.get(i)+"Coin(s)");
		}
		
		
	}
	public static void addPotion(String name, int healthValue) {
		if (potionName ==null &&potionValue ==0) {
			potionName=name;
			potionValue=healthValue;
		}
		
		
		
	}
	public static String usePotion() {
		if (potionName !=null &&potionValue !=0) {
		GUIController.player1.setHealth(getPotionValue());
		potionName=null;
		potionValue=0;
		return "potion used";
		}else {
			return "No health Potion";
		}
	
}
public static int getPotionValue() {
			return potionValue;
		}
		public static String getPotion() {
			return potionName+" Health: " +potionValue;
		}
}
