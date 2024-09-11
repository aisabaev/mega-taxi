package kg.mega.mega_taxi.model;

import jakarta.persistence.*;

@Entity
@Table(name = "permission")
public class Permissions {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "permission_name")
    private String permissionName;
}
