
@SuppressWarnings("serial")
public class UnsupportedTransactionException extends Exception {
	public UnsupportedTransactionException() {
		super("You have enter incorrect information. try with valid data");
		}
	public UnsupportedTransactionException(String message) {
		super(message);
		}

}
