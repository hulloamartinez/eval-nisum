package cl.nisum.evaluacion.exception;

public class CallApiException extends RuntimeException{
    private static final long serialVersionUID = 1L;
	private String code;

    public CallApiException(String message, String code) {
        super(message);
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
