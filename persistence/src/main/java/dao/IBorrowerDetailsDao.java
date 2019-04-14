package dao;

import model.Book;
import model.BorrowerDetails;

import java.util.List;

public interface IBorrowerDetailsDao {

    boolean insertBorrowerDetails(BorrowerDetails borrowerDetails);

    List<BorrowerDetails> listBorrowerDetails();
}
