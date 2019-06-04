import java.util.Scanner;
/**
 * 
 * @author mmcki
 * UserInputProcessor class deals with the user input in the calculator app. It takes two numeric input values as Strings,
 * then converts them to doubles. It also takes an operator of type String.
 *
 */
public class UserInputProcessor {
	
	String userInputX;
	String userInputY;
	String operand;
	String userContinue;
	
	double userSolution;
	double inputX;
	double inputY;
	double answer;
	boolean done = false;
	
	//UserInputProcessor objects
	Addition addition = new Addition();
	Subtraction subtraction = new Subtraction();
	Multiplication multiplication = new Multiplication();
	Division division = new Division();
	Modulo modulo = new Modulo();
	RaisePower power = new RaisePower();
	Root root = new Root();
	
	/**
	 * inputHandler() method deals with the logic of the application, allowing the user to quit or go again 
	 * as many times as needed.
	 * 
	 */
	public void inputHandler() {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Welcome to the console calculator!\nPress any key to begin, or enter \"help\" for help!");
		help(scanner);
		
		while(!done) {
			
			inputX = promptUserHandler(inputX, userInputX);
			operand = operandHandler(operand);
			inputY = promptUserHandler(inputY, userInputY);
			answer = operatorSwitch(operand);
			System.out.println("The answer is: " + answer);
			
			//Ask user if they want to go again, or exit
			System.out.println("Do you wish to continue?");
			userContinue = scanner.nextLine();
			if(userContinue.equalsIgnoreCase("no")) {
				System.out.println("Bye!!");
				done = true;
			}else {
				done = false;
			} // End of if statement
		} // End of while loop
	}// End of inputHandler() method
	
	/**
	 * 
	 * @param operand String which carries the operator value that is inputted from the user
	 * @return tempVal double holds the answer and passes it to the answer variable within the inputHandler() method
	 */
	public double operatorSwitch(String operand) {
	
		double tempVal = 0.0;
		switch(operand) {
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
		default: throw new RuntimeException("Error detected in operator switch. Invalid entry = " + operand);
		
		} // End of switch
		return tempVal;
	} // End of operatorSwitch() method
	
	/**
	 * 
	 * @param scanner Scanner
	 * @param userInput String holds the numeric userInput value, converts it into a double, which is then passed into the userInputNum of type double.
	 * @return userInputNum double holds the converted userInput value
	 */
	public double promptUser(Scanner scanner, String userInput) {
		
		double userInputNum = 0;
		System.out.println("Enter your number");
		userInput = scanner.nextLine();
		
		if(userInput.equalsIgnoreCase("pi")) {
			userInputNum = Math.PI;
		}else {
			userInputNum = dataConversion(userInput);
		}
		return userInputNum;
	}
	
	/**
	 * 
	 * @param scanner
	 */
	public void help(Scanner scanner) {
		
		if(scanner.nextLine().equalsIgnoreCase("help")) {
			System.out.println("Enter your first number, the operator you would like to use, and then your second number.\nAddition: +\nSubtraction: -\nMultiplication: *\nDivision: \\ \nModulus Division: %\nPI: enter: \"pi\"\nTo raise to a power: ^\nTo take the nth root of: ~\n\nFor root and power, the base is the first number, while the root/power is the second number.");
		}
		
	}
	
	/**
	 * 
	 * @param userInput
	 * @return
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
		//TODO:Check exception hierarchy
	}
	
	/**
	 * 
	 * @param input
	 * @param userInput
	 * @return
	 */
	public double promptUserHandler(double input, String userInput) {
		
		Scanner scanner = new Scanner(System.in);
		boolean done = false;
		
		//Get first input value from user
		while(!done) {
			try {
				input = promptUser(scanner, userInput);
				done = true;
			}//End of try block
			catch(RuntimeException e) {
				
				System.out.println("Invalid input data. Please enter a number. Exception:  " + e);
			}//End of catch block
		}//End of while loop
		return input;
	}//End of promptUserHandler()

	/**
	 * @param operand
	 * @return
	 */
	public String operandHandler(String operand) {
		
		Scanner scanner = new Scanner(System.in);
		boolean done = false;
		//Process operator and print answer
		while(!done) {
			try{
				//Prompt user to enter their operator
				System.out.println("Enter your operand");
				operand = scanner.nextLine();
			    operatorSwitch(operand);
				done = true;
			}//End of try block
			catch(RuntimeException e) {
				System.out.print(e);
				System.out.println("Please enter a valid operator. Ex. + for addition, - for subtraction, * for multiplication, / for division, % for modulo division, ^ for square root, ~ for taking root of the nth power\nFor root and power, the base is the first number, while the root/power is the second number.");
			}//End of catch block
		}//End of loop
		return operand;
	}//End of operandHandler() method
}// End of class UserInputProcessor
