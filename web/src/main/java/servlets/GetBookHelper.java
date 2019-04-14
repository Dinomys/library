package servlets;

import dao.Impl.BookDao;
import dto.BookDtoExtended;
import model.Book;
import service.BookService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GetBookHelper {

public void getBook(HttpServletRequest req, HttpServletResponse resp, String destination) throws ServletException, IOException {
    if (req.getAttribute("bookid") != null) {
        BookDao bookDao = new BookDao();
        BookService bookService = new BookService();
        BookDtoExtended book = bookService.showAllBookDetails(bookDao.showBookById((long)req.getAttribute("bookid")));
        req.setAttribute("book", book);
        req.getRequestDispatcher(destination).forward(req, resp);
    } else {
        req.getRequestDispatcher("mustPickBook.jsp");
    }
}
}
