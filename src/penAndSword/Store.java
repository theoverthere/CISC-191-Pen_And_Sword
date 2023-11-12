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
	
	static boolean affordArmor;

	public static void populateShopInventory() {
		Items shopInv = new Items();
		HashMap<String, Integer> armors = shopInv.getarmorsMap1();
		// System.out.println(armors);

		// HashMap<String, Integer> shopInventory = new HashMap<>();
		armorSlot = shopInv.getOneArmor();
		weaponSlot = shopInv.getOneWeapon();
		
		transArmor =armorSlot;
		

		System.out.println(armorSlot);
		System.out.println(weaponSlot);
	}

	// buy method needs to call the trasaction method in items and needs to somehow
	// give a price to the armor value and weapon value
	//this would be called when the player decides to buy the Armor ->
	public static void buyArmor() 
	{
		//needs multiple if statements for all the possible weapons and armors
		Items s = new Items();
		
		if(transArmor == "armor slot: Plate Armor::4"){
			
			affordArmor = s.Transaction(5);
			System.out.println("you bought the Plate Armor");
		}
		if(transArmor == "armor slot: Steel Armor::6"){
			
			affordArmor = s.Transaction(8);
			System.out.println("You Bought The Steel Armor");
		}
		if(transArmor == "armor slot: Leather Armor::3"){
			
			affordArmor = s.Transaction(3);
			System.out.println("You Bought The Leather Armor");
			
			if (transArmor == null) {
				System.out.println("idk");
			}
		}	
		
	}

	// decides the greetings to be says before acessing shop
	public static String greetingsDecider() {

		int r = (int) (Math.random() * 5);// voicelines containing the different greeting
		String voiceLines = new String[] { "its not getting any newer", "Need something?",
				"Do you have coin? if so welcome!", "Hand crafted tools right here!",
				"hello welcome to the dugout care to buy?" }[r];
		return "as you approach the shopkeep says: " + voiceLines;
	}

	public static void main(String[] args) {
		// not permanant just to show the greetings
		System.out.println(greetingsDecider());

		populateShopInventory();
		buyArmor();
	}

}
