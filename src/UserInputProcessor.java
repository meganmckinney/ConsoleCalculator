import java.util.Scanner;
/**
 * 
 * @author Megan McKinney
 *
 * UserInputProcessor class deals with the user input in the calculator app. It takes two numeric input values as Strings,
 * then converts them to doubles. It also takes an operator of type String.
 * 
 * The operator is handled using a switch, and the operations themselves are handled via objects.
 *
 */
public class UserInputProcessor {
	
	//Strings
	String userInputX;
	String userInputY;
	String operator;
	String userContinue;
	
	//Doubles
	double userSolution;
	double inputX;
	double inputY;
	double answer;
	boolean isDone = false;
	
	//Objects
	Addition addition = new Addition();
	Subtraction subtraction = new Subtraction();
	Multiplication multiplication = new Multiplication();
	Division division = new Division();
	Modulo modulo = new Modulo();
	RaisePower power = new RaisePower();
	Root root = new Root();
	
	/**
	 * inputHandler() method deals with the logic of the application, allowing the user to quit or go again 
	 * as many times as necessary.
	 */
	public void inputHandler() {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Welcome to the console calculator!\nPress any key to begin, or enter \"help\" for help!");
		help (scanner);
	 	
		while (!isDone) {
			
			inputX = promptUserHandler(inputX, userInputX);
			operator = operandHandler(operator);
			inputY = promptUserHandler(inputY, userInputY);
			answer = operatorSwitch(operator);
			System.out.println("The answer is: " + answer);
			
			//Ask user if they want to go again, or exit
			System.out.println("Do you wish to continue?: ");
			userContinue = scanner.nextLine();
			if (userContinue.equalsIgnoreCase("no")) {
				System.out.println("Bye!!");
				isDone = true;
			} else {
				isDone = false;
			} // End of if statement
		} // End of while loop
	}// End of inputHandler() method
	
	/**
	 * 
	 * @param operator String which carries the operator value that is input from the user
	 * @return tempVal double holds the answer that is passed from the method call, and passes it to the answer variable within the inputHandler() method
	 * 
	 * The operatorSwitch() method holds the switch for the operator.
	 * For each case, there is a corresponding object that calls the 
	 * 
	 */
	public double operatorSwitch(String operator) {
	
		double tempVal = 0.0;
		switch(operator) {
		case "+": tempVal = addition.calculate(inputX, inputY);
		break;
		case"-": tempVal = subtraction.calculate(inputX, inputY);
		break;
		case"*": tempVal = multiplication.calculate(inputX, inputY);
		break;
		case"/": tempVal = division.calculate(inputX, inputY);
		break;
		case"%": tempVal = modulo.calculate(inputX, inputY);
		break;
		case"^": tempVal = power.calculate(inputX, inputY);
		break;
		case"~": tempVal = root.calculate(inputX, inputY);
		break;
		default: throw new RuntimeException("Error detected in operator switch. Invalid entry = " + operator);
		
		} // End of switch
		return tempVal;
	} // End of operatorSwitch() method
	
	/**
	 * 
	 * @param scanner Scanner
	 * @param userInput String holds the numeric userInput value, converts it into a double, which is then passed into the userInputNum of type double.
	 * @return userInputNum double holds the converted userInput value
	 * 
	 * the promptUser() method deals with the prompts for the first and second input values, and sets them to userInputNum, which is then returned to its respective field, either inputX or inputY
	 */
	public double promptUser(Scanner scanner, String userInput) {
		
		double userInputNum = 0;
		System.out.println("Enter your number");
		userInput = scanner.nextLine();
		
		if (userInput.equalsIgnoreCase("pi")) {
			userInputNum = Math.PI;
		} else {
			userInputNum = dataConversion(userInput);
		}
		return userInputNum;
	}
	
	/**
	 * 
	 * @param scanner Scanner
	 * 
	 * help() handles the help functionality at the beginning of the program, which allows the user to enter help and receive detailed instructions on how to use the console calculator.
	 */
	public void help(Scanner scanner) {
		
		if(scanner.nextLine().equalsIgnoreCase("help")) {
			System.out.println("Enter your first number, the operator you would like to use, and then your second number.\nAddition: +\nSubtraction: -\nMultiplication: *\nDivision: \\ \nModulus Division: %\nPI: enter: \"pi\"\nTo raise to a power: ^\nTo take the nth root of: ~\n\nFor root and power, the base is the first number, while the root/power is the second number.");
		}
		
	}
	
	/**
	 * 
	 * @param userInput String is the original input value
	 * @return userInputNum double is the converted input value
	 * AKA String ---> Double converter
	 * Handles exceptions related to input and conversion errors as well.
	 */
	public double dataConversion(String userInput) {
		
		double userInputNum = 0; 
		
		try{
			userInputNum = Double.parseDouble(userInput);
		}
		catch(Exception e) {
			throw new RuntimeException("Invalid data, try entering a number.  " + e);
		}
		return userInputNum;
	}
	
	/**
	 * 
	 * @param input double is the converted input value from userInput
	 * @param userInput String is the original input value from the user
	 * @return input double is the verified (or checked) input value
	 * 
	 * This method is the exception handling for the promptUser() method.
	 * It essentially allows the program to loop until the user enters a correct input value, instead of terminating the program at the moment an exception is thrown.
	 */
	public double promptUserHandler(double input, String userInput) {
		
		Scanner scanner = new Scanner(System.in);
		boolean isDone = false;
		
		//Get first input value from user
		while(!isDone) {
			try {
				input = promptUser(scanner, userInput);
				isDone = true;
			}//End of try block
			catch(RuntimeException e) {
				
				System.out.println("Invalid input data. Please enter a number. Exception:  " + e);
			}//End of catch block
		}//End of while loop
		return input;
	}//End of promptUserHandler()

	/**
	 * @param operator String is the operator entered by the user
	 * @return operand String after it has been checked by the exception handler
	 * 
	 * This method is the exception handling for the operand field
	 * Much like the promptUserHandler(), it also allows the program to loop until the user enters valid input
	 */
	public String operandHandler(String operator) {
		
		Scanner scanner = new Scanner(System.in);
		boolean isDone = false;

		while(!isDone) {
			try{
				//Prompt user to enter their operator
				System.out.println("Enter your operand");
				operator = scanner.nextLine();
			    operatorSwitch(operator);
			    //This flag will never be reached and executed until the try block has been fully and completely executed
				isDone = true;
			}//End of try block
			catch(RuntimeException e) {
				System.out.print(e);
				System.out.println("Please enter a valid operator. Ex. + for addition, - for subtraction, * for multiplication, / for division, % for modulo division, ^ for square root, ~ for taking root of the nth power\nFor root and power, the base is the first number, while the root/power is the second number.");
			}//End of catch block
		}//End of loop
		return operator;
	}//End of operandHandler() method
}// End of class UserInputProcessor
