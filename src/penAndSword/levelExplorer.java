package penAndSword;

/*
 * The purpose of this class is to move the player through the games levels and decide what levels (either dungeon, boss, shop, or library)
 * the player can access next
 */
public class levelExplorer
{
	private int currentLevel = Player.getPlayerLevel();
	private int numLevels;
	private int finalLevel = 10;
	
	public void nextLevel() 
	{
		if(currentLevel < 1) 
		{
			Dungeon.dungeonLevel(currentLevel);
		}
		if(currentLevel > 1) 
		{
			Shop.populateShopInventory();
		}
	}
	
}
