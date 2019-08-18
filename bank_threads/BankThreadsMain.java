package week1.day7.assignment5.bank_threads;

import java.io.File;

public class BankThreadsMain {

	public static void main(String[] args) {
		final String FOLDER = "logs" + File.separator + "7-5 Message Logs";
		final String LOG_FILE_NAME = "message-log.txt";
		
		File folder = new File (FOLDER);
		if (!folder.exists())
			folder.mkdir();
		
		File logFile = new File (FOLDER + File.separator + LOG_FILE_NAME);
		
		Account account = new Account (10000);
		
		// Start withdrawals
		
		WithdrawalThread wt = new WithdrawalThread(account, 1200, logFile);
		wt.run();
		System.out.println("Balance: " + account.getBalance());
		
		wt = new WithdrawalThread(account, 500, logFile);
		wt.run();
		System.out.println("Balance: " + account.getBalance());
		
		wt = new WithdrawalThread(account, 5000, logFile);
		wt.run();
		System.out.println("Balance: " + account.getBalance());
		
		wt = new WithdrawalThread(account, 6500, logFile);
		wt.run();
		System.out.println("Balance: " + account.getBalance());
	}
}
