package penAndSword;
import javax.imageio.ImageIO;
import java.awt.GraphicsEnvironment;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.swing.*;

//import penAndSword.GUIController.IntroScreenHandler;
//import penAndSword.GUIController.TitleScreenHandler;

import java.awt.*;

public class GUIView extends GUIController

{		//fields for Title and intro:
static JFrame window;
	static JLabel backgroundLabel;
	static JLabel introBackgroundLabel;
	JButton titleButton;
	static JButton introButton;
	static JPanel startButtonPanel;
	TitleScreenHandler tsHandler = new TitleScreenHandler();
	IntroScreenHandler inHandler = new IntroScreenHandler();
	JPanel introPanel;
	
		//fields for panels
		private JLayeredPane centerPanelContainer;
		private JPanel centerPanelComponents;
		private JPanel centerPanelBackground;
		private JPanel bottomPanel;
		private JPanel eastPanel;
		private JPanel westPanel;
		private JPanel topWestPanel;
		private JPanel bottomWestPanel;
	
		//fields for components
		private JTextArea adventureText;
		static JFormattedTextField playerInputField;
		private JButton b1;
		//private ImageIcon backGround;
		private JLabel bgLabel;
		private JLabel invSlot1,invSlot2,invSlot3, invSlot4, invSlot5,invSlot6, invSlot7, invSlot8;
		private JLabel playerHealth;
		private JLabel playerArmor;
		private JLabel equippedWeapon;
		private JProgressBar levelUpProgress;
		private JLabel portrait1, portrait2, portrait3, portrait4;
		
