package gradle_jdbc_study.ui.exception;

@SuppressWarnings("serial")
public class InvalidCheckException extends RuntimeException {

	public InvalidCheckException() {
		super("������ �����մϴ�.");
	}

	public InvalidCheckException(Throwable cause) {
		super("������ �����մϴ�.", cause);
	}
	
}
