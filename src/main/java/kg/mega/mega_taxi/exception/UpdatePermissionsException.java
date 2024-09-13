package kg.mega.mega_taxi.exception;

public class UpdatePermissionsException extends RuntimeException{
    public UpdatePermissionsException(String message) {
        super(message);
    }

    public UpdatePermissionsException(String message, Throwable cause) {
        super(message, cause);
    }
}
