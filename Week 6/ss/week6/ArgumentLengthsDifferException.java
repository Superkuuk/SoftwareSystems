package ss.week6;

public class ArgumentLengthsDifferException extends WrongArgumentException {
	public ArgumentLengthsDifferException(int a, int b) {
		super("error: length of command line arguments "
                + "differs (" + a + ", " + b + ")");
	}
	public ArgumentLengthsDifferException(String msg) {
		super(msg);
	}
}
