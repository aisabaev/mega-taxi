package kg.mega.mega_taxi.service;

import kg.mega.mega_taxi.exception.orders.DeleteOrderException;
import kg.mega.mega_taxi.exception.orders.OrderCreateException;
import kg.mega.mega_taxi.exception.orders.OrderNotFoundException;
import kg.mega.mega_taxi.exception.orders.UpdateOrderException;
import kg.mega.mega_taxi.model.Orders;
import kg.mega.mega_taxi.model.OrdersHistory;
import kg.mega.mega_taxi.repository.OrderStatusRepository;
import kg.mega.mega_taxi.repository.OrdersRepository;
import kg.mega.mega_taxi.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class OrdersService {
    
    private final OrdersRepository ordersRepository;
    private final UserRepository userRepository;
    private final OrderStatusRepository orderStatusRepository;
    private final OrdersHistoryService ordersHistoryService;


    public void createOrder(Orders order){
        try {
            ordersRepository.save(order);
        } catch (DataAccessException e) {
            throw new OrderCreateException("Failed to save order");
        }
    }

    public void deleteOrder(Long id){
        try {
            ordersRepository.findById(id)
                    .orElseThrow(() -> new DeleteOrderException("Order with ID " + id + " not found."));
            ordersRepository.deleteById(id);
        } catch (DeleteOrderException e) {
            throw e;
        } catch (DataAccessException e) {
            throw new DeleteOrderException("Database error occurred");
        } catch (Exception e) {
            throw new DeleteOrderException("Failed to update order" + e.getMessage());
        }
    }

    public void updateOrder(Orders order) {
        try {
            ordersRepository.findById(order.getId())
                    .orElseThrow(() -> new UpdateOrderException("Order with ID " + order.getId() + " not found."));

            userRepository.findById(order.getClient().getId())
                    .orElseThrow(() -> new UpdateOrderException("Client with ID " + order.getClient().getId() + " not found."));

            userRepository.findById(order.getDriver().getId())
                    .orElseThrow(() -> new UpdateOrderException("Driver with ID " + order.getDriver().getId() + " not found."));

            orderStatusRepository.findById(order.getStatusOrder().getId())
                    .orElseThrow(() -> new UpdateOrderException("Order with ID " + order.getStatusOrder().getId() + " not found."));
//            if (orderStatusRepository.findById(order.getStatusOrder().getId())
//                    .filter(orderStatus -> "DONE".equals(orderStatus.getStatus_name()))
//                    .isPresent()) {
            if (order.getStatusOrder().getId() == 2) {
                OrdersHistory ordersHistory = new OrdersHistory();
                ordersHistory.setEndPoint(order.getDestinationPoint());
                ordersHistory.setSourcePoint(order.getSourcePoint());
                ordersHistory.setStatusOrder(order.getStatusOrder());
                ordersHistory.setDriver(order.getDriver());
                ordersHistory.setClient(order.getClient());
                ordersHistory.setPrice(order.getPrice());
                ordersHistoryService.createOrder(ordersHistory);
                deleteOrder(order.getId());
            }else {
                ordersRepository.save(order);
            }
        } catch (UpdateOrderException e) {
            throw e;
        } catch (DataAccessException e) {
            throw new UpdateOrderException("Database error occurred");
        } catch (Exception e) {
            throw new UpdateOrderException("Failed to update order" + e.getMessage());
        }
    }

    public Orders getOrder(Long id){
        try {
            ordersRepository.findById(id).orElseThrow(() -> new OrderNotFoundException("Order with ID" + id + "not found."));
            return ordersRepository.findById(id).orElse(null);
        } catch (OrderNotFoundException e) {
            throw new OrderNotFoundException("Order with ID" + id + "not found.");

        }
    }

    public List<Orders> getAllOrders(){
        return ordersRepository.findAll();
    }
}
