package service;

import dao.Impl.BookDao;
import model.Book;
import model.Borrow;
import model.Borrower;
import org.hibernate.SessionFactory;

import java.util.Date;
import java.util.List;

public class BookService {


    //    private String title;
    //    private String author;
    //    private String isbn;
    //    private String category;
    //    private Date published;
    //    private String borrowedBy;

    public String currentBorrowerName (Book book){
        String borrowerName = null;
        if (book.isBorrow()){
            List <Borrow> borrowList = book.getBorrows();
            Borrower borrower = borrowList.get(borrowList.size()-1).getBorrower();
            if (borrower != null){
                borrowerName = borrower.getBorrowerName();
            }
        }
        return borrowerName;
    }




}
