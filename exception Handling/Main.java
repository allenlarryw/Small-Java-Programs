import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CheckingAccount account = new CheckingAccount(948394);

		System.out.println(" your account number is " + account.getNumber());

		account.deposit(100);

		System.out.println("This is your account Balance $" + account.getBalance());

		System.out.println("How much money do you want to withdraw");

		try {
			Scanner input = new Scanner(System.in);

			int withdrawAmount = input.nextInt();

			account.withdraw(withdrawAmount);

			System.out.print("You have $" + account.getBalance() + " left in your account");

			input.close();

		} catch (InsufficientFundsException e) {
			// TODO Auto-generated catch block
			// if no funds are available this error is thrown
		} catch (InputMismatchException e) {
			System.out.println("You did not enter a interger");
		} finally {
			System.out.println();
			System.out.println("This happens no matter what");
		}

	}

}
