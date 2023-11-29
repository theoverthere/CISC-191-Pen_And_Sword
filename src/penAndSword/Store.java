package penAndSword;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Store {

	// populate shop inventory assigns 3 variables to a random armor, a random
	// weapon and a random health potion then it
	// when it takes the input from the console on what it wants to buy it needs to
	// check if they have enough coins
	//
	private static String armorSlot;
	private static String weaponSlot;
	public static String transArmor;
	public static String transWeapon;

	static boolean affordArmor;
	static boolean affordWeapon;

	public static void populateShopInventory() {
		Items shopInv = new Items();
		HashMap<String, Integer> armors = shopInv.getarmorsMap1();
		// System.out.println(armors);

		// HashMap<String, Integer> shopInventory = new HashMap<>();
		armorSlot = shopInv.getOneArmor();
		weaponSlot = shopInv.getOneWeapon();

		transArmor = armorSlot;
		transWeapon = weaponSlot;
		System.out.println("==========================");
		System.out.println(armorSlot);
		System.out.println("==========================");
		System.out.println(weaponSlot);
		System.out.println("==========================");
		System.out.println("you currently have " + shopInv.purse + " coins");
	}

	// buy method needs to call the trasaction method in items and needs to somehow
	// give a price to the armor value and weapon value
	// this would be called when the player decides to buy the Armor ->

	public static void buyArmor() {
		// needs multiple if statements for all the possible weapons and armors
		Items s = new Items();
		if (transArmor.contains("Plate")) {
			affordArmor = s.Transaction(3);
			if (affordArmor == true) {
				s.equipArmor(4, "Plate Armor");
			}
		}
		if (transArmor.contains("Steel")&&s.armorName!="Steel Armor") {
			affordArmor = s.Transaction(6);
			if (affordArmor == true) {
				s.equipArmor(6, "Steel Armor");
			}
		}
		if (transArmor.contains("Leather")&&s.armorName!="Leather Armor") {
			affordArmor = s.Transaction(1);
			if (affordArmor == true) {
				s.equipArmor(3, "Leather Armor");
			}
		}
	}

	public static void buyWeapon() {
		// needs multiple if statements for all the possible weapons and armors
		Items d = new Items();
		if (transWeapon.contains("Basic")) {
			affordWeapon = d.Transaction(2);
			if (affordWeapon == true) {
				d.equipTheWeapon(1, "Basic Sword");
			}
		}
		if (transWeapon.contains("Spear")) {
			affordWeapon = d.Transaction(3);
			if (affordWeapon == true) {
				d.equipTheWeapon(2, "Spear");
			}
		}
		if (transWeapon.contains("Broad")) {
			affordWeapon = d.Transaction(4);
			if (affordWeapon == true) {
				d.equipTheWeapon(3, "Copper Broadsword");
			}
		}
		if (transWeapon.contains("Heavy")) {
				affordWeapon = d.Transaction(6);
				if (affordWeapon == true) {
					d.equipTheWeapon(5, "Heavy Jade Hammer");
				}
			}
		}
	

	// decides the greetings to be says before acessing shop
	public static String greetingsDecider() {

		int dialogue = (int) (Math.random() * 5);// voicelines containing the different greeting
		String voiceLines = new String[] { "its not getting any newer", "Need something?",
				"Do you have coin? if so welcome!", "Hand crafted tools right here!",
				"hello welcome to the dugout care to buy?" }[dialogue];
		return "As you approach the shopkeep says: '" + voiceLines+"'";
	}
public static void leaveShop() {
	System.out.println("As you leave the store the shopkeep says: 'Thanks! and good luck...'");
}
public static void shopAdvice() {
	System.out.println("In his trading stall you ask the Shopkeep if he has any advice to offer. He answers:"
			+ " 'In these lands, wisdom is as valuable as gold.");
	System.out.println("Its almost always better to try and outsmart your "
			+ "opponent rather than risking having to go toe to giant toe with them.");
	System.out.println( "And remember, a trusty weapon can mean life or death. "
			+ "Thankfully we sell trusty weapons.'");
}
//just to show stuff
	public static void main(String[] args) {
		// not permanant just to show the greetings
		System.out.println(greetingsDecider());

		populateShopInventory();
		buyArmor();
	}

}
