import java.util.Scanner;

public class Transaction {
	String Account_No;
	String Name;
	String Account_type;
	long Balance;
	int Pin;

	//process of account opening
	Scanner sc = new Scanner(System.in);
	public void OpenAccount() {
		System.out.println("Enter Account Number :");
		Account_No = sc.next();
		System.out.println("Enter Customer Name :");
		Name = sc.next();
		System.out.println("Enter Account Type : ");
		Account_type = sc.next();
		System.out.println("Enter Balance : ");
		Balance = sc.nextLong();
		System.out.println("Enter Pin : ");
		Pin = sc.nextInt();

	}

	//method of show customer details
	public void ShowDetails() {
		System.out.println("Customer Account Number :" + Account_No);
		System.out.println("Customet Name : " + Name);
		System.out.println("Customer Account Type :" + Account_type );
		System.out.println("Account Balance :" + Balance);

	}

	//method for credit
	public void credit() {
		long Amount;
		System.out.println("How much amount you want to deposit : ");
		Amount = sc.nextLong();
		Balance = Balance + Amount;
		System.out.println("Available Balance in Your Account : " + Balance);

	}

	//method for debit 
	public void debit() {
		long Amount;
		System.out.println("How much amount you want to withdrawl :");
		Amount = sc.nextLong();
		if (Amount <= Balance) {
			Balance = Balance - Amount;
			System.out.println("Available Balance in Your Account : " + Balance);			
		}
		else
			System.out.println("You don't have sufficient balance in your account :" + Amount);

	}
	//process of balance inquiry
	public void checkBalance() {
		System.out.println("Available Balance in Your Account is : " + Balance);

	}
	//process of pin change
	public void PinChange() {
		int p;
		System.out.println("Do you want to change your pin");
		System.out.println("Enter your old pin : ");
		p= sc.nextInt();
		if (p == Pin) {
			System.out.println("Enter your new pin : ");
			int n = sc.nextInt();
			System.out.println("confirm your pin : ");
			int s = sc.nextInt();
			if (n == s) {
				Pin = n;
				System.out.println("Your new pin is : " + Pin);	
			}
			else
				System.out.println("your entered pin didn't match with previos pin ");		
		}
		else
			System.out.println("you entered wrong pin ");

	}
	//search customer through account number
	public boolean search(String Account_N0) {
		if (Account_No.equals(Account_N0)) {
			ShowDetails();
			return(true);
		}
		return (false);
	}


	public static class BankingSystem {
		public static void main(String[] args) {
			int n, i;
			Scanner sc = new Scanner(System.in);
			System.out.println("How many customer details you want to enter : ");
			n = sc.nextInt();
			Transaction t[] = new Transaction[n];
			for  (i = 0; i< t.length; i++) {
				t[i] = new Transaction();
				t[i].OpenAccount();
			}
			int s;
			do {
				System.out.println("\n***Banking Application***");
				System.out.println("1.Credit \n2.Debit \n3.Balance inquiry \n4.PinChange");
				System.out.println("Enter your Choice : ");
				s = sc.nextInt();
				try {
					switch (s) {
					case 1: 
						System.out.println("Enter Account Number : ");
						String Account_No = sc.next();
						boolean found = false;
						for (i = 0; i< t.length; i++) {
							found = t[i] .search(Account_No);

							if (found ) {
								t[i].credit();
								break;
							}	
						}
						if  (!found) {
							System.out.println("Account doesn't exist");
						}
						break;
					case 2:
						System.out.println("Enter Account Number : ");
						Account_No = sc.next();
						found = false;
						for (i = 0; i< t.length; i++) {
							found = t[i] .search(Account_No);

							if (found ) {
								t[i].debit();
								break;
							}	
						}
						if  (!found) {
							System.out.println("Account doesn't exist");
						}
						break;
					case 3:
						System.out.println("Enter Account Number : ");
						Account_No = sc.next();
						found = false;
						for (i = 0; i< t.length; i++) {
							found = t[i] .search(Account_No);

							if (found ) {
								t[i].checkBalance();
								break;
							}	
						}
						if  (!found) {
							System.out.println("Account doesn't exist");
						}
						break;
					case 4:
						System.out.println("Enter Account Number : ");
						Account_No = sc.next();
						found = false;
						for (i = 0; i< t.length; i++) {
							found = t[i] .search(Account_No);

							if (found ) {
								t[i].PinChange();
								break;
							}	
						}
						if  (!found) {
							System.out.println("Account doesn't exist");
						}
						break;
					default:
						throw new UnsupportedTransactionException();
					
				}
				}
					catch(UnsupportedTransactionException e) {
						System.out.println(e.getMessage());
					
				}

			}


			
		
		while (s != 5);


	
}
		}
	


}



