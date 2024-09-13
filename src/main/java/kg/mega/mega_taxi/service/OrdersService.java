package kg.mega.mega_taxi.service;

import kg.mega.mega_taxi.exception.UpdateOrderException;
import kg.mega.mega_taxi.model.OrderStatus;
import kg.mega.mega_taxi.model.Orders;
import kg.mega.mega_taxi.model.Users;
import kg.mega.mega_taxi.repository.OrderStatusRepository;
import kg.mega.mega_taxi.repository.OrdersRepository;
import kg.mega.mega_taxi.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.sql.Driver;

@Service
@AllArgsConstructor
public class OrdersService {
    
    private final OrdersRepository ordersRepository;
    private final UserRepository userRepository;
    private final OrderStatusRepository orderStatusRepository;

    public void createOrder(Orders order){
        ordersRepository.save(order);
    }

    public void deleteOrder(Long id){
        ordersRepository.deleteById(id);
    }

    public void updateOrder(Orders order) {
        try {
            Orders existingOrder = ordersRepository.findById(order.getId())
                    .orElseThrow(() -> new UpdateOrderException("Order with ID" + order.getId() + "not found."));

            Users existingUser = userRepository.findById(order.getClient().getId())
                    .orElseThrow(() -> new UpdateOrderException("Client with ID" + order.getClient().getId() + "not found."));

            Users existingDriver = userRepository.findById(order.getDriver().getId())
                    .orElseThrow(() -> new UpdateOrderException("Driver with ID" + order.getDriver().getId() + "not found."));

            OrderStatus exitingStatus = orderStatusRepository.findById(order.getStatusOrder().getId())
                    .orElseThrow(() -> new UpdateOrderException("Order with ID" + order.getStatusOrder().getId() + "not found."));

            ordersRepository.save(order);
        } catch (UpdateOrderException e) {
            throw e;
        } catch (DataAccessException e) {
            throw new UpdateOrderException("Database error occurred");
        } catch (Exception e) {
            throw new UpdateOrderException("Failed to update order" + e.getMessage());
        }
    }
    public Orders getOrder(Long id){
        return ordersRepository.findById(id).orElse(null);
    }
    
    
}
