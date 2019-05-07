package cn.boommanpro.codebreak.exception;

public class InitErrorException extends RuntimeException{
    public InitErrorException() {
    }

    public InitErrorException(String message) {
        super(message);
    }

    public InitErrorException(String message, Throwable cause) {
        super(message, cause);
    }

    public InitErrorException(Throwable cause) {
        super(cause);
    }

    public InitErrorException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
