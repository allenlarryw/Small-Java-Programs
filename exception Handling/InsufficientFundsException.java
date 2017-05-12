
// File Name InsufficientFundsException.java
import java.io.*;

public class InsufficientFundsException extends Exception {
	private double amount;

	public InsufficientFundsException(double amount) {
		this.amount = amount;

		System.out.print("You do not have enough funds you need  $" + amount + " more to withdraw this amount");

	}

	public double getAmount() {
		return amount;
	}
}