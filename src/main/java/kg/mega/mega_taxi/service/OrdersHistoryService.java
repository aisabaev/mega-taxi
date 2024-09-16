package kg.mega.mega_taxi.service;

import kg.mega.mega_taxi.exception.orders.DeleteOrderException;
import kg.mega.mega_taxi.exception.orders.OrderNotFoundException;
import kg.mega.mega_taxi.exception.orders.UpdateOrderException;
import kg.mega.mega_taxi.exception.orders_history.CreateOrderHistoryException;
import kg.mega.mega_taxi.exception.orders_history.DeleteOrderHistoryException;
import kg.mega.mega_taxi.exception.orders_history.OrderHistoryNotFoundException;
import kg.mega.mega_taxi.exception.orders_history.UpdateOrderHistoryException;
import kg.mega.mega_taxi.model.Orders;
import kg.mega.mega_taxi.model.OrdersHistory;
import kg.mega.mega_taxi.repository.OrderStatusRepository;
import kg.mega.mega_taxi.repository.OrdersHistoryRepository;
import kg.mega.mega_taxi.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class OrdersHistoryService {

    private final OrdersHistoryRepository ordersHistoryRepository;
    private final UserRepository userRepository;
    private final OrderStatusRepository orderStatusRepository;

    public void createOrder(OrdersHistory order){
        try {
            ordersHistoryRepository.save(order);
        } catch (Exception e) {
            throw new CreateOrderHistoryException("Failed to create order history. " + e.getMessage());
        }
    }

    public void deleteOrder(Long id) {
        try {
            ordersHistoryRepository.findById(id)
                    .orElseThrow(() -> new DeleteOrderHistoryException("Order does not exist."));
            ordersHistoryRepository.deleteById(id);
        } catch (DeleteOrderException e) {
            throw e;
        } catch (DataAccessException e) {
            throw new DeleteOrderHistoryException("Database error occurred");
        } catch (Exception e) {
            throw new DeleteOrderHistoryException("Failed to update order " + e.getMessage());
        }
    }

    public void updateOrder(OrdersHistory order, Long id){
        try {
//            ordersHistoryRepository.findById(order.getId())
//                    .orElseThrow(() -> new UpdateOrderException("Order with ID" + order.getId() + "not found."));
//
//            userRepository.findById(order.getClient().getId())
//                    .orElseThrow(() -> new UpdateOrderException("Client with ID" + order.getClient().getId() + "not found."));
//
//            userRepository.findById(order.getDriver().getId())
//                    .orElseThrow(() -> new UpdateOrderException("Driver with ID" + order.getDriver().getId() + "not found."));
//
//            orderStatusRepository.findById(order.getStatusOrder().getId())
//                    .orElseThrow(() -> new UpdateOrderException("Order with ID" + order.getStatusOrder().getId() + "not found."));

            ordersHistoryRepository.save(order);
        } catch (UpdateOrderException e) {
            throw e;
        } catch (DataAccessException e) {
            throw new UpdateOrderHistoryException("Database error occurred");
        } catch (Exception e) {
            throw new UpdateOrderHistoryException("Failed to update order: " + e.getMessage());
        }
    }

    public OrdersHistory getOrder(Long id){
        try {
            ordersHistoryRepository.findById(id).orElseThrow(() -> new OrderHistoryNotFoundException("Order with ID" + id + "not found."));
            return ordersHistoryRepository.findById(id).orElse(null);
        } catch (OrderHistoryNotFoundException e) {
            throw new OrderHistoryNotFoundException("Order with ID" + id + "not found.");

        }
    }
}
