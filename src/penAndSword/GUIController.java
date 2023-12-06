package penAndSword;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
/*
 * Purpose: This class will handle execution of code when a button in the GUI is pressed
 */

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

		@Override
		public void actionPerformed(ActionEvent e)
		{
			player1 = new Player(GUIView.nameInput.getText());
			theDungeon = LevelExplorer.nextLevel();
			GUIView.createMainScreen();
			
		}
		
		public static String getDungeonText(Dungeon dungeon) 
		{
			return dungeon.openingText;
		}
		
		public static List<Enemy> getEnemies(Dungeon dungeon) 
		{
			return dungeon.finalEnemies;
		}
		
	}
	
	public static class submitListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			String input = GUIView.playerInputField.getText();
			try
			{
				if(GUIView.inputRangeCheck(GUIView.playerInputField.getText())) 
				{
					switch(input) 
					{
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
			catch (InvalidInputException e1)
			{
				e1.printStackTrace();
			}
		}
	}

	public static class playerInputFieldListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e)
		{
			String input = GUIView.playerInputField.getText();
			try
			{
				if(GUIView.inputRangeCheck(GUIView.playerInputField.getText())) 
				{
					switch(input) 
					{
						case "1":
							//
						case "2":
							//
						case "3":
							//
						case "4":
							//
					}
				}
			}
			catch (InvalidInputException e1)
			{
				e1.printStackTrace();
			}
			
			
		}	
	}
	
	
}
