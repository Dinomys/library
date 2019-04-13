package service;

import dao.IBookDao;
import dao.Impl.BookDao;
import dto.BookDto;
import model.Book;
import model.Borrow;
import model.Borrower;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BookService {

    public String currentBorrowerName(Book book) {
        String borrowerName = null;
        if (book.isBorrow()) {
            List<Borrow> borrowList = book.getBorrows();
            Borrower borrower = borrowList.get(borrowList.size() - 1).getBorrower();
            if (borrower != null) {
                borrowerName = borrower.getBorrowerName();
            }
        }
        return borrowerName;
    }

    public BookDto showBook(Book book) {
        return new BookDto(book.getId(), book.getTitle(), book.getAuthor().getAuthorName(), book.getIsbn(), book.getCategory(),
                book.getReleaseDate(), currentBorrowerName(book));
    }

    public List<BookDto> books() {
        IBookDao bookDao = new BookDao();
        List <Book> books =  bookDao.listBooks();
        List<BookDto> bookDtoList = new ArrayList<BookDto>();
        for (Book b : books) {
            bookDtoList.add(showBook(b));
        }
        return bookDtoList;
    }

}
