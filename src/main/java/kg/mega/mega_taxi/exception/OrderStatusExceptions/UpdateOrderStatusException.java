package kg.mega.mega_taxi.exception.OrderStatusExceptions;

public class UpdateOrderStatusException extends RuntimeException {
    public UpdateOrderStatusException(String message) {
        super(message);
    }
    public UpdateOrderStatusException(String message, Throwable cause) {
        super(message, cause);
    }
}
