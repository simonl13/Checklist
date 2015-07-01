import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Item {

	static Scanner itemInput = new Scanner(System.in);
	static ArrayList<String> checkList = new ArrayList<>(); 

	public static void newItem() throws IOException {
		FileWriter output = new FileWriter("checklist.txt");
		System.out.println("What is it you would like to add to the checklist?");
		String newItem = itemInput.nextLine();
		
		output.write(newItem + "\n");
		output.flush();

		checkList.add(newItem);
		System.out.println("\"" + newItem + "\" has been added.");
		output.close();
	}
	
	public static void listItems() {
		if (checkList.size() == 0) {
			System.out.println("There are no checklist items yet. Type in \"new\" to make one.");
		}
		else {
			for (int i = 0; i < checkList.size(); i++) {
				System.out.println("#" + i + ". " + checkList.get(i));
			}
		}
	}
	
	public static void removeItem() throws IOException {
		System.out.println("Which item would you like to remove from the checklist?");
		int removedItem = itemInput.nextInt();

		File inputFile = new File("checkList.txt");
		File tempFile = new File("myTempFile.txt");
		
		BufferedReader reader = new BufferedReader(new FileReader(inputFile));
		BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
		
		String lineToRemove = checkList.get(removedItem);
		String currentLine;
		
		while((currentLine = reader.readLine()) != null) { //if the currentline is not blank, continue
			String trimmedLine = currentLine.trim(); //set deleted line to variable
			if(trimmedLine.equals(lineToRemove)) continue; //if trimmed line does not equal the removed line, continue past next line
			writer.write(currentLine + System.getProperty("line.separator")); //gets the sequence used by OS to separate lines in text file
		}
		
		writer.close(); 
		reader.close();
		checkList.remove(removedItem);
		tempFile.renameTo(inputFile); //final rename
		
		System.out.println("Item #" + removedItem + " successfully removed.");
	}
}
