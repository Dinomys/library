package dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookDtoExtended {
    private long id;
    private String title;
    private String author;
    private String isbn;
    private String category;
    private Date published;
    private String borrowedBy;
    boolean borrow;
    int pages;
    String summary;
}
