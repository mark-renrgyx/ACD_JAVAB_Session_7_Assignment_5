package week1.day7.assignment5.bank_threads;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class LoggingThread  implements Runnable {
	private File file;				// This gets rid of compiler warning.  It was never used outside of constructor.
	private FileWriter fileWriter;
	private String text;
	
	public LoggingThread (File file, String text) {
		this.file = file;
		this.text = text;
	}
	
	@Override
	public void run() {
		try {
			file.createNewFile();
		} catch (IOException e) {
			System.err.println("Failed to create a log file");
			e.printStackTrace();
		}
		try {
			fileWriter = new FileWriter(file, true);
		} catch (IOException e) {
			System.err.println("Failed to create writer");
			e.printStackTrace();
		}
		String line = "[" + new Date().toString() + "] : " + text + "\n";
		try {
			fileWriter.append(line);
			fileWriter.close();
		} catch (IOException e) {
			System.err.println("Failed to write to file");
			e.printStackTrace();
		}
	}
}
