package service;

import dao.IBookDao;
import dao.IBorrowDao;
import dao.Impl.BookDao;
import dao.Impl.BorrowDao;
import dao.Impl.BorrowerDao;
import model.Book;
import model.Borrow;
import model.Borrower;

import java.util.Calendar;

public class BorrowService {

    private final IBookDao bookDao;
    private final IBorrowDao borrowDao;
    private final BorrowerDao borrowerDao;

    public BorrowService() {
        this.bookDao = new BookDao();
        this.borrowDao = new BorrowDao();
        this.borrowerDao = new BorrowerDao();
    }

    public void borrowBook(long bookid, long borrowerid) {
        Calendar calendar = Calendar.getInstance();
        Book book = bookDao.showBookById(bookid);
        Borrower borrower = borrowerDao.showBorrowerById(borrowerid);
        Borrow borrow = new Borrow(book, borrower, calendar.getTime());
        book.setBorrow(true);
        borrowDao.addBorrow(borrow);
        bookDao.editBook(book);
    }
}
