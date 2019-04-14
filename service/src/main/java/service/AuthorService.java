package service;

import dao.Impl.AuthorDao;
import dto.AuthorDto;
import model.Author;

import java.util.ArrayList;
import java.util.List;

public class AuthorService {

    private String getAuthorName (Author author){
        return author.getFirstName() + " " + author.getLastName();
    }

    public List<AuthorDto> authorsList (){
        AuthorDao authorDao = new AuthorDao();
        List<Author> authorList = authorDao.listAuthors();
        List<AuthorDto> authorDtos = new ArrayList<AuthorDto>();
        for (Author a : authorList){
            authorDtos.add(new AuthorDto(a.getId(), a.getAuthorName()));
        }
        return authorDtos;
    }
}
