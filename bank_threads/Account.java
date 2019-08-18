package week1.day7.assignment5.bank_threads;

public class Account {
	
	private volatile double balance;
	
	public Account(double balance) {
		this.balance = balance;
	}
	
	public boolean withdraw (double amount) {
		synchronized(this) {
			if (balance < amount)
				return false;
			balance -= amount;
			return true;
		}
	}
	
	public void deposit (double amount) {
		synchronized(this) {
			balance += amount;
		}
	}
	public double getBalance() {
		return balance;
	}
}
