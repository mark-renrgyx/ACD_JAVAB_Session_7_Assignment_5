package week1.day7.assignment5.bank_threads;

import java.io.File;

public class SmsThread implements Runnable {
	private File file;
	
	public SmsThread(File file) {
		this.file = file;
	}
	@Override
	public void run() {
		String message = "Sent an SMS!";
		System.out.println(message);
		LoggingThread t = new LoggingThread(file, message);
		t.run();
	}
}