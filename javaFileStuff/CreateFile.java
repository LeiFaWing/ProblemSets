import java.io.File;
import java.io.IOException;


public class CreateFile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File file = new File("test.txt");
		
		try {
			if (file.createNewFile()) {
				System.out.println("Created new file!");
			}
			else  {
				System.out.println("File already exists!");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
