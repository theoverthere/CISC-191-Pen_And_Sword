package penAndSword;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import javax.swing.JEditorPane;

public class Store {

	// populate shop inventory assigns 3 variables to a random armor, a random
	// weapon and a random health potion then it
	// when it takes the input from the console on what it wants to buy it needs to
	// check if they have enough coins
	//
	String armorReturn;
	private static String armorSlot;
	private static String weaponSlot;
	private static String potionSlot;
	public static String transArmor;
	public static String transWeapon;
	public static String transPotion;
	static boolean affordArmor;
	static boolean affordWeapon;
	static boolean affordPotion;

	public static String Constructor1;
	public static String Constructor2;

	public Store() {
		this.Constructor1=greetingsDecider();
		this.Constructor2=populateShopInventory();}

	public static String populateShopInventory() { //makes generates the weapon and armor and sells loot.
		Items shopInv = new Items();
		armorSlot = shopInv.getOneArmor();
		weaponSlot = shopInv.getOneWeapon();
		potionSlot=shopInv.getOnePotion();
		transArmor = armorSlot;
		transWeapon = weaponSlot;
		transPotion = potionSlot;
		
		String generate = "==========================\n"+armorSlot+"\n==========================\n"
		+weaponSlot+"\n==========================\n"+potionSlot+"\nyou currently have " + shopInv.purse + " coins"
		+ "\n 1= Buy armor, 2= Buy weapon,3= Buy Potion, 4= Ask for advice, 5=Leave shop";
		Constructor2=generate;
		return Constructor2;}//pop shop inv does no longer automatically sell loot

	public static String buyPotion() {
		if (transPotion.contains("Tasty")) {
			affordPotion = Items.Transaction(10);
		 if (affordPotion ==true) {
			Items.addPotion("Tasty Health Potion",8);
			return "You have bought and equipped the item! you now have: "+Items.getPurse()+"coins";
				}else {
return "Insuficient funds, you could not Buy the armor";}
		}
		if (transPotion.contains("Standard")) {
			affordPotion = Items.Transaction(5);
			if (affordPotion == true) {
				Items.addPotion("Standard Health Potion", 4);
				return "You have bought and equipped the item! you now have: "+Items.getPurse()+"coins";
				}else {
return "Insuficient funds, you could not Buy the armor";}}
return "something wrong in Potion";
		}
	

	public static String buyArmor() {
		
		// needs multiple if statements for all the possible weapons and armors
		
		if (transArmor.contains("Plate")) {
			affordArmor = Items.Transaction(8);//price for the item
			if (affordArmor == true) {
				Items.equipArmor(4, "Plate Armor");
				return "You have bought and equipped the item! you now have: "+Items.getPurse()+"coins";}
				else {
return "Insuficient funds, you could not Buy the armor";
				}}//equipes the damage and name to items
		if (transArmor.contains("Steel")) {
			affordArmor = Items.Transaction(11);
			if (affordArmor == true) {
				Items.equipArmor(6, "Steel Armor");
				return "You have bought and equipped the item! you now have: "+Items.getPurse()+"coins";}
				else {
return "Insuficient funds, you could not buy the armor";
				}}
		if (transArmor.contains("Leather")) {
			affordArmor = Items.Transaction(5);
			if (affordArmor == true) {
				Items.equipArmor(3, "Leather Armor");
				return "You have bought and equipped the item! you now have: "+Items.getPurse()+"coins";}
				else {
return "Insuficient funds, you could not Buy the armor";
				}}
		if (transArmor.contains("Mith")) {
			affordArmor = Items.Transaction(18);
			if (affordArmor == true) {
				Items.equipArmor(9, "Mithril armor");
				return "You have bought and equipped the item! you now have: "+Items.getPurse()+"coins";}
				else {
return "Insuficient funds, you could not Buy the armor";
				}}
		if (transArmor.contains("Ancient")) {
			affordArmor = Items.Transaction(23);
			if (affordArmor == true) {
				Items.equipArmor(12, "Ancient armor");
				return "You have bought and equipped the item! you now have: "+Items.getPurse()+"coins";}
				else {
return "Insuficient funds, you could not Buy the armor";
				}}
		return "trans armor must be wrong? problem in buy armor";}
		
	public static String buyWeapon() {
		
		Items d = new Items();
		if (transWeapon.contains("Basic")) {
			affordWeapon = d.Transaction(6);
			if (affordWeapon == true) {
				d.equipTheWeapon(2, "Basic Sword");
				return "You have bought and equipped the item! you now have: "+d.getPurse()+"coins";
			}else {
return "Insuficient funds, you could not Buy the armor";}
		}
		if (transWeapon.contains("Spear")) {
			affordWeapon = d.Transaction(8);
			if (affordWeapon == true) {
				d.equipTheWeapon(3, "Spear");
				return "You have bought and equipped the item! you now have: "+d.getPurse()+"coins";
			}else {
return "Insuficient funds, you could not Buy the armor";}
			
		}
		if (transWeapon.contains("Broad")) {
			affordWeapon = d.Transaction(10);
			if (affordWeapon == true) {
				d.equipTheWeapon(5, "Copper Broadsword");
				return "You have bought and equipped the item! you now have: "+d.getPurse()+"coins";
			}else {
return "Insuficient funds, you could not Buy the armor";
			}
		}
		if (transWeapon.contains("Heavy")) {
				affordWeapon = d.Transaction(15);
				if (affordWeapon == true) {
					d.equipTheWeapon(7, "Heavy Jade Hammer");
				return "You have bought and equipped the item! you now have: "+d.getPurse()+"coins";
			}else {
return "Insuficient funds, you could not Buy the armor";
				}
			}
			return "something wrong with weapons not finding a weapon in transWeapon";
		}
	

	// decides the greetings to be says before acessing shop
	public static String greetingsDecider() {

		int dialogue = (int) (Math.random() * 5);// voicelines containing the different greeting
		String voiceLines = new String[] { "its not getting any newer", "Need something?",
				"Do you have coin? if so welcome!", "Hand crafted tools right here!",
				"hello welcome to the dugout care to buy?" }[dialogue];
		return "As you approach the shopkeep says: '" + voiceLines+"'";
	}
public static String leaveShop() {
	return"As you leave the store the shopkeep says: 'Thanks! and good luck...'";
}
public static String shopAdvice() {
	return "In his trading stall you ask the Shopkeep if he has any advice to offer. He answers: 'In these lands, wisdom is as valuable as gold. Its almost always better to try and outsmart your opponent rather than risking having to go toe to giant toe with them." +
	"And remember, a trusty weapon can mean life or death. Thankfully we sell trusty weapons.";
}
//just to show stuff
	public static void main(String[] args) {
		// not permanant just to show the greetings
		System.out.println(greetingsDecider());

		populateShopInventory();
		buyArmor();
	}

}
