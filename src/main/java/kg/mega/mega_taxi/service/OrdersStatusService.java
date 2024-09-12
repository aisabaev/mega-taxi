package kg.mega.mega_taxi.service;


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