package penAndSword;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
			createGameScreen();
		}
	}

	public class playerInputListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e)
		{
			String input = GUIView.playerInputField.getText();
			if(GUIView.inputRangeCheck(GUIView.playerInputField.getText())) 
			{
				switch(input) 
				{
					case "1":
						//whatever happens
					case "2":
						//whatever happens for 2
					case "3":
						//whatevr happens for 4
					case "4":
						//whatever happ
				}
			}
			
			
		}

	}
		
}
