package penAndSword;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/*
 * Purpose: This class will handle execution of code when a button in the GUI is pressed
 */

public class GUIController  
	{
		

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

		@Override
		public void actionPerformed(ActionEvent e)
		{
			Player player1 = new Player(GUIView.nameInput.getText());
			GUIView.createMainScreen();
			
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
