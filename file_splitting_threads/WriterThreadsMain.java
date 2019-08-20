package week1.day7.assignment5.file_splitting_threads;

import java.io.File;
import java.io.IOException;

public class WriterThreadsMain {

	public static void main(String[] args) {
		final String FOLDER = "IO Files" + File.separator + "7-5 File Splitting";
		final String LOG_FILE_NAME = "to_split.txt";
		
		File folder = new File (FOLDER);
		if (!folder.exists())
			folder.mkdir();
		
		File inputFile = new File (FOLDER + File.separator + LOG_FILE_NAME);
		
		try {
			FileReadingThread t = new FileReadingThread(inputFile);
			t.run();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
