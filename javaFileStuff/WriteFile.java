import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class WriteFile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		overwriteFile();
		//overwriteFile2();
	}
	
	public static void overwriteFile() {
		File file = new File("test.txt");
		try {
			PrintWriter pWriter = new PrintWriter(file);
			
			pWriter.write("This is a line\n");
			pWriter.write("This is another line\n");
			
			pWriter.println("This is a line");
			pWriter.println("This is another line");
			
			pWriter.close();
			
			System.out.println("Wrote to file - 1");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void overwriteFile2() {
		
		try {
			FileWriter fWriter = new FileWriter("test.txt");
			
			fWriter.write("Wrote a line\n");
			fWriter.write("Wrote another line\n");
			
			fWriter.close();
			
			System.out.println("Wrote to file - 2");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
