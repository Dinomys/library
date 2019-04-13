package servlets;

import dto.BookDto;
import model.Book;
import service.BookService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet ("/index")
public class IndexServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        BookService bookService = new BookService();

        List<BookDto> books = bookService.books();

        req.setAttribute("books", books);

        req.getRequestDispatcher("index.jsp").forward(req, resp);
        }
    }
