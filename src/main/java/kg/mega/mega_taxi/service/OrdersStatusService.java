package kg.mega.mega_taxi.service;



import kg.mega.mega_taxi.exception.CreateOrderStatusException;
import kg.mega.mega_taxi.exception.DeleteOrderStatusException;
import kg.mega.mega_taxi.exception.GetOrderStatusByIdException;
import kg.mega.mega_taxi.exception.UpdateOrderStatusException;
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

