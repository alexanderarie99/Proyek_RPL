import Method.*;
import Servlet.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Admin extends HttpServlet {
 @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        HttpSession session=request.getSession();
        Krs_Control mhs = new Krs_Control();
        
        if(session.getAttribute("DataLogin")!=null){
           String[] DataLogin=(String[]) session.getAttribute("DataLogin");
            if(DataLogin[2].equals("admin")){
                try {
                    MethodDosen dsn = mhs.dataDosen(DataLogin[0]);
                    ArrayList<MahasiswaKrs> krsList = mhs.mhsKrs();
                        session.setAttribute("krslist", krsList);
                        session.setAttribute("dataDsn", dsn);                        
                        request.getRequestDispatcher("Admin.jsp").forward(request, response);
                } catch (Exception ex) {}
            }
            }else{
                response.sendRedirect("/ProjectWEB/Home");
            }

    
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                PrintWriter out = response.getWriter();
                
        
        }
        
   

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}


