package week1.day7.assignment5.file_splitting_threads;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileReadingThread implements Runnable {
	private FileReader fileReader;
	private File file;
	
	public FileReadingThread(File file) throws IOException {
		this.file = file;
		if (!file.exists()) {
			System.err.println("No file found to split");
			throw new IOException("Need a file to split");
		}
		try {
			fileReader = new FileReader(file);
		} catch (IOException e) {
			System.err.println("Failed to create reader");
			e.printStackTrace();
		}
	}
	@Override
	public void run() {
		FileWritingThread vowelsThread = new FileWritingThread(new File(file.getParent() + File.separator + "vowels.txt"));
		FileWritingThread digitsThread = new FileWritingThread(new File(file.getParent() + File.separator + "digits.txt"));
		FileWritingThread contentsThread = new FileWritingThread(new File(file.getParent() + File.separator + "contents.txt"));
		
		vowelsThread.setSpaces("");
		digitsThread.setSpaces("    ");
		contentsThread.setSpaces("        ");
		
		String vowels = "aeiou";
		String digits = "0123456789";
		int ch = 0;
	    while(ch != -1) {
	        try {
				ch = fileReader.read();
			} catch (IOException e) {
				e.printStackTrace();
			}
	        String s = new String ((Character.toString((char) ch)));
	        if (vowels.contains(s.toLowerCase()) || vowels.contains(s.toUpperCase())) {
	        	vowelsThread.setChar(ch);
	        	vowelsThread.run();
	        }
	        else if (digits.contains(s.toLowerCase()) || digits.contains(s.toUpperCase())) {
	        	digitsThread.setChar(ch);
	        	digitsThread.run();
	        }
	        else {
	        	contentsThread.setChar(ch);
	        	contentsThread.run();
	        }
	    }
	    try {
			fileReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
