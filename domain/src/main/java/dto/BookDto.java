package dto;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookDto {
    private long id;
    private String title;
    private String author;
    private String isbn;
    private String category;
    private Date published;
    private String borrowedBy;
}