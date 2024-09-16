package kg.mega.mega_taxi.exception.OrderStatusExceptions;

public class CreateOrderStatusException extends RuntimeException{
    public CreateOrderStatusException(String message) {
        super(message);
    }

    public CreateOrderStatusException(String message, Throwable cause) {
        super(message, cause);
    }
}
