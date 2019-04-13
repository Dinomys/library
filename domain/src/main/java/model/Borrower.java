package model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "borrowers")
public class Borrower {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_borrower")
    long id;

    @Column(name = "first_name")
    String firstName;

    @Column(name = "last_name")
    String lastName;

    @OneToMany(mappedBy = "borrower")
    List<Borrow> borrows;

    @OneToOne
    @JoinColumn(name = "id_borrower_details")
    BorrowerDetails borrowerDetails;

    public String getBorrowerName(){
        return this.firstName + " " + this.lastName;
    }
}
