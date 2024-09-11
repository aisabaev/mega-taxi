package kg.mega.mega_taxi.model;

import jakarta.persistence.*;

@Entity
@Table(name = "order_history")
public class OrdersHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "source_point")
    private String sourcePoint;

    @Column(name = "destination_point")
    private String endPoint;


    @OneToMany
    @JoinTable(name = "users")
    private Users client;

    @OneToMany
    @JoinTable(name = "users")
    private Users driver;

    @Column(name = "price")
    private float price;

    @OneToOne
    @JoinTable(name = "status_order")
    private OrderStatus orderStatus;
}
