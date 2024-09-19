package kg.mega.mega_taxi.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "order_history")
@Data
public class OrdersHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "source_point")
    private String sourcePoint;

    @Column(name = "destination_point")
    private String endPoint;


    @OneToOne
    @JoinColumn(name = "client")
    private Users client;

    @OneToOne
    @JoinColumn(name = "driver")
    private Users driver;

    @Column(name = "price")
    private double price;

    @OneToOne
    @JoinColumn(name = "order_status")
    private OrderStatus statusOrder;
}
