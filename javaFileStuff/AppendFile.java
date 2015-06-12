import java.io.FileWriter;
import java.io.IOException;


public class AppendFile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		appendFile();
	}

	public static void appendFile() {

		try {
			FileWriter fWriter = new FileWriter("test.txt", true);

			fWriter.write("Appended a line\n");
			fWriter.write("Appended another line\n");
			
			fWriter.append("Added a line\n");
			fWriter.append("Added another line\n");

			fWriter.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

}
