package penAndSword;


/*
 * This class will provide a custom exception for when the player inputs a value that is out of range of what is expected
 */
public class InvalidInputException extends Exception
{
	public InvalidInputException(String message) 
	{
		super(message);
	}
}
