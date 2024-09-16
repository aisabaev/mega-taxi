package kg.mega.mega_taxi.exception.OrderStatusExceptions;

public class DeleteOrderStatusException extends RuntimeException{
    public DeleteOrderStatusException(String message) {
        super(message);
    }

    public DeleteOrderStatusException(String message, Throwable cause) {
        super(message, cause);
    }
}
