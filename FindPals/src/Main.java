import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {


	static int[][] pals;
	static String text = "";

	public static void main(String[] args) {

		File file = new File("C:\\Users\\Sancho Jimenez\\IdeaProjects\\School Code\\Palindrome\\src\\tom-sawyer.txt");
		Scanner scanner;
		try {
			scanner = new Scanner(file);
		} catch(FileNotFoundException e) {
			e.printStackTrace();
			return;
		}
		while(scanner.hasNextLine())
			text += scanner.nextLine();
		text = text.replaceAll("[^a-zA-z]", "");

		pals = new int[text.length()][text.length()];

	}
}
