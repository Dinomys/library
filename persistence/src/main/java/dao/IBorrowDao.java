package dao;

import model.Borrow;

import java.util.List;

public interface IBorrowDao {

    boolean addBorrow(Borrow borrow);

    Borrow showBorrowById(long id);

    List<Borrow> listBorrows();
}
