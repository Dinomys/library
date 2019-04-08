package model;

import lombok.Data;
import lombok.Generated;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id_book")
    long id;
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
    int authorId;
}

