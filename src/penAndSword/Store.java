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

	public static String Constructor1;
	public static String Constructor2;

	public Store() {
		this.Constructor1=greetingsDecider();
		this.Constructor2=populateShopInventory();}

	public static String populateShopInventory() { //makes generates the weapon and armor and sells loot.
		Items shopInv = new Items();
		armorSlot = shopInv.getOneArmor();
		weaponSlot = shopInv.getOneWeapon();
		transArmor = armorSlot;
		transWeapon = weaponSlot;
		String generate = "==========================/n"+armorSlot+"/n==========================/n"+
				weaponSlot+"==========================/n"+"==========================/n"+"you currently have " + shopInv.purse + " coins";
		System.out.println("==========================");
		System.out.println(armorSlot);
		System.out.println("==========================");
		System.out.println(weaponSlot);
		System.out.println("==========================");
		System.out.println("you currently have " + shopInv.purse + " coins");
		Items.sellLoot();
		Constructor2=generate;
		return Constructor2;}

	// buy method needs to call the trasaction method in items and needs to somehow
	// give a price to the armor value and weapon value
	// this would be called when the player decides to buy the Armor ->

	public static void buyArmor() {
		// needs multiple if statements for all the possible weapons and armors
		Items s = new Items();
		if (transArmor.contains("Plate")) {
			affordArmor = s.Transaction(8);//price for the item
			if (affordArmor == true) {
				s.equipArmor(4, "Plate Armor");}}//equipes the damage and name to items
		if (transArmor.contains("Steel")) {
			affordArmor = s.Transaction(11);
			if (affordArmor == true) {
				s.equipArmor(6, "Steel Armor");}}
		if (transArmor.contains("Leather")) {
			affordArmor = s.Transaction(5);
			if (affordArmor == true) {
				s.equipArmor(3, "Leather Armor");}}
		if (transArmor.contains("Mith")) {
			affordArmor = s.Transaction(18);
			if (affordArmor == true) {
				s.equipArmor(9, "Mithril armor");}}
		if (transArmor.contains("Ancient")) {
			affordArmor = s.Transaction(23);
			if (affordArmor == true) {
				s.equipArmor(12, "Ancient armor");}}}
		
	public static void buyWeapon() {
		
		Items d = new Items();
		if (transWeapon.contains("Basic")) {
			affordWeapon = d.Transaction(6);
			if (affordWeapon == true) {
				d.equipTheWeapon(2, "Basic Sword");
			}
		}
		if (transWeapon.contains("Spear")) {
			affordWeapon = d.Transaction(8);
			if (affordWeapon == true) {
				d.equipTheWeapon(3, "Spear");
			}
		}
		if (transWeapon.contains("Broad")) {
			affordWeapon = d.Transaction(10);
			if (affordWeapon == true) {
				d.equipTheWeapon(5, "Copper Broadsword");
			}
		}
		if (transWeapon.contains("Heavy")) {
				affordWeapon = d.Transaction(15);
				if (affordWeapon == true) {
					d.equipTheWeapon(7, "Heavy Jade Hammer");
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
