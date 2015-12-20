package ss.week6;

public class ArgumentLengthsDifferException extends WrongArgumentException {

	private int i, j;
	
	public ArgumentLengthsDifferException(int i, int j) {
		this.i = i;
		this.j = j;
	}
	
	public String getMessage() {
		return "error: length of command line arguments "
                + "differs (" + i + ", " + j + ")";
	}
}
