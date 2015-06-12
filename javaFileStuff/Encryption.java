import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;


public class Encryption {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File file = new File("test.txt");
		//File outfile = new File("out.txt");
		String content = "";
		StringBuilder sb = new StringBuilder();
		
		try {
			Scanner input = new Scanner(file);
			
			while (input.hasNext()) {
//				content = content + input.nextLine() + "\n";
				
//				sb.append(input.nextLine());
//				sb.append("\n");
				content = input.nextLine();
				String[] sentence = content.split(" ");
				
				for (String s: sentence) {
					sb.append(encrypt(s));
					sb.append(" ");
				}
				sb.append("\n");
			}
			
			try {
				FileWriter fWriter = new FileWriter("out.txt");
				
				fWriter.write(sb.toString());
				
				fWriter.close();
				
				System.out.println("Wrote to output file");
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			input.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static String encrypt(String s) {
		
		String firstLetter = s.substring(0, 1);
		
		if (firstLetter.equals("a") || firstLetter.equals("e") || firstLetter.equals("i") || firstLetter.equals("o") || firstLetter.equals("u")) {
			return s + "yay";
		}
		else  {
			return s.substring(1) + firstLetter + "ay";
		}
	}

}
