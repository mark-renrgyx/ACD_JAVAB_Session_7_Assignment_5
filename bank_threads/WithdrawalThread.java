package week1.day7.assignment5.bank_threads;

import java.io.File;

public class WithdrawalThread implements Runnable {
	
	private Account account;
	private int withdrawalAmount;
	private File logFile;
	
	public WithdrawalThread (Account account, int amount, File logFile) {
		this.account = account;
		this.logFile = logFile;
		withdrawalAmount = amount;
	}
	
	@Override
	public void run() {
		if (account.withdraw(withdrawalAmount)) {
			EmailThread emailThread = new EmailThread(logFile);
			emailThread.run();
			
			SmsThread smsThread = new SmsThread(logFile);
			smsThread.run();
		}
		else // Failed to withdraw
			System.out.println("Failed to withdraw, insufficient funds");
	}

}
