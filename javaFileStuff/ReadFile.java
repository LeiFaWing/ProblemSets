import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class ReadFile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//File file = new File("test.txt");
		File file = new File("out.txt");
		
		try {
			Scanner input = new Scanner(file);
			
			while (input.hasNext()) {
				System.out.println(input.nextLine());
			}
			
			input.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}

}
