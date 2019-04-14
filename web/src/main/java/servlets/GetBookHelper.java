package servlets;

import dto.BookDto;
import dto.BookDtoExtended;
import model.Book;
import service.BookService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class GetBookHelper {
    private static GetBookHelper getBookHelper = null;
    private final BookService bookService;

    public GetBookHelper() {
        this.bookService = new BookService();
    }

    public static GetBookHelper getInstance (){
        if (getBookHelper == null){
            getBookHelper = new GetBookHelper();
        }
        return getBookHelper;
    }

    public List<BookDto> getBookList() throws ServletException, IOException{
        return bookService.books();
    }

    public BookService getService (){
        return bookService;
    }


    public void getBook(HttpServletRequest req, HttpServletResponse resp, String destination) throws ServletException, IOException {

        if (req.getParameter("bookid") != null) {
        BookDtoExtended book = bookService.showAllBookDetails(Long.valueOf(req.getParameter("bookid")));
        req.setAttribute("book", book);
        req.getRequestDispatcher(destination).forward(req, resp);

    } else {
        req.getRequestDispatcher("mustPickBook.jsp").forward(req, resp);
    }
}
}
