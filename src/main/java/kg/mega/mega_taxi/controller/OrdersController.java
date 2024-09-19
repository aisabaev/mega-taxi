package kg.mega.mega_taxi.controller;


import com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException;
import kg.mega.mega_taxi.exception.orders.DeleteOrderException;
import kg.mega.mega_taxi.exception.orders.OrderCreateException;
import kg.mega.mega_taxi.exception.orders.OrderNotFoundException;
import kg.mega.mega_taxi.exception.orders.UpdateOrderException;
import kg.mega.mega_taxi.model.Orders;
import kg.mega.mega_taxi.service.OrdersService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/orders")
@AllArgsConstructor
public class OrdersController {

    private final OrdersService ordersService;

    @PostMapping("/create")
    public ResponseEntity<?> createOrder(@Validated @RequestBody Orders order){
        try {
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body("Order created successfully") ;
        } catch (OrderCreateException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Unable to Create Order. Error: " + e.getMessage());
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Unexpected Error: " + e.getMessage());
        }

    }

    @GetMapping("/get_{id}")
    public ResponseEntity<?> getOrder(@PathVariable long id){
        try {
            return ResponseEntity.ok(ordersService.getOrder(id));
        }
        catch (OrderNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Order with id " + id + " not found");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An unexpected error occurred: " + e.getMessage());
        }
    }

    @ExceptionHandler(UnrecognizedPropertyException.class)
    public ResponseEntity<String> handleUnrecognizedPropertyException(UnrecognizedPropertyException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body("An error occurred! Unable to Create Order. Unrecognizable field detected: " + e.getPropertyName());
    }


    @PutMapping("/update_order")
    public ResponseEntity<?> updateOrder(@RequestBody Orders orders){
        try {
            ordersService.updateOrder(orders);
            return ResponseEntity.ok().build();
        }
        catch (UpdateOrderException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Unable to update order. Error: " + e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An unexpected error occurred: " + e.getMessage());
        }
    }

    @DeleteMapping("/delete_{id}")
    public ResponseEntity<?> deleteOrder(@PathVariable long id){
        try {
            ordersService.deleteOrder(id);
            return ResponseEntity.ok().body("Order with id " + id + " deleted successfully");
        } catch (DeleteOrderException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An unexpected error occurred: " + e.getMessage());
        }
    }

    @GetMapping("/get_all")
    public ResponseEntity<?> getAllOrders(){
        return ResponseEntity.ok().body(ordersService.getAllOrders());
    }

}
