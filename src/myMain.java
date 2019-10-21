import java.util.Scanner;

public class myMain {
	public static void main(String args[]){
		ConcreteCalculator concreteCalculator = new ConcreteCalculator();
		Scanner stdIn = new Scanner(System.in);
		String userInput = "";
		
		System.out.println("########################################\n   Welcome to my  concrete calculator.\n   "
				+ "Enter shape you wish to be created,\n   or type quit to finish!\n   "
				+ "(Rectangle, Cylinder, Square)\n########################################\n\n");
		
		while(!(userInput.equalsIgnoreCase("quit"))) {
			System.out.println("Enter command you want to do or type QUIT to finish.(add <shape>, remove <shape>, display)");
			System.out.println(concreteCalculator.command(userInput));
			userInput = stdIn.nextLine();
		}
		stdIn.close();
		
	}
}
