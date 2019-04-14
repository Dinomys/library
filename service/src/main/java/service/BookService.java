package service;

import dao.IBookDao;
import dao.IBorrowDao;
import dao.Impl.BookDao;
import dao.Impl.BorrowDao;
import dao.Impl.BorrowerDao;
import dto.BookDto;
import dto.BookDtoExtended;
import model.Book;
import model.Borrow;
import model.Borrower;
import org.hibernate.query.criteria.internal.expression.function.CurrentDateFunction;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class BookService {

    private final IBookDao bookDao;;

    public BookService() {
        this.bookDao = new BookDao();
    }

    public void editBook(Book book){
        bookDao.editBook(book);
    }

    public void addBook(Book book){
        bookDao.insertBook(book);
    }


    public void returnBook(long bookid){
        Book book = bookDao.showBookById(bookid);
        book.setBorrow(false);
    }

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
        List<Book> books = bookDao.listBooks();
        List<BookDto> bookDtoList = new ArrayList<BookDto>();
        for (Book b : books) {
            bookDtoList.add(showBook(b));
        }
        return bookDtoList;
    }

    public BookDtoExtended showAllBookDetails(long id) {
        Book book = bookDao.showBookById(id);
        return new BookDtoExtended(book.getId(), book.getTitle(), book.getAuthor().getAuthorName(), book.getIsbn(),
                book.getCategory(), book.getReleaseDate(), currentBorrowerName(book), book.isBorrow(), book.getPages(),
                book.getSummary());
    }
}
