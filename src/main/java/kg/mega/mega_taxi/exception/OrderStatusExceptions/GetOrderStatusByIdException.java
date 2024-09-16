package kg.mega.mega_taxi.exception.OrderStatusExceptions;

public class GetOrderStatusByIdException extends RuntimeException {
    public GetOrderStatusByIdException(String message) {
        super(message);
    }

    public GetOrderStatusByIdException(String message, Throwable cause) {
        super(message, cause);
    }
}
