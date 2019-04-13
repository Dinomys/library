package service;


import model.Book;
import model.Borrower;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

public class BookServiceTest {

    @Test
    public void currentBorrowerName() {
        Book book = new Book ();
        book.setBorrow(true);
    }
}
