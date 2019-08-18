package week1.day7.assignment5.bank_threads;

import java.io.File;

public class EmailThread implements Runnable {
	private File file;
	
	public EmailThread(File file) {
		this.file = file;
	}
	@Override
	public void run() {
		String message = "Sent an e-mail!";
		System.out.println(message);
		LoggingThread t = new LoggingThread(file, message);
		t.run();
	}
}
