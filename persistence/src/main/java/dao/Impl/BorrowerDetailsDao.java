package dao.Impl;

import dao.IBorrowerDetailsDao;
import model.BorrowerDetails;

import java.util.List;

public class BorrowerDetailsDao implements IBorrowerDetailsDao {
    @Override
    public boolean insertBorrowerDetails(BorrowerDetails borrowerDetails) {
        return false;
    }

    @Override
    public BorrowerDetails editBorrowerDetails(BorrowerDetails borrowerDetails) {
        return null;
    }

    @Override
    public BorrowerDetails showBorrowerDetailsById(long id) {
        return null;
    }

    @Override
    public List<BorrowerDetails> listBorrowerDetails() {
        return null;
    }
}
