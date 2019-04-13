package model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "borrowerDetails")
public class BorrowerDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_borrower")
    long id;

    String address;
    String email;
    String phone;
}
