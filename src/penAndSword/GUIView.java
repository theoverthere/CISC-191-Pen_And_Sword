package penAndSword;
import javax.imageio.ImageIO;
import java.awt.GraphicsEnvironment;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.swing.*;

import java.awt.*;

public class GUIView extends GUIController

{		
	//fields for Title and intro:
	static JFrame window;
	static JLabel backgroundLabel;
	static JLabel introBackgroundLabel;
	static JLabel gameOverScreen;
	JButton titleButton;
	static JButton introButton;
	static JPanel startButtonPanel;
	TitleScreenHandler tsHandler = new TitleScreenHandler();
	static IntroScreenHandler inHandler = new IntroScreenHandler();
	static BeginScreenHandler bgHandler = new BeginScreenHandler();
	static JPanel introPanel;
	
	//fields for main screen frame and panels
	static JFrame mainFrame;
	private static JPanel mainPanel;
	private static JLayeredPane centerPanelContainer;
	private static JPanel centerPanelComponents;
	private static JPanel centerPanelBackground;
	private static JPanel bottomPanel;
	private static JPanel eastPanel;
	private static JPanel westPanel;
	private static JPanel topWestPanel;
	private static JPanel bottomWestPanel;
	
	//fields for center and bottom panel components
	private static JEditorPane adventureText;
	static JEditorPane instructionText;
	static JEditorPane riddleCombatText;
	static JFormattedTextField playerInputField;
	static JButton enterButton;
	static submitListener sl = new submitListener();
	
	//fields for east and west panel components
	private static JLabel bgLabel;
	private static JLabel invSlot1,invSlot2,invSlot3, invSlot4, invSlot5,invSlot6, invSlot7, invSlot8;
	private static JLabel playerName;
	private static JLabel playerHealth;
	private static JLabel playerArmor;
	private static JLabel equippedWeapon;
	public static JProgressBar levelUpProgress;
	private static JLabel portrait0, portrait1, portrait2, portrait3;
	static JLabel[] portraits = {portrait0, portrait1, portrait2, portrait3};
	
	//fields for begin screen
	private static JFormattedTextField nameHere;
	static JTextField nameInput;
	private static JButton begin;
	static JFrame beginFrame;
	private static JPanel beginPanel;
	private static JPanel beginContainer;
	
	//fields for game over screen
	
	//custom font
	static Font customFont = new Font("Serif", Font.ITALIC, 20);
	
