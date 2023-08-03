package rocha.andre.streaming.exceptions;

public class ErrorConversionException extends Exception {
    private String message;

    public ErrorConversionException(String message) {
        super(message);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
