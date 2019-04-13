package dao.Impl;

import dao.IBorrowDao;
import model.Borrow;

import java.util.List;

public class BorrowDao implements IBorrowDao {

    @Override
    public boolean insertBook(Borrow borrow) {
        return false;
    }

    @Override
    public Borrow showBorrowById(long id) {
        return null;
    }

    @Override
    public List<Borrow> listBorrows() {
        return null;
    }
}