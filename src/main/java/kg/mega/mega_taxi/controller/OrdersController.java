package kg.mega.mega_taxi.controller;


import kg.mega.mega_taxi.model.Orders;
import kg.mega.mega_taxi.service.OrdersService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/orders")
@AllArgsConstructor
public class OrdersController {

    private final OrdersService ordersService;

    @PostMapping("/create")
    public void createOrder(Orders order){
        ordersService.createOrder(order);
    }


    public void updateOrder(Orders orders){
        ordersService.updateOrder(orders);
    }
}
