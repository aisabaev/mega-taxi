package kg.mega.mega_taxi.exception;

public class DeleteAllPermissionsException extends RuntimeException{
    public DeleteAllPermissionsException(String message) {
        super(message);
    }

    public DeleteAllPermissionsException(String message, Throwable cause) {
        super(message, cause);
    }
}
