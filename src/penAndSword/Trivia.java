package penAndSword;

import java.util.*;

/*
 * The purpose of the trivia class is to provide a way to instantiate trivia objects and add them all to a list that 
 * can be called by other classes in this program. The trivia class also provides the methods that
 * run the trivia mini-game such as checking player input and comparing it with the correct answer
 */
public class Trivia
{
	//fields
	private String question;
	private String answer1;
	private String answer2;
	private String answer3;
	private String answer4;
	private int solution;
	private static boolean answeredCorrectly = false;
	
	//initialize arraylist to hold questions
	private static List<Trivia> trivia = new ArrayList<>();
	
	/*
	 * Purpose: This constructor will allow us to create trivia objects, each with a question and four possible answers
	 * 
	 * @param: String newQuestion
	 * @param: String A1
	 * @param: String A2
	 * @param: String A3
	 * @param: String A4
	 */
	public Trivia(String newQuestion, String A1, String A2, String A3, String A4, int newSolution) 
	{
		this.question = newQuestion;
		this.answer1 = A1;
		this.answer2 = A2;
		this.answer3 = A3;
		this.answer4 = A4;
		this.solution = newSolution;
		Trivia.addQuestion(this);
	}
	
	/*
	 * Purpose: adds a new trivia question to the list
	 * 
	 * @param: Trivia newTrivia
	 */
	public static void addQuestion(Trivia newTrivia) 
	{
		trivia.add(newTrivia);
	}
	
	//area to create trivia objects
	static Trivia test = new Trivia("What number am I thinking of?", "1", "2", "3", "4", 3);
	static Trivia q1 = new Trivia("What walks on four legs in the morning, two legs in the afternoon, and three legs in the evening?", "A Man", "A chicken", "A robot", "A dog", 1);
	
	/*
	 * Purpose: allow other classes to access a trivia question by index
	 * 
	 * @param: int questionNum
	 * @return: String question
	 */
	
	public static String getQuestion(int questionNum) 
	{
		return trivia.get(questionNum).question;
	}
	
	/*
	 * Purpose: allow other classes to access trivia answers by index
	 * 
	 * @param: int questionNum
	 * @return: String answer1, answer2, answer3, answer4
	 */
	
	public static String getAnswerChoices(int questionNum) 
	{
		return trivia.get(questionNum).answer1 + " " + trivia.get(questionNum).answer2 + " " + trivia.get(questionNum).answer3 + " " + trivia.get(questionNum).answer4;
	}
	
	/*
	 *Purpose: allow other classes to access trivia solutions by index
	 *
	 * @param: int questionNum
	 * @return: int solution
	 */
	
	public static int getSolution(int questionNum)
	{
		return trivia.get(questionNum).solution;
	}
	
	public static Trivia getTrivia(int triviaNum) 
	{
		return trivia.get(triviaNum);
	}
	
	/*
	 * Purpose: This method provides a way to verify if the players choice was the correct answer
	 * 
	 * @param: String playerInput, correctAnswer
	 * @return: boolean answeredCorrectly
	 */
	public static boolean checkAnswer(int playerInput, int correctAnswer) 
	{
		if(playerInput == correctAnswer) 
		{
			answeredCorrectly = true;
			return answeredCorrectly;
 		}
		else 
		{
			return false;
		}
	}
	
	
	//main method for testing
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		int playerInput;
		
		
		System.out.println(getQuestion(1));
		System.out.print("Choices: ");
		System.out.println(getAnswerChoices(1));
		playerInput = sc.nextInt();
		while(answeredCorrectly == false) 
		{
			if(checkAnswer(playerInput, getSolution(1)) == true)
				{
					System.out.println("That is the correct answer!");
				}
			else 
			{
				System.out.println("Wrong again bucko!");
				System.out.println(getQuestion(1));
				System.out.print("Choices: ");
				System.out.println(getAnswerChoices(1));
				playerInput = sc.nextInt();
			}
		}
		
	}
	
}
