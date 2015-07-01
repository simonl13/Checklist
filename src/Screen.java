import java.io.IOException;
import java.util.Scanner;
import java.util.Calendar;

public class Screen {
	public static void main(String[] args) throws IOException {
				
		String command;
		int dayStatus = Calendar.getInstance().get(Calendar.HOUR_OF_DAY); //gets 24-hour in order to tell comparison with noon.
		String time = dayStatus + ":" + Calendar.getInstance().get(Calendar.MINUTE); //gets time.
		
		Scanner commandInput = new Scanner(System.in);			
		
		//tells time with greeting based on time.
		if (dayStatus <= 12) {
			System.out.println("Good morning. It is currently " + time);
		}
		else {
			System.out.println("Good afternoon. It is currently " + time);
		}
		
		Item.loadItems(); //calls LoadItems.
		
		System.out.println("What would you like to do?");
		while(true) { //constantly loops.
			command = commandInput.next();
			switch(command) {
			default:
				System.out.println("That is not a valid option. Type \"help\" for options.");
				break;
			case "about":
				System.out.println("This is a checklist.");
				break;
			case "remove":
				Item.removeItem();
				break;
			case "help":
				System.out.println("Available Options: about, help, list, new, remove, quit.");
				break;
			case "new":	
				Item.newItem();
				break;
			case "list":
				Item.listItems(); //calls ListItems
				break;
			case "quit":
				commandInput.close();
				System.exit(1); //terminates program. 
			}
		}
	}
}
