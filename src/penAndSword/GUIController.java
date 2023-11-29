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

	public class IntroScreenHandler implements ActionListener 
	{
		public void actionPerformed(ActionEvent event) 
		{
			GUIView.eraseIntroScreen();
		}
	}

	public class playerInputFieldListener implements ActionListener
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
							//whatever happens
						case "2":
							//whatever happens for 2
						case "3":
							//whatevr happens for 3
						case "4":
							//whatever happens for 4
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
