package model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "borrow")
public class Borrow {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_borrow")
    long id;

    @ManyToOne
    @JoinColumn(name = "book_id")
    Book book;

    @ManyToOne
    @JoinColumn(name = "borrower_id")
    Borrower borrower;

    @Column (name = "rental_date")
    @Temporal(TemporalType.DATE)
    Date rentalDate;

    public Borrow(Book book, Borrower borrower, Date rentalDate) {
        this.book = book;
        this.borrower = borrower;
        this.rentalDate = rentalDate;
    }
}