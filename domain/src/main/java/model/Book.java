package model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id_book")
    long id;

    @OneToMany(mappedBy = "book")
    List<Borrow> borrows;

    boolean borrow;
    String category;
    String isbn;
    int pages;

    @Column (name = "release_date")
    @Temporal(TemporalType.DATE)
    Date releaseDate;
    String summary;
    String title;

    @ManyToOne
    @JoinColumn (name = "author_id")
    Author author;

public boolean isBorrow(){
    return this.borrow;
}

}