package dao.Impl;

import dao.IBorrowerDao;
import model.Book;
import model.Borrower;

import java.util.List;

public class BorrowerDao implements IBorrowerDao {
    @Override
    public boolean insertBorrower(Borrower borrower) {
        return false;
    }

    @Override
    public Borrower editBorrower(List objects) {
        return null;
    }

    @Override
    public boolean removeBorrower(Borrower borrower) {
        return false;
    }

    @Override
    public Book showBorrowerById(long id) {
        return null;
    }

    @Override
    public List<Book> listBorrowers() {
        return null;
    }
}
