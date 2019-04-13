package dao;

import model.Book;
import model.Borrower;

import java.util.List;

public interface IBorrowerDao<T> {

    boolean insertBorrower(Borrower borrower);

    Borrower editBorrower(List<T> objects);

    boolean removeBorrower(Borrower borrower);

    Book showBorrowerById(long id);

    List<Book> listBorrowers();
}