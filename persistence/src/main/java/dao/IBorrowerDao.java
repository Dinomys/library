package dao;

import model.Borrower;

import java.util.List;

public interface IBorrowerDao<T> {

    boolean insertBorrower(Borrower borrower);

    boolean removeBorrower(Borrower borrower);

    Borrower showBorrowerById(long id);

    List<Borrower> listBorrowers();
}