	//////////////////////TITLE/////////////////////////	
	public GUIView() 
	{

		// Create a window.
		window = new JFrame();
		// Set the size of the window.
		window.setSize(1200, 700);

		// Set the title.
		window.setTitle("Pen & Sword");

		JPanel opuo = new JPanel(new BorderLayout());
		window.setContentPane(opuo);

		BufferedImage image = null;
			try 
			{
				image = ImageIO.read(new File("./Images/TitleImage.png"));
			}
			catch (IOException e) 
			{
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
		titleButton.addMouseListener(new java.awt.event.MouseAdapter() 
		{
			public void mouseEntered(java.awt.event.MouseEvent evt) 
			{
				titleButton.setBackground(new Color(20, 100, 42)); // Lighter orange on hover
			}

			public void mouseExited(java.awt.event.MouseEvent evt) 
			{
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
	
	//////////////////// INTRO TEXT///////////////////////////////
	public static void createIntroScreen() 
	{
		backgroundLabel.setVisible(false);// erases the title things
		startButtonPanel.setVisible(false);

		// sets the background to black
		window.getContentPane().setBackground(Color.black);
		// makes a new image and applies it to introimage
		BufferedImage introImage = null;
		try 
		{
			introImage = ImageIO.read(new File(
					"./Images/IntroText.png"));
		} 
		catch (IOException e) 
		{
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
		public static void eraseIntroScreen() 
		{                    
		// erases the intro screen
		introBackgroundLabel.setVisible(false);
		introButton.setVisible(false);
		// if you want to get rid of the black background use window.setVisablle to
		// false
		}
		
		////////////////////Begin screen (input name and start game)/////////////////////////////
		public static void createBeginScreen() 
		{
			window.dispose();
			
			// Create a window.
			beginFrame = new JFrame();
			// Set the size of the window.
			beginFrame.setSize(1200, 700);
			beginFrame.setBackground(new Color(167, 194, 192));
			// Set the title.
			beginFrame.setTitle("Pen & Sword");

			beginPanel = new JPanel(new BorderLayout());
			beginFrame.setContentPane(beginPanel);
			
			beginContainer = new JPanel();
			beginPanel.add(beginContainer, BorderLayout.CENTER);
			
			nameHere = new JFormattedTextField("Please enter your name:");
			beginContainer.add(nameHere);
			nameHere.setEnabled(false);
			nameInput = new JTextField("               ");
			beginContainer.add(nameInput);
			
			begin = new JButton("Begin Journey");
			begin.setBackground(new Color(167, 194, 192)); // Orange background does not work
			begin.setForeground(Color.WHITE); // White text color
			begin.setFont(new Font("Serif", Font.BOLD, 30)); // Bold, larger font
			begin.addActionListener(bgHandler);
			beginPanel.add(begin, BorderLayout.SOUTH);
			
			//beginFrame.add(beginPanel);
			beginFrame.setVisible(true);
		}
		
		/////////////////////Main panel///////////////////////////////////////////////////////////
		public static void createMainScreen() 
		{
			
			mainFrame = new JFrame();
			
			final int WINDOW_WIDTH = 1200;
			final int WINDOW_HEIGHT = 700;
			
			mainFrame.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
			mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			mainPanel = new JPanel(new BorderLayout());
			mainFrame.setContentPane(mainPanel);
			//mainFrame.setBackground(new Color(143, 184, 201));
			
			//centerPanelContainer = new JLayeredPane();
			createCenterPanelComponents();
			//createCenterPanelBackground();
			//centerPanelContainer.add(centerPanelComponents);
			//centerPanelContainer.add(centerPanelBackground);
			mainPanel.add(centerPanelComponents, BorderLayout.CENTER);
			centerPanelComponents.setBackground(new Color(143, 184, 201));
			createBottomPanel();
			mainPanel.add(bottomPanel, BorderLayout.SOUTH);
			bottomPanel.setBackground(new Color(143, 184, 201));
			createEastPanel();
			mainPanel.add(eastPanel, BorderLayout.EAST);
			eastPanel.setBackground(new Color(143, 184, 201));
			createWestPanel();
			mainPanel.add(westPanel, BorderLayout.WEST);	
			westPanel.setBackground(new Color(143, 184, 201));
			//mainFrame.add(mainPanel);
			mainFrame.setVisible(true);
		}
		
		///////////////////Game over/////////////////////////////////////////////////////////////
		public static void createGameOverScreen() 
		{
				// makes a new image and applies it to introimage
				BufferedImage introImage = null;
				try {
					introImage = ImageIO.read(new File(
							"./Images/gameOverScreen.jpg"));} 
				catch (IOException e) {
					e.printStackTrace();}
				gameOverScreen = new JLabel(new ImageIcon(introImage));
				// displays everything
				window.add(gameOverScreen);
				window.setVisible(true);
			}
		
		
		///////////////////////////////Components and Panels///////////////////////////////////////
		private static void createCenterPanelComponents() 
		{
			if(LevelExplorer.getIsDungeon() == true) 
			{
			centerPanelComponents = new JPanel();
			adventureText = new JEditorPane();
			adventureText.setBounds(0, 0, 500, 200);
			adventureText.setFont(customFont);;
			adventureText.setEditable(false);
			adventureText.setText(Dungeon.getDungeonText(BeginScreenHandler.theDungeon));
			instructionText = new JEditorPane();
			instructionText.setBounds(0, 0, 500, 200);
			instructionText.setFont(customFont);
			instructionText.setEditable(false);
			riddleCombatText = new JEditorPane();
			riddleCombatText.setBounds(0, 0, 500, 200);
			riddleCombatText.setEditable(false);
			riddleCombatText.setFont(customFont);
			centerPanelComponents.add(adventureText);	
			centerPanelComponents.add(instructionText);
			centerPanelComponents.add(riddleCombatText);
			} 
			if(LevelExplorer.getIsShop() == true) 
			{
				centerPanelComponents = new JPanel();
				adventureText = new JEditorPane();
				adventureText.setBounds(0, 0, 500, 200);
				adventureText.setFont(customFont);
				adventureText.setEditable(false);
				adventureText.setText(BeginScreenHandler.theShop.Constructor1);
				instructionText = new JEditorPane();
				instructionText.setBounds(0, 0, 500, 200);
				instructionText.setFont(customFont);
				instructionText.setEditable(false);
				
				riddleCombatText = new JEditorPane();
				riddleCombatText.setBounds(0, 0, 500, 200);
				riddleCombatText.setEditable(false);
				riddleCombatText.setFont(customFont);
				centerPanelComponents.add(adventureText);	
				centerPanelComponents.add(instructionText);
				centerPanelComponents.add(riddleCombatText);
			}
		}	
		
		private static void createCenterPanelBackground() 
		{	
			centerPanelBackground = new JPanel(new BorderLayout());
			ImageIcon backGround = new ImageIcon("Images/healthpotion.jpg");
			bgLabel = new JLabel(backGround);
			centerPanelBackground.add(bgLabel, BorderLayout.CENTER);
			centerPanelBackground.setPreferredSize(new Dimension(backGround.getIconWidth(), backGround.getIconHeight()));
			//BufferedImage centerBgImage = null;
//			try 
//			{
//				centerBgImage = ImageIO.read(new File(
//						"./Images/IntroText.png"));
//			} 
//			catch (IOException e) 
//			{
//				e.printStackTrace();
//			}
//			introBackgroundLabel = new JLabel(new ImageIcon(centerBgImage));
		}
		  
		private static void createBottomPanel() 
		{
			bottomPanel = new JPanel();
			playerInputField = new JFormattedTextField();
			playerInputField.setSize(50, 25);
			playerInputField.setText("This is where player input will be");
			playerInputField.setFont(customFont);
			enterButton = new JButton("Submit");
			enterButton.addActionListener(sl);
			bottomPanel.add(enterButton);
			bottomPanel.add(playerInputField);
		}
		
		private static void createEastPanel() 
		{
			eastPanel = new JPanel();
			eastPanel.setLayout(new GridLayout(4, 2));
			//removed this to make room for a loot space
			//ImageIcon icon = new ImageIcon("Images/healthpotion.jpg");
			invSlot1 = new JLabel(Items.getWeaponStats());//weapon
			invSlot2 = new JLabel(Items.getArmorStats());//armor
			invSlot2.setFont(customFont);
			invSlot3 = new JLabel(Items.potionName+" Health: " +Items.potionValue);//potion
			
			invSlot4 = new JLabel(Items.getPlayerLootAt(0));
		
			invSlot5 = new JLabel(Items.getPlayerLootAt(1));
			invSlot6 = new JLabel(Items.getPlayerLootAt(2));
			invSlot7 = new JLabel(Items.getPlayerLootAt(3));
			invSlot8 = new JLabel(Items.getPlayerLootAt(4));
			eastPanel.add(invSlot1);
			eastPanel.add(invSlot2);
			eastPanel.add(invSlot3);
			eastPanel.add(invSlot4);
			eastPanel.add(invSlot5);
			eastPanel.add(invSlot6);
			eastPanel.add(invSlot7);
			eastPanel.add(invSlot8);
		}
		
		private static void createWestPanel() 
		{
			westPanel = new JPanel();
			westPanel.setLayout(new GridLayout(2, 1));
			
			topWestPanel = new JPanel();
			topWestPanel.setLayout(new GridLayout(5, 1));
			topWestPanel.setBackground(new Color(143, 184, 201));//makes the west panel the background color
			playerName = new JLabel(GUIController.player1.getName());
			playerName.setOpaque(true);
			
			playerName.setForeground(Color.black);
			playerName.setFont(new Font("Serif", Font.ITALIC, 20));
			
			playerHealth = new JLabel("Health: " + GUIController.player1.getHealth());
			playerArmor = new JLabel("Armor: " + GUIController.player1.getArmor());
			equippedWeapon = new JLabel("Weapon: " + Items.getWeaponStats());
			levelUpProgress = new JProgressBar(0, 10);
			levelUpProgress.setBounds(1, 1, 5, 2);
			levelUpProgress.setValue(GUIController.player1.getExp());
			topWestPanel.add(playerName);
			topWestPanel.add(playerHealth);
			topWestPanel.add(playerArmor);
			topWestPanel.add(equippedWeapon);
			topWestPanel.add(levelUpProgress);
			westPanel.add(topWestPanel);
			
			bottomWestPanel = new JPanel();
			bottomWestPanel.setLayout(new GridLayout(2, 2));

			for(int i = Dungeon.getEnemies(BeginScreenHandler.theDungeon).size() - 1; i > -1; i--) 
			{
				portraits[i] = new JLabel("Name: " + Dungeon.getEnemyName(Dungeon.getEnemy(BeginScreenHandler.theDungeon, i)) + " \n HP: " + Dungeon.getEnemyHP(Dungeon.getEnemies(BeginScreenHandler.theDungeon).elementAt(i)));
				bottomWestPanel.add(portraits[i]);
			}

			westPanel.add(bottomWestPanel);	
		}
	
		//////////////////////////////////////////Register Buttons///////////////////////////////////////////////////
		
		//register action listener for playerInputField
//		public void registerPlayerInputFieldListener(GUIController.playerInputFieldListener playerInputFieldListener) 
//	    {
//			playerInputField.addActionListener(playerInputFieldListener);
//	    }
		
		public void registerSubmitListener(GUIController.submitListener submitListener) 
		{
			enterButton.addActionListener(submitListener);
		}
		
		//method to check if input in playerInputField was within accepted range (1-4)
		public static boolean inputRangeCheck(String input, int roomType) throws InvalidInputException
		{
			switch(roomType) 
			{
				//case 1 is for dungeons
				case 1:
					switch(input) 
					{
						case "1": //Answer question
							return true;
						case "2": //Fight enemy
							return true;
					}
					
					return false;
				//case 2 is for shops
				case 2:
					switch(input) 
					{
						case "1": //Buy an item
							return true;
						case "2": //sell an item
							return true;
						case "3": // leave
							return true;
					}
					return false;
				//case 3 is for bosses
				case 3:
					switch(input) 
					{
						case "1": //Fight the boss
							return true;
					}
					return false;
				//case 4 is for when you are answering a trivia question
				case 4: 
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
					return false;
				//case 5 is for choosing the next room (dungeon or shop)
				case 5: 
					switch(input) 
					{
						case "1":
							return true;
						case "2":
							return true;
					}
					return false;
						
					
			}
			
			throw new InvalidInputException("Input is out of range");
		}
		 
		public static void main(String[] args) 
		{	 
			GUIView gui = new GUIView();
			//createMainScreen();
			//createBeginScreen();
		}

}


