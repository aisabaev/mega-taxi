package kg.mega.mega_taxi.service;



import kg.mega.mega_taxi.exception.CreateOrderStatusException;
import kg.mega.mega_taxi.exception.DeleteOrderStatusException;
import kg.mega.mega_taxi.exception.GetOrderStatusByIdException;
import kg.mega.mega_taxi.model.OrderStatus;
import kg.mega.mega_taxi.repository.OrderStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrdersStatusService {

    @Autowired
    private OrderStatusRepository orderStatusRepository;


    public void createOrderStatus(OrderStatus orderStatus){
        try{
            orderStatusRepository.save(orderStatus);
        }catch (CreateOrderStatusException e){
            throw new RuntimeException(e.getMessage() + " " + e.getCause());
        }
    }

    public void deleteOrderStatusById(Long id){
        try {
            orderStatusRepository.deleteById(id);
        }catch (DeleteOrderStatusException e){
            throw new RuntimeException(e.getMessage() + " " + e.getCause());
        }
    }

    public Optional<OrderStatus> getOrderStatusById(Long id){
        try {
            return orderStatusRepository.findById(id);
        }catch (GetOrderStatusByIdException e){
            throw new RuntimeException(e.getMessage() + " " + e.getCause());
        }
    }

    public void updateOrderStatus(OrderStatus orderStatus){
        try {
            orderStatusRepository.save(orderStatus);
        }catch (UpdateOrderStatusException e){
            throw new RuntimeException(e.getMessage() + " " + e.getCause());
        }
    }
}
=======
import kg.mega.mega_taxi.model.OrderStatus;
import kg.mega.mega_taxi.model.OrderStatus;
import kg.mega.mega_taxi.repository.OrderStatusRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrdersStatusService {

    private final OrderStatusRepository orderStatusRepository;

    public void createOrder(OrderStatus order) {
        orderStatusRepository.save(order);
    }

    public void deleteOrder(Long id) {
        orderStatusRepository.deleteById(id);
    }

    public boolean updateOrder(OrderStatus order, Long id) {
        OrderStatus orderToUpdate = orderStatusRepository.findById(id).orElse(null);
        if (orderToUpdate != null) {
            orderToUpdate.setStatus_name(order.getStatus_name());
            orderStatusRepository.save(orderToUpdate);
            return true;
        } else {
            return false;
        }
    }

    public OrderStatus getOrder(Long id) {
        return orderStatusRepository.findById(id).orElse(null);
    }
}

