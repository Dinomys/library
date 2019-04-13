package model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "authors")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id_authors")
    long id;

    @OneToMany(mappedBy = "author", fetch = FetchType.EAGER)
    List<Book> books;

    @Column (name = "first_name")
    String firstName;

    @Column (name = "last_name")
    String lastName;

    @Column (name = "birth_place")
    String birthPlace;

public String getAuthorName (){
    return this.firstName + " " + this.lastName;
}
}
