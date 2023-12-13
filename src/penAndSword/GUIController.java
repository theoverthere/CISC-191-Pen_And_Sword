package penAndSword;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EmptyStackException;
import java.util.List;
/*
 * Purpose: This class will handle execution of code when a button in the GUI is pressed
 */
import java.util.Random;

import javax.swing.JEditorPane;

import penAndSword.GUIController.BeginScreenHandler;

public class GUIController  
	{
		static public Player player1 = new Player("Player Name");

		public class TitleScreenHandler implements ActionListener
		{
			public void actionPerformed(ActionEvent event) 
			{
				GUIView.createIntroScreen();
			}
	}

	public static class IntroScreenHandler implements ActionListener 
	{
		public void actionPerformed(ActionEvent event) 
		{
			GUIView.eraseIntroScreen();
			GUIView.createBeginScreen();
		}
	}
	
	public static class BeginScreenHandler implements ActionListener
	{
		
		public static Dungeon theDungeon;
		public static Store theShop;

		@Override
		public void actionPerformed(ActionEvent e)
		{
			GUIView.beginFrame.dispose();
			player1 = new Player(GUIView.nameInput.getText());
			//here
			
			Items.inventoryLootString.add("nothing"); Items.inventoryLootValue.add(0);
			Items.inventoryLootString.add("nothing"); Items.inventoryLootValue.add(0);
			Items.inventoryLootString.add("nothing");Items.inventoryLootValue.add(0);
		    Items.inventoryLootString.add("nothing");Items.inventoryLootValue.add(0);
			Items.inventoryLootString.add("nothing");Items.inventoryLootValue.add(0);



			theDungeon = LevelExplorer.nextLevel();
			//theShop = LevelExplorer.nextShop();
			GUIView.createMainScreen();
			PlayerOptions.dungeonOptions(theDungeon);
			
		}
		
		public static void reRoll() 
		{
			LevelExplorer.setIsLevelChooser(true);
			GUIView.instructionText.setText("Where would you like to go next?");
			GUIView.mainFrame.dispose();
			GUIView.createMainScreen();	
			
			GUIView.riddleCombatText.setText("Press 1 for next dungeon \nPress 2 for the shop");
		}
		
		public static void newDungeon() 
		{
			theDungeon = LevelExplorer.nextLevel();
		}
		
		public static void newShop() 
		{
			theShop = LevelExplorer.nextShop();
		}
		
		
	}
	
	public static class submitListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			String input = GUIView.playerInputField.getText();
			Random rand = new Random();
			int random = rand.nextInt(0, Trivia.triviaLength());
			
			
			try
			{
				//this code will execute when a dungeon is loaded
				if(LevelExplorer.getIsDungeon() == true) 
				{
					//check that input was in range, execute this code if a trivia question is not in progress
					if(GUIView.inputRangeCheck(GUIView.playerInputField.getText(), 1) == true && Trivia.inTrivia == false) 
					{
						switch(input) 
						{
							//answer question
							case "1":
								
								
								Trivia.inTrivia = true;
								GUIView.mainFrame.dispose();
								GUIView.createMainScreen();
								PlayerOptions.dungeonOptions(BeginScreenHandler.theDungeon);
								GUIView.riddleCombatText.setText(Trivia.getQuestion(random) + "\n" + Trivia.getAnswerChoices(random) + "\nPlease input a choice 1-4");
								
								
								System.out.print(Trivia.inTrivia);
								break;
							//call combat method
							case "2":
								
								Trivia.inTrivia = false;
								GUIView.mainFrame.dispose();
								GUIView.createMainScreen();
								PlayerOptions.dungeonOptions(BeginScreenHandler.theDungeon);
								GUIView.riddleCombatText.setText("Have at you!\n" + PlayerOptions.enemyCombat(GUIController.player1, Dungeon.getEnemies(BeginScreenHandler.theDungeon).peek(), BeginScreenHandler.theDungeon));
								//break;
						}
					}
					else
					{
						if(Trivia.checkAnswer(input, Trivia.getSolution(random)) == true) 
						{
							//kill the enemy start next enemy
							Trivia.inTrivia = false;
							GUIView.riddleCombatText.setText("Great job!");
							
							//System.out.print("check check");
						}
						else 
						{
							//player must start combat
  						    Trivia.inTrivia = false;
							//System.out.print(Trivia.inTrivia);
							GUIView.riddleCombatText.setText("Wrong Answer!\n" + PlayerOptions.enemyCombat(GUIController.player1, Dungeon.getEnemies(BeginScreenHandler.theDungeon).peek(), BeginScreenHandler.theDungeon));
						}
					}
				//this code will execute when a shop is loaded
				if(LevelExplorer.getIsShop() == true) 
				{
					if(GUIView.inputRangeCheck(GUIView.playerInputField.getText(), 2) == true) 
					{
						switch(input) 
						{
						
							case "1": 
							
							String armorResult = Store.buyArmor();
							GUIView.riddleCombatText.setText(armorResult);
							break;
							//buys armor
							case "2":
							String weaponResult = Store.buyWeapon();
							GUIView.riddleCombatText.setText(weaponResult);
							break;
							//buys weapon
							case "3":
							String potionResult = Store.buyPotion();
							GUIView.riddleCombatText.setText(potionResult);
							break;

							//buy potion
							case "4":
							String adviceResult = Store.shopAdvice();
							GUIView.riddleCombatText.setText(adviceResult);
							break;
							//advice?
							case "5":
							String leave = Store.leaveShop();
							GUIView.riddleCombatText.setText(leave);
							LevelExplorer.nextLevel();
							break;
							//exits shop
							//next level
							
						}
					}
				}
				//this code will execute when a boss is loaded
				if(LevelExplorer.getIsBoss() == true) 
				{
					if(GUIView.inputRangeCheck(GUIView.playerInputField.getText(), 3) == true) 
					{
						switch(input) 
						{//abandoned i think
						
							case "1":
							//
							case "2":
							
							case "3":
							//
							case "4":
							//
						}
					}
				}
				//this code will execute when a player needs to choose the next level
				if(LevelExplorer.getIsLevelChooser() == true) 
				{
					int i = Integer.parseInt(input);
					LevelExplorer.levelChooser(i);
					GUIView.mainFrame.dispose();
					GUIView.createMainScreen();
				}
			}
		}
			catch (InvalidInputException e1)
			{
				e1.printStackTrace();
			}
			catch(EmptyStackException e2) 
			{
				BeginScreenHandler.reRoll();
			}
			
			
		}
	}
	

//	public static class playerInputFieldListener implements ActionListener
//	{
//
//		@Override
//		public void actionPerformed(ActionEvent e)
//		{
//			String input = GUIView.playerInputField.getText();
//			try
//			{
//				if(GUIView.inputRangeCheck(GUIView.playerInputField.getText())) 
//				{
//					switch(input) 
//					{
//						case "1":
//							//
//						case "2":
//							//
//						case "3":
//							//
//						case "4":
//							//
//					}
//				}
//			}
//			catch (InvalidInputException e1)
//			{
//				e1.printStackTrace();
//			}
//			
//			
//		}	
//	}
}
