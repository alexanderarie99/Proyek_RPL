import Method.LoginStatus;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class Home extends HttpServlet {
    LoginStatus Login=new LoginStatus();
    String [] DataLogin;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session=request.getSession();
        
        if(session.getAttribute("DataLogin")!=null){
            DataLogin=(String[]) session.getAttribute("DataLogin");
            if(DataLogin[2].equals("mahasiswa")){
                response.sendRedirect("/ProjectWEB/Mahasiswa");
            }else if(DataLogin[2].equals("admin")){
                response.sendRedirect("/ProjectWEB/Admin");
            }
        }else{
            request.getRequestDispatcher("/TanpaLogin").forward(request, response);
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session=request.getSession();
        if(session.getAttribute("LoginData")!=null){
            DataLogin =(String[]) session.getAttribute("LoginData");
        }else{
            try {
                DataLogin=Login.CekLogin(request.getParameter("username"), 
                        request.getParameter("password"));
            } catch (SQLException ex) {
            }
            
            if(DataLogin[2]==null ){
                response.sendRedirect("/ProjectWEB/Home");
            }
            else if(DataLogin[2].equals("mahasiswa")){
                session.setAttribute("DataLogin", DataLogin);
                response.sendRedirect("/ProjectWEB/Mahasiswa");
            }
            else if(DataLogin[2].equals("admin")){
                session.setAttribute("DataLogin", DataLogin);
                response.sendRedirect("/ProjectWEB/Admin");
            }
        }
    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
