package service;

import dao.Impl.BorrowerDao;
import dto.BorrowerDto;
import model.Borrower;

import java.util.ArrayList;
import java.util.List;

public class BorrowerService {

    private String getBorrowerName (Borrower b){
        return b.getFirstName() + " " + b.getLastName();
    }

    public List<BorrowerDto> listAllBorrowers (){
        List<Borrower> list = BorrowerDao.listBorrowers();
        List<BorrowerDto> listAllBorrowers = new ArrayList<BorrowerDto>();
        for (Borrower b : list){
            listAllBorrowers.add(new BorrowerDto(b.getBorrowerName()));
        }
        return listAllBorrowers;
    }

}
