package kg.mega.mega_taxi.exception.PermisssionsExceptions;

public class GetPermissionsByIdException extends RuntimeException {
    public GetPermissionsByIdException(String message) {
        super(message);
    }
    public GetPermissionsByIdException(String message, Throwable cause) {
        super(message, cause);
    }
}
