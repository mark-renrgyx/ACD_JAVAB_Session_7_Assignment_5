package week1.day7.assignment5.file_splitting_threads;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileWritingThread implements Runnable {
	volatile int nextChar;
	FileWriter fileWriter;
	
	/** Spaces for sysout */
	private String spaces;
	
	public FileWritingThread (File file) {
		if (!file.exists()) {
			
			try {
				file.createNewFile();
			} catch (IOException e) {
				System.err.println("Failed to create an output file");
				e.printStackTrace();
			}
		}
		try {
			fileWriter = new FileWriter(file);
		} catch (IOException e) {
			System.err.println("Failed to create writer");
			e.printStackTrace();
		}
	}
	
	public void setChar(int ch) {
		nextChar = ch;
	}
	@Override
	public void run() {
		System.out.println(spaces + Character.toString((char)nextChar));
		try {
			fileWriter.append(Character.toString((char)nextChar));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void setSpaces(String spaces) {
		this.spaces = spaces;
	}
}
