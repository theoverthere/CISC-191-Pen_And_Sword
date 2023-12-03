package penAndSword;

public class Tester
{
	static Player duncan = new Player("Duncan");
	
	public static void main(String[] args) 
	{
		System.out.println(duncan.getHealth());
		duncan.setHealth(5);
		System.out.println(duncan.getHealth());
	}
}
