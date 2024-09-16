package kg.mega.mega_taxi.exception.PermisssionsExceptions;

public class DeletePermissionsByIdException extends RuntimeException{
    public DeletePermissionsByIdException(String message) {
        super(message);
    }

    public DeletePermissionsByIdException(String message, Throwable cause) {
        super(message, cause);
    }
}
