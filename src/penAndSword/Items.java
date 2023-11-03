package penAndSword;

import java.util.*;

public class Items {

	private int damageValue;
	private int healthValue;
	private int armorValue;
	private static int EXP;

	public Items() {
		this.damageValue = 0;
		this.healthValue = 0;
		this.armorValue = 0;
	}

	public static HashMap<String, Integer> weapons = new HashMap<>();
	public static HashMap<String, Integer> armor = new HashMap<>(); 
	{
		armor.put("Leather Armor", 3);
		}
	public static HashMap<String, Integer> healthPotion = new HashMap<>();

	public static void main(String[] args) {
		// types of weapons

		weapons.put("Basic Sword", 1);
		weapons.put("spear", 2);
		weapons.put("broadsword", 3);

		System.out.println(weapons);
		// 3 types of armor

		//armor.put("Leather Armor", 3);
		armor.put("Plate Armor", 4);
		armor.put("Steel Armor", 6);

		System.out.println(armor);

		// purpose makes 2 health potions

		healthPotion.put("Standard Health Potion", 4);
		healthPotion.put("tasty Health Potion", 8);

		// the following will check exp and return a statement saying "you are now level
		// blah"
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
		return 1;
	}

	// takes the first value and minuses it by the second value
	public static int takeCoinsAway(int c, int m) {
		return c - m;
	}

	// designate the exp level
	private void putNewExp(int newexp) {
		this.EXP = newexp;
	}

	//public static char[] get(String string)
	//{
		// TODO Auto-generated method stub
		//return null;
	//}

	
	
}
