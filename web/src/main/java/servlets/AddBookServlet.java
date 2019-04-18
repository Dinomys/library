package servlets;

import dao.Impl.BookDao;
import model.Book;
import service.BookService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

@WebServlet("/add")
public class AddBookServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("add.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long authorId = Long.valueOf(req.getParameter("authorFormControlSelect"));
        String title = req.getParameter("formTitleInput");
        String summary = req.getParameter("formSummaryInput");
        String category = req.getParameter("categoryFormControlSelect");
        String isbn = req.getParameter("formISBNInput");
        LocalDate localDate = LocalDate.parse(req.getParameter("formReleaseInput"));
        Date date = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
        String pages = req.getParameter("formPagesInput");

        Book book = new Book(null, false, category,
                isbn, pages, date,
                summary, title, authorId);
        BookService service = GetBookHelper.getInstance().getService();
        service.addBook(book);
    }
}