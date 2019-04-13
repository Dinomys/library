package dao;

import model.Book;
import model.BorrowerDetails;

import java.util.List;

public interface IBorrowerDetailsDao {

    boolean insertBorrowerDetails(BorrowerDetails borrowerDetails);

    BorrowerDetails editBorrowerDetails(BorrowerDetails borrowerDetails);

    BorrowerDetails showBorrowerDetailsById(long id);

    List<BorrowerDetails> listBorrowerDetails();
}
