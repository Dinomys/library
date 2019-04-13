package dao;

import model.Book;
import model.Borrow;

import java.util.List;

public interface IBorrowDao {

    boolean insertBook(Borrow borrow);

    Borrow showBorrowById(long id);

    List<Borrow> listBorrows();
}
