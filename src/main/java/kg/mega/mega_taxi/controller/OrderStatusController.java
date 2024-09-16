package kg.mega.mega_taxi.controller;


import kg.mega.mega_taxi.model.OrderStatus;
import kg.mega.mega_taxi.service.OrderStatusService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orderStatus")
public class OrderStatusController {

    OrderStatusService orderStatusService;

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@RequestParam long id){
        try {
            return ResponseEntity.ok(orderStatusService.getOrderStatusById(id));
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @PostMapping("/create")
    public ResponseEntity<?> createOrderStatus(@RequestBody OrderStatus orderStatus){
        try {
            if (orderStatus.getStatus_name() != null){
                orderStatusService.createOrderStatus(orderStatus);
                return ResponseEntity.ok().body("Good Request");
            }else {
                return ResponseEntity.badRequest().build();
            }
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteOrderStatus(@RequestParam long id){
        try{
            if (orderStatusService.getOrderStatusById(id).isPresent()){
                orderStatusService.deleteOrderStatusById(id);
                return ResponseEntity.ok().body("Order Status was deleted");
            }else {
                return ResponseEntity.badRequest().body("Order Status with that id was not found");
            }
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @PutMapping("/edit")
    public ResponseEntity<?> editOrderStatus(@RequestBody OrderStatus orderStatus, @RequestParam Long id){
        try {
            if (orderStatusService.getOrderStatusById(id).isPresent()) {
                orderStatusService.updateOrderStatus(orderStatus, id);
                return ResponseEntity.ok().body("Your change was successful");
            }else {
                return ResponseEntity.badRequest().body("Edited was failed");
            }
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
