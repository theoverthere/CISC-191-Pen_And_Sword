package penAndSword;
import javax.imageio.ImageIO;
import java.awt.GraphicsEnvironment;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.swing.*;
import java.awt.*;

public class GUIView

{		
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
		private JFormattedTextField playerInputField;
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
	
		
		public GUIView() 
		{
			JFrame mainFrame = new JFrame("Pen & Sword"); //create main JFrame
			
			final int WINDOW_WIDTH = 1200; // Window width in pixels
			final int WINDOW_HEIGHT = 650; // Window height in pixels
			
			mainFrame.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
			mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			JPanel mainPanel = new JPanel(new BorderLayout()); //create main panel
			mainFrame.setContentPane(mainPanel);
		
			
			centerPanelContainer = new JLayeredPane(); //create layered pain
			
			createCenterPanelComponents(); //initialize components of layered pane
			createCenterPanelBackground(); //intialize background of layered pane
			centerPanelContainer.add(centerPanelBackground, JLayeredPane.DEFAULT_LAYER);
			centerPanelContainer.add(centerPanelComponents, JLayeredPane.PALETTE_LAYER);
			
			mainPanel.add(centerPanelContainer, BorderLayout.CENTER);
			
			createBottomPanel();
			mainPanel.add(bottomPanel, BorderLayout.SOUTH);
		
			createEastPanel();
			mainPanel.add(eastPanel, BorderLayout.EAST);
				
			createWestPanel();
			mainPanel.add(westPanel, BorderLayout.WEST);
	
				
	
		JPanel opuo = new JPanel(new BorderLayout());
		mainFrame.setContentPane(opuo);

			BufferedImage image = null;
        try {
            image = ImageIO.read(new File("C:\\Users\\nicho\\git\\CISC-191-Pen_And_Sword\\Images\\pen and sword.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Create a JLabel with the image
        JLabel backgroundLabel = new JLabel(new ImageIcon(image));

        // Set layout to BorderLayout to cover the whole frame
        mainFrame.setLayout(new BorderLayout());

        // Add the background label to the frame
        
        // Create button
        JButton titleButton = new JButton("Play Game?");
        
        
        
        titleButton.setBackground(new Color(255, 69, 0)); // Orange background
        titleButton.setForeground(Color.WHITE); // White text color
        titleButton.setFont(new Font("Serif", Font.BOLD, 30)); // Bold, larger font
        
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
        JPanel startButtonPanel = new JPanel();
        
        startButtonPanel.setBackground(new Color(77, 77, 94));
        startButtonPanel.add(titleButton);
        
        mainFrame.add(backgroundLabel);//BorderLayout.CENTER
        mainFrame.add(startButtonPanel, BorderLayout.SOUTH);
        
        
        // Display the window.
		mainFrame.setVisible(true);
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
		 
		public static void main(String[] args) 
		{	 
			GUIView gui = new GUIView();

		}

}
