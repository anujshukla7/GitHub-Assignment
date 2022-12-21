
@SuppressWarnings("serial")
public class UnsupportedTransactionException extends Exception {
	public UnsupportedTransactionException() {
		super("You have entered wrong choice.Enter Valid option .");
		}
	public UnsupportedTransactionException(String message) {
		super(message);
		}

}
