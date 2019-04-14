package servlets;

import dao.Impl.BookDao;
import dao.Impl.BorrowerDao;
import model.Book;
import service.BookService;
import service.BorrowService;
import service.BorrowerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/details")
public class BookDetailsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        GetBookHelper helper = GetBookHelper.getInstance();
        BorrowerService borrowerService = new BorrowerService();
        req.setAttribute("borrowers", borrowerService.listAllBorrowers());
        helper.getBook(req, resp, "details.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        BookService bookService = GetBookHelper.getInstance().getService();
        String bookIdStr = req.getParameter("bookid");
        if (bookIdStr == null) {
            req.getRequestDispatcher("mustPickBook.jsp").forward(req, resp);
        } else {
            long bookid = Long.valueOf(req.getParameter("bookid"));
            BorrowService borrowService = new BorrowService();

            switch (action) {
                case "borrow":
                    String borrowerId = req.getParameter("borrowerid");
                    if(borrowerId != null) {
                        long borrowerIdLong = Long.valueOf(req.getParameter("borrowerid"));
                        borrowService.borrowBook(bookid, borrowerIdLong);
                        req.getRequestDispatcher("borrowSuccess.jsp").forward(req, resp);
                    } else {
                        req.getRequestDispatcher("/details").forward(req, resp);
                    }
                    break;
                case "return":
                    bookService.returnBook(bookid);
                    break;
                default:
                    req.getRequestDispatcher("/index").forward(req, resp);
                    break;
            }

        }
    }
}