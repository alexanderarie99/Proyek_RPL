import Servlet.*;
import Method.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.*;
public class TanpaLogin extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            PrintWriter out = response.getWriter();
            HttpSession session=request.getSession();
        try {
            Mahasiswa_panggil mtk = new Mahasiswa_panggil();
            ArrayList<MataKuliah> mtkList = mtk.listMat();
            session.setAttribute("mtkList", mtkList);
            request.getRequestDispatcher("Homepage.jsp").forward(request, response);
        } catch (SQLException e) {
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
