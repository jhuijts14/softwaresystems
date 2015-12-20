package ss.week6;

public class TooFewArgumentsException extends WrongArgumentException {
	
	public String getMessage() {
		return "error: must pass two command line arguments";
	}
}