		Font customFont = new Font(Font.DIALOG, Font.BOLD, 10);
	
		
		//////////////////// TITLE//
	public GUIView() {

		// Create a window.
		window = new JFrame();
		// Set the size of the window.
		window.setSize(1200, 700);

		// Set the title.
		window.setTitle("Pen & Sword");

		JPanel opuo = new JPanel(new BorderLayout());
		window.setContentPane(opuo);

		BufferedImage image = null;
		try {
			image = ImageIO.read(new File("C:\\Users\\nicho\\git\\CISC-191-Pen_And_Sword\\Images\\pen and sword.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Create a JLabel with the image
		backgroundLabel = new JLabel(new ImageIcon(image));

		// Set layout to BorderLayout to cover the whole frame
		window.setLayout(new BorderLayout());

		// Create button
		titleButton = new JButton("Play Game?");

		titleButton.setBackground(new Color(255, 69, 0)); // Orange background
		titleButton.setForeground(Color.WHITE); // White text color
		titleButton.setFont(new Font("Serif", Font.BOLD, 30)); // Bold, larger font
		titleButton.addActionListener(tsHandler);
		// Add a hover effect
		titleButton.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				titleButton.setBackground(new Color(20, 100, 42)); // Lighter orange on hover
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				titleButton.setBackground(new Color(255, 69, 0)); // Back to original color on exit
			}
		});

		// Add the button to the frame
		startButtonPanel = new JPanel();
		startButtonPanel.setBackground(new Color(77, 77, 94));
		startButtonPanel.add(titleButton);
		window.add(backgroundLabel);// BorderLayout.CENTER
		window.add(startButtonPanel, BorderLayout.SOUTH);
		// Display the window.
		window.setVisible(true);

		// Add the button to the frame
		startButtonPanel = new JPanel();

		startButtonPanel.setBackground(new Color(77, 77, 94));
		startButtonPanel.add(titleButton);

		window.add(backgroundLabel);// BorderLayout.CENTER
		window.add(startButtonPanel, BorderLayout.SOUTH);

		// Display the window.
		window.setVisible(true);
	}	
	//////////////////// INTRO//
	public static void createIntroScreen() {
		backgroundLabel.setVisible(false);// erases the title things
		startButtonPanel.setVisible(false);

		// sets the background to black
		window.getContentPane().setBackground(Color.black);
		// makes a new image and applies it to introimage
		BufferedImage introImage = null;
		try {
			introImage = ImageIO.read(new File(
					"C:\\Users\\nicho\\OneDrive\\Documents\\GitHub\\CISC-191-Pen_And_Sword\\images\\introText.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		introBackgroundLabel = new JLabel(new ImageIcon(introImage));

		// creates a new button similar to title
		introButton = new JButton("Continue");
		introButton.setBackground(new Color(167, 194, 192)); // Orange background
		introButton.setForeground(Color.WHITE); // White text color
		introButton.setFont(new Font("Serif", Font.BOLD, 30)); // Bold, larger font
		introButton.addActionListener(inHandler);

		// displays everything
		window.add(introBackgroundLabel);
		window.add(introButton, BorderLayout.SOUTH);
		window.setVisible(true);
	}
		public static void createGameScreen() {                    //GAME////////////////////
		// erases the intro screen
		introBackgroundLabel.setVisible(false);
		introButton.setVisible(false);
		// if you want to get rid of the black background use window.setVisablle to
		// false
	}
		
		private void createCenterPanelComponents() 
		{
			centerPanelComponents = new JPanel();
			adventureText = new JTextArea();
			adventureText.setEditable(false);
			adventureText.setText("This is where the text describing the game and enemies will be");
			centerPanelComponents.add(adventureText);	
		}
		
		private void createCenterPanelBackground() 
		{	
			centerPanelBackground = new JPanel(new BorderLayout());
			ImageIcon backGround = new ImageIcon("Images/health_potion.jpg");
			bgLabel = new JLabel(backGround);
			centerPanelBackground.add(bgLabel, BorderLayout.CENTER);
			centerPanelBackground.setPreferredSize(new Dimension(backGround.getIconWidth(), backGround.getIconHeight()));
		}
		
		private void createBottomPanel() 
		{
			bottomPanel = new JPanel();
			playerInputField = new JFormattedTextField();
			playerInputField.setText("This is where player input will be");
			playerInputField.setFont(customFont);
			bottomPanel.add(playerInputField);
		}
		
		private void createEastPanel() 
		{
			eastPanel = new JPanel();
			eastPanel.setLayout(new GridLayout(4, 2));
			ImageIcon icon = new ImageIcon("Images/health_potion.jpg");
			invSlot1 = new JLabel(icon);
			invSlot2 = new JLabel("item2");
			invSlot2.setFont(customFont);
			invSlot3 = new JLabel("item3");
			invSlot4 = new JLabel("item4");
			invSlot5 = new JLabel("item5");
			invSlot6 = new JLabel("item6");
			invSlot7 = new JLabel("item7");
			invSlot8 = new JLabel("coins");
			eastPanel.add(invSlot1);
			eastPanel.add(invSlot2);
			eastPanel.add(invSlot3);
			eastPanel.add(invSlot4);
			eastPanel.add(invSlot5);
			eastPanel.add(invSlot6);
			eastPanel.add(invSlot7);
			eastPanel.add(invSlot8);
		}
		
		private void createWestPanel() 
		{
			westPanel = new JPanel();
			westPanel.setLayout(new GridLayout(2, 1));
			
			topWestPanel = new JPanel();
			topWestPanel.setLayout(new GridLayout(4, 1));
			playerHealth = new JLabel("Health: 100");
			playerArmor = new JLabel("Armor: 20");
			equippedWeapon = new JLabel("sword_picture.jpg");
			levelUpProgress = new JProgressBar(1, 10);
			levelUpProgress.setBounds(1, 1, 5, 2);
			levelUpProgress.setValue(5);
			topWestPanel.add(playerHealth);
			topWestPanel.add(playerArmor);
			topWestPanel.add(equippedWeapon);
			topWestPanel.add(levelUpProgress);
			westPanel.add(topWestPanel);
			
			bottomWestPanel = new JPanel();
			bottomWestPanel.setLayout(new GridLayout(2, 2));
			portrait1 = new JLabel("portrait1");
			portrait2 = new JLabel("portrait2");
			portrait3 = new JLabel("portrait3");
			portrait4 = new JLabel("portrait4");
			bottomWestPanel.add(portrait1);
			bottomWestPanel.add(portrait2);
			bottomWestPanel.add(portrait3);
			bottomWestPanel.add(portrait4);
			westPanel.add(bottomWestPanel);	
		}
		
		//register action listener for playerInputField
		public void registerPlayerInputFieldListener(GUIController.playerInputFieldListener playerInputFieldListener) 
	    {
			playerInputField.addActionListener(playerInputFieldListener);
	    }
		
		//method to check if input in playerInputField was within accepted range (1-4)
		public static boolean inputRangeCheck(String input) throws InvalidInputException
		{
			switch(input) 
			{
				case "1":
					return true;
				case "2":
					return true;
				case "3":
					return true;
				case "4": 
					return true;
			}
			throw new InvalidInputException("Input must be 1-4");
		}
		 
		public static void main(String[] args) 
		{	 
			GUIView gui = new GUIView();

		}

}
