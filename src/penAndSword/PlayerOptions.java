package penAndSword;

import java.util.EmptyStackException;
import java.util.Random;

public class PlayerOptions extends GUIController
{
	
	public static void dungeonOptions(Dungeon dungeon) 
	{
		//generate a riddle or combat situation for the player
			
			GUIView.instructionText.setText("There are " + Dungeon.getEnemies(dungeon).size() + " enemies in this room. You are approached by a " + Dungeon.getEnemyName(Dungeon.getEnemies(dungeon).peek()) + ". It asks you a riddle:\n"+"Press 1 to answer \nPress 2 to fight this guy instead");
			
			
	}
	
	public static void shopOptions() 
	{
		
	}
	
	public static void bossOptions() 
	{
		
	}
	
	public static String enemyCombat(Player player, Enemy enemy, Dungeon dungeon) 
	{
		String combatReport = "";
		int totalHealthLost = 0;
		
		
		while(true)
		{
			int pDamage = player.getDamage(), pArmor = Integer.parseInt(player.getArmor()), pHealth = Integer.parseInt(player.getHealth());
			int eDamage = enemy.getDamage(), eArmor = Integer.parseInt(enemy.getArmor()), eHealth = Integer.parseInt(enemy.getHealth());
			int enemyDamageDone = eDamage - pArmor;
			System.out.println("enemyDamageDone: " +enemyDamageDone);
			int playerDamageDone = pDamage - eArmor;
			System.out.println("playerDamageDone" +playerDamageDone);
			totalHealthLost = totalHealthLost + enemyDamageDone;
			System.out.println("totalHealthLost" +totalHealthLost);
			System.out.println("player hp:" +player.getHealth());
			System.out.println("enemy hp:" +enemy.getHealth());
			
			if(pHealth > 0 && eHealth > 0)
			{
				player.setHealth(enemyDamageDone);
				enemy.setHealth(playerDamageDone);
			}
			
			if(pHealth > 0 && eHealth <= 0)
			{
				//enemy is dead, encounter over, return report
				try 
				{
					if(Dungeon.getEnemies(BeginScreenHandler.theDungeon).size() != 0)
					{
						dungeon.finalEnemies.pop();
						
						
					}
					else 
					{
						BeginScreenHandler.reRoll();
						break;
						
					}
				}
				catch(EmptyStackException e) 
				{
					BeginScreenHandler.reRoll();
				}
				
		
				System.out.println(dungeon.finalEnemies.toString());
				combatReport = "You Win! \nYou took " + totalHealthLost + " points of damage";
				if (Player.getplayerExp(player)==10)
				{
					player.setLevel();
				  //needs something that said you leveled up
					combatReport = "You Win! \nYou took " + totalHealthLost + " points of damage \nLevel Up!: You are now level " + player.getLevel();
					break;
				} 
				else 
				{
					Player.changePlayerExp(player);
					break;
					
					
				}
				 // Generates a random integer either 0 or 1 
			
//				if (random.nextInt(0, 1) == 0) 
//				{
//					Items.regularAfterBattleLoot();
//				}
				
			
			
			}
			if(pHealth <= 0 && eHealth > 0) 
			{
				//game over 
				combatReport = "Game Over!";
				GUIView.createGameOverScreen();
				break;
				
			}
		
		
		}
		return combatReport;
	}
	
	public static void bossCombat() 
	{
		
	}
	

	
//	public static void main(String[] args) 
//	{
//		Player dMan = new Player("dMan");
//		Enemy badGuy = new Enemy(5, 3, null, 1, 0, null);
//		
//		System.out.print(enemyCombat(dMan, badGuy));
//	}
}
