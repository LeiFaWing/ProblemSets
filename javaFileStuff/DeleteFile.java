import java.io.File;


public class DeleteFile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File file = new File("test.txt");
		//File file = new File("out.txt");
		file.delete();
	}

}